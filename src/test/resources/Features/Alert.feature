Feature: Validate the alert text and accept the alert
  @Alert
  Scenario: Validate the alert text and accept the alert
    Given User on the account page
    When User enters invalide information and click creat account button
    Then verify alert text and accept the alert