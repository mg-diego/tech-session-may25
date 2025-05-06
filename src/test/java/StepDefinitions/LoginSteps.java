package StepDefinitions;

import PageObjectModel.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps extends WebStepBase {
    private LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage(super.webDriver);
    }

    @Given("the user sets username {string}")
    public void userSetsUsername(String username) {
        this.loginPage.setUsername(username);
    }

    @Given("the user sets password {string}")
    public void userSetsPassword(String password) {
        this.loginPage.setPassword(password);
    }

    @When("the user clicks on Submit button")
    public void theUserClicksOnSubmitButton() {
        this.loginPage.clickSubmit();
    }
}
