package com.test.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebBase {
	//WebDriver driver;
	protected String testResultsFolderPath;
	
	
	protected WebDriver initializeWebdriver() 
	{
	System.setProperty("webdriver.chrome.driver", Constants.driverPath);
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(options);
	driver.get("https://google.com");
	return driver;

	}
	
	protected void setupTestsAndReport() {
		testResultsFolderPath+= testResultsFolderPath+Math.random();
		
	}
}
