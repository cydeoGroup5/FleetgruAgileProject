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