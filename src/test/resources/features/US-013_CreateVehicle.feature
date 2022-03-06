@wip
Feature: Create Car Function

  Background:
    Given user on the login page


#  Scenario: Verify that driver can not see Create Car button
#    When user login as "driver"
#    And user navigate to "Fleet" "Vehicles"
#    Then user should not see Create Car button

  @done
  Scenario Outline: Verify that managers can see Create Car button
    When user login as "<userType>"
    And user navigate to "Fleet" "Vehicles"
    Then user should see Create Car button

    Examples:
      | userType      |
      | store manager |
      | sales manager |

  @done
  Scenario: Verify that user can see all data titles
    When user login as "store manager"
    And user navigate to "Fleet" "Vehicles"
    When user click Create Car button
    Then user should see following titles
      | License Plate                 |
      | Tags                          |
      | Driver                        |
      | Location                      |
      | Chassis Number                |
      | Model Year                    |
      | Last Odometer                 |
      | Immatriculation Date          |
      | First Contract Date           |
      | Catalog Value (VAT Incl.) ($) |
      | Seats Number                  |
      | Doors Number                  |
      | Color                         |
      | Transmission                  |
      | Fuel Type                     |
      | CO2 Emissions                 |
      | Horsepower                    |
      | Horsepower Taxation           |
      | Power (KW)                    |
      | Logo                          |

  @done
  Scenario: Verify that user see following options for tags
    When user login as "store manager"
    And user navigate to "Fleet" "Vehicles"
    When user click Create Car button
    Then user should see following check box names

      | Junior       |
      | Senior       |
      | Employee Car |
      | Purchased    |
      | Compact      |
      | Sedan        |
      | Convertible  |

  @done
  Scenario: Verify that user see following option under Transmission dropdown
    When user login as "store manager"
    And user navigate to "Fleet" "Vehicles"
    When user click Create Car button
    Then user should see following option under Transmission dropdown
      | Manual    |
      | Automatic |

  @done
  Scenario: Verify that user see following option under Fuel Type dropdown
    When user login as "store manager"
    And user navigate to "Fleet" "Vehicles"
    When user click Create Car button
    Then user should see following option under Fuel Type dropdown
      | Gasoline |
      | Diesel   |
      | Electric |
      | Hybrid   |

  @done
  Scenario: Verify that user can upload Logo
    When user login as "store manager"
    And user navigate to "Fleet" "Vehicles"
    When user click Create Car button
    And user upload "logo.png"
    Then user can upload "logo.png"

  @done
  Scenario: Verify that user can select 3 different save option
    When user login as "store manager"
    And user navigate to "Fleet" "Vehicles"
    When user click Create Car button
    Then user should see following option under sava dropdown
      | Save And Close |
      | Save And New   |
      | Save           |


  @firstCheck
  Scenario Outline: Verify that user can create car
    When user login as "store manager"
    And user navigate to "Fleet" "Vehicles"
    When user click Create Car button
    And user fill the form
      | License Plate                 | 290 JCC           |
      | Tags                          | Senior            |
      | Driver                        | Saruman the White |
      | Location                      | Kentucky          |
      | Chassis Number                | 1GNCS18Z3M011556 |
      | Model Year                    | 2020              |
      | Last Odometer                 | 2000              |
      | Immatriculation Date          | Mar 1, 2020       |
      | First Contract Date           | Mar 5, 2020       |
      | Catalog Value (VAT Incl.) ($) | 23500             |
      | Seats Number                  | 5                 |
      | Doors Number                  | 4                 |
      | Color                         | Blue              |
      | Transmission                  | Automatic         |
      | Fuel Type                     | Hybrid            |
      | CO2 Emissions                 | 2.7               |
      | Horsepower                    | 180               |
      | Horsepower Taxation           | 200               |
      | Power (KW)                    | 15000             |
      | Logo                          | logo.png          |

    When user choose "<saveButton>" option
    Then user should see "Entity saved" message after saving
    Examples:
      | saveButton     |
      | Save           |
#      | Save and New   |
#      | Save and Close |


    #TODO: Create a unhappy path scenario and use SoftAssertion