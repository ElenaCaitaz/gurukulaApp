Feature: Register new user functionality for admin users

  Scenario: All elements are displayed on Registration page
    Given user navigates to Welcome page
    When user clicks on Register a new account
    Then user is redirected to Registration page
    And Registration page has the following elements
      | Login                     |
      | E-mail                    |
      | New password              |
      | New password confirmation |
      | Register                  |

  Scenario Outline: User cannot create other user with incorrect details
    Given user navigates to Registration page
    And user fills in new user details with the following data
      | login   | email   | newPassword   | confirmPassword   |
      | EClogin | <email> | <newPassword> | <confirmPassword> |
      | EClogin | <email> | <newPassword> | <confirmPassword> |
    Then validation error is displayed '<message>'
    Examples:
      | newPassword | confirmPassword | email          | message                                                             |
      | pass        | password2       | test@email.com | Your password is required to be at least 5 characters.              |
      | password1   | 12j             | test@email.com | Your confirmation password is required to be at least 5 characters. |
      | password2   | password2       | test           | Your e-mail is invalid.                                             |
      | password2   | password2       | test@          | Your e-mail is invalid.                                             |
      | password2   | password2       | @domain.com    | Your e-mail is invalid.                                             |
      | password2   | password2       | 32             | Your e-mail is required to be at least 5 characters.                |

  Scenario: User cannot create other user when pass does not match
    Given user navigates to Registration page
    When user fills in new user details with the following data
      | login    | email          | newPassword | confirmPassword |
      | EClogin1 | test@email.com | password1   | 1password3      |
    When user clicks on Register
    Then error message is displayed 'The password and its confirmation do not match!' on Registration page