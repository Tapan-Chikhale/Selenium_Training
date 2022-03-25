package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebOrders_E2E_Scenarios
{
  
	ChromeDriver driver;
	@BeforeTest
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
	}
	
  @Test(priority=1)
  public void Login_WebOrder() throws InterruptedException 
  {
	  driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
	  driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	  driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("(//h1[normalize-space()='Web Orders'])[1]")).isDisplayed();
	  Thread.sleep(2000);
  }
  @Test(priority=2)
  public void CreateOrder_UpdateOrder_DeleteOrder() throws InterruptedException 
  {
	  //Create Order and Verify Order
	  driver.findElement(By.xpath("//a[normalize-space()='Order']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//h2[normalize-space()='Order']")).isDisplayed();
	  Thread.sleep(2000);
	  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();
	  Thread.sleep(500);
	  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("50");
	  Thread.sleep(500);
	  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).clear();
	  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys("100");
	  Thread.sleep(500);
	  
	  //Update order and Verify Order
	  
	  //Delete Order and Verify Order
	  
  }
  
	@AfterTest
	public void CloseBrowser()
	{
		//driver.quit();
	}
  }
