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
        |userType|
        |sales manager|
        |store manager|