Feature: Edit branch functionality for admin users

  Background:
    Given user navigates to Login page
    And user logs in with 'admin' username and 'admin' password
    And user is redirected to Home page
    And user navigates to Branch page

  Scenario: User can edit a Branch
    When user selects first element and clicks on Edit
    And all input fields are cleared
    And name and code are inserted
    And user clicks on Save
    Then branch is updated

  Scenario Outline: User cannot edit a Branch with incorrect details
    When user selects first element and clicks on Edit
    And all input fields are cleared
    And name '<name>' and code ' <code> ' are inserted
    Then validation error is displayed '<message>' on branch pop-up
    Examples:
      | name  | code | message                                             |
      | e     |      | This field is required to be at least 5 characters. |
      |       | 1    | This field is required to be at least 2 characters. |
      | r2133 |      | This field should follow pattern ^[a-zA-Z\s]*$.     |
      |       | tn   | This field should follow pattern ^[A-Z0-9]*$.       |

  Scenario: User cannot create new Branch when clicks on Cancel
    When user selects first element and clicks on Edit
    And all input fields are cleared
    And name and code are inserted
    And user clicks on Cancel
    Then branch is not updated
