package StepDefinitions.API.catalog;

import API.catalog.CatalogResource;
import Database.mongodb.CatalogDatabaseClient;
import StepDefinitions.API.ApiValidatorSteps;
import StepDefinitions.API.user.ApiLoginSteps;
import data.Catalog;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.bson.types.ObjectId;

import java.util.Map;

public class ApiCatalogSteps {

    @When("the GET Catalog endpoint is requested with {string} filter")
    public void theGetCatalogEndpointIsRequestedWithFilter(String filter) {
        ApiValidatorSteps.response = CatalogResource.get(filter, ApiLoginSteps.token);
    }

    @When("the POST Catalog endpoint is requested with values")
    public void thePostCatalogEndpointIsRequestedWith(DataTable table) {
        Map<String, String> firstRow = table.asMaps(String.class, String.class).get(0);
        ApiValidatorSteps.response = CatalogResource.post(new Catalog("", firstRow.get("Name"), firstRow.get("Description")), ApiLoginSteps.token);
    }

    @When("the DELETE Catalog endpoint is requested with {string} id")
    public void theDeleteCatalogEndpointIsRequestedWith(String id) {
        ApiValidatorSteps.response = CatalogResource.delete(id, ApiLoginSteps.token);
    }

    @When("the PUT Catalog endpoint is requested with values")
    public void thePutCatalogEndpointIsRequestedWith(DataTable table) {
        Map<String, String> firstRow = table.asMaps(String.class, String.class).get(0);
        ApiValidatorSteps.response = CatalogResource.put(Catalog
                .builder()
                    .id(firstRow.get("ID"))
                    .name(firstRow.get("Name"))
                    .description(firstRow.get("Description"))
                .build(),
            ApiLoginSteps.token);
    }

}
