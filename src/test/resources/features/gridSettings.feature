Feature: Grid Settings Functionality

  Background:
    Given user on the login page
    #it can be any user type
    When user login as "store manager"
    And user should navigate to "Fleet" "Vehicles" tab
    When user clicks on the gear icon

    Scenario: Grid settings should be visible when user clicks gear icon
      Then user should be able to see grid settings

    Scenario: Column names in grid settings
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

      Scenario: Quick search box working properly
        #it is valid for all columns
        And user types "Tags"
        Then user should be able to see "Tags" column

      Scenario:Clicking column name on grid settings should make appear column name table
        #it is valid for all columns
        When user clicks on the "Driver"
        Then user should be able to select the "Driver"

      Scenario: User arrange the order of the columns
        Then user should be able to arrange the order of the columns

      Scenario: User can see all changes on the All Cars table in accordance with Grid Settings
        #it is valid for all columns
        When  user clicks on the "Tags"
        Then user should be able to see the "Tags"




