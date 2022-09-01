Feature: Login Test
  Description: Login tests for Sauce Labs

  Background:
    Given I am on login page

  @login
  Scenario: Can login with valid credentials
    When login with 'valid username'
    Then product page is displayed

  @login
  Scenario: Cannot login with locked username
    When login with 'locked username'
    Then login error is displayed as "Epic sadface: Sorry, this user has been locked out."

    #Should fail due to performance issue
  @login
  Scenario: Login with performance username
    When login with 'performance username'
    Then product page is displayed


  @login
  Scenario: Cannot login with without username
    When login without username
    Then login error is displayed as "Epic sadface: Username is required"

  @login
  Scenario: Cannot login without password
    When login without password
    Then login error is displayed as "Epic sadface: Password is required"





