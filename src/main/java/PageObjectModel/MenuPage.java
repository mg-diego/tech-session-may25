package PageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuPage extends PageBase {

    @FindBy(xpath= "//*[@role='tab']")
    private List<WebElement> menuOptions;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void selectMenuOption(String menuOption) throws InterruptedException {
        Thread.sleep(2000);
        WebElement selectedMenuOption = switch (menuOption.toLowerCase()) {
            case "homepage" -> menuOptions.get(0);
            case "catalog" -> menuOptions.get(1);
            case "user management" -> menuOptions.get(2);
            case "language" -> menuOptions.get(3);
            case "logout" -> menuOptions.get(4);
            default ->  throw new UnsupportedOperationException(String.format("Menu option %s not available.", menuOption));
        };

        clickElement(selectedMenuOption);
    }
}
