package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.RandomUtility;
import com.demowebshop.utilities.TestHelperUtility;
import com.demowebshop.utilities.WaitUtility;

public class HomePage extends TestHelperUtility{ //pageUtility's object is created in TestHelperUtility
	public WebDriver driver;
	public HomePage(WebDriver driver){ //initializing pagefactory (constructor)
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _subEmailField="newsletter-email";  /*elements should be written before actions*/
	@FindBy(id=_subEmailField)
	private WebElement subEmailField;
	private final String _subButton="newsletter-subscribe-button";  
	@FindBy(id=_subButton)
	private WebElement subButton;
	private final String _SubMessage="newsletter-result-block";  
	@FindBy(id=_SubMessage)
	private WebElement SubMessage;
	private final String _loginLink="//a[@class='ico-login']"; 
	@FindBy(xpath=_loginLink)
	private WebElement loginLink;
	private final String _registerLink="//a[@class='ico-register']"; 
	@FindBy(xpath=_registerLink)
	private WebElement registerLink;
	public String getHomePageTitle() {
		String title=page.getPageTitle(driver);
		return title;
	}
	public void enterSubEmail() {
		String emailId=RandomUtility.getRandomEmail(); //inputing random emailid
		page.enterText(subEmailField,emailId);
	}
	public void clickOnSubButton() {
		page.clickOnElement(subButton);
	}
	public String getSubMessage() {
		wait.setHardWait();
		wait.waitForElementToBeVisible(driver,_SubMessage,WaitUtility.LocatorType.Id);
		String message=page.getElementText(SubMessage);
		return message;
	}
	public LoginPage clickLoginLink() {  //navigation from one page to next page
		page.clickOnElement(loginLink);
		return new LoginPage(driver);
	}
	public RegisterPage clickRegisterLink() {
		page.clickOnElement(registerLink);
		return new RegisterPage(driver);
	}
	
	
}
