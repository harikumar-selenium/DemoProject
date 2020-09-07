package com.pages.homepage;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Helper.BrowerserFactory;
import com.Helper.HelperClass;
import com.Helper.Pojo;
import com.automationpractice.Pages.HomePage;
import com.automationpractice.Pages.LoginPage;

public class ValidateLoginTest {
	WebDriver driver =null;
	
	
	@BeforeTest
	public void setUp() throws IOException{
		
		driver=BrowerserFactory.setBrowerDriver();
		
		//Pojo pojo = new Pojo();
			Pojo pojo = new Pojo();
		Reporter.log("Base Url Name: "+pojo.getBaseUrl(),true);
		
		//driver.get(pojo.getBaseUrl());
		
	}
	
	@Test(priority=1)
	public void launchWebsite() throws IOException{
		
		Pojo pojo = new Pojo();
		
		driver.get(pojo.getBaseUrl());
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(dependsOnMethods="launchWebsite")
	public void verifyWebsiteLaunch()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).isDisplayed(), "Website is not launched");
		
	}
	
	@Test(priority=3)
	public void clickonSignIn(){
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnSignInLink();
		//WebElement signInLnk=driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		//Actions action = new Actions(driver);
		//action.moveToElement(signInLnk).contextClick(signInLnk).sendKeys(Keys.ARROW_DOWN).se
		//action.moveToElement(signInLnk).contextClick(signInLnk).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
	@Test(priority=4)
	public void login() throws InterruptedException, IOException{
		
		Properties prop= HelperClass.LoadPropertyFile();
		
		prop.getProperty("username");
		prop.getProperty("password");
		
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Actions action = new Actions(driver);
		//driver.navigate().to("http://automationpractice.com/index.php?id_category=3&controller=category");
		
		//driver.navigate().back(); //one step back // similar to clicking browser back button
		
		//driver.navigate().forward(); //one step forward //similar to clicking brower next button
		
		driver.navigate().to("http://automationpractice.com/index.php?id_category=3&controller=category");
		
		//WebElement lnk_top=driver.findElement(By.xpath("//a[contains(text(),'Tops')][2]"));
		
		//Actions action = new Actions(driver);
		//action.contextClick(lnk_top).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	}
	
	@AfterClass
	public void closeDriver() throws InterruptedException{
		Thread.sleep(4000);
		driver.quit();
	}

}
