package com.test.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class WebDriverBase extends WebBase {
	
	protected WebDriver driver;
	public ExtentTest test;
	
	protected WebDriverBase(WebDriver driver, ExtentTest test, String folderPath) {
		this.driver = driver;
		this.test=test;
		this.testResultsFolderPath = folderPath;
	}
	
	protected String getTextByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
 
}
