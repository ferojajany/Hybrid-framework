Feature: Login functionality for Kapruka  website
  @Login2
  Scenario Outline: Valid and invaoide outline attempts on kapruka
   Given I login with the webside
    When User enters "<email>" and "<password>"
    Then User clicks on the login button
    Then User should see"<errorMasseg>"
    Examples:
    | email               | password  | errorMasseg             |
    | feroja@gmail.com    | 123456    | Sorry, we did not find an account for that e-mail address|
    | jany@gmail.com      | 7655432   | Sorry, we did not find an account for that e-mail address.|
    | admin@gmail.com     | valid@6789 | Your password is wrong. Please try again.|
    | admin@gmail.com |  user@5432  | Your password is wrong. Please try again.|