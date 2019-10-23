@web @regression @webproject @webprojectlaunch
Feature: Web Project Launch

  Background:
    Given I am on the launch page

  @FA2-236 @webprojectlaunch_1
  Scenario: Verify the current temperature is between the lowest and highest temperature from the Daily Timeline
    Then I verify current temperature is between the lowest and highest temperature from the Daily Timeline

  @FA2-220 @webprojectlaunch_2
  Scenario: Verify the temperature timeline for an individual day
    When I click on the temperature range for current day
    Then I verify the min temperature in the details field matches the min temperature in the temperature range
    And I verify the max temperature in the details field matches the max temperature in the temperature range

  @FA2-77 @webprojectlaunch_3
  Scenario: Verify Daily Timeline is displayed in two hour increments
    Then I verify the Daily Timeline is displayed in two hour increments
