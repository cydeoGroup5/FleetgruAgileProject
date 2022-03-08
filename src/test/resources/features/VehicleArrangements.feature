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


  Scenario: default value View Per Page button

    Then user should see default value is "25"


  Scenario:  View Per Page values clickable

    When user click on View Per Page button
    Then user can select any value in View Per Page menu

  @mst
  Scenario Outline: ascending order clicking the <column> name

    When user click any "<column>"
    Then user should see "<column>" in "ascending" order

    Examples:
      | column               |
      | License Plate        |
#      | Tags                 |
#      | Driver               |
#     | Location             |
#      | Model Year           |
#      | Chassis Number       |
#      | Last Odometer        |
#      | Immatriculation Date |
#      | First Contract Date  |
#      | CVVI                 |
#      | Seats Number         |
#      | Doors Number         |
#      | Color                |
#      | Transmission         |
#      | Fuel Type            |
#      | CO2 Emissions        |
#      | Horsepower           |
#      | Horsepower Taxation  |
#      | Power (kW)           |


  Scenario Outline: descending order clicking the column name

    When user click any "<column>" two times
    Then user should see "<column>" in "descending" order
    Examples:
      | column               |
      | Driver        |