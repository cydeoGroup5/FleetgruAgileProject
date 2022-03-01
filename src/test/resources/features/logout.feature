@wip
Feature: Logout Function

  Background:
    Given user on the login page

  #TODO:We can comment out this scenario outline
  Scenario Outline: Verify user can logged out
    When user login as "<userType>"
    And user click logout button
    Then user should ends up the "Login" page
    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |


  #This is for specific user. No need to test for every user
  Scenario: Verify driver can logged out
    When user login as "driver"
    And user click logout button
    Then user should ends up the "Login" page