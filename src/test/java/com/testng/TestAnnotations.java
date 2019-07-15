package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotations {

	@BeforeSuite
	public void SetUp()
	{
		System.out.println("system property setup");
	}
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("launch the broeser");
	}
	@BeforeTest
	public void Login()
	{
		System.out.println("login to app");
	}
	@BeforeMethod
	public void enterUrl()
	{
		System.out.println("Enter url");
	}
	@Test
	public void Loginpage()
	{
		System.out.println("loginpage");
	}
	@Test
	public void Homepage()
	{
		System.out.println("home page");
	}
	@AfterMethod
	public void logout()
	{
		System.out.println("logout the app");
	}
	@AfterTest
	public void ClearCokkies()
	{
		System.out.println("ClearCokkies");
	}
	@AfterClass
	public void closebrowser()
	{
	System.out.println("closebrowser");
	}

	@AfterSuite
	public void generateReport()
	{
		System.out.println("generateReport");
	}
}
