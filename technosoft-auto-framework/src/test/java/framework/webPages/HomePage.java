package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.util.ArrayList;

public class HomePage extends BasePage{

	private By emailOrPhoneLoginTextField = By.xpath("//input[@type='email' and @class='inputtext login_form_input_box']");
	private By passwordTextField = By.xpath("//input[@type='password' and @class='inputtext login_form_input_box']");

	private By firstNameTextField = By.xpath("//div[@id='fullname_field']//input[@type='text' and @name='firstname']");
	private By lastNameTextField = By.xpath("//div[@id='fullname_field']//input[@type='text' and @name='lastname']");
	private By mobileOrEmailTextField = By.xpath("//div[@id='reg_form_box']//input[@type='text' and @name='reg_email__']");
	private By newPasswordTextField = By.xpath("//div[@id='password_field']//input[@type='password' and @name='reg_passwd__']");

	private By monthDDLField = By.xpath("//span[@data-name='birthday_wrapper']//select[@name='birthday_month']");

	private By femaleGenderRadioButton = By.xpath("//span[@data-name='gender_wrapper']//input[@type='radio' and @value='1']");
	private By maleGenderRadioButton = By.xpath("//span[@data-name='gender_wrapper']//input[@type='radio' and @value='2']");

	private By loginButton = By.xpath("//input[@value='Log In' and @data-testid='royal_login_button']");
	private By signupButton = By.xpath("//button[@type='submit' and @name='websubmit']");

	private By redWarningButtonOnEmailField = By.xpath("//div[@class='_5dbb _5634']/div[@class='uiStickyPlaceholderInput']//following-sibling::i[1]");
	private By errorMessageFieldOnEmailField = By.xpath("//div[text()='Please enter a valid mobile number or email address.']");

	private By createNewPageButton = By.xpath("//a[text()='Create a Page']");
	private By signupLinkButton = By.xpath("//a[text()='Sign Up']");

	private By errorMessage = By.id("errorMessage");
	private By messengerLink = By.id("");
	
	public void clickOnLoginButton() {
		clickOn(loginButton);
	}

	public void setEmailOrPhoneLogin(String emailOrPhoneLogin) {

		setValue(emailOrPhoneLoginTextField, emailOrPhoneLogin);

	}

	public void setPassword(String password)
	{
		setValue(passwordTextField, password);
	}

	public boolean isFirstNameDisplayed()
	{
		return isElementDisplayed(firstNameTextField);
	}

	public void setFirstName(String firstName) {
		setValue(firstNameTextField, firstName);
	}

	public void setLastName(String lastName) {
		setValue(lastNameTextField, lastName);
	}

	public void setMobileOrEmail(String mobileOrEmail) {
		setValue(mobileOrEmailTextField, mobileOrEmail);
	}

	public void setNewPassword(String password) {
		setValue(newPasswordTextField, password);
	}

	public boolean isFemaleGenderSelected() {
		return isElementSelected(femaleGenderRadioButton);
	}

	public void clickOnFemaleGender() {
		clickOn(femaleGenderRadioButton);
	}

	public boolean isMaleGenderSelected() {
		return isElementSelected(maleGenderRadioButton);
	}

	public void clickOnMaleGender() {
		clickOn(maleGenderRadioButton);
	}

	public void clickOnNewPassword()
	{
		clickOn(newPasswordTextField);
	}

	public boolean isRedWarningButtonOnEmailFieldDisplayed()
	{
		return isElementDisplayed(redWarningButtonOnEmailField);
	}

	public void clickRedWarningButtonOnEmailField()
	{
		this.clickOn(redWarningButtonOnEmailField);
	}

	public boolean isErrorMessageOnEmailFieldDisplayed() {
		return isElementDisplayed(errorMessageFieldOnEmailField);
	}

	public String getErrorMessageFromEmailField()
	{
		return this.getTextFromElement(errorMessageFieldOnEmailField);
	}

	public boolean isItemInMonthDDLByText(String ddlItem)
	{
		return isItemInDropDownListByText(monthDDLField, ddlItem);
	}

	public void selectItemFromMonthDDLByText(String ddlItem)
	{
		this.selectByText(monthDDLField, ddlItem);
	}

	public String getVisibleTextOfSelectedOptionFromMonthDDL()
	{
		return this.getTextFromSelectedOption(monthDDLField);
	}

	public boolean hasDuplicatesInMonthDDL()
	{
		return this.hasDuplicateDDLItems(monthDDLField);
	}

	public ArrayList<String> getDuplicatesInMonthDDL()
	{
		return this.getDuplicateDDLItems(monthDDLField);
	}

	public String getErrorMessage() {
		return getTextFromElement(errorMessage);
	}

	public void clickOnMessengerLink() {
		clickOn(messengerLink);
	}

	public boolean isInitialLoginPageCorrect()
	{
		boolean isCorrect = true;

		try
		{
			isFirstNameDisplayed();
		}
		catch(TimeoutException e)
		{
			isCorrect = false;
			clickOn(createNewPageButton);
			clickOn(signupLinkButton);
		}

		return isCorrect;
	}

}
