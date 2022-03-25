package com.orangehrm;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_TestNG_Priority 
{
	ChromeDriver driver;

	@Test(priority=1)
	public void b_Login_Scenario() {
		System.out.println("Second Method as per Alphabet");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();

	}

	@Test(priority=2)
	public void a_Logout_Scenario() throws InterruptedException {
		System.out.println("First Method as per Alphabet");
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.name("Submit")).isDisplayed();
	}

	@BeforeTest
	public void beforeTest() {
		// Download chrome driver at Run-Time
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
