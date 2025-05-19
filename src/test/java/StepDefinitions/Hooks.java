package StepDefinitions;

import Database.mongodb.CatalogDatabaseClient;
import Database.mongodb.MongoDbClient;
import Database.postgresql.LanguageDatabaseClient;
import DriverManager.WebDriverManager;
import TestContext.TestContext;
import data.enums.Browsers;
import data.enums.Languages;
import data.models.ScenarioConfiguration;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterAll;
import utils.ConfigurationReader;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public void beforeScenario(Scenario scenario) throws MalformedURLException {
        var scenarioTags = scenario.getSourceTagNames().toArray(new String[0]);

        if (Arrays.stream(scenarioTags).anyMatch(x -> x.equalsIgnoreCase("@WEB"))) {
            var scenarioConfiguration = generateScenarioConfiguration(scenario.getName());

            hooksTestContext.setWebDriverManager(new WebDriverManager());
            hooksTestContext.getWebDriverManager().initDriver(scenarioConfiguration);
        }

        MongoDbClient.open();
        CatalogDatabaseClient.clearCatalogCollection();
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

        MongoDbClient.close();
    }

    private ScenarioConfiguration generateScenarioConfiguration(String scenarioName) {
        var configurationString = scenarioName.substring(scenarioName.indexOf("[") + 1);
        configurationString = configurationString.substring(0, configurationString.indexOf("]"));
        List<String> configuration = Arrays.stream(configurationString.split("-")).collect(Collectors.toList());

        return new ScenarioConfiguration(Browsers.valueOf(configuration.get(0).trim()), configuration.get(1).trim(), configuration.get(2).trim(), scenarioName);
    }
}