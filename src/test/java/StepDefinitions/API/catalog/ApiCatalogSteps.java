package StepDefinitions.API.catalog;

import API.catalog.CatalogResource;
import TestContext.TestContext;
import data.models.Catalog;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.Map;

public class ApiCatalogSteps {
    
    private static TestContext catalogTestContext;
    
    public ApiCatalogSteps(TestContext testContext) {
        catalogTestContext = testContext;
    }

    @When("the GET Catalog endpoint is requested with {string} filter")
    public void theGetCatalogEndpointIsRequestedWithFilter(String filter) {
        catalogTestContext.setLastResponse(CatalogResource.get(filter, catalogTestContext.getToken()));
    }

    @When("the POST Catalog endpoint is requested with values")
    public void thePostCatalogEndpointIsRequestedWith(DataTable table) {
        Map<String, String> firstRow = table.asMaps(String.class, String.class).get(0);
        catalogTestContext.setLastResponse(CatalogResource.post(new Catalog("", firstRow.get("Name"), firstRow.get("Description")), catalogTestContext.getToken()));
    }

    @When("the DELETE Catalog endpoint is requested with {string} id")
    public void theDeleteCatalogEndpointIsRequestedWith(String id) {
        catalogTestContext.setLastResponse(CatalogResource.delete(id, catalogTestContext.getToken()));
    }

    @When("the PUT Catalog endpoint is requested with values")
    public void thePutCatalogEndpointIsRequestedWith(DataTable table) {
        Map<String, String> firstRow = table.asMaps(String.class, String.class).get(0);
        catalogTestContext.setLastResponse(CatalogResource.put(Catalog
                .builder()
                    .id(firstRow.get("ID"))
                    .name(firstRow.get("Name"))
                    .description(firstRow.get("Description"))
                .build(),
            catalogTestContext.getToken()));
    }

}
