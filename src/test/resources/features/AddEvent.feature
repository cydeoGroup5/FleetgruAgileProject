
Feature: AddEvent

  Background:

    Given user on the login page


  Scenario: Driver Case
    When the Driver log in with valid credantials
    Then the user Hover Over Fleet and click  Vehicles
    And the user click any car info
    Then verify that General Information page opened and Driver cannot see Add Event Button
    And user click logout button_AddEvent

  Scenario: Sales Manager Can access Add Event Page
    When the Sales Manager log in with valid credantials
    Then the user Hover Over Fleet and click  Vehicles
    And the user click any car info
    Then verify that General Information page opened and Add Event Button is seen
    And user click logout button_AddEvent


  Scenario: Store Manager Can access Add Event Page
    When the Store Manager log in with valid credantials
    Then the user Hover Over Fleet and click  Vehicles
    And the user click any car info
    Then verify that General Information page opened and Add Event Button is seen
    And user click logout button_AddEvent


  Scenario: Sales Manager click() Add Event Button
    When the Sales Manager log in with valid credantials
    Then the user Hover Over Fleet and click  Vehicles
    And the user click any car info
    Then The User click Add Event Button
    And Verify that Add Event page should pop up.
    And user click logout button_AddEvent


  Scenario: Store Manager click() Add Event Button
    When the Store Manager log in with valid credantials
    Then the user Hover Over Fleet and click  Vehicles
    And the user click any car info
    Then The User click Add Event Button
    And Verify that Add Event page should pop up.
    And user click logout button_AddEvent

  Scenario: Sales Manager case : Add Event Page Compulsory fields
    When the Sales Manager log in with valid credantials
    Then the user Hover Over Fleet and click  Vehicles
    And the user click any car info
    Then The User click Add Event Button
    And Verify that List of Comp.Fields is <Title,Owner,Organizer display name,Organizer email,Start Date,End Date>
    And user click logout button_AddEvent

  Scenario: Store Manager case : Add Event Page Compulsory fields
    When the Store Manager log in with valid credantials
    Then the user Hover Over Fleet and click  Vehicles
    And the user click any car info
    Then The User click Add Event Button
    And Verify that List of Comp.Fields is <Title,Owner,Organizer display name,Organizer email,Start Date,End Date>
    And user click logout button_AddEvent

  Scenario Outline: Sales Manager case: One of the Compulsory field is empty
    When the Sales Manager log in with valid credantials
    Then the user Hover Over Fleet and click  Vehicles
    And the user click any car info
    Then The User click Add Event Button
    And The Sales Manager enters "<Title>" , "<Owner>" , "<Organizer display name>" , "<Organizer email>" , "<Start Date>" ,"<End Date>"
    Then Click The Save Button
    And Verify That "This value should not be blank." message appears.
    And user click logout button_AddEvent

    Examples:
      | Title | Owner  | Organizer display name | Organizer email   | Start Date  | End Date    |
      |       | Albert | Albert and his sons    | Alberco@gmail.com | Mar 1, 2022 | Mar 1, 2022 |
      | Try3  | Albert |                        | Alberco@gmail.com | Mar 1, 2022 | Mar 1, 2022 |
      | Try4  | Albert | Albert and his sons    |                   | Mar 1, 2022 | Mar 1, 2022 |
      | Try5  | Albert | Albert and his sons    | Alberco@gmail.com |             | Mar 1, 2022 |
      | Try6  | Albert | Albert and his sons    | Alberco@gmail.com | Mar 1, 2022 |             |