/**
 * 
 */
package com.automationpractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author hari 
 *
 */
public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="email")
	@CacheLookup
	WebElement input_email;
	
	@FindBy(id="passwd")
	@CacheLookup
	WebElement input_password;
	
	@FindBy(id="SubmitLogin")
	@CacheLookup
	WebElement btn_Submit;
	
	public void login(String uName, String pwd) throws InterruptedException
	{
		input_email.clear();
		
		Actions action = new Actions(driver);
		action.sendKeys(input_email, uName).build().perform(); //build().perform()
		//action.sendKeys(input_email, uName).perform();
		Thread.sleep(3000);
		//input_email.sendKeys(uName);
		action.sendKeys(Keys.TAB).sendKeys(pwd).build().perform();
		//input_password.clear();
		
		//input_password.sendKeys("");
		//action.sendKeys(input_password, pwd).perform();
		
		btn_Submit.click();
		
		
		
	}
	
	
	/*
	 * Login page Const.
	 */
	public LoginPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	

}
