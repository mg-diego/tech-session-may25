@WEB
Feature: Login

  Scenario Outline: [<Browser> - <Version> - <Resolution>] - Login
    Given the user sets username "admin"
    And the user sets password 'admin'
    When the user clicks on Submit button
    Then the user is at Homepage

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