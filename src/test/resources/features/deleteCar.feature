
Feature: Delete A Car
  Background:
    Given user on the login page

  Scenario Outline: Sales or Store Manager see the delete button
    When user login as "<userType>"
    And user should navigate to "Fleet" "Vehicles" tab
    And user hover over the three dots at the end of each row
    Then user can see the delete button

    Examples:
    |userType|
    |sales manager|
    |store manager|

  Scenario: Driver see the delete button
    When user login as "driver"
    And user should navigate to "Fleet" "Vehicles" tab
    And user hover over the three dots at the end of each row for driver
    Then user can see the delete button

  Scenario Outline: Delete Confirmation popup display for sales and store manager
    When user login as "<userType>"
    And user should navigate to "Fleet" "Vehicles" tab
    And user hover over the three dots at the end of each row
    When user clicks on delete button
    Then Delete Confirmation popup should be displayed

    Examples:
      |userType|
      |sales manager|
      |store manager|

  Scenario: Delete Confirmation popup display for driver
    When user login as "driver"
    And user should navigate to "Fleet" "Vehicles" tab
    And user hover over the three dots at the end of each row for driver
    When user clicks on delete button
    Then Delete Confirmation popup should be displayed
  @smoke
  Scenario: You do not have permission to perform this action message for driver
    When user login as "driver"
    And user should navigate to "Fleet" "Vehicles" tab
    And user hover over the three dots at the end of each row for driver
    When user clicks on delete button
    Then Delete Confirmation popup should be displayed
    When user clicks Yes Delete button
    Then "You do not have permission to perform this action." message should be displayed for driver
  @smoke
  Scenario Outline: Sales Manager and Store Manager can delete a car <userType>
    When user login as "<userType>"
    And user should navigate to "Fleet" "Vehicles" tab
    And user hover over the three dots at the end of each row
    When user clicks on delete button
    Then Delete Confirmation popup should be displayed
    When user clicks Yes Delete button
    Then "Item deleted" message should be displayed for sales and store manager

    Examples:
      |userType|
      |sales manager|
      |store manager|

  Scenario Outline: Sales Manager and Store Manager can delete a car from General Information Page <userType>
    When user login as "<userType>"
    And user should navigate to "Fleet" "Vehicles" tab
    And user clicks on first raw from Cars table
    Then user navigates to General Information Page
    When user click on delete button
    And user clicks Yes Delete button
    Then "Car deleted" message should be displayed for Sales and Store Managers
    Examples:
      |userType|
      |sales manager|
      |store manager|


  Scenario Outline: When A Car Deleted, it is also be removed from the Fleet-Vehicle page <userType>
    When user login as "<userType>"
    And user should navigate to "Fleet" "Vehicles" tab
    And user clicks on first raw from Cars table
    Then user navigates to General Information Page
    When user click on delete button
    And user clicks Yes Delete button
    Then "Car deleted" message should be displayed for Sales and Store Managers
    Then the corresponding car should also be removed from the Fleet-Vehicle page.

    Examples:
      |userType|
      |sales manager|
      |store manager|