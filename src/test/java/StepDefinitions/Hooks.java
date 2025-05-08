package StepDefinitions;

import Database.mongodb.MongoDbClient;
import DriverManager.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;

public class Hooks {

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.getDriver();
    }

    @AfterAll
    public static void afterAll() {
        WebDriverManager.closeDriver();
    }

    @Before(value="diego")
    public void beforeScenario(Scenario scenario) {
        var mongoDbClient = new MongoDbClient();
        mongoDbClient.deleteAllDocuments("catalog");
    }

    @After
    public void afterScenario(Scenario scenario) {
        // Clean up resources, close WebDriver, etc.
    }
}