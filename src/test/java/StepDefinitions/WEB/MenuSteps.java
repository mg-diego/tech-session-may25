package StepDefinitions.WEB;

import PageObjectModel.MenuPage;
import TestContext.TestContext;
import io.cucumber.java.en.Given;
import utils.Translator;

public class MenuSteps {
    private TestContext testContext;
    private final MenuPage menuPage;

    public MenuSteps(TestContext testContext) {
        this.testContext = testContext;
        this.menuPage = new MenuPage(testContext.getWebDriverManager().getDriver());
    }

    @Given("the user sets selects {string} menu option")
    public void selectMenuOption(String menuOption) throws InterruptedException {
        Translator.getTranslation(menuOption, this.testContext.getCurrentLanguage());
        this.menuPage.selectMenuOption(menuOption);
    }
}
