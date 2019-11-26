package com.hrm.qa.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage = new LoginPage();

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeMethod
	public void setup() throws Exception {
		intialisation();
		 loginpage = new LoginPage();
	}
	
/*	@Test(priority=1)
	public void validateLoginPageTitle() {
		loginpage.validateLoginTitle();
		
	}
	*/
	@Test(priority=2)
	public void loginTest() throws Exception {
		loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	

}
