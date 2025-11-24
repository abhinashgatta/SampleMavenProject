package com.test.testCases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownOperations {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");

		
		driver.findElement(By.xpath("//button[contains(text(),'Dropdown Example')]")).click();
		
		List<WebElement> options =  driver.findElements(By.xpath("//button[contains(text(),'Dropdown Example')]/following-sibling::ul/li/a"));
		
		
		for(WebElement option : options) {
			
			System.out.println(option.getText());			
			
		}
		
		driver.quit();
	}

}
