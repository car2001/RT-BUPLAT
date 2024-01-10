package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/resources/features/osm/position/",
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
