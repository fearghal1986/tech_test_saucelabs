Feature: Login Test
  Description: Login tests for Sauce Labs

  Background:
    Given I am on login page

  @product
  Scenario: Item can be purchased from site
    When login with 'valid username'and empty cart
    And item "Sauce Labs Backpack" is added to cart and Products Page reopened
    Then cart displays "1"

  @product
  Scenario: Item can be added to cart
    When login with 'valid username'and empty cart
    And item "Sauce Labs Backpack" is added to cart and Products Page reopened
    Then cart displays "1"

  @product
  Scenario: Item can be removed from cart
    When login with 'valid username'and empty cart
    And item "Sauce Labs Backpack" is added to cart and Products Page reopened
    Then cart is emptied and nothing displayed in cart

  @product
  Scenario: Multiple Items can be added to cart
    When login with 'valid username'and empty cart
    And item "Sauce Labs Backpack" is added to cart and Products Page reopened
    And item "Sauce Labs Bike Light" is added to cart and Products Page reopened
    Then cart displays "2"

  @product
  Scenario: Items can be removed from multiple additions to cart
    When login with 'valid username'and empty cart
    And "2" items are added to cart
    Then cart displays "1" after item removed

  @product
  Scenario: Button updates when item added to cart
    When login with 'valid username'and empty cart
    And item "Sauce Labs Backpack" is added to cart
    Then remove button is displayed

    #running this scenario to show issue with problem user will be captured
  @product
  Scenario: Button updates when item added to cart with problem user
    When login with 'problem username'and empty cart
    And item "Sauce Labs Backpack" is added to cart
    Then remove button is displayed