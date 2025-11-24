package com.test.PageClasses;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.test.Base.WebDriverBase;

public class GooglePage extends WebDriverBase{

	public GooglePage(WebDriver driver, ExtentTest test, String folderPath) {
		super(driver, test, folderPath);
		// TODO Auto-generated constructor stub
	}
	
	public String getGoogleTitel() {
		return driver.getTitle();
	
		
	}
	
	public void checkBrokenLink() throws IOException, URISyntaxException {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links:"+links.size());
		for(int i=0;i<links.size();i++) {
			WebElement element = links.get(i);
			String url = element.getDomAttribute("href");
//					getAttribute("href");
			System.out.println("Links:"+url);
					
			URI uri = new URI(url);
			//URL link = new URL(url);
			URL link = uri.toURL();
			HttpURLConnection http = (HttpURLConnection) link.openConnection();
			http.connect();
			
			int code = http.getResponseCode();
			
			if(code>=400) {
				System.out.println("broken link:"+url);
			}
			else
				System.out.println("Valid link:"+url);
		}
		System.out.println();
		System.out.println("All the links are checked");
	}
}
