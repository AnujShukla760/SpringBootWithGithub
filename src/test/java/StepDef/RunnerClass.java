package StepDef;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature/calculator.feature",
        glue = "StepDef",
        plugin = {"pretty","html:target/cucumber-reports.html"},
         tags="@Anuj"
)

public class RunnerClass {

    // surefire and failsafe
}
