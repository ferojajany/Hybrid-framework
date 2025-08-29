Feature: Dropdown validation
  @Dropdown
  Scenario: Verify dropdown contains expected option
    Given I am on the dropdown page
    When I select option from the dropdown
    Then I should see expected option is selected