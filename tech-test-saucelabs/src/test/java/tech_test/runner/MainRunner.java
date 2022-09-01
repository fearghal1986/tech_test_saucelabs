package tech_test.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
      features = {"."}, // Leaving the "." as the path to be able to populate the rerun.txt file with the whole path for the feature files that fail as per https://stackoverflow.com/a/40326021/12439311
        glue = {"tech_test.steps", "tech_test.hooks"},
        tags = {""},
        monochrome = true,
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json", "rerun:target/rerun.txt"}
)

public class MainRunner {

}
