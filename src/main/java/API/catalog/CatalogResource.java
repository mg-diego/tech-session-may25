package API.catalog;

import API.BaseResource;
import data.models.Catalog;
import io.restassured.response.Response;

public class CatalogResource extends BaseResource {
    private static final String ENDPOINT = "/catalog/";
    private static final int PORT = 8002;

    public static Response get(String filter, String token) {
        return getAuthorizedBaseRequest(PORT, token)
                    .queryParam("filter", filter)
                .when()
                    .get(ENDPOINT);
    }

    public static Response post(Catalog catalog, String token) {
        catalog.name = catalog.name != null ? catalog.name : "";
        catalog.description = catalog.description != null ? catalog.description : "";

        return getAuthorizedBaseRequest(PORT, token)
                    .body(catalog)
                .when()
                    .post(ENDPOINT);
    }

    public static Response put(Catalog catalog, String token) {
        catalog.id = catalog.id != null ? catalog.id : "";
        catalog.name = catalog.name != null ? catalog.name : "";
        catalog.description = catalog.description != null ? catalog.description : "";

        return getAuthorizedBaseRequest(PORT, token)
                    .body(catalog)
                .when()
                    .put(ENDPOINT);
    }

    public static Response delete(String id, String token) {
        return getAuthorizedBaseRequest(PORT, token)
                    .queryParam("catalog_id", id)
                .when()
                    .delete(ENDPOINT);
    }
}
