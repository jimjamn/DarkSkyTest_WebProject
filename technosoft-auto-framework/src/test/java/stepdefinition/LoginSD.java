package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePage;
import framework.webPages.LoginPage;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mohammadmuntakim.
 */
public class LoginSD {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Given("^I am on the home page$")
    public void iAmOnHomePage() {
        String title = "Facebook - Log In or Sign Up";
        if(!homePage.isInitialLoginPageCorrect())
            title = "Sign Up for Facebook | Facebook";

        Assert.assertEquals(SharedSD.getDriver().getTitle(), title, "Invalid Home Page");
    }

    @When("^I enter (.+) into the (username|password|firstname|lastname|mobile number|email|new password) text field on the home page$")
    public void enterDataIntoTextField(String anyText, String textField) {

        switch (textField) {
            case "username":
                homePage.setEmailOrPhoneLogin(anyText);
                break;
            case "password":
                homePage.setPassword(anyText);
                break;
            case "firstname":
                homePage.setFirstName(anyText);
                break;
            case "lastname":
                homePage.setLastName(anyText);
                break;
            case "email":
            case "mobile number":
                homePage.setMobileOrEmail(anyText);
                break;
            case "new password":
                homePage.setNewPassword(anyText);
                break;
        }
    }

    @When("^I click on the (new password) text field on the home page$")
    public void clickOnTextField(String textField)
    {
        switch(textField)
        {
            case "new password":
                homePage.clickOnNewPassword();
                break;
        }
    }

    @When("^I click on the red warning button on the (email|mobile) text field on the home page$")
    public void clickOnRedWarningButtonOnTextField(String textField)
    {
        switch(textField)
        {
            case "email":
            case "mobile":
                homePage.clickRedWarningButtonOnEmailField();
                break;
        }
    }

    @When("^I select (current month) from the (month) drop down list$")
    public void selectItemFromDropDownListByText(String ddlItemText, String ddlToSelect)
    {
        switch (ddlToSelect)
        {
            case "month":
                switch(ddlItemText)
                {
                    case "current month":
                        homePage.selectItemFromMonthDDLByText(getCurrentMonth());
                        break;
                }
                break;
        }
    }

    @When("^I click on (login|create account) button on the home page$")
    public void clickOnLoginButton(String button) {

        switch (button) {
            case "login":
                homePage.clickOnLoginButton();
                break;
            case "create account":
                //Implement Create account object
                break;
        }
    }

    @Then("^I verify that the red warning button appears on the (email|mobile) text field$")
    public void verifyRedWarningButtonAppearsOnTextField(String textField)
    {
        switch(textField)
        {
            case "email":
            case "mobile":
                Assert.assertTrue(homePage.isRedWarningButtonOnEmailFieldDisplayed(), "Red warning button on email field should display");
                break;
        }
    }

    @Then("^I verify that an error message displays next to the (email|mobile) text field$")
    public void verifyErrorMessageDisplayedForTextField(String textField)
    {
        switch(textField)
        {
            case "email":
            case "mobile":
                Assert.assertTrue(homePage.isErrorMessageOnEmailFieldDisplayed(), "Error message on email field should appear");
                break;
        }
    }

    @Then("^I verify the text of the error message next to the (email|mobile) text field$")
    public void verifyErrorMessageTextForTextField(String textField)
    {
        switch(textField)
        {
            case "email":
            case "mobile":
                Assert.assertEquals(homePage.getErrorMessageFromEmailField(), "Please enter a valid mobile number or email address.");
                break;
        }
    }

    @Then("^I verify (current month) is in the (month) drop down list$")
    public void verifyDDLContainsItemByText(String ddlItemText, String ddlToCheck)
    {
        switch(ddlToCheck)
        {
            case "month":
                switch(ddlItemText)
                {
                    case "current month":
                        Assert.assertTrue(homePage.isItemInMonthDDLByText(getCurrentMonth()), getCurrentMonth() + " is not in " + ddlToCheck + " drop down list");
                        break;
                }
                break;

        }
    }

    @Then("^I verify that (current month) is displayed on the (month) drop down list$")
    public void verifyMonthTextIsDisplayedOnDDL(String ddlItemText, String ddlToCheck)
    {
        switch(ddlToCheck)
        {
            case "month":
                switch(ddlItemText)
                {
                    case "current month":
                        Assert.assertEquals(homePage.getVisibleTextOfSelectedOptionFromMonthDDL(), getCurrentMonth());
                        break;
                }
                break;

        }
    }

    @Then("^I verify that the (month) drop down list has no duplicate values$")
    public void verifyDropDownListHasNoDuplicates(String ddlToCheck)
    {
        ArrayList<String> duplicates = new ArrayList<String>(0);

        switch (ddlToCheck)
        {
            case "month":
                 duplicates = homePage.getDuplicatesInMonthDDL();
                break;
        }

        Assert.assertTrue(duplicates.size() == 0, "Duplicates found in month DDL: " + duplicates.toString());
    }

    @Then("^I verify that i am an invalid login page$")
    public void verifyInvalidLoginPage() {
        Assert.assertEquals(loginPage.getPageHeader(), "Log Into Facebook");
    }

    @Then("^I verify invalid signup error message$")
    public void verifySignUpErrorMessage() {
        Assert.assertEquals(homePage.getErrorMessage(), "Invalid signup");
    }

    private String getCurrentMonth()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        //c.add(Calendar.MONTH, 2);
        return sdf.format(c.getTime());
    }
}
