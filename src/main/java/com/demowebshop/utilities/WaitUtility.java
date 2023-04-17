package com.demowebshop.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long EXPLICIT_WAIT=20000;
	public  static  final long IMPLICIT_WAIT=20;
	public  static final long HARD_WAIT=20000;
	public  static  final long PAGE_LOAD_WAIT=20;
	public  static  final  long FLUENT_WAIT=20;
	public static final  long POLLING_TIME=5;

	public void setHardWait(){
	    try {
	        Thread.sleep(HARD_WAIT);
	    } catch (InterruptedException e) {
	        throw new RuntimeException(e);
	    }
	}
	public static  void setImplicitWait(WebDriver driver){
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}
	public static void setPageLoadWait(WebDriver driver){
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
	}
	public enum LocatorType{
	    Id,Name,Xpath,ClassName,CssSelector,TagName,LinkText,PartialLinkText;
	}
	public  void waitForElementToBeVisible(WebDriver driver, String target, Enum locatorType){
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	    if(locatorType.equals(LocatorType.Id)){
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
	    } else if (locatorType.equals(LocatorType.ClassName)) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(target)));
	    }else if (locatorType.equals(LocatorType.Name)) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(target)));
	    }else if (locatorType.equals(LocatorType.Xpath)) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target)));
	    }else {
	        throw new RuntimeException("Invalid Locator");
	    }
	}
	public  void waitForElementToBeClickable(WebDriver driver,String target,Enum locatorType){
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	    if(locatorType.equals(LocatorType.Id)){
	        wait.until(ExpectedConditions.elementToBeClickable(By.id(target)));
	    } else {
	        throw new RuntimeException("Invalid Locator");
	    }
	}
}
