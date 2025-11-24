package com.test.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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

		// Corrected file path
		report = new ExtentReports(
				System.getProperty("user.home") + "/Downloads/ExtentReportResults.html", 
				true);

		// Parent test
		test = report.startTest("Google test");

		testResultsFolderPath = Constants.folderPath;
		setupTestsAndReport();
	}

	@Test(priority = 1, enabled = true)
	public void googleTitleTest() {

		// Child test node
		subTest = report.startTest("Step 1: Google title test");

		String title = new GooglePage(driver, subTest, testResultsFolderPath).getGoogleTitel();

		if (title.equals("Google")) {
			subTest.log(LogStatus.PASS, "Title verified successfully.");
		} else {
			subTest.log(LogStatus.FAIL, "Title is incorrect. Actual value: " + title);
		}

		// attach subtest under main test
		test.appendChild(subTest);
	}

	@Test(groups = "Sanity testing", enabled = true)
	public void googleTest() throws Exception {

		subTest = report.startTest("Step 1");

		new GooglePage(driver, subTest, testResultsFolderPath).checkBrokenLink();

		test.appendChild(subTest);
	}

	@AfterClass
	public void tearDown() {

		// End parent test only once
		report.endTest(test);

		// Flush once at the end
		report.flush();

		driver.quit();
	}


}
