@web @regression @homework
Feature: Homework

  Background:
    Given I am on the home page

  @homework-1
  Scenario Outline: Verify that the red warning button and correct error message displays if an invalid email address is entered
    When I enter <firstname> into the firstname text field on the home page
    And I enter <lastname> into the lastname text field on the home page
    And I enter <email> into the email text field on the home page
    And I click on the new password text field on the home page
    Then I verify that the red warning button appears on the email text field
    When I click on the red warning button on the email text field on the home page
    Then I verify that an error message displays next to the email text field
    And I verify the text of the error message next to the email text field

    Examples:
      | firstname   | lastname    | email                         |
      | Palma       | Hintz       | plainaddress                  |
      | Mathew      | Boehm       | #@%^%#$@#$@#.com              |
      | Kasi        | Hermann     | @example.com                  |
      | Shandi      | Harber      | Joe Smith <email@example.com> |
      | Kendall     | Johnson     | email.example.com             |
      | Earnest     | Tillman     | email@example@example.com     |
      | Kristi      | Rippin      | .email@example.com            |
      | Lavern      | Frami       | email.@example.com            |
      | Chiquita    | Schinner    | email..email@example.com      |
      | Stephine    | Bauch       | あいうえお@example.com          |
      | Debbie      | Zemlak      | email@example.com (Joe Smith) |
      | Rico        | Welch       | email@example                 |
      | Tammera     | Bednar      | email@-example.com            |
      | Augustus    | O'Hara      | email@example.web             |
      | Armando     | Runolfsson  | email@111.222.333.44444       |
      | Russell     | Witting     | email@example..com            |
      | Zola        | Wyman       | Abc..123@example.com          |

  @homework-2
  Scenario: Verify the current month can be selected from the month drop down list
    Then I verify current month is in the month drop down list
    When I select current month from the month drop down list
    Then I verify that current month is displayed on the month drop down list

  @homework-3
  Scenario: Verify the month drop down list does not have duplicates
    Then I verify that the month drop down list has no duplicate values