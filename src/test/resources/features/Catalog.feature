Feature: Catalog

  Scenario: Create Catalog
    Given the user sets username "admin"
    And the user sets password 'admin'
    When the user clicks on Submit button
    Then the user is at Homepage
    When the user sets selects 'Catalog' menu option
    Then the user is at Catalog
    When the user clicks in Create New - Catalog
    And the user sets 'name' as Catalog name
    And the user sets 'description' as Catalog description
    And the user clicks in Create new catalog - Dialog
    # PENDING TO CHECK THE CONFIRMATION NOTIFICATIOn


  Scenario: Edit Catalog
   # PENDING

  Scenario: Delete Catalog
    Given the catalog is inserted in database
      | Name  | Description   |
      | diego | description 2 |