package StepDefinitions.API;

import TestContext.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiValidatorSteps {
    private TestContext ApiTestContext;
    
    public ApiValidatorSteps(TestContext testcontext) {
        ApiTestContext = testcontext;
    }   
    @Then("the response status code is {int}")
    public void responseStatusCodeIs(int expectedStatusCode) {
        assertThat(ApiTestContext.getLastResponse().getStatusCode()).isEqualTo(expectedStatusCode).withFailMessage(getLastResponseAsString());
    }

    @And("the response contains {string}")
    public void theResponseContains(String expectedResponse) {
        assertThat(getLastResponseAsString()).contains(expectedResponse).withFailMessage(getLastResponseAsString());
    }

    @And("the response does not contain {string}")
    public void theResponseDoesNotContain(String notExpectedResult) {
        assertThat(getLastResponseAsString()).doesNotContain(notExpectedResult).withFailMessage(getLastResponseAsString());
    }

    @And("the response contains the json key {string} with value {string}")
    public void theResponseContainsJsonKey(String jsonKey, String value) {
        assertThat(ApiTestContext.getLastResponse().jsonPath().getString(jsonKey)).isEqualTo(value).withFailMessage(getLastResponseAsString());
    }

    @And("the response contains the json key {string} with {int} items")
    public void theResponseContainsJsonKey(String jsonKey, int numberOfItems) {
        assertThat(ApiTestContext.getLastResponse().jsonPath().getList(jsonKey).size()).isEqualTo(numberOfItems).withFailMessage(getLastResponseAsString());
    }
    
    private String getLastResponseAsString() {
        return ApiTestContext.getLastResponse().asString();
    }
}
