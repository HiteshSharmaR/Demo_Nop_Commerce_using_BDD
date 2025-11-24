package page.db_connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnectionEstablished {

    // Connection String for Windows Authentication context
    // Note: We often pass the Windows User, but no password is required if the plugin handles the handshake
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + System.getProperty("user.name");

    public static String getStoredData(String query, String columnName) {
        String resultData = "";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Establish Connection
            con = DriverManager.getConnection(DB_URL);

            // 2. Create Statement
            stmt = con.createStatement();

            // 3. Execute Query
            rs = stmt.executeQuery(query);

            // 4. Process Results
            if (rs.next()) {
                resultData = rs.getString(columnName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Close Connections (Crucial to prevent memory leaks)
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultData;
    }

    protected static Connection connection;
    public static Connection createConnection() {

        try {
            if (connection == null || connection.isClosed()) {

                Properties prop = new Properties();
                FileInputStream ip = null;
                try {
                    ip = new FileInputStream("src/test/java/resources/sqlconfig.properties");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                prop.load(ip);

                String dbURL = prop.getProperty("db.url");
                String dbUser = prop.getProperty("db.username");
                String dbPass = prop.getProperty("db.password");

                try {
                    connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }


    public static void closeConnection() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
