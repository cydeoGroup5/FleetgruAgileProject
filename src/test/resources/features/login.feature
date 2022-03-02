@logout
Feature: Login Function

  Background: User navigate to login page
    Given user on the login page

  #This is for specific user. No need to test for every user
  Scenario: Verify driver can login with valid credentials
    When user login as "driver"
    Then user should land on "Quick Launchpad" page


    #The codes below are for regression. For only login function, the codes from above are enough.





  Scenario Outline: Verify all users can login with valid credentials
    When user login as "<userType>"
    Then user should land on "<expectedPage>" page

    Examples:
      | userType      | expectedPage    |
      | driver        | Quick Launchpad |
      | store manager | Dashboard       |
      | sales manager | Dashboard       |


  Scenario Outline: Verify user can not login with invalid credentials
    When user enter "<username>" and "<password>"
    And user click login button
    Then "Invalid user name or password." message should be displayed
    Examples:
      | username | password    |
      | user1    | password    |
      | username | UserUser123 |
      | username | password    |

  Scenario Outline: Verify user can not login without credentials
    When user enter "<username>" and "<password>"
    And user click login button
    Then "Please fill out this field." pop up should be displayed
    Examples:
      | username | password    |
      | user1    |             |
      |          | UserUser123 |
      |          |             |

  Scenario: Verify forgot password function is working
    Then user should see "Forgot your password?" link is displayed
    When user click Forgot Password? link
    Then user should navigate to "Forgot Password" page


  Scenario: Verify Remember Me checkbox is working
    Then user should see Remember me checkbox is displayed
    When user click Remember Me checkbox
    Then checkbox should be selected


  Scenario Outline: Verify user see password as bullet sign
    When user enter "<username>" and "<password>"
    Then user should see password as bullet sign
    Examples:
      | username | password    |
      | user1    | UserUser123 |


  Scenario Outline: Verify Enter key is working
    When user enter "<username>" and "<password>"
    And user hit Enter key
    Then user should land on "<expectedPage>" page

    Examples:
      | username        | password    | expectedPage    |
      | user1           | UserUser123 | Quick Launchpad |
      | storemanager85  | UserUser123 | Dashboard       |
      | salesmanager101 | UserUser123 | Dashboard       |



  Scenario Outline: Verify user see own username in the profile menu
    When  user enter "<username>" and "<password>"
    And user hit Enter key
    Then user should see "<username>" in the profile menu
    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | salesmanager101 | UserUser123 |
      | storemanager85  | UserUser123 |