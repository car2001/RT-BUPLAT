package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/resources/features/1.login",
glue={"stepdefinitions"},
monochrome = true,
plugin= {
        "pretty",
        "html:target/HtmlReports.html",
        "json:target/report.json"
}
)
public class TestRunner {

}
