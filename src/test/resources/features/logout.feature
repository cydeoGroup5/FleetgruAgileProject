@login
Feature: Logout Function

  Background:
    Given user on the login page

  #This is for specific user. No need to test for every user
  Scenario: Verify driver can logged out
    When user login as "driver"
    And user click logout button
    Then user should ends up the "Login" page



  #The codes below are for regression. For only logout function, the codes from above are enough.



  Scenario Outline: Verify user can logged out
    When user login as "<userType>"
    And user click logout button
    Then user should ends up the "Login" page
    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |


  Scenario Outline: Verify user can not land on Dashboard by clicking back button after logged out
    When user login as "<userType>"
    And user click logout button
    Then user should ends up the "Login" page
    When user click back button
    Then user should ends up the "Login" page
    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |


  Scenario Outline: Verify user logged out after closing the open tab
    When user login as "<userType>"
    And user open a new tab
    When user close the "Dashboard" page
    And user on the login page
    Then user should ends up the "Login" page

    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |


  Scenario Outline: Verify user logged out after closing all the open tabs
    When user login as "<userType>"
    And user open a new tab
    And user on the login page
    And user open a new tab
    When user close the "Dashboard" page
    And user on the login page
    Then user should ends up the "Login" page

    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |



