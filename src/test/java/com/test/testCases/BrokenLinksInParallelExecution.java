package com.test.testCases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksInParallelExecution {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); // Automatically downloads matching driver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        
        List<WebElement> elements = driver.findElements(By.xpath("//a"));
        System.out.println(elements.size());
        
        List<String> links = new ArrayList<String>();
        
        for(WebElement element : elements) {
        	
        	String linkurl = element.getDomAttribute("href");
        	links.add(linkurl);
        	
//        	checkBrokenLink(linkurl);
        }
        
        long startTime = System.currentTimeMillis();
        links.parallelStream().forEach(e -> checkBrokenLink(e));
        long endTime = System.currentTimeMillis();
        
        System.out.println("total time is -->"+(endTime-startTime));
        driver.close();
		
	}

	private static void checkBrokenLink(String linkurl) {
		
		try {
		URL urls = new URL(linkurl);
		
		HttpURLConnection urlconn =  (HttpURLConnection) urls.openConnection();
		urlconn.connect();
		
		if(urlconn.getResponseCode()>=400) {
			System.out.println(linkurl +" ---->"+urlconn.getResponseMessage()+" is a broken link");
		}
		
		else {
			
			System.out.println(linkurl +" ---->"+urlconn.getResponseMessage());
		}
		
		}
		
		catch(Exception e) {
			
			
		}
		
		
		
	}

}
