package com.testng;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Methods {
	
	public  void selectMethod(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByVisibleText(value);
		
	}

}
