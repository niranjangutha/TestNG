package com.testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Priority extends Methods
{
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
	@Test(priority = 1)
	public void fbCheckListBox()
	{
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("title:"+title);
		WebElement day=driver.findElement(By.id("day"));
		WebElement month=driver.findElement(By.id("month"));
		WebElement year=driver.findElement(By.id("year"));
		/*
		 * Select class having the 7 methods are there to select and deselect the list of elemments
		 */

		// senario 1
		Select select=new Select(day);
		select.selectByVisibleText("4");
		Select select1=new Select(month);
		select1.selectByVisibleText("Aug");
		Select select2=new Select(year);
		select2.selectByVisibleText("1993");
	
	}
	@Test(priority = 2)
	public void fbCheckListBox1()
	{
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("title:"+title);
		WebElement day=driver.findElement(By.id("day"));
		WebElement month=driver.findElement(By.id("month"));
		WebElement year=driver.findElement(By.id("year"));
		/*
		 * Select class having the 7 methods are there to select and deselect the list of elemments
		 */
		//senario 2
		Methods m1=new Methods();
				m1.selectMethod(day, "21");
				m1.selectMethod(month, "Apr");
				m1.selectMethod(year, "1993");
				
		
	
	}
	@Test(priority = 4)
	public void PrintDaysList()
	{
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("title:"+title);
		WebElement day=driver.findElement(By.id("day"));
		
		Select select=new Select(day);
		List<WebElement> listdays=select.getOptions();
		int Daylistsize=listdays.size()-1;// because of here days is the header of the list and remove it
		System.out.println("daylistsize:"+Daylistsize);
		for(int i=0;i<listdays.size();i++)
		{
			String dayval=listdays.get(i).getText();
			System.out.println(dayval);
			if(dayval.equals("15"))
			{
				listdays.get(i).click();
				break;
			}
		}
	}
	@Test(priority = 3)
	public void PrintMonthList()
	{
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("title:"+title);
		WebElement month=driver.findElement(By.id("month"));
		
		Select select=new Select(month);
		List<WebElement> monthlist=select.getOptions();
		int monthlistsize=monthlist.size()-1;// because of here month is the header of the list and remove it
		System.out.println("monthlistsize:"+monthlistsize);
		for(int i=0;i<monthlist.size();i++)
		{
			String monthval=monthlist.get(i).getText();
			System.out.println(monthval);
		}
	}
	@Test(priority = 7)
	public void PrintyearList()
	{
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("title:"+title);
		WebElement year=driver.findElement(By.id("year"));
		
		Select select=new Select(year);
		List<WebElement> yearlist=select.getOptions();
		int yearlistsize=yearlist.size()-1;// because of here year is the header of the list and remove it
		System.out.println("yearlistsize:"+yearlistsize);
		for(int i=0;i<yearlist.size();i++)
		{
			String yearval=yearlist.get(i).getText();
			System.out.println(yearval);
		}
	}
	@Test(priority = 6)
	public void selectMonth()
	{
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("title:"+title);
		WebElement month=driver.findElement(By.id("month"));
		
		Select select=new Select(month);
		List<WebElement> monthlist=select.getOptions();
		int monthlistsize=monthlist.size()-1;// because of here month is the header of the list and remove it
		System.out.println("monthlistsize:"+monthlistsize);
		for(int i=0;i<monthlist.size();i++)
		{
			String monthval=monthlist.get(i).getText();
			if(monthval.equals("Apr"))
			{
				monthlist.get(i).getText();
				break;
			}
		}
	}
	@Test(priority = 5)
	 public void HandleBootstrapDropDown()
	 {
		driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(" head page title:"+title);
		String value="HTML";
		driver.findElement(By.xpath("//button[@id='btnDropdownDemo']")).click();
		List<WebElement> dropList=driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
		System.out.println(dropList.size());
		for(int i=0;i<dropList.size();i++)
		{
			System.out.println(dropList.get(i).getText());
			if(dropList.get(i).getText().equals(value))
			{
				dropList.get(i).click();
				break;
			}
			
		}
		title=driver.getTitle();
		System.out.println("next page title:"+title);
		if(title.contains(value))
		{
			System.out.println("testcase pass");
		}
		else
		{
			System.out.println("test case fail");
		}
	 }
	
	@Test(priority = 9)
	 public void HandleBootstrapDropDown1()
	 {
		driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_12");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(" head page title:"+title);
		String value="PHP";
		driver.findElement(By.xpath("//button[@id='btnDropdownDemo']")).click();
		List<WebElement> dropList=driver.findElements(By.xpath("//div[@class='dropdown-menu show']//*[self::a or self::h6]"));
		System.out.println(dropList.size());
		for(int i=0;i<dropList.size();i++)
		{
			System.out.println(dropList.get(i).getText());
			if(dropList.get(i).getText().contains(value))
			{
				dropList.get(i).click();
				break;
			}
			
		}
		title=driver.getTitle();
		System.out.println("next page title:"+title);
		if(title.contains(value))
		{
			System.out.println("testcase pass");
		}
		else
		{
			System.out.println("test case fail");
		}
	 }
	@Test(priority = 8)
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
		for (int i = 0; i < droplist.size(); i++) {
			System.out.println(droplist.get(i).getText());
			if(droplist.get(i).getText().contains("Call"))
			{
				droplist.get(i).click();
				break;
			}
		}

	}
		@Test(priority = 10)
		public void dropDown2()
		{
			driver.get("https://register.freecrm.com/register/");
			driver.manage().window().maximize();
			String title=driver.getTitle();
			System.out.println(" head page title:"+title);
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@class='search']")).click();
			List<WebElement> droplist=driver.findElements(By.xpath("//div[@class='menu transition visible']//div"));
			System.out.println(droplist.size());
			String actual="Peru (+51)";
			for(WebElement list:droplist)
			{
				System.out.println(list.getText());
			}
			for (int i = 0; i < droplist.size(); i++) {
				if(droplist.get(i).getText().equals(actual))
				droplist.get(i).click();
				Assert.assertEquals(actual, "Peru (+91)");
			}
		}

	@AfterMethod
	public void close()
	{
		driver.close();
	}
	


}
