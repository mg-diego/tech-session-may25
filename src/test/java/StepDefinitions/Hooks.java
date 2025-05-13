package StepDefinitions;

import API.user.LoginResource;
import Database.mongodb.CatalogDatabaseClient;
import Database.mongodb.MongoDbClient;
import DriverManager.WebDriverManager;
import StepDefinitions.API.ApiValidatorSteps;
import StepDefinitions.API.user.ApiLoginSteps;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;

import java.util.Objects;

public class Hooks {

    @BeforeAll
    public static void beforeAll() {
        // Read config.json
    }

    @AfterAll
    public static void afterAll() {

    }

    @Before()
    public void beforeScenario(Scenario scenario) {
        if (scenario.getSourceTagNames().stream().anyMatch(tag -> Objects.equals(tag.toUpperCase(), "@WEB"))) {
            WebDriverManager.getDriver();
        }
        var catalogDatabaseClient = new CatalogDatabaseClient();
        catalogDatabaseClient.deleteAllDocuments("catalog");
        ApiValidatorSteps.response = null;
        ApiLoginSteps.token = "";
    }

    @After
    public void afterScenario(Scenario scenario) {
        WebDriverManager.closeDriver();
    }
}