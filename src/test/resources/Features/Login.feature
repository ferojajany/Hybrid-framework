Feature: Login page validation
  @Login
  Scenario: Coustomer account Login
    Given URL is launched
    When user enters email and password and click on Login button
    Then Login should be successful
    And Attach Screenshot