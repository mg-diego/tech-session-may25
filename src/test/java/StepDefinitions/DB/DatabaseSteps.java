package StepDefinitions.DB;

import Database.mongodb.CatalogDatabaseClient;
import Database.postgresql.LanguageDatabaseClient;
import TestContext.TestContext;
import data.enums.Languages;
import data.models.Catalog;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class DatabaseSteps {
    private TestContext testContext;
    private CatalogDatabaseClient catalogDatabaseClient;

    public DatabaseSteps(TestContext testContext) {
        this.testContext = testContext;
        this.catalogDatabaseClient = new CatalogDatabaseClient();
    }

    @Given("the following catalogs are inserted in database")
    public void theCatalogIsInsertedInDatabase(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (var row : rows) {
            this.catalogDatabaseClient.insertCatalog(
                    Catalog.builder()
                            .id(row.get("ID"))
                            .name(row.get("Name"))
                            .description(row.get("Description"))
                        .build()
            );
        }
    }

    @Given("the language is set to {string} in database")
    public void theLanguageIsSetToInDatabase(String locale) {
        var language = Languages.fromLocale(locale);
        testContext.setCurrentLanguage(language);
        LanguageDatabaseClient.updateLanguageTo(language.getLocale());
    }
}
