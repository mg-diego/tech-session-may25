package API;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public abstract class BaseResource {
    protected static String baseURI = "http://localhost:";

    public BaseResource() {
        RestAssured.baseURI = baseURI;
    }

    protected static RequestSpecification getAuthorizedBaseRequest(int port, String token) {
        return  RestAssured
                .given()
                    .contentType("application/json")
                    .port(port)
                    .header("Authorization", "Bearer " + token);
    }
}
