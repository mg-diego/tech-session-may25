package StepDefinitions.API.user;

import API.user.LoginResource;
import TestContext.TestContext;
import io.cucumber.java.en.When;

public class ApiLoginSteps {
    public static TestContext apiTestContext;

    public ApiLoginSteps(TestContext testContext) {
        apiTestContext = testContext;
    }

    @When("the POST Login endpoint is requested with {string} username and {string} password")
    public void theLoginEndpointIsRequestedWithAdminUsernameAndAdminPassword(String username, String password) {
        var token = LoginResource.post(username, password);

        apiTestContext.setToken(token.jsonPath().getString("detail.access_token"));
        apiTestContext.setLastResponse(token);
    }
}
