package page.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/resources/Feature/Login.feature",
        glue = {"page.steps"},
        monochrome = true
)
public class Executions extends AbstractTestNGCucumberTests {
}
