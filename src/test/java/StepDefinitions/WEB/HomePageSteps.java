package StepDefinitions.WEB;

import PageObjectModel.HomePage;
import TestContext.TestContext;
import io.cucumber.java.en.Then;

public class HomePageSteps {

    private final HomePage homePage;

    public HomePageSteps(TestContext testContext) {
        homePage = new HomePage(testContext.getWebDriverManager().getDriver());
    }

    @Then("the user is at Homepage")
    public void theUserIsAtHomepage() {
        this.homePage.checkUserIsAtHomePage();
    }
}
