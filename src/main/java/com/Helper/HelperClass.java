package com.Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
	
	public static Properties LoadPropertyFile() throws IOException
	{
		Pojo pojo = new Pojo();
		
		FileInputStream file = new FileInputStream(pojo.getConfig_filePath());

		Properties prop = new Properties();

		prop.load(file);

		file.close();
		
		return prop;
	}
	
	public static void waitExplicit(WebElement element, WebDriver driver)
	{
		WebDriverWait wbdriver = new WebDriverWait(driver, 10);
		
		wbdriver.until(ExpectedConditions.visibilityOf(element));
		
		
	}

	
	public static void waitbasedonVisibleElement(WebElement element, WebDriver driver)
	{
		WebDriverWait wbdriver = new WebDriverWait(driver, 10);
		
		//wbdriver.until(ExpectedConditions. .visibilityOf(element));
		
		
	}
}
