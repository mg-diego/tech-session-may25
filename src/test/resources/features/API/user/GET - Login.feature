@API
Feature: API POST Login

  Scenario Outline: POST - Login
    When the POST Login endpoint is requested with '<username>' username and '<password>' password
    Then the response status code is <statusCode>
    And the response contains '<responseContent>'

    Examples:
      | username | password | statusCode | responseContent     |
      | admin    | admin    | 200        | bearer              |
      | fake     | admin    | 404        | USER_NOT_FOUND      |
      | admin    | fake     | 404        | USER_WRONG_PASSWORD |
      | fake     | fake     | 404        | USER_NOT_FOUND      |