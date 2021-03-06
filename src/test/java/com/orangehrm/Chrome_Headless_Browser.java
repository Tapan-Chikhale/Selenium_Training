package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome_Headless_Browser 
{

	WebDriver driver;
	@Test
		public void Chrome_Headless() 
	{

			WebDriverManager.chromedriver().setup();
			//WebDriverManager.firefoxdriver().setup();
			//WebDriverManager.edgedriver().setup();
			
			//EdgeOptions options = new EdgeOptions();
			//FirefoxOptions options = new FirefoxOptions();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(false);
			//options.setHeadless(true);
			// options.setHeadless(true);
			options.addArguments("incognito");
			//driver = new EdgeDriver(options);
			//driver = new FirefoxDriver(options);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

			driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			driver.quit();
			
		}
}
