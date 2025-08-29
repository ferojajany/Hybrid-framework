Feature: Validate broken link on kapruka same day delivery
  @Links
  Scenario: Verify the links on the same page
    Given Navigate to Kapruka rush deoivary page
    When All the links are collected on the page
    Then Verify each link are not broken