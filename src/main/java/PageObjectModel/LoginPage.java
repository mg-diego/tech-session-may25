package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    @FindBy(id="text_input_1")
    private WebElement usernameInput;

    @FindBy(xpath="//*[@autocomplete='new-password']")
    private WebElement passwordInput;

    @FindBy(xpath="//*[@data-testid='stBaseButton-primary']")
    private WebElement submitButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username) {
        sendKeysElement(usernameInput, username);
    }

    public void setPassword(String password) {
        sendKeysElement(passwordInput, password);
    }

    public void clickSubmit() {
        clickElement(submitButton);
    }
}
