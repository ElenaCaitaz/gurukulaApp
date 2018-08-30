Feature: View and search branch functionality for admin users

  Background:
    Given user navigates to Login page
    And user logs in with 'admin' username and 'admin' password
    And user is redirected to Home page
    And user navigates to Branch page

  Scenario: User can view details of a Branch
    When user selects first element and clicks on View
    Then user is redirected to Branch details page
    And Branch details page has the following elements
      | Name |
      | Code |
      | Back |

  Scenario: user can search a Branch
#    Given 20 branches are created
    When user searches for the 5 branch
    Then the correct branch is displayed



