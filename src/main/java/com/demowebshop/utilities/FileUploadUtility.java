package com.demowebshop.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

public class FileUploadUtility {
	public void FileUploadUsingRobotClass(WebDriver driver, String path) throws AWTException, InterruptedException {
	       StringSelection s = new StringSelection(path);
	       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
	       Robot r = new Robot();
	       Thread.sleep(5000);
	       r.keyPress(KeyEvent.VK_ENTER);
	       r.keyRelease(KeyEvent.VK_ENTER);
	       Thread.sleep(5000);
	       r.keyPress(KeyEvent.VK_CONTROL);
	       r.keyPress(KeyEvent.VK_V);
	       Thread.sleep(5000);
	       r.keyRelease(KeyEvent.VK_CONTROL);
	       r.keyRelease(KeyEvent.VK_V);
	       Thread.sleep(5000);
	       r.keyPress(KeyEvent.VK_ENTER);
	       r.keyRelease(KeyEvent.VK_ENTER);
	   }
}
