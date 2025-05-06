package StepDefinitions;

import PageObjectModel.HomePage;
import io.cucumber.java.en.Then;

public class HomePageSteps extends WebStepBase {

    private HomePage homePage;

    public HomePageSteps() {
        homePage = new HomePage(super.webDriver);
    }

    @Then("the user is at Homepage")
    public void theUserIsAtHomepage() {
        this.homePage.checkUserIsAtHomePage();
    }
}
