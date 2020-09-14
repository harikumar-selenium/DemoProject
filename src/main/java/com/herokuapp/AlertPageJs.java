package com.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPageJs {
	
	WebDriver driver;
	
	@FindBy(id="alertexamples")
	public WebElement btn_shwAlert;
	
	@FindBy(id="promptexample")
	WebElement btn_promptAlert;
	

	public AlertPageJs(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
		 this.driver=driver;
	}
	
	public void handleAlert()
	{
		btn_shwAlert.click();
	}
	
	public void handlePromtAlert()
	{
		btn_promptAlert.click();
	}
	
}
