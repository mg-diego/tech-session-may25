package API.user;

import API.BaseResource;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginResource extends BaseResource {
    private static final String ENDPOINT = "/login/";
    private static final int PORT = 8001;

    public static Response post(String username, String password) {
        return RestAssured
                .given()
                    .port(PORT)
                    .queryParam("username", username)
                    .queryParam("password", password)
                .when()
                    .post(ENDPOINT);
    }
}
