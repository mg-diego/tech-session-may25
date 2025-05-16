package StepDefinitions.WEB;

import PageObjectModel.LoginPage;
import TestContext.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(TestContext testContext) {
        loginPage = new LoginPage(testContext.getWebDriverManager().getDriver());
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
