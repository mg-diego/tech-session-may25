package StepDefinitions.API.user;

import API.user.LoginResource;
import StepDefinitions.API.ApiValidatorSteps;
import io.cucumber.java.en.When;

public class ApiLoginSteps {
    public static String token;

    @When("the POST Login endpoint is requested with {string} username and {string} password")
    public void theLoginEndpointIsRequestedWithAdminUsernameAndAdminPassword(String username, String password) {
        ApiValidatorSteps.response = LoginResource.post(username, password);

        token = ApiValidatorSteps.response.jsonPath().getString("detail.access_token");
    }
}
