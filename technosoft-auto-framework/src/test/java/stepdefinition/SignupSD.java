package stepdefinition;

import cucumber.api.java.en.Then;
import framework.webPages.HomePage;
import org.junit.Assert;

public class SignupSD {

    private HomePage homePage = new HomePage();

    @Then("^I verify gender (female|male) is selected$")
    public void genderValidation(String gender) {

        if (gender.equals("female")) {
            if (!homePage.isFemaleGenderSelected()) {
                homePage.clickOnFemaleGender();
            }
            Assert.assertTrue(homePage.isFemaleGenderSelected());
        } else if (gender.equals("male")) {
            if (!homePage.isMaleGenderSelected()) {
                homePage.clickOnMaleGender();
            }
            Assert.assertTrue(homePage.isMaleGenderSelected());
        }
    }
}
