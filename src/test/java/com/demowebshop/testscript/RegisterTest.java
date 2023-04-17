package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;
import com.demowebshop.utilities.RandomUtility;

public class RegisterTest extends Base {
	HomePage home;
	RegisterPage register;
	UserAccountPage user;
	@Test(priority = 1, enabled = true, description = "TC001 verify Valid Registration",groups= {"Regression"})
	public void TC_001_verifyValidRegistration() {
		home=new HomePage(driver);
		register=home.clickRegisterLink();
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("RegisterPage");
		String gender=data.get(1).get(0);
		register.selectGender(gender);
		String fName=RandomUtility.getfName();
		String lName=RandomUtility.getlName();
		String emailid=RandomUtility.getRandomEmail();
		String passwd=fName+"@123";
		String confirmPasswd=passwd;
		//register.selectGender(gender);
		register.enterFirstName(fName);
		register.enterLastName(lName);
		register.enterEmail(emailid);
		register.enterPassword(passwd);
		register.enterConfirmPass(confirmPasswd);
		user=register.clickOnRegisterButton();
		String actualmail=user.getUserEmail();
		Assert.assertEquals(emailid,actualmail,ErrorMessages.EMAILID_FAILURE_MESSAGE);
	}
}
