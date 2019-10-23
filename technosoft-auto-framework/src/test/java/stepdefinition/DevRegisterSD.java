package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DevRegisterPage;
import framework.webPages.LaunchPage;
import org.testng.Assert;

public class DevRegisterSD {

    private LaunchPage launchPage = new LaunchPage();
    private DevRegisterPage devRegisterPage = new DevRegisterPage();

    @Given("^I am on the register page$")
    public void iAmOnTheRegisterPage()
    {
        launchPage.clickOnDarkSkyAPIButton();
        devRegisterPage.clickOnSignUpButton();
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky API: Register", "Invalid Register Page");
    }

    @When("^I click on the (register) button$")
    public void clickOnButton(String buttonName)
    {
        switch(buttonName)
        {
            case "register":
                devRegisterPage.clickOnRegisterButton();
                break;
        }
    }

    @Then("^I verify the error message displayed next to the (email) text field$")
    public void verifyErrorMessageTextFromTextField(String textField)
    {
        switch (textField)
        {
            case "email":
                Assert.assertEquals(devRegisterPage.getErrorMessageFromEmailTextField(), "Please fill out this field.");
                break;
        }
    }
}
