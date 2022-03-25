package com.orangehrm;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Navigate_Command {
	// Global Declaration
		ChromeDriver driver;

		@Test
		public void Verify_Navigation_Command() throws InterruptedException
		{

			driver.findElement(By.linkText("Forgot your password?")).click();
			Thread.sleep(5000);
			String FYPActLink =driver.getCurrentUrl();
			String ExpLink="https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode";
			Assert.assertEquals(FYPActLink, ExpLink);
			driver.navigate().back();
			Thread.sleep(5000);
			//Verify user back to Login Page
			String LoginActLink =driver.getCurrentUrl();
			String LoginExpLink="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
			Assert.assertEquals(LoginActLink, LoginExpLink);
			//Verify that user navigated back to Forget your password page
			driver.navigate().forward();
			Thread.sleep(5000);
			String FYPActLinkBack =driver.getCurrentUrl();
			String ExpLinkBack="https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode";
			Assert.assertEquals(FYPActLinkBack, ExpLinkBack);

		}

		@BeforeTest
		public void LaunchBrowser() 
		{
			// Download chromedriver at run time
			// WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// ChromeDriver driver = new ChromeDriver();
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		}

		@AfterTest
		public void CloseBrowser()
		{
			driver.quit();
		}

}
