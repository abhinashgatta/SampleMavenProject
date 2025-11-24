package com.test.testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.test.Base.Constants;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", Constants.driverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");
		options.addArguments("--disable-gpu");
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		
		//WebElement el = driver.findElement(By.tagName("a"));
		
		List<WebElement> el = driver.findElements(By.tagName("a"));
		for(int i=0; i<el.size();i++) {
			
			WebElement element =  el.get(i);
			String url = element.getAttribute("href");
			
			 URL link = new URL(url); 
			 HttpURLConnection con = (HttpURLConnection)link.openConnection();
			 int code = con.getResponseCode();
			 
			 if(code>=400)
				 System.out.println("Broken links-"+url);
			 else
				 System.out.println("Valid link-"+url);
			
		}
		
		System.out.println();
		System.out.println("All links checked");
		driver.quit();
		
		
		
	}

}
