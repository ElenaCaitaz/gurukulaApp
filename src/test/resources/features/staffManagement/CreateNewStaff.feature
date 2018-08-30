Feature: Create staff functionality for admin users

  Background:
    Given user navigates to Login page
    And user logs in with 'admin' username and 'admin' password
    And user is redirected to Home page

  Scenario: User can access and view staff page
    When user clicks on Entities and selects Staff
    Then user is redirected to Staff page
    And Staff page has the following elements
      | Create a new Staff |
      | Search a Staff     |

  Scenario: User can create new Staff
    Given user navigates to Staff page
    When user clicks on Create a new Staff
    And user sets the value for name input
    And user selects the 8 from branch dropdown
    And user clicks on Save staff
    Then staff is created

  Scenario: User cannot create a new Staff with incorrect details
    Given user navigates to Staff page
    When user clicks on Create a new Staff
    And user sets the value 'r2133' for name input
    Then validation error is displayed 'This field should follow pattern ^[a-zA-Z\s]*$.' on staff pop up

  Scenario: Staff is not created when user clicks on Cancel
    Given user navigates to Staff page
    When user clicks on Create a new Staff
    And user sets the value 'StaffOne' for name input
    And user selects the 7 from branch dropdown
    And user clicks on Cancel staff
    Then staff is not created