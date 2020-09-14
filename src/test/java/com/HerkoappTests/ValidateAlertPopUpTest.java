package com.HerkoappTests;

import org.testng.annotations.Test;

import com.Helper.BrowerserFactory;
import com.Helper.Pojo;
import com.herokuapp.AlertPageJs;
import com.herokuapp.HomePage;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class ValidateAlertPopUpTest {
	
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
  public void clickOnAlertJsLnk()
  {
	  HomePage homepage = new HomePage(driver);
	  homepage.clickOnAletsLnk();
  }
  
  @Test(dependsOnMethods="clickOnAlertJsLnk")
  public void validateAlertPage()
  {
	  Assert.assertEquals(driver.getTitle(), "Test Page For JavaScript Alerts");
  }
  
  @Test(dependsOnMethods="validateAlertPage")
  public void clickOnShwAlertBtn() throws InterruptedException
  {
	  AlertPageJs alertPage = new AlertPageJs(driver);
	  alertPage.handleAlert();
	  Thread.sleep(3000);
  }
  
  @Test(dependsOnMethods="clickOnShwAlertBtn")
  public void handleAlert() throws InterruptedException
  {
	  Alert alert=driver.switchTo().alert();
	  Reporter.log("alert Text is "+alert.getText(),true);
	 
	  alert.accept(); // clicking on OK on JS alert pop up
	  Thread.sleep(2000);
	  //alert.dismiss(); // clicking on Cancel btn on alert pop up
	   
  }
  
  @Test(dependsOnMethods="handleAlert")
  public void clickOnPromptAlert() throws InterruptedException
  {
	  AlertPageJs alertPage = new AlertPageJs(driver);
	  alertPage.handlePromtAlert();
	  Alert alert1=driver.switchTo().alert();
	  alert1.sendKeys("Selenium");
	  //driver.switchTo().alert().sendKeys("hari kumar");
	  Thread.sleep(4000);
	  alert1.accept();
  }
  
  @Test(dependsOnMethods="clickOnPromptAlert")
  public void validatePromptAlertValue()
  {
	  String actualpromtAlertValue=driver.findElement(By.id("promptreturn")).getText();
	  Assert.assertEquals(actualpromtAlertValue, "Hari kumar selenium");
  }
  
  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
