/**
 * 
 */
package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Hari 
 * 
 * this class contains locators and methods for Home page 
 *
 */
public class HomePage {
	
	//a[@title='Log in to your  account'] website has this value 
	
	@FindBy(xpath="//a[@title='Log in to your customer account']")
	@CacheLookup //a[@title='Log in to your customer account'] 1st time 
	public WebElement lnk_sign_in;
	
	WebDriver driver;
	
	public void clickOnSignInLink(){
		
		lnk_sign_in.click();
	}
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
		
	}

}
