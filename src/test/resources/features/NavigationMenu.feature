@FLEETG-828
Feature: Navigation menu

  Background: User navigate to login page
    Given user on the login page

  Scenario Outline: Verify to see the General Information page
    Given user login as "<userType>"
    Then user should land on "<expectedPage>" page
    And the user navigates to "Fleet", "Vehicles"
    Then the user should land on the "Car - Entities - System - Car - Entities - System" page

    Examples:
      | userType      | expectedPage    |
      | driver        | Quick Launchpad |
      | store manager | Dashboard       |
      | sales manager | Dashboard       |


  Scenario Outline: Verify to see the General Information page <userType>
    Given user login as "<userType>"
    And the user navigates to "Fleet", "Vehicles"
    And user clicks on the eye icon

    Examples:
      | userType      |
      | sales manager |
      | store manager |

@Smoke
  Scenario Outline: Verify to see the General Information page for driver
    Given user login as "<userType>"
    When the user navigates to "Fleet", "Vehicles"
    And user clicks on the eye icon
    Then the user should land on the "General Information"
    Then the user should see "Add Event" "Delete" "Edit" buttons
    Examples:
      | userType      |
      | sales manager |
      | store manager |


  Scenario: Verify to see the General Information page for driver
    Given user login as "driver"
    And the user navigates to "Fleet", "Vehicles"
    And user clicks on the eye icon for driver
    Then the user should land on the "General Information"
    Then the user should not see "Add Event" "Delete" "Edit" buttons



  Scenario: Verify to see the General Information page for driver
    Given user login as "store manager"
    And the user navigates to "Fleet", "Vehicles"
    And user clicks on the eye icon
    Then the user should land on the "General Information"
    And the user take the information from General Information page
    And the user goes back the "Fleet-Vehicle" page
    And the user take the information from Fleet-Vehicle page
    Then Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same