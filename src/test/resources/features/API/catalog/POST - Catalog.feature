@API

Feature: API POST Catalog

  Scenario: POST - Catalog (No token)
    When the POST Catalog endpoint is requested with values
      | Name | Description |
      | test | value       |
    Then the response status code is 401
    And the response contains the json key 'detail' with value 'Token invalid'

  Scenario: POST - Catalog (Check values)
    Given the POST Login endpoint is requested with 'admin' username and 'admin' password
    Then the response status code is 200
    When the POST Catalog endpoint is requested with values
      | Name | Description |
      | test | value       |
    Then the response status code is 200
    And the response contains the json key 'detail.name' with value 'test'
    And the response contains the json key 'detail.description' with value 'value'

  Scenario Outline: POST - Catalog (<Scenario>)
    Given the POST Login endpoint is requested with 'admin' username and 'admin' password
    Then the response status code is 200
    When the POST Catalog endpoint is requested with values
      | Name   | Description   |
      | <name> | <description> |
    Then the response status code is 400
    And the response contains the json key 'detail' with value '<responseContent>'

    Examples:
      | Scenario                   | name | description | responseContent   |
      | Empty Name                 |      | description | EMPTY_NAME        |
      | Empty Description          | name |             | EMPTY_DESCRIPTION |
      | Empty Name and Description |      |             | EMPTY_NAME        |