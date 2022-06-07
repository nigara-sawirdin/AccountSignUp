import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},       // location of where the feature files are located
        glue = {"stepdefinitions"},     // glue step definition codes
        plugin = {"json:report/json/cucumber.json"},
        monochrome = true
)
public class TestRunner {
}