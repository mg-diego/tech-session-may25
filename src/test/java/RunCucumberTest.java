import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty" },
        features = "src\\test\\resources\\features",
        glue = "StepDefinitions"
)
public class RunCucumberTest {
}
