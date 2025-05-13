package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriverSession();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }

    protected static WebDriver createDriverSession() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setCapability("unhandledPromptBehavior", "ignore");
        chromeOptions.addArguments("--disable-search-engine-choice-screen");

        var driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.get("http://localhost:8501");

        return driver;
    }
}
