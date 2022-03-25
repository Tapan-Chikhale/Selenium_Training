package com.orangehrm;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logout_Scenario
{

	@Test
	public void Logout() throws InterruptedException
	{
		// Download chrome driver at Run-Time
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
			driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			driver.findElement(By.name("Submit")).click();
			driver.findElement(By.linkText("Dashboard")).isDisplayed();
			
			driver.findElement(By.id("welcome")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Logout")).click();
			driver.findElement(By.name("Submit")).isDisplayed();
			
		
		driver.quit();
	}

}
