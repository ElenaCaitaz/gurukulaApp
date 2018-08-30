Feature: Forget Password functionality for admin users

  Background:
    Given user navigates to Login page
    And user clicks on forget password link
    And user is redirected to Reset Password page

  Scenario: User cannot reset password with an unregistered email
    When user fills in the email input field with 'test@email.com'
    And user clicks on Reset Password
    Then 'error message' is displayed 'E-Mail address isn't registered! Please check and try again' on Reset page

  Scenario Outline: User cannot create other user with incorrect email
    When user fills in the email input field with '<email>'
    Then 'validation error' is displayed 'Your e-mail is invalid.' on Reset page
    Examples:
      | email                      |
      | plainaddress               |
      | test@                      |
      | @domain.com                |
      | email.domain.com           |
      | email@domain.com Joe Smith |

