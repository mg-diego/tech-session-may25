@WEB
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
    # PENDING TO CHECK THE CONFIRMATION NOTIFICATION


  Scenario Outline: Edit Catalog
    Given the language is set to '<Language>' in database
    Given the following catalogs are inserted in database
      | Name  | Description   |
      | diego | description 2 |
    Given the user sets username "admin"
    And the user sets password 'admin'
    When the user clicks on Submit button
    Then the user is at Homepage
    When the user sets selects 'TRANSLATIONS.MENU_CATALOG_BUTTON' menu option
    Then the user is at Catalog
    # CLICK EDIT BUTTON AND VERIFY

    Examples:
      | Language |
      | en       |
      | es       |
      | pt       |
      | fr       |
      | jp       |

  Scenario: Delete Catalog
    Given the following catalogs are inserted in database
      | Name  | Description   |
      | diego | description 2 |
    Given the user sets username "admin"
    And the user sets password 'admin'
    When the user clicks on Submit button
    Then the user is at Homepage
    When the user sets selects 'Catalog' menu option
    Then the user is at Catalog
    # CLICK DELETE BUTTON AND VERIFY