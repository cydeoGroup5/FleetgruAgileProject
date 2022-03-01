@wip
Feature: Login Function

  Background: User navigate to login page
    Given user on the login page


  #  #TODO:We can comment out this scenario outline
  Scenario Outline: Verify all users can login with valid credentials
    When user login as "<userType>"
    Then user should land on "<expectedPage>" page

    Examples:
      | userType      | expectedPage    |
      | driver        | Quick Launchpad |
      | store manager | Dashboard       |
      | sales manager | Dashboard       |


  #This is for specific user. No need to test for every user
  Scenario: Verify driver can login with valid credentials
    When user login as "driver"
    Then user should land on "Quick Launchpad" page