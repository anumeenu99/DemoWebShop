package com.demowebshop.automationcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 *
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 *
	 * @param browser
	 * @return this will return tldriver.
	 */

	public static WebDriver testInitialization(String browser){
	    if(browser.equals("chrome")){
	        ChromeOptions ops=new ChromeOptions();
	        ops.addArguments("--remote-allow-origins=*");
	        tlDriver.set(new ChromeDriver(ops));
	    }else if(browser.equals("FireFox")){
	        tlDriver.set(new FirefoxDriver());
	    }else if(browser.equals("edge")){
	        tlDriver.set(new EdgeDriver());
	    }else{
	        throw new RuntimeException("Invalid browser");
	    }
	    getDriver().manage().deleteAllCookies();
	    getDriver().manage().window().maximize();
	    return getDriver();
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 *
	 * @return
	 */

	public static synchronized WebDriver getDriver() {
	    return tlDriver.get();
	}
}
