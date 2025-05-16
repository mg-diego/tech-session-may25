package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigurationReader;

public class WebDriverManager {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            driver = createDriverSession();
        }
        return driver;
    }

    public void closeDriver() {
        if (driver != null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    protected WebDriver createDriverSession() {
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");// Update this path

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setCapability("unhandledPromptBehavior", "ignore");
        chromeOptions.addArguments("--disable-search-engine-choice-screen");

        var driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getWebUrl());

        return driver;
    }
}
