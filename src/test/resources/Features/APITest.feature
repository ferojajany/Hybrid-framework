Feature: Create a new user in the pet store
  @pet
  Scenario: Successfully create a new user
    Given I add the pet store endpoint
    When  I add a user with following details
  | id     | 0         |
  |username|feroja12345|
  |firstName|Feroja|
  |lastName| Jany|
  |email|feroja@gmail.com|
  |password|1234567|
  |phone|12345677|
  |userStatus|1|
  Then I should receive status code 200