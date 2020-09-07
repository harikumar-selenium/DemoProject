package com.Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BrowerserFactory {

	//static String  filePath = "./config.properties";
	static String  browser_name=null;
	static WebDriver driver;
	
	public static WebDriver setBrowerDriver() throws IOException
	{
		Pojo pojo = new Pojo();
		
		FileInputStream file = new FileInputStream(pojo.getConfig_filePath());

		Properties prop = new Properties();

		prop.load(file);

		file.close();
//comment
		browser_name=prop.getProperty("browser");
		
		Reporter.log("Configuration file has Browser Name: "+browser_name,true);

		if(browser_name.equalsIgnoreCase("chrome") || browser_name==null)
		{
			Reporter.log("Chrome browser is set",true);
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			
			driver=new ChromeDriver();
			
			
		}

		else if(browser_name.equalsIgnoreCase("FireFox")){

			driver = new FirefoxDriver();
			driver.get(pojo.getBaseUrl());
		}

		else 
		{
			driver = new InternetExplorerDriver();
			driver.get(pojo.getBaseUrl());
		}

		return driver;
	}
	



}
