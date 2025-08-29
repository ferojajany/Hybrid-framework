Feature: Account page validation
  @Login3
  Scenario: Create new account
    Given URL is launched and navigate to the account page
    When User enters name, email and password and Click create account button
    Then  User should be Unsuccessful
    When  User check language