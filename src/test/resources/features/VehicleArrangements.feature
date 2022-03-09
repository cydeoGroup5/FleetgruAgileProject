Feature: Vehicle Table Arrangements

  Background:

    Given user on the login page
    Given user login as "sales manager"
    Given user should navigate to "Fleet" "Vehicles" tab

  Scenario: View Per Page assertion

    When user click on View Per Page button
    Then user should see numbers to be displayed

      | 10  |
      | 25  |
      | 50  |
      | 100 |


  Scenario: Default value View Per Page button

    Then user should see default value is "25"


  Scenario:  View Per Page values clickable

    When user click on View Per Page button
    Then user can select any value in View Per Page menu

  @mst
  Scenario Outline: Ascending order clicking the <column> name

    When user click any "<column>"
    Then user should see "<column>" in "ascending" order

    Examples:
      | column         |
      | License Plate  |
      | Tags           |
      | Driver         |
      | Location       |
      | Model Year     |
      | Chassis Number |
      | Last Odometer  |
      | Seats Number   |


  Scenario Outline: Descending order clicking the column name

    When user click any "<column>" two times
    Then user should see "<column>" in "descending" order
    Examples:
      | column              |
      | Doors Number        |
      | Color               |
      | Transmission        |
      | Fuel Type           |
      | CO2 Emissions       |
      | Horsepower Taxation |
      | Power (kW)          |

  @mst
  Scenario Outline: User can remove all sorting

    When user click any "<column>"
    And user click on refresh button
    Then user should see all sorting are removed

    Examples:
      | column |
      | Driver |