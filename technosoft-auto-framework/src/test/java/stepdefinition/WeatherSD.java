package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.LaunchPage;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class WeatherSD {

    private LaunchPage launchPage = new LaunchPage();
    private final int MAX_ITEMS_DAILY_TIMELINE = 12;
    private final int DAILY_TIMELINE_INCREMENT = 2;
    private final String CURRENT_TIME_NOW = "Now";
    private final String AM_STRING = "am";
    private final String PM_STRING = "pm";

    @Given("^I am on the launch page$")
    public void iAmOnTheLaunchPage()
    {
        Assert.assertTrue(SharedSD.getDriver().getTitle().startsWith("Dark Sky"), "Invalid Launch Page");
    }

    @When("^I click on the temperature range for current day$")
    public void clickOnTemperatureRangeForCurrentDay()
    {
        launchPage.clickOnTempRangeFieldForCurrentDay();
    }

    @Then("^I verify current temperature is between the lowest and highest temperature from the Daily Timeline$")
    public void verifyCurrentTempBetweenMinMaxFromDailyTimeLine()
    {
        int currentTemp = launchPage.getCurrentTemperature();
        int minTemp  = launchPage.getMinTempFromDailyTimeLine();
        int maxTemp = launchPage.getMaxTempFromDailyTimeLine();

        Assert.assertTrue(currentTemp >= minTemp && currentTemp <= maxTemp,
                "Current Temperature (" + currentTemp + ") is not between lowest ("+ minTemp +") and highest ("+ maxTemp +") temperature from Daily Timeline");
    }

    @Then("^I verify the min temperature in the details field matches the min temperature in the temperature range$")
    public void verifyMinTempRangeMatchesDetailsForCurrentDay()
    {
        int minTempOnTempRange = launchPage.getMinTempOnTempRangeFieldForToday();
        int minTempOnDayDetails = launchPage.getMinTempOnDayDetailsFieldForToday();

        Assert.assertTrue(minTempOnTempRange == minTempOnDayDetails,
                "Lowest temperature on the temperature range (" + minTempOnTempRange + ") is not the same as lowest temperature on day details (" + minTempOnDayDetails + ") for today");

    }

    @Then("^I verify the max temperature in the details field matches the max temperature in the temperature range$")
    public void verifyMaxTempRangeMatchesDetailsForCurrentDay()
    {
        int maxTempOnTempRange = launchPage.getMaxTempOnTempRangeFieldForToday();
        int maxTempOnDayDetails = launchPage.getMaxTempOnDayDetailsFieldForToday();

        Assert.assertTrue(maxTempOnTempRange == maxTempOnDayDetails,
                "Highest temperature on the temperature range (" + maxTempOnTempRange + ") is not the same as highest temperature on day details (" + maxTempOnDayDetails + ") for today");
    }

    @Then("^I verify the Daily Timeline is displayed in two hour increments$")
    public void verifyDailyTimeLineDisplayedTwoHrIncrements()
    {
        String[] dailyTimeLine = launchPage.getDailyTimeLine();
        String[] dailyTimeLineFromCurrentTime = getDailyTimeLineFromCurrentTime();

        Assert.assertEquals(Arrays.toString(dailyTimeLine),Arrays.toString(dailyTimeLineFromCurrentTime), "Daily timeline is not displayed in two hour increments from current time" );

    }

    private String[] getDailyTimeLineFromCurrentTime()
    {
        String[] timeline = new String[MAX_ITEMS_DAILY_TIMELINE];

        timeline[0] = CURRENT_TIME_NOW;

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.HOUR, DAILY_TIMELINE_INCREMENT);

        String AM_PM;
        int hour;

        for(int i = 1; i < timeline.length ; i++)
        {
            if(c.get(Calendar.AM_PM) == Calendar.AM)
                AM_PM = AM_STRING;
            else
                AM_PM = PM_STRING;

            hour = c.get(Calendar.HOUR);

            if(hour == 0)
                hour = 12;

            timeline[i] = hour + "" + AM_PM;
            c.add(Calendar.HOUR, DAILY_TIMELINE_INCREMENT);
        }

        return timeline;
    }

}
