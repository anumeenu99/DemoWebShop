package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.ExcelUtility;
import com.demowebshop.utilities.RandomUtility;
import com.demowebshop.utilities.TestHelperUtility;

public class LoginPage extends TestHelperUtility {
public WebDriver driver;
public LoginPage(WebDriver driver){ 
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
private final String _emailField="Email";  
@FindBy(id=_emailField)
private WebElement emailField;
private final String _passwordField="Password";  
@FindBy(id=_passwordField)
private WebElement passwordField;
private final String _loginButton="//input[@class='button-1 login-button']";  
@FindBy(xpath=_loginButton)
private WebElement loginButton;
private final String _errorMessage="//div[@class='validation-summary-errors']//span";  
@FindBy(xpath=_errorMessage)
private WebElement errorMessage;


public String getLoginPageTitle() {
	String title=page.getPageTitle(driver);
	return title;
}
public void enterEmail(String emailId) {
	page.enterText(emailField,emailId);
}
public void enterPassword(String password) {
	page.enterText(passwordField,password);
}
public void clickOnLoginButton() {
	page.clickOnElement(loginButton);
}
public String getErrorMessage() {
	String errMessage=page.getElementText(errorMessage);
	return errMessage;
}
public UserAccountPage clickLoginButton() {
	page.clickOnElement(loginButton);
	return new UserAccountPage(driver);
}
}
