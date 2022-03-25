package com.orangehrm;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_DataDriverTesting_Using_Data_Provider extends ApplicationTestData
{
	// ChromeDriver driver;
//Global Declaration
	ChromeDriver driver;

	@Test (dataProvider="Login")
	public void Login_Valid_Scenario(String uname, String upass) throws InterruptedException {

		driver.findElement(By.name("txtUsername")).sendKeys(uname);
		driver.findElement(By.name("txtPassword")).sendKeys(upass);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		driver.findElement(By.partialLinkText("Welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.id("btnLogin")).isDisplayed();
	}

	@BeforeTest
	public void LaunchBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
