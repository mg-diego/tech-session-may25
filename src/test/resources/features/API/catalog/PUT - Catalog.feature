@API
Feature: API PUT Catalog

  Scenario: PUT - Catalog (No token)
    When the PUT Catalog endpoint is requested with values
      | ID                       | Name | Description |
      | 68234725f9099814f13a0fd2 | name | description |
    Then the response status code is 401
    And the response contains the json key 'detail' with value 'Token invalid'

  Scenario Outline: PUT - Catalog (<Scenario>)
    Given the POST Login endpoint is requested with 'admin' username and 'admin' password
    Then the response status code is 200
    When the PUT Catalog endpoint is requested with values
      | ID   | Name   | Description   |
      | <ID> | <Name> | <Description> |
    Then the response status code is <statusCode>
    And the response contains the json key 'detail' with value '<responseContent>'

    Examples:
      | Scenario          | ID                       | Name | Description | responseContent   | statusCode |
      | Not existing      | 68234725f9099814f13a0fd2 | name | description | NOT_FOUND         | 404        |
      | Empty ID          |                          | name | description | EMPTY_ID          | 400        |
      | Empty Name        | 68234725f9099814f13a0fd2 |      | description | EMPTY_NAME        | 400        |
      | Empty Description | 68234725f9099814f13a0fd2 | name |             | EMPTY_DESCRIPTION | 400        |


  Scenario: PUT - Catalog
    Given the following catalogs are inserted in database
      | ID                       | Name  | Description   |
      | 68234725f9099814f13a0fd2 | diego | description 1 |
    Given the POST Login endpoint is requested with 'admin' username and 'admin' password
    Then the response status code is 200
    When the PUT Catalog endpoint is requested with values
      | ID                       | Name   | Description    |
      | 68234725f9099814f13a0fd2 | diego2 | description 22 |
    Then the response status code is 200
    And the response contains the json key 'detail._id' with value '68234725f9099814f13a0fd2'
    And the response contains the json key 'detail.name' with value 'diego2'
    And the response contains the json key 'detail.description' with value 'description 22'