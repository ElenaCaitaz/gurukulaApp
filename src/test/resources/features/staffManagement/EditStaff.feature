Feature: Edit staff functionality for admin users

  Background:
    Given user navigates to Login page
    And user logs in with 'admin' username and 'admin' password
    And user is redirected to Home page
    And user navigates to Staff page

  Scenario: User can edit a Staff
    When user selects first element and clicks on Edit
    And user sets the value for name input
    And user selects the 9 from branch dropdown
    And user clicks on Save staff
    Then staff is updated

  Scenario: User cannot edit a Staff with incorrect details
    When user selects first element and clicks on Edit
    And user sets the value 'r2133' for name input
    Then validation error is displayed 'This field should follow pattern ^[a-zA-Z\s]*$.' on staff pop up

  Scenario:Staff is not updated when user clicks on Cancel
    When user selects first element and clicks on Edit
    And user sets the value for name input
    And user selects the 9 from branch dropdown
    And user clicks on Cancel staff
    Then staff is not updated