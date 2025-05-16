package StepDefinitions;

import Database.mongodb.CatalogDatabaseClient;
import Database.postgresql.LanguageDatabaseClient;
import DriverManager.WebDriverManager;
import TestContext.TestContext;
import data.enums.Languages;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;
import utils.ConfigurationReader;

import java.util.Objects;

public class Hooks {
    private TestContext hooksTestContext;

    public Hooks(TestContext testContext) {
        hooksTestContext = testContext;
    }

    @BeforeAll
    public static void beforeAll() {
        ConfigurationReader.loadConfiguration();
    }

    @AfterAll
    public static void afterAll() {

    }

    @Before()
    public void beforeScenario(Scenario scenario) {
        System.out.println("Starting scenario: " + Thread.currentThread().getName());

        if (scenario.getSourceTagNames().stream().anyMatch(tag -> Objects.equals(tag.toUpperCase(), "@WEB"))) {
            hooksTestContext.setWebDriverManager(new WebDriverManager());
        }

        CatalogDatabaseClient.deleteAllDocuments("catalog");
        LanguageDatabaseClient.updateLanguageTo(Languages.ENGLISH.getLocale());

        hooksTestContext.setCurrentLanguage(Languages.ENGLISH);
        hooksTestContext.setLastResponse(null);
        hooksTestContext.setToken("");
    }

    @After
    public void afterScenario(Scenario scenario) {
        var webDriver = hooksTestContext.getWebDriverManager();
        if (webDriver != null) {
            webDriver.closeDriver();
        }
    }
}