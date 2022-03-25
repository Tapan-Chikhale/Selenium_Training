package com.orangehrm;

import org.testng.annotations.DataProvider;

public class ApplicationTestData
{
	@DataProvider(name = "Login")
	public Object[][] getDataforLogin() 
	{
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Admin", "admin123" },
				{"dixit", "admin123" },
				{"sanket", "admin123" },
				{"Admin", "admin123" }
				};

	}
	
	@DataProvider(name = "LoginScenario")
	public Object[][] getDataforLoginDifferentScenarios() {
		return new Object[][] { 
				{ "admin", "", "Password cannot be empty"},
				{ "", "admin123", "Username cannot be empty" }, 
				{ "AdminWrong", "admin123", "Invalid credentials" },
				{ "admin", "admin", "Invalid credentials" }, 
				{ "admin", "admin123", "Dashboard" } };

	}
	
	//----------------------  This is to Read Excel ----------------------------------
	
	@DataProvider(name = "LoginExcelData")
	public Object[][] ReadDataFromExcel() throws Exception{
		Read_Excel excel = new Read_Excel();
		String RelativePath = System.getProperty("user.dir");
//		Object[][] testObjArray = excel.getExcelData("C:\\Selenium Training\\workspace\\OrangeHRM_Demo\\Test_Data\\OrangeHRM_Test_Data.xls","Login");
		Object[][] testObjArray = excel.getExcelData(RelativePath+"\\Test_Data\\OrangeHRM_Test_Data.xls","Login");
		System.out.println(testObjArray);
		return testObjArray;
	}
	
}
