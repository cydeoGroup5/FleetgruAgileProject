@FLEETG-911
Feature: Default

	
	@FLEETG-901 @FLEETG-900
	Scenario Outline: User can apply filters by typing the filter name, from the 'Manage Filters' menu.
		Given user on the login page
		Given user login as "sales manager"
		Given user should navigate to "Fleet" "Vehicles" tab
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

	
	@FLEETG-902 @FLEETG-900
	Scenario: You do not have permission to perform this action message for driver
		Given user on the login page
		When user login as "driver"
		And user should navigate to "Fleet" "Vehicles" tab
		And user hover over the three dots at the end of each row for driver
		When user clicks on delete button
		Then Delete Confirmation popup should be displayed
		When user clicks Yes Delete button
		Then "You do not have permission to perform this action." message should be displayed for driver