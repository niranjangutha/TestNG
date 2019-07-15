package com.testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependnsOn {
	static WebDriver driver;
	String title;
	@BeforeMethod
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "H:\\chrome\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	/*
	 * using Enabled =(True/false) to skip or process the test case
	 * using invocationCount = 10 it will run on test case in 10 times
	 * dependsOnMethods = "testcasename" if testcasename method should be pass other wise skip the current testcase
	 * priority = integer , it will follow the priority for testcase execution, before it will follow the alphabetical order
	 */
	
	@Test(dependsOnMethods = "dropDown1" )
	public void dropDown2()
	{
		
		driver.get("https://register.freecrm.com/register/");
		driver.manage().window().maximize();
		 title=driver.getTitle();
		System.out.println(" head page title:"+title);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='search']")).click();
		List<WebElement> droplist=driver.findElements(By.xpath("//div[@class='menu transition visible']//div"));
		System.out.println(droplist.size());
		String actual="Peru (+51)";
		String expected="Peru (+51)";
//		for(WebElement list:droplist)
//		{
//			System.out.println(list.getText());
//		}
		for (int i = 0; i < droplist.size(); i++) {
			if(droplist.get(i).getText().equals(actual))
			droplist.get(i).click();
			//Assert.assertEquals(actual, "Peru (+51)");
			Assert.assertTrue(actual==expected, "tese caase pass");
		}	

	}
	@Test
	public void dropDown1()
	{
		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(" head page title:"+title);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@class='rd-navbar--has-dropdown rd-navbar-submenu']")).click();
		List<WebElement> droplist=driver.findElements(By.xpath("//ul[@class='rd-navbar-dropdown rd-navbar-open-right']//li//a"));
		System.out.println(droplist.size());
		for (WebElement list:droplist) {
			System.out.println(list.getText());
		}
		for(int i=0;i<droplist.size();i++) {
			if(droplist.get(i).getText().contains("Call"))
			{
				droplist.get(i).click();
				break;
			}
		}
		title=driver.getTitle();
		Assert.assertEquals(title, "CRM  Center Free CRM");

	}

}
