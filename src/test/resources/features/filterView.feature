@FLEETG-852
Feature: As a store manager and sales manager, I should be able to add an event[ Filter Menu General]

	Background:
		#@FLEETG-853
		Given user on the login page
		#@FLEETG-844
		 Given user login as "sales manager"
		#@FLEETG-845
		Given user should navigate to "Fleet" "Vehicles" tab
		


	#When a user clicks on the filter icon, the "Manage Filter" button should be visible
	@FLEETG-846 @FLEETG-851
	Scenario:  When a user clicks on the filter icon, the "Manage Filter" button should be visible
		When user clicks on filter icon
		    Then the "Manage Filter" button should be visible	


	#User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.
	@FLEETG-847 @FLEETG-851
	Scenario Outline: User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.
		When user click "Manage Filter"
		    Then user can apply filters by  clicking on the "<filter name>"
		    Examples:
		      |filter name|
		      | Tags     |
		      | Driver   |	


	#User can apply filters by typing the filter name, from the 'Manage Filters' menu.
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


	#User can apply multiple filters at the same time
	@FLEETG-849 @FLEETG-851
	Scenario Outline: User can apply multiple filters at the same time
		And user click "Manage Filter"
		    When User clicks "<tab1>""<tab2>""<tab3>"
		    Then the filters "<tab1>""<tab2>""<tab3>" are checked
		    Examples:
		      | tab1 | tab2   | tab3       |
		      | Tags | Driver | Model Year |


	#User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module
	@FLEETG-850 @FLEETG-851
	Scenario:  User can remove all filters by clicking on the reset icon, under the 'Fleet-Vehicles' module
		When user clicks on the reset icon
		    Then All filters should be removed