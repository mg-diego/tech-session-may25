package StepDefinitions;

import DriverManager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebStepBase {
    protected WebDriver webDriver;

    public WebStepBase() {
        this.webDriver = WebDriverManager.getDriver();
    }
}
