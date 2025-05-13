@API

Feature: API GET Catalog

  Scenario: GET - Catalog (No token)
    When the GET Catalog endpoint is requested with 'filter' filter
    Then the response status code is 401
    And the response contains the json key 'detail' with value 'Token invalid'

  Scenario: GET - Catalog (No results)
    Given the POST Login endpoint is requested with 'admin' username and 'admin' password
    Then the response status code is 200
    When the GET Catalog endpoint is requested with 'filter' filter
    Then the response status code is 200
    And the response contains '[]'

  Scenario: GET - Catalog (Filter with values)
    Given the following catalogs are inserted in database
      | Name        | Description   |
      | diego       | description 1 |
      | diego extra | description 2 |
      | another     | description 3 |
    And the POST Login endpoint is requested with 'admin' username and 'admin' password
    Then the response status code is 200
    When the GET Catalog endpoint is requested with 'diego' filter
    Then the response status code is 200
    And the response contains the json key 'detail' with 2 items
    And the response contains the json key 'detail[0].name' with value 'diego'
    And the response contains the json key 'detail[0].description' with value 'description 1'
    And the response contains the json key 'detail[1].name' with value 'diego extra'
    And the response contains the json key 'detail[1].description' with value 'description 2'
    And the response does not contain 'another'
    And the response does not contain 'description 3'

  Scenario: GET - Catalog (Filter retrieve no values)
    Given the following catalogs are inserted in database
      | Name        | Description   |
      | diego       | description 1 |
      | diego extra | description 2 |
      | another     | description 3 |
    And the POST Login endpoint is requested with 'admin' username and 'admin' password
    Then the response status code is 200
    When the GET Catalog endpoint is requested with 'fake' filter
    Then the response status code is 200
    And the response contains the json key 'detail' with 0 items