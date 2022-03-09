#1- All user types can see all vehicle information under 'Fleet-Vehicles' module
#2- User can see the total page number
#3- User can go to next page clicking ">" button and can go to previous page clicking "<" button
#4- User can see total recordings of vehicles
#5- User can download table data in XLS or CSV format from "Export Grid" (a confirmation message is enough to validate)
@arslan
Feature: Vehicle Table View

  Background:
		#@FLEETG-853
    Given user on the login page


  Scenario Outline: All user types can see all vehicle information under 'Fleet-Vehicles' module
    Given user login as "<userType>"
    Given user should navigate to "Fleet" "Vehicles" tab
    Then Users can see all vehicle information table
    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |

  Scenario Outline: User can see the total page number
    Given user login as "<userType>"
    Given user should navigate to "Fleet" "Vehicles" tab
    Then User can see page number
    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |


  Scenario Outline: User can go to next page clicking ">" button and can go to previous page clicking "<" button
    Given user login as "<userType>"
    Given user should navigate to "Fleet" "Vehicles" tab
    Then User can click on a forward button
    And User can click on a backwards button
    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |

  Scenario Outline: User can see total recordings of vehicles
    Given user login as "<userType>"
    Given user should navigate to "Fleet" "Vehicles" tab
    Then User can see recording number of vehicles
    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |


  Scenario Outline: User can download table data in XLS or CSV format from "Export Grid"
    Given user login as "<userType>"
    Given user should navigate to "Fleet" "Vehicles" tab
    Then User can download XLS file from Export Grid
    And User can download CSV file from Export Grid
    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |