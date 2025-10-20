package page.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/resources/Feature/",
        glue = {"page.steps"},
        monochrome = true,
        tags = "@login"
)
public class Executions extends AbstractTestNGCucumberTests {
}
