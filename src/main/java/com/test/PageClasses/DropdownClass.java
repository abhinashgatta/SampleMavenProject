package com.test.PageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("www.exapmle.com");
		int expectedCnt = 1000;
		WebElement el = driver.findElement(By.xpath(""));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		boolean isloaded = wait.until(new ExpectedCondition<Boolean>()
		{
			public Boolean apply(WebDriver driver) {

				Select sel = new Select(el);
				return sel.getOptions().size()==expectedCnt;
			}
		});
		
		if(isloaded) 
			System.out.println("Loaded");
		else
			System.out.println("not loaded");
		
		Select sel = new Select(el);
		List<WebElement> li = sel.getOptions();
	
		Actions act = new Actions(driver);
		act.moveToElement(el).build().perform();
		
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(5));
		wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		for(WebElement ele : li)
		{
			System.out.println(ele.getText());
		}

	}

}
