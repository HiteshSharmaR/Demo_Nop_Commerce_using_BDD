package page.steps;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {

        public static WebDriver driver;
        private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

        @Before
        public void setup() {
            // Log the start of the setup method
            logger.info("Starting WebDriver setup for the scenario...");

            try {
                // 1. Instantiation
                driver = new ChromeDriver();
                logger.debug("Successfully instantiated ChromeDriver.");

                // 2. Window Management
                driver.manage().window().maximize();
                logger.debug("Browser window maximized.");

                // 3. Cookie Management
                driver.manage().deleteAllCookies();
                logger.debug("All browser cookies deleted.");

                logger.info("WebDriver setup completed successfully.");

            } catch (Exception e) {
                // Log any failure with error level and stack trace
                logger.error("!!! FATAL ERROR during WebDriver setup: {}", e.getMessage(), e);
                // Re-throw the exception to fail the test/scenario gracefully
                throw new RuntimeException("Failed to initialize WebDriver.", e);
            }
        }

        // You would typically have a @After hook here as well
        // @After
        // public void teardown(Scenario scenario) { ... }
}