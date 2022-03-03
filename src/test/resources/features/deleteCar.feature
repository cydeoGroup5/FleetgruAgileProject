Feature: Delete A Car
  Background:
    Given user on the login page
@wip
  Scenario Outline: Sales or Store Manager see the delete button
    When user login as "<userType>"
    And user should navigate to "Fleet" "Vehicles" tab
    And user hover over the three dots at the end of each row
    Then user can see the delete button

    Examples:
    |userType|
    |sales manager|
    |store manager|
  @wip
  Scenario: Driver see the delete button
    When user login as "driver"
    And user should navigate to "Fleet" "Vehicles" tab
    And user hover over the three dots at the end of each row for driver
    Then user can see the delete button