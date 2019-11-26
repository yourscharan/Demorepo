package com.hrm.qa.TestCases;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		
		intialisation();
		loginpage=new LoginPage();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	@Test(priority=1)
	public void verifyHomepageTitleTest() throws IOException {
		//homepage = new HomePage();
		String title = homepage.verifyHomePageTitle();
		assertEquals(title, "OrangeHRM");
		}

	

	
	
	@Test(priority=2)
	public void verifyPimLinkTest() throws Exception {
		//homepage = new HomePage();
		homepage.verifyPimLink();
		
	}
	
	@Test(priority=3)
	public void verifyLeaveLinkTest() throws Exception {
		//homepage = new HomePage();

		homepage.verifyLeavelink();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
