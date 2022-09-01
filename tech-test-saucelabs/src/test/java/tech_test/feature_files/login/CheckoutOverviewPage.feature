Feature: Login Test
  Description: Login tests for Sauce Labs

  Background:
    Given I am on login page

  @checkoutoverview
  Scenario: Assert item can be purchased
    When item is added and checkout page is opened
    And valid name and address details are entered
    Then user selects finish and the sale is completed

    #Showing issue with problem user will be captured
  @checkoutoverview
  Scenario: Assert item can be purchased with problem user
    When item is added and checkout page is opened with problem user
    And valid name and address details are entered
    Then user selects finish and the sale is completed