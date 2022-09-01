Feature: Login Test
  Description: Login tests for Sauce Labs

  Background:
    Given I am on login page


  @checkoutpage
  Scenario: Assert first name input is mandatory
    When item is added and checkout page is opened
    And text "Joe" is added to "first name" input
    And text "Bloggs" is added to "last name" input
    And continue button is selected
    Then address error is displayed as "Error: Postal Code is required"

  @checkoutpage
  Scenario: Assert last name input is mandatory
    When item is added and checkout page is opened
    And text "Joe" is added to "first name" input
    And text "add" is added to "address" input
    And continue button is selected
    Then address error is displayed as "Error: Last Name is required"


  @checkoutpage
  Scenario: Assert address input is mandatory
    When item is added and checkout page is opened
    And text "Joe" is added to "first name" input
    And text "Bloggs" is added to "last name" input
    And continue button is selected
    Then address error is displayed as "Error: Postal Code is required"