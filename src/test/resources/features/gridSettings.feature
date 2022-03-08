Feature: Grid Settings Functionality

  Background:
    Given user on the login page
    #it can be any user type
    When user login as "sales manager"
    And user should navigate to "Fleet" "Vehicles" tab

    Scenario: Grid settings should be visible when user clicks gear icon
      When user clicks on the gear icon
      Then user should be able to see grid settings

    Scenario: Column names in grid settings
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


