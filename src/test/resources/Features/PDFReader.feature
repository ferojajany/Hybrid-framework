Feature: Read excel file
  @PDFReader
  Scenario: Customer account login
    Given I am on the login page
    When I login with the website
    Then I should see dashbord
    When Read the excel
    Then Varify text in excel