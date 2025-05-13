package StepDefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiValidatorSteps {

    public static Response response;

    @Then("the response status code is {int}")
    public void responseStatusCodeIs(int expectedStatusCode) {
        assertThat(response.statusCode()).isEqualTo(expectedStatusCode).withFailMessage(response.asString());
    }

    @And("the response contains {string}")
    public void theResponseContains(String expectedResponse) {
        assertThat(response.asString()).contains(expectedResponse).withFailMessage(response.asString());
    }

    @And("the response does not contain {string}")
    public void theResponseDoesNotContain(String notExpectedResult) {
        assertThat(response.asString()).doesNotContain(notExpectedResult).withFailMessage(response.asString());
    }

    @And("the response contains the json key {string} with value {string}")
    public void theResponseContainsJsonKey(String jsonKey, String value) {
        assertThat(response.jsonPath().getString(jsonKey)).isEqualTo(value).withFailMessage(response.asString());
    }

    @And("the response contains the json key {string} with {int} items")
    public void theResponseContainsJsonKey(String jsonKey, int numberOfItems) {
        assertThat(response.jsonPath().getList(jsonKey).size()).isEqualTo(numberOfItems).withFailMessage(response.asString());
    }
}
