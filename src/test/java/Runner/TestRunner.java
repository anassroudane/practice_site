package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/automatisationSelenium/Practice_Site/src/test/java/Features",
                glue = {"StepDefinition"},
                plugin = {"pretty", "junit:target/JunitReports/report.xml"}
                 )

public class TestRunner {
}
