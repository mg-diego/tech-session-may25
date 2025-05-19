@WEB
Feature: Catalog

  Scenario Outline: [<Browser> - <Version> - <Resolution>] - Create Catalog
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

    @Chrome
    Examples:
      | Browser | Resolution | Version |
      | CHROME  | 1920x1080  | 136     |
      | CHROME  | 1024x768   | 96      |

    @Firefox
    Examples:
      | Browser | Resolution | Version |
      | FIREFOX | 1920x1080  | 136     |
      | FIREFOX | 1024x768   | 96      |

    @Edge
    Examples:
      | Browser | Resolution | Version |
      | EDGE    | 1920x1080  | 136     |
      | EDGE    | 1024x768   | 96      |


  Scenario Outline: [<Browser> - <Version> - <Resolution>] - Edit Catalog
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

    @Chrome
    Examples:
      | Browser | Resolution | Version | Language |
      | CHROME  | 1920x1080  | 136     | en       |
      | CHROME  | 1024x768   | 96      | es       |

    @Firefox
    Examples:
      | Browser | Resolution | Version | Language |
      | FIREFOX | 1920x1080  | 136     | pt       |
      | FIREFOX | 1024x768   | 96      | fr       |

    @Edge
    Examples:
      | Browser | Resolution | Version | Language |
      | EDGE    | 1920x1080  | 136     | en       |
      | EDGE    | 1024x768   | 96      | jp       |


  Scenario Outline: [<Browser> - <Version> - <Resolution>] - Delete Catalog
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

    @Chrome
    Examples:
      | Browser | Resolution | Version |
      | CHROME  | 1920x1080  | 136     |
      | CHROME  | 1024x768   | 96      |

    @Firefox
    Examples:
      | Browser | Resolution | Version |
      | FIREFOX | 1920x1080  | 136     |
      | FIREFOX | 1024x768   | 96      |

    @Edge
    Examples:
      | Browser | Resolution | Version |
      | EDGE    | 1920x1080  | 136     |
      | EDGE    | 1024x768   | 96      |