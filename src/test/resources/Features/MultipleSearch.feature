Feature: Multiple search page validation
  @MultipleSearch
  Scenario: Testing multiple search page
    Given User am on the search page
    When User enter input to search and click on search button
    Then Verify all items displayed related to text