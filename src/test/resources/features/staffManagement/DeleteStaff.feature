Feature: Delete staff functionality for admin users

  Background:
    Given user navigates to Login page
    And user logs in with 'admin' username and 'admin' password
    And user is redirected to Home page
    And user navigates to Staff page

  Scenario: User can delete a branch
    When user selects first element and clicks on Delete
    And user clicks on 'Delete' on displayed Staff Pop up
    Then staff is deleted

  Scenario: Branch is not deleted when user clicks on Cancel
    When user selects first element and clicks on Delete
    And user clicks on 'Cancel' on displayed Staff Pop up
    Then staff is not deleted
