package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.pages.HomePage;
import com.demowebshop.utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage home;

	@Test(priority = 1, enabled = true, description = "TC001 verify Home Page Title",groups= {"Smoke"})
	public void TC_001_verifyHomePageTitle() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		String expectedTitle = data.get(1).get(0);
		home = new HomePage(driver);
		String actualHomePagetitle = home.getHomePageTitle();
		Assert.assertEquals(expectedTitle, actualHomePagetitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
	}

	@Test(priority = 1, enabled = true, description = "TC002 verify Subscribe Email Message",groups= {"Regression"})
	public void TC_002_verifySubscribeEmailMessage() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		String expSubMessage = data.get(1).get(1);
		home = new HomePage(driver);
		home.enterSubEmail();
		home.clickOnSubButton();
		String actSubMessage = home.getSubMessage();
		Assert.assertEquals(expSubMessage, actSubMessage, ErrorMessages.EMAIL_FAILURE_MESSAGE);
	}
}
