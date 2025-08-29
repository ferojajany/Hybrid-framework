Feature: Search page validation
  @Search
  Scenario: Testing search page
    Given I am on the search page
    When User enter text to search and click on search button
    Then User should see "Greenery Bliss Cake - Chocolate Mini ,bento Cake" in the result
    Then verify all items displayed related to Search criteria

