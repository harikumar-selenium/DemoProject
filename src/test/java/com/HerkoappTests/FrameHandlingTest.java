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

public class FrameHandlingTest {
	
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
  public void clickOnFrameLink()
  {
	  HomePage homepage = new HomePage(driver);
	  homepage.clickOnFrameLnkTstPage();
	  
	  Assert.assertEquals(driver.getTitle(), "Nested Frames Simple Example");
  }
  
  @Test(dependsOnMethods="clickOnFrameLink")
  public void getContentFromFrame() throws InterruptedException
  {
	  driver.switchTo().frame("top");	
	  Thread.sleep(3000);
	  Reporter
	  .log(driver.findElement(By.xpath("//h1[contains(text(),'Nested Frames')]")).getText(),true);
  }  
  
  @Test(dependsOnMethods="getContentFromFrame")
  public void switchtoSecondFrame()
  {
	  driver.switchTo().defaultContent();
	  
	  driver.switchTo().frame("left");
	 
	  
	Reporter.log(driver.findElement(By.xpath("//h1[contains(text(),'Left')]")).getText(),true);
  }
  
  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
