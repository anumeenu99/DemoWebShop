package com.demowebshop.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.RandomUtility;
import com.demowebshop.utilities.TestHelperUtility;

public class RegisterPage extends TestHelperUtility{
	public WebDriver driver;
	public RegisterPage(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _genButton="//input[@name='Gender']/following-sibling::label";  
	@FindBy(xpath=_genButton)
	private List<WebElement> genButton;
	private final String _firstNameField="//input[@id='FirstName']";  
	@FindBy(xpath=_firstNameField)
	private WebElement firstNameField;
	private final String _lastNameField="//input[@id='LastName']";  
	@FindBy(xpath=_lastNameField)
	private WebElement lastNameField;
	private final String _emailField="//input[@id='Email']";
	@FindBy(xpath=_emailField)
	private WebElement emailField;
	private final String _passwordField="//input[@id='Password']";  
	@FindBy(xpath=_passwordField)
	private WebElement passwordField;
	private final String _confPassField="//input[@id='ConfirmPassword']";  
	@FindBy(xpath=_confPassField)
	private WebElement confPassField;
	private final String _registerButton="//input[@id='register-button']";  
	@FindBy(xpath=_registerButton)
	private WebElement registerButton;
	
	public void enterFirstName(String firstName) {
		page.enterText(firstNameField,firstName);
	}
	public void enterLastName(String lastName) {
		page.enterText(lastNameField,lastName);
	}
	public void enterEmail(String email) {
		page.enterText(emailField,email);
	}
	public void enterPassword(String password) {
		page.enterText(passwordField,password);
	}
	public void enterConfirmPass(String confirmPassword) {
		page.enterText(confPassField,confirmPassword);
	}
	public void selectGender(String gender) {
		for(int i=0;i<genButton.size();i++) {
			//String genderValue=genButton.get(i).getAttribute("value");
			String genderValue=page.getElementText(genButton.get(i));
			if(genderValue.equals(gender)) {
				page.clickOnElement(genButton.get(i));
				break;
			}
		}
	}
	public UserAccountPage clickOnRegisterButton() {
		page.clickOnElement(registerButton);
		return new UserAccountPage(driver);
	}
}

