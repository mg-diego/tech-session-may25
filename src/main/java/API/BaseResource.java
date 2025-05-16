package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.ConfigurationReader;

public abstract class BaseResource {
    protected static String baseURI = ConfigurationReader.getApiBaseUrl();

    public BaseResource() {
        RestAssured.baseURI = baseURI;
    }

    protected static RequestSpecification getAuthorizedBaseRequest(int port, String token) {
        return  RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .port(port)
                    .header("Authorization", "Bearer " + token);
    }
}
