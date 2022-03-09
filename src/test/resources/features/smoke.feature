/* 1) Please first update this branch
while you are on branch smoke!
git fetch
git pull

After updating smoke branch
2) add your smoke scenarios  with @smoke and @yourName tag



After adding your smoke scenario/s
3)  add and commit your changes


4) push your changes to remote smoke
after you push your changes

make sure
git status
you see smoke branch is up to date with origin/smoke

*/

Feature: Smoke

  @FLEETG-848 @FLEETG-851 @onur @smoke
  Scenario Outline: User can apply filters by typing the filter name, from the 'Manage Filters' menu.
    And user click "Manage Filter"
    When user apply filters by typing "<manage filters options>"
    Then the "<manage filters options>" should be seen and clickable
    Examples:
      | manage filters options |
      | Tags                   |
      | License Plate          |
      | Driver                 |
      | Location               |
      | Chassis Number         |
      | Model Year             |
      | Last Odometer          |

  @smoke @yusuf
  Scenario: You do not have permission to perform this action message for driver
    When user login as "driver"
    And user should navigate to "Fleet" "Vehicles" tab
    And user hover over the three dots at the end of each row for driver
    When user clicks on delete button
    Then Delete Confirmation popup should be displayed
    When user clicks Yes Delete button
    Then "You do not have permission to perform this action." message should be displayed for driver

  @smoke @yusuf
  Scenario Outline: Sales Manager and Store Manager can delete a car <userType>
    When user login as "<userType>"
    And user should navigate to "Fleet" "Vehicles" tab
    And user hover over the three dots at the end of each row
    When user clicks on delete button
    Then Delete Confirmation popup should be displayed
    When user clicks Yes Delete button
    Then "Item deleted" message should be displayed for sales and store manager

    Examples:
      | userType      |
      | sales manager |
      | store manager |

  @smoke @zafer
  Scenario: Column names in grid settings
    Given user on the login page
      #it can be any user type
    When user login as "store manager"
    And user should navigate to "Fleet" "Vehicles" tab
    When user clicks on the gear icon
    Then user should be able to see following options
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |


  @smoke @omer
  Scenario Outline: Verify that user can create car
    When user login as "store manager"
    And user navigate to "Fleet" "Vehicles"
    When user click Create Car button
    And user fill the form
      | License Plate                 | 290 JCC          |
      | Tags                          | Senior           |
      | Driver                        | <driverName>     |
      | Location                      | Kentucky         |
      | Chassis Number                | 1GNCS18Z3M011556 |
      | Model Year                    | 2020             |
      | Last Odometer                 | 2000             |
      | Immatriculation Date          | Mar 1, 2020      |
      | First Contract Date           | Mar 5, 2020      |
      | Catalog Value (VAT Incl.) ($) | 23500            |
      | Seats Number                  | 5                |
      | Doors Number                  | 4                |
      | Color                         | Blue             |
      | Transmission                  | Automatic        |
      | Fuel Type                     | Hybrid           |
      | CO2 Emissions                 | 2.7              |
      | Horsepower                    | 180              |
      | Horsepower Taxation           | 200              |
      | Power (KW)                    | 15000            |
      | Logo                          | logo.png         |

    When user choose "<saveButton>" option
    Then user should see "Entity saved" message after saving
    Examples:
      | saveButton     | driverName        |
      | Save           | Saruman the White |
      | Save and New   | Gandalf the White |
      | Save and Close | Gandalf the Grey  |

  @smoke @arslan
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


  @smoke @arslan
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
