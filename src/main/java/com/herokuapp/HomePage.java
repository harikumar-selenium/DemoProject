package com.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{

 @FindBy(id="alerttest") 
 private WebElement lnk_alerts;
 
 @FindBy(id="framestest")
 WebElement lnk_FrameTstPage;
 
 @FindBy(id="windowstest")
 WebElement lnk_newWindow;
 
 WebDriver driver;
 
 
 public HomePage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
	 this.driver=driver;
	 
 }
 
 public void clickOnAletsLnk()
 {
	 lnk_alerts.click();
 }
 
 /*
  * This method is to click on Frame test page link From Home Page
  */
public void clickOnFrameLnkTstPage()
{
	lnk_FrameTstPage.click();
}
 
/*
 * This method is to click on a link which will land on a page where you can 
 * click on a another link to open a new webpage.
 */

public void clickOnWindowLnk()
{
	lnk_newWindow.click();
	
}
}
