package DriverManager;

import data.enums.Browsers;
import data.models.ScenarioConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigurationReader;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverManager {

    private WebDriver driver;

    public void initDriver(ScenarioConfiguration scenarioConfiguration) throws MalformedURLException {
        this.driver = createDriverSession(scenarioConfiguration);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        if (driver != null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    protected WebDriver createDriverSession(ScenarioConfiguration scenarioConfiguration) throws MalformedURLException {
        WebDriver driver = null;
        var browser = scenarioConfiguration.getBrowser();

        if (browser == Browsers.CHROME) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.setCapability("unhandledPromptBehavior", "ignore");
            chromeOptions.addArguments("--disable-search-engine-choice-screen");
            chromeOptions.setCapability("browserVersion", scenarioConfiguration.getVersion());
            chromeOptions.setCapability("se:recordVideo", true);
            chromeOptions.setCapability("se:name", scenarioConfiguration.getName());
            chromeOptions.setCapability("se:sessionName", "LoginTest_TC001");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        }

        if (browser == Browsers.FIREFOX) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setAcceptInsecureCerts(true);
            firefoxOptions.setCapability("unhandledPromptBehavior", "ignore");
            firefoxOptions.setCapability("browserVersion", scenarioConfiguration.getVersion());
            firefoxOptions.setCapability("se:recordVideo", true);
            firefoxOptions.setCapability("se:name", scenarioConfiguration.getName());
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
        }

        if (browser == Browsers.EDGE) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setAcceptInsecureCerts(true);
            edgeOptions.setCapability("unhandledPromptBehavior", "ignore");
            edgeOptions.setCapability("browserVersion", scenarioConfiguration.getVersion());
            edgeOptions.setCapability("se:recordVideo", true);
            edgeOptions.setCapability("se:name", scenarioConfiguration.getName());
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), edgeOptions);
        }

        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getWebUrl());

        return driver;
    }
}
