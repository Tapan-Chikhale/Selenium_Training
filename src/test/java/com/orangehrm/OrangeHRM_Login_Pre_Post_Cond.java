package com.orangehrm;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_Pre_Post_Cond
{
	//Global Declarations
	ChromeDriver driver; 
	
	
	@Before
	public void PreCondition_CloseBrowser()
	{
		// Download chrome driver at Run-Time
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@After
	public void PostCondition_CloseBrowser()
	{
		driver.quit();
	}
	

	@Test
	public void Login_Valid_Scenario()
	{
		
			driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			driver.findElement(By.name("Submit")).click();
			driver.findElement(By.linkText("Dashboard")).isDisplayed();
			
	}

}
