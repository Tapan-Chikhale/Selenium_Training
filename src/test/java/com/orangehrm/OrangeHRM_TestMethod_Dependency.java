package com.orangehrm;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_TestMethod_Dependency {
	 ChromeDriver driver;
  @Test
  public void Login() 
  {
	    driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
	  
  }
  @BeforeTest
  public void beforeTest()
  {
	// Download chrome driver at Run-Time
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
  }

  @AfterTest
  public void Logout() 
  {
	  driver.quit();
  }

}
