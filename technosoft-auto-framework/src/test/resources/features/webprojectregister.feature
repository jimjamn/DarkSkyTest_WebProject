@web @regression @webproject @webprojectregistration
Feature: Web Project Registration

  Background:
    Given I am on the register page

  @FA2-304 @webprojectregister_1
  Scenario: Verify invalid signup error message
    When I click on the register button
    Then I verify the error message displayed next to the email text field