package StepDefinitions.WEB;

import DriverManager.WebDriverManager;
import PageObjectModel.CatalogPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatalogSteps extends WebStepBase {

    private final CatalogPage catalogPage;

    public CatalogSteps() {
        this.catalogPage = new CatalogPage(WebDriverManager.getDriver());
    }

    @Then("the user is at Catalog")
    public void theUserIsAtCatalog() {
        this.catalogPage.checkUserIsAtCatalog();
    }

    @When("the user clicks in Create New - Catalog")
    public void theUserClicksInCreateNewCatalog() {
        this.catalogPage.clickCreateNewButton();
    }

    @And("the user sets {string} as Catalog name")
    public void theUserSetsAsCatalogName(String name) {
        this.catalogPage.setCatalogName(name);
    }

    @And("the user sets {string} as Catalog description")
    public void theUserSetsAsCatalogDescription(String description) {
        this.catalogPage.setCatalogDescription(description);
    }

    @And("the user clicks in Create new catalog - Dialog")
    public void theUserClicksInCreateNewCatalogDialog() {
        this.catalogPage.clickCreateCatalogDialogButton();
    }
}
