package framework.webPages;

import org.openqa.selenium.By;

public class DevRegisterPage extends BasePage {

    private By signUpButton = By.xpath("//a[@href='/dev/register' and text()='Sign Up']");
    private By emailTextField = By.xpath("//input[@class='full' and @type='email']");
    private By registerButton = By.xpath("//button[contains(text(),'Register')]");

    public void clickOnSignUpButton()
    {
        clickOn(signUpButton);
    }

    public void clickOnRegisterButton()
    {
        clickOn(registerButton);
    }

    public String getErrorMessageFromEmailTextField()
    {
        return getValidationMessageFromHTML5RequiredElement(emailTextField);
    }

}
