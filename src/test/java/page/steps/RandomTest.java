package page.steps;

import page.db_connection.DatabaseConnectionEstablished;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static page.db_connection.DatabaseConnectionEstablished.createConnection;

public class RandomTest {

    public static void main(String[] args) {
//         String sqlQuery = "select FirstName,LastName from customer where FirstName like '%john%' and LastName like '%doe%'";
//        String dbStatus = DatabaseConnectionEstablished.getStoredData(sqlQuery, "status");
//        System.out.println("Status from DB: " + dbStatus);
        Connection conn = createConnection();

        String query = "select * from learndbtesting.authentication where id = 1";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {   // Move to the first row
                String value = rs.getString("otp");
                System.out.println("Value: " + value);
            } else {
                System.out.println("No record found");
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}