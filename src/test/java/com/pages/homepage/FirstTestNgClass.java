package com.pages.homepage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Helper.BrowerserFactory;

public class FirstTestNgClass {
  
	WebDriver driver=null;
	
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=BrowerserFactory.setBrowerDriver();
		
	}
	
	@Test
	public void setBrowerPath() throws IOException 
	{
		
	
	}
	
}
