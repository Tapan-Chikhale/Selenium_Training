package com.orangehrm;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HDFC_NetBanking_Alert_Example {
	// Global Declaration
		ChromeDriver driver;

		@Test (groups= {"sanitytest"})
		public void Verify_Navigation_Command() throws InterruptedException
		{
			driver.switchTo().frame("login_page");
			//driver.findElement(By.name("fldLoginUserId")).sendKeys("1000");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[normalize-space()='CONTINUE']")).click();
			Thread.sleep(5000);
			String AlertText = driver.switchTo().alert().getText();
			String ExpAlertMeg = "Customer ID  cannot be left blank.";
			Assert.assertEquals(AlertText, ExpAlertMeg);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			//driver.switchTo().defaultContent();
		}

		@BeforeTest (alwaysRun = true)
		public void LaunchBrowser() 
		{
			// Download chromedriver at run time
			// WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// ChromeDriver driver = new ChromeDriver();
			driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");
		}

		@AfterTest  (alwaysRun = true)
		public void CloseBrowser()
		{
			driver.quit();
		}

}
