package com.test.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.test.Base.Constants;
import com.test.Base.WebBase;
import com.test.PageClasses.GooglePage;

public class BrowserLaunchTest extends WebBase {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	ExtentTest subTest;

	@BeforeClass
	public void setup() {

		driver = initializeWebdriver();
		report = new ExtentReports(System.getProperty("/Users/abhinash/Downloads") + "ExtentReportResults.html");
		test=report.startTest("Google test");
		testResultsFolderPath = Constants.folderPath;
		setupTestsAndReport();
	}

	@Test
	public void googleTest() throws Exception {		
		
		subTest = report.startTest("Step 1");
		
//		String title = 
				new GooglePage(driver, subTest, testResultsFolderPath)
							.checkBrokenLink();
//							.getGoogleTitel();
		//System.out.println(title);
//		if (title.equals("Google")) {
//			subTest.log(LogStatus.PASS, "Title is verified");
//		}
//		else {
//			subTest.log(LogStatus.FAIL, "Title is incorrect");
//		}
		test.appendChild(subTest);
		
		report.endTest(test);
		report.flush();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
