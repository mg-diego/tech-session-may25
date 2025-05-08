package StepDefinitions.DB;

import Database.mongodb.CatalogDatabaseClient;
import data.Catalog;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.Map;

public class DatabaseSteps {

    private CatalogDatabaseClient catalogDatabaseClient;

    public DatabaseSteps() {
        this.catalogDatabaseClient = new CatalogDatabaseClient();
    }

    @Given("the catalog is inserted in database")
    public void theCatalogIsInsertedInDatabase(DataTable table) {
        Map<String, String> firstRow = table.asMaps(String.class, String.class).get(0);
        this.catalogDatabaseClient.insertCatalog(new Catalog("", firstRow.get("Name"), firstRow.get("Description")));
    }
}
