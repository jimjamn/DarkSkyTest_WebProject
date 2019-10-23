package framework.webPages;

import org.openqa.selenium.By;

public class LaunchPage extends BasePage {

    private By darkSkyAPIButton = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    private By currentTemperatureField = By.xpath("//span[@class='summary swap']");
    private By dailyTimeLineTemperatureListField = By.xpath("//div[@class='scroll-container']//div[@class='temps']/span/span[1]");
    private By dailyTimeLineHoursField = By.xpath("//div[@class='scroll-container']//div[@class='hours']/span/span[1]");
    private By currentDayTempRangeField = By.xpath("//div[@id='week']//a[1]//span[@class='tempRange']");
    private By minTempOnTempRangeFieldForToday = By.xpath("//div[@id='week']//a[1]//span[@class='minTemp']");
    private By maxTempOnTempRangeFieldForToday = By.xpath("//div[@id='week']//a[1]//span[@class='maxTemp']");
    private By minTempOnDayDetailsFieldForToday = By.xpath("//div[@class='dayDetails revealed'][1]//span[@class='highTemp swip']//span[@class='temp']");
    private By maxTempOnDayDetailsFieldForToday = By.xpath("//div[@class='dayDetails revealed'][1]//span[@class='lowTemp swap']//span[@class='temp']");

    private final char DEGREE_CHAR_MAIN = '˚';
    private final char DEGREE_CHAR_TIMELINE = '°';

    public void clickOnDarkSkyAPIButton()
    {
        clickOn(darkSkyAPIButton);
    }

    public int getCurrentTemperature()
    {
        String currentTempString = getTextFromElement(currentTemperatureField);

        return Integer.parseInt(currentTempString.substring(0,currentTempString.indexOf(DEGREE_CHAR_MAIN)));
    }

    public int getMinTempFromDailyTimeLine()
    {

        return getMinTempFromTemperatureStringList(getTextFromElementList(dailyTimeLineTemperatureListField));

    }

    public int getMaxTempFromDailyTimeLine()
    {

        return getMaxTempFromTemperatureStringList(getTextFromElementList(dailyTimeLineTemperatureListField));

    }

    public int getMinTempOnTempRangeFieldForToday()
    {
        String tempString = getTextFromElement(minTempOnTempRangeFieldForToday);

        return Integer.parseInt(tempString.substring(0, tempString.indexOf(DEGREE_CHAR_MAIN)));
    }

    public int getMaxTempOnTempRangeFieldForToday()
    {
        String tempString = getTextFromElement(maxTempOnTempRangeFieldForToday);

        return Integer.parseInt(tempString.substring(0, tempString.indexOf(DEGREE_CHAR_MAIN)));
    }

    public int getMinTempOnDayDetailsFieldForToday()
    {
        String tempString = getTextFromElement(minTempOnDayDetailsFieldForToday);

        return Integer.parseInt(tempString.substring(0, tempString.indexOf(DEGREE_CHAR_MAIN)));
    }

    public int getMaxTempOnDayDetailsFieldForToday()
    {
        String tempString = getTextFromElement(maxTempOnDayDetailsFieldForToday);

        return Integer.parseInt(tempString.substring(0, tempString.indexOf(DEGREE_CHAR_MAIN)));
    }

    public String[] getDailyTimeLine()
    {
        return getTextFromElementList(dailyTimeLineHoursField);
    }

    public void clickOnTempRangeFieldForCurrentDay()
    {
        scrollPageToElement(currentDayTempRangeField);
        clickOn(currentDayTempRangeField);
    }

    private int getMinTempFromTemperatureStringList(String[] temps)
    {
        String myString = temps[0];
        int degreeCharIndex = temps[0].indexOf(DEGREE_CHAR_TIMELINE);

        int minTemp = Integer.parseInt(temps[0].substring(0, temps[0].indexOf(DEGREE_CHAR_TIMELINE)));
        int temporaryTemp;

        for(int i = 1; i < temps.length; i++)
        {
            temporaryTemp = Integer.parseInt(temps[i].substring(0,temps[i].indexOf(DEGREE_CHAR_TIMELINE)));

            if(minTemp > temporaryTemp)
                minTemp = temporaryTemp;
        }

        return minTemp;
    }

    private int getMaxTempFromTemperatureStringList(String[] temps)
    {
        int temp;
        int maxTemp = Integer.parseInt(temps[0].substring(0, temps[0].indexOf(DEGREE_CHAR_TIMELINE)));

        for (int i = 1; i < temps.length; i++)
        {
            temp = Integer.parseInt(temps[i].substring(0, temps[i].indexOf(DEGREE_CHAR_TIMELINE)));

            if (maxTemp < temp)
                maxTemp = temp;
        }

        return maxTemp;
    }
}
