package PageObjectModel;

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
        WebElement selectedMenuOption;
        switch(menuOption.toLowerCase()) {
            case "homepage":
                selectedMenuOption = menuOptions.get(0);
                break;
            case "catalog":
                selectedMenuOption = menuOptions.get(1);
                break;
            case "user management":
                selectedMenuOption = menuOptions.get(2);
                break;
            case "language":
                selectedMenuOption = menuOptions.get(3);
                break;
            case "logout":
                selectedMenuOption = menuOptions.get(4);
                break;
            default:
                throw new UnsupportedOperationException(String.format("Menu option %s not available.", menuOption));
        }

        clickElement(selectedMenuOption);
    }
}
