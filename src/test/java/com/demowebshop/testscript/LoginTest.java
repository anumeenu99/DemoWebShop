package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.dataprovider.DataProviders;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;

public class LoginTest extends Base{
	HomePage home;
	LoginPage login;
	UserAccountPage user;
	@Test(priority = 1, enabled = true, description = "TC003 verify Login Page Title",groups= {"Sanity"})
	public void TC_003_verifyLoginPageTitle() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expectedTitle = data.get(1).get(0);
		home = new HomePage(driver);
		login=home.clickLoginLink();
		String actualLoginPagetitle = login.getLoginPageTitle();
		Assert.assertEquals(expectedTitle, actualLoginPagetitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
	}
	@Test(priority = 1, enabled = true, description = "TC004 verify Invalid Login Error Message",dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class,groups= {"Smoke"})
	public void TC_004_verifyInvalidLoginErrorMessage(String emailId,String password) {
		home = new HomePage(driver);
		login=home.clickLoginLink();
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expErrorMessage = data.get(1).get(1);
		login.enterEmail(emailId);
		login.enterPassword(password);
		login.clickOnLoginButton();
		String actErrorMessage = login.getErrorMessage();
		Assert.assertEquals(expErrorMessage, actErrorMessage, ErrorMessages.LOGIN_FAILURE_MESSAGE);
	}
	
	@Test(priority = 1, enabled = true, description ="TC005 verify Valid Login Message")
	public void TC_005_verifyValidLoginMessage() {
		home=new HomePage(driver);
		login=home.clickLoginLink();
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String expemail=data.get(1).get(2);
		String passwd=data.get(1).get(3);
		login.enterEmail(expemail);
		login.enterPassword(passwd);
		user=login.clickLoginButton();
		String actmail=user.getUemail();
		Assert.assertEquals(expemail,actmail);
	}
}
