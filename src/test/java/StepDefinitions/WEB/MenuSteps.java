package StepDefinitions.WEB;

import DriverManager.WebDriverManager;
import PageObjectModel.MenuPage;
import io.cucumber.java.en.Given;

public class MenuSteps extends WebStepBase {

    private final MenuPage menuPage;

    public MenuSteps() {
        this.menuPage = new MenuPage(WebDriverManager.getDriver());
    }

    @Given("the user sets selects {string} menu option")
    public void selectMenuOption(String menuOption) throws InterruptedException {
        this.menuPage.selectMenuOption(menuOption);
    }
}
