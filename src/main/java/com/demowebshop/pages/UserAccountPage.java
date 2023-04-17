package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.TestHelperUtility;

public class UserAccountPage extends TestHelperUtility{
	public WebDriver driver;
	public UserAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	private final String _validationemail="//div[@class='header-links']//a[@class='account']";
	@FindBy(xpath=_validationemail)
	private WebElement validationemail;
	private final String _useremail="//a[text()='anuj@yopmail.com']";  
	@FindBy(xpath=_useremail)
	private WebElement useremail;
	
	public String getUserEmail() {
		String email=page.getElementText(validationemail);
		return email;
	}
	public String getUemail() {
		String uemail=page.getElementText(useremail);
		return uemail;
	}
}
