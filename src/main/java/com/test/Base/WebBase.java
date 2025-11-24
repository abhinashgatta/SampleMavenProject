package com.test.Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebBase {
	//WebDriver driver;
	protected String testResultsFolderPath;
	WebDriver driver;
	protected static ExtentReports mainReport;
	protected String testReportName;
	
	
	protected WebDriver initializeWebdriver() 
	{
//		System.setProperty("webdriver.chrome.driver", Constants.driverPath);
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://google.com");
		return driver;

	}
	
	protected void setupTestsAndReport() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmmss");
		LocalDateTime now = LocalDateTime.now();
		testResultsFolderPath+= testResultsFolderPath+"/Test Report_"+dtf.format(now);
		mainReport=new ExtentReports(testResultsFolderPath+"/"+testReportName+"Test Report.html");
//		mainReport.loadConfig(new File(Constants.));
		
	}
	
	protected void getScreenshot() throws IOException {
		
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyDirectory(f, new File("Sc.png"));
		
		
	}
	
	protected void Fluentwait() {
		
		Wait<WebDriver> wait2 = new FluentWait<>(driver)
								.withTimeout(Duration.ofSeconds(30))
							    .pollingEvery(Duration.ofSeconds(5))
							    .ignoring(NoSuchFieldException.class);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("example")));
		
	}
	
	protected void ExplicitWait() {
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.elementToBeSelected(By.id("")));
		
	}
	
}
