package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends PageBase {

    @FindBy(xpath = "//*[@data-testid='stBaseButton-primary']")
    private WebElement createNewButton;

    @FindBy(xpath = "//*[@aria-label='Name']")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@aria-label='Description']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//*[@data-testid='stBaseButton-secondary']")
    private List<WebElement> createCatalogDialogButton;

    @FindBy(xpath = "//*[@data-testid='stForm']")
    private List<WebElement> catalogList;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public void checkUserIsAtCatalog() {
        createNewButton.isDisplayed();
    }

    public void clickCreateNewButton() {
        clickElement(createNewButton);
    }

    public void setCatalogName(String name) {
        sendKeysElement(nameInput, name);
    }

    public void setCatalogDescription(String description) {
        sendKeysElement(descriptionInput, description);
    }

    public void clickCreateCatalogDialogButton() {
        clickElement(createCatalogDialogButton.stream().filter(WebElement::isDisplayed).findFirst().get());
    }
}
