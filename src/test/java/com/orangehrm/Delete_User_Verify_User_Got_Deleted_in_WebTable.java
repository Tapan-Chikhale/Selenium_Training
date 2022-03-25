package com.orangehrm;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_User_Verify_User_Got_Deleted_in_WebTable {

	WebDriver driver;

	@Test(priority = 1, description = "Login to OrangeHRM with valid credentials")
	public void Login() throws InterruptedException {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		// driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		// Verify that Dashboard page displayed
		String ActElement = driver.findElement(By.linkText("Dashboard")).getText();
		String ExpElement = "Dashboard";
		Assert.assertEquals(ActElement, ExpElement);
		System.out.println(ActElement);

	}

	  @Test(priority=2)
	  public void Add_User() throws InterruptedException
	  {
		  driver.findElement(By.linkText("Admin")).click();
		  driver.findElement(By.cssSelector(".toggle.tiptip")).isDisplayed();
		  driver.findElement(By.id("btnAdd")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("UserHeading")).isDisplayed();
		  Select userrole = new Select(driver.findElement(By.id("systemUser_userType")));
		  userrole.selectByVisibleText("Admin");
		  driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");
		  //Random class will help to generate random number
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(1000);
		  driver.findElement(By.id("systemUser_userName")).sendKeys("Abhi"+randomInt);
		  driver.findElement(By.id("systemUser_password")).sendKeys("admin123");
		  driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("admin123");
		  Thread.sleep(2000);
		  driver.findElement(By.id("btnSave")).click();
		  Thread.sleep(3000);
		  //Verify that user got added to Webtable or not
		  String ExpName = "Abhi"+randomInt;
		  String ActName = driver.findElement(By.xpath("//a[text()='" + ExpName + "']")).getText();
		  Assert.assertEquals(ActName, ExpName);
		  
		  
		  //Delete User from WebTable
		  driver.findElement(By.xpath("//a[text()='" + ExpName + "']//parent::td//preceding-sibling::td/input")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.id("btnDelete")).click();
		  driver.findElement(By.id("dialogDeleteBtn")).click();
		  Thread.sleep(4000);
		  //Verify user got deleted or not
		  
		  Boolean deleteduser = driver.getPageSource().contains(ExpName);
		  Assert.assertFalse(deleteduser);
	  }

	@Test(priority = 3, description = "Logout from OrangeHRM")
	public void Logout() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.id("logInPanelHeading")).isDisplayed();

	}

	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		// WebDriverManager.firefoxdriver().setup();
		// WebDriverManager.edgedriver().setup();
		driver = new ChromeDriver();
		// driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void CloseBrowser() {
		// driver.close();//Close will close only current chrome browser
		driver.quit();
	}
}