Feature: View and search staff functionality for admin users

  Background:
    Given user navigates to Login page
    And user logs in with 'admin' username and 'admin' password
    And user is redirected to Home page
    And user navigates to Staff page

  Scenario: User can view details of a staff
    When user selects first element and clicks on View
    Then user is redirected to Staff details page
    And Staff details page has the following elements
      | Name   |
      | Branch |
      | Back   |

  Scenario: user can search a staff
    When user searches for the 1 staff
    Then searched staff is displayed

