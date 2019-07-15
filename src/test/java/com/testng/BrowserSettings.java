package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserSettings {
	static WebDriver driver;
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");// disable notifiacations in chrome browser
		opt.addArguments("disable-infobars"); //  disable informationbar in chrome driver 
		/*
		 * This comment lines are used in remote awebDriver
		 * DesiredCapabilities caps = DesiredCapabilities.chrome();
		 * caps.setCapability(ChromeOptions.CAPABILITY, opt); WebDriver driver = new
		 * RemoteWebDriver(caps);
		 */
		
	System.setProperty("webdriver.chrome.driver", ".//browsers//chromedriver.exe");	
	 driver=new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.get("https://www.softwaretestingmaterial.com/");
	Thread.sleep(5000);
	WebDriverWait wait=new WebDriverWait(driver, 20);// explicit wait declaration 
//	wait.until(ExpectedConditions.visibilityOf(element));// explicit wait condition 
	driver.findElement(By.xpath("//span[contains(text(),'Training')]")).sendKeys(Keys.CONTROL + "t");
	//wait.until(ExpectedConditions.visibilityOf(training));
	System.out.println("Title:"+driver.getTitle());
	((JavascriptExecutor)driver).executeScript("scroll(0,500)");

	
	((JavascriptExecutor)driver).executeScript("scroll(0,500)");// scroll the web page using javaScript

	}
	@Test
	public void getmethod() throws InterruptedException
	{
	driver.get("http://facebook.com/");
	Thread.sleep(3000);
	String title=driver.getTitle();
	System.out.println(title);
	String url=driver.getCurrentUrl();
	System.out.println(url);

	}
	@Test
	public void getsizemethod() throws InterruptedException
	{
	driver.get("http://facebook.com/");
	Thread.sleep(3000);
	driver.manage().window().setSize(new Dimension(500,200));
	Thread.sleep(3000);
	Dimension d1=driver.manage().window().getSize();
	System.out.println(d1);
	}
	@Test
	public void getpositionmethod() throws InterruptedException
	{
	driver.get("http://facebook.com/");
	Thread.sleep(3000);
	driver.manage().window().setPosition(new Point(800,200));
	Thread.sleep(3000);
	Point d1=driver.manage().window().getPosition();
	System.out.println(d1);
	}
	@Test
	public void navigationmethod() throws InterruptedException
	{
	driver.get("http://facebook.com/");
	Thread.sleep(3000);
	driver.navigate().to("http://amazon.in/");
	Thread.sleep(3000);
	driver.navigate().back();
	Thread.sleep(3000);
	driver.navigate().forward();
	Thread.sleep(3000);
	driver.navigate().refresh();
	Thread.sleep(3000);
	}
	@Test
	public void windowmethod() throws InterruptedException
	{
	driver.get("http://facebook.com/");
	Thread.sleep(3000);
	driver.manage().window().fullscreen();
	Thread.sleep(3000);
	driver.manage().window().maximize();
	Thread.sleep(3000);


	}
	@Test
	public void Xpathmethod() throws InterruptedException
	{
	driver.get("H:/first.html");
	Thread.sleep(3000);
	//ABSOLUTE Xpath
	String label=driver.findElement(By.xpath("html/body/p")).getText();
	System.out.println(label);
	String tb=driver.findElement(By.xpath("html/body/table/tbody/tr[1]/td[1]")).getText();
	System.out.println(tb);
	//RELATIVE Xapth
	int val=driver.findElements(By.xpath(".//*")).size();//THIS IS FIND THE TOTAL XPATH'S IN DOM
	System.out.println(val);
	driver.findElement(By.xpath(".//input[@type='text']")).sendKeys("niranjan");//USING TAGNAME, ATTRIBUTE AND ATTIBUTE VALUE
	Thread.sleep(3000);
	}

	@Test
	public void dynamicxpath() throws InterruptedException
	{
	//driver.get("http://facebook.com/");
	//Thread.sleep(3000);
	// Text() method
	//String text=driver.findElement(By.xpath(".//span[text()='Create an account']")).getText();
	//System.out.println(text);
	driver.get("H:/first.html");
	Thread.sleep(3000);
	// starts-with()
	//driver.findElement(By.xpath(".//input[starts-with(@id,'fir')]")).sendKeys("niranjan");
	//Thread.sleep(3000);
	// contains()
	driver.findElement(By.xpath(".//input[contains(@id,'fir')]")).sendKeys("niranjan");
	Thread.sleep(3000);
	//LAST()
	String last=driver.findElement(By.xpath(".//tbody/tr[last()]")).getText();
	System.out.println(last);
	//LAST()-1
	String last1=driver.findElement(By.xpath(".//tbody/tr[last()-1]")).getText();
	System.out.println(last1);
	}
	
	
	@AfterMethod
	public void teatDown()
	{
		driver.quit();
	}


}
