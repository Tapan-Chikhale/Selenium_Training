package com.orangehrm;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Alert_Example {
	// Global Declaration
		ChromeDriver driver;

		@Test (priority=1)
		public void ClickForJSAlert() throws InterruptedException
		{
			//driver.switchTo().frame("login_page");
			//driver.findElement(By.name("fldLoginUserId")).sendKeys("1000");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			String AlertText1 = driver.findElement(By.xpath("//p[@id='result']")).getText(); 
			String ExpAlertText1 = "You successfully clicked an alert";
			Assert.assertEquals(AlertText1, ExpAlertText1);
			Thread.sleep(5000);
		}
		
		@Test (priority=2)
		public void ClickForJSConfirm() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().dismiss();
			Thread.sleep(2000);
			String AlertText2 = driver.findElement(By.xpath("//p[@id='result']")).getText();
			Thread.sleep(2000);
			String ExpAlertText2 = "You clicked: Cancel";
			Assert.assertEquals(AlertText2, ExpAlertText2);
			Thread.sleep(2000);
		}
		
		@Test (priority=3)
		public void ClickForJSPrompt() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
			Thread.sleep(3000);
			driver.switchTo().alert().sendKeys("Tapan");
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			String AlertText3 = driver.findElement(By.xpath("//p[@id='result']")).getText();
			Thread.sleep(2000);
			String ExpAlertText3 = "You entered: Tapan";
			Assert.assertEquals(AlertText3, ExpAlertText3);
			Thread.sleep(2000);
		}

		@BeforeTest
		public void LaunchBrowser() 
		{
			// Download chromedriver at run time
			// WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// ChromeDriver driver = new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		}

		@AfterTest
		public void CloseBrowser()
		{
			driver.quit();
		}

}
