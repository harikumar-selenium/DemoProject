package com.HerkoappTests;

import org.testng.annotations.Test;

import com.Helper.BrowerserFactory;
import com.Helper.Pojo;
import com.herokuapp.HomePage;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class ValidateNewWindowTest {
 
	WebDriver driver;
	String baseurl=null;
	

  @BeforeTest
  public void beforeTest() throws IOException {
	  
	  driver=BrowerserFactory.setBrowerDriver();
		
	  Pojo pojo = new Pojo();
	  baseurl=pojo.getBaseUrl();
	  Reporter.log("Base Url Name: "+pojo.getBaseUrl(),true); 
  
  }

  @Test
  public void launchWebSite()
  {
	  driver.get(baseurl);
	  driver.manage().window().maximize();
  }
  
  @Test(dependsOnMethods="launchWebSite")
  public void validateWebsite()
  {
	  Assert.assertEquals(driver.getTitle(), "Selenium Test Pages");
  }
  
  @Test(dependsOnMethods="validateWebsite")
  public void clickOnNewWindow()
  {
	  HomePage homepage = new HomePage(driver);
	  homepage.clickOnWindowLnk();
  }
  
  @Test(dependsOnMethods="clickOnNewWindow")
  public void clickOnOpenNewWindowlnk() throws InterruptedException
  {
	  driver.findElement(By.id("gobasicajax")).click();
	  Thread.sleep(5000);
  }
  
  @Test(dependsOnMethods="clickOnOpenNewWindowlnk")
  public void ValidateNewWindow()
  {
	  //sdsdsa
	  String parentWindow=driver.getWindowHandle();
	  Reporter.log(driver.getWindowHandle(),true);
	  //driver.getWindowHandles();
	  //for(int i=0; i<=driver.windowhhandles().size;i++
	  
	  for(String window :driver.getWindowHandles())
	  {
		  /*if(!parentWindow.equalsIgnoreCase(window))
		  {
			  driver.switchTo().window(window);
			  break;
		  }*/
		  System.out.println(window);
	  }
	  Assert.assertEquals(driver.getTitle(), "Test Page For Basic Ajax Example");
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
	  
	  //quit vs close
	  //quite : will close all the open windows and close your Session that is opened by webdriver
	  // close : will only close the window which is currently focused on. 
  }


}
