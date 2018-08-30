Feature: Create branch functionality for admin users

  Background:
    Given user navigates to Login page
    And user logs in with 'admin' username and 'admin' password
    And user is redirected to Home page

  Scenario: User can access and view Branch page
    When user clicks on Entities and selects Branch
    Then user is redirected to Branch page
    And Branch page has the following elements
      | Create a new Branch |
      | Search a Branch     |

  Scenario: User can create new Branch
    And user navigates to Branch page
    When user clicks on Create a new Branch
    And name and code are inserted
    And user clicks on Save
    Then branch is created

  Scenario Outline: User cannot create a new Branch with incorrect details
    And user navigates to Branch page
    When user clicks on Create a new Branch
    And name '<name>' and code '<code>' are inserted
    Then validation error is displayed '<message>' on branch pop-up
    Examples:
      | name  | code | message                                             |
      | e     |      | This field is required to be at least 5 characters. |
      |       | 1    | This field is required to be at least 5 characters. |
      | r2133 |      | This field should follow pattern ^[a-zA-Z\s]*$.     |
      |       | tn   | This field should follow pattern ^[A-Z0-9]*$.       |

  Scenario: User cannot create new Branch when clicks on Cancel
    And user navigates to Branch page
    When user clicks on Create a new Branch
    And name and code are inserted
    And user clicks on Cancel
    Then branch is not created