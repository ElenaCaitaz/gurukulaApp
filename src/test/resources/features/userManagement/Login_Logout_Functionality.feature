Feature: Login Logout functionality for Admin users

  Scenario: User is able to access Welcome page
    When user navigates to Welcome page
    Then Welcome page has the following elements
      | Account                |
      | login                  |
      | Register a new account |

  Scenario: User is able to log in with valid password and user name
    Given user navigates to Welcome page
    And user clicks on Login link
    When user logs in with 'admin' username and 'admin' password
    Then user is redirected to Home page
    And alert message is displayed 'You are logged in as user "admin".'
    And Home page has the following elements
      | Home     |
      | Entities |
      | Account  |

  Scenario Outline: User cannot log in with invalid credentials
    Given user navigates to Login page
    When user logs in with '<username>' username and '<password>' password
    Then error message is displayed 'Authentication failed! Please check your credentials and try again.'
    Examples:
      | username | password  |
      | admin    | password1 |
      | Noname   | admin     |
      | Noname   | password1 |
      |          |           |

  Scenario: User is able to log out
    Given user navigates to Login page
    When user logs in with 'admin' username and 'admin' password
    Then user is redirected to Home page
    And user clicks on Account menu and logs out
    And user is redirected to Welcome page