package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Priority {
	WebDriver driver;
	@BeforeMethod 
	public void Testngasics()
	{
		System.setProperty("webdriver.chrome.driver", ".//browsers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://google.com/");
		
		
	}
	@Test
	public void getTitle()
	{
		String title=driver.getTitle();
		System.out.println(title);
	}
	@Test
	public void getUrl()
	{
		String url=driver.getCurrentUrl();
		System.out.println(url);
	}
	@Test
	public void LinkText() 
	{
		String linktext=driver.findElement(By.partialLinkText("Gmail")).getText();
		System.out.println(linktext);
				}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	


}
