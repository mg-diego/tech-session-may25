package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    @FindBy(xpath="//*[@data-testid='stHeading']")
    private WebElement homepageHeader;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void checkUserIsAtHomePage() {
        homepageHeader.isDisplayed();
    }
}
