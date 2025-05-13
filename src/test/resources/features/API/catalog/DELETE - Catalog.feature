@API
Feature: API DELETE Catalog

  Scenario: DELETE - Catalog (No token)
    When the DELETE Catalog endpoint is requested with '123' id
    Then the response status code is 401
    And the response contains the json key 'detail' with value 'Token invalid'

  Scenario Outline: DELETE - Catalog (<Scenario>)
    Given the POST Login endpoint is requested with 'admin' username and 'admin' password
    Then the response status code is 200
    When the DELETE Catalog endpoint is requested with '<id>' id
    Then the response status code is <statusCode>
    And the response contains the json key 'detail' with value '<error>'

    Examples:
      | Scenario        | id                       | statusCode | error                                                                                                      |
      | Wrong id format | 123                      | 500        | Unexpected error: \'123\' is not a valid ObjectId, it must be a 12-byte input or a 24-character hex string |
      | Not existing ID | a89f5260c9e2d3688a158e22 | 404        | NOT_FOUND                                                                                                  |

  Scenario: DELETE - Catalog
    Given the following catalogs are inserted in database
      | ID                       | Name  | Description   |
      | a89f5260c9e2d3688a158e22 | diego | description 1 |
    And the POST Login endpoint is requested with 'admin' username and 'admin' password
    Then the response status code is 200
    When the DELETE Catalog endpoint is requested with 'a89f5260c9e2d3688a158e22' id
    Then the response status code is 200