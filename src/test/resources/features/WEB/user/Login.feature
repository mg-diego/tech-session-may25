@WEB
Feature: Login

  Scenario: Login
    Given the user sets username "admin"
    And the user sets password 'admin'
    When the user clicks on Submit button
    Then the user is at Homepage