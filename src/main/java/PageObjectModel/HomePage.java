package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class HomePage extends PageBase {

    @FindBy(xpath="//*[@id='welcome-to-the-testing-sample-app']")
    private WebElement homepageHeader;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void checkUserIsAtHomePage() {
        assertThat(homepageHeader.isDisplayed()).isTrue();
    }
}
