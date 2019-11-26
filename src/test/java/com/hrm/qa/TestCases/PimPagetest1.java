package com.hrm.qa.TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hr.qa.util.TestUtil;
import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.pimPage;

public class PimPagetest1 extends TestBase {
	
	public PimPagetest1() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	HomePage homePage = new HomePage();
	LoginPage loginpage;
	 TestUtil testutil = new TestUtil();
		pimPage pim;
String sheetname = "employee";
	
	@BeforeMethod
	public void setup() throws Exception {
		intialisation();
		loginpage = new LoginPage();
		homePage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		pim=homePage.verifyPimLink();
	}
	
	@Test(priority=1)
	public void verifyPimTitleTest() throws Exception {
        testutil.switchtoframe();
		String title = pim.verifyPIMpageTitle();
		assertEquals(title, "Employee Information");
		System.out.println(title);
		
	}
	
	@DataProvider()
	public Object[][] getOrangeTestdata() throws EncryptedDocumentException, IOException {
		Object[][] data = TestUtil.getTestData(sheetname);
		return data;  // this Dataprovider is fetching data from getTestData from Util calss and returning
		                //2d arrray
	}
	
	
	
	@Test(priority=2,dataProvider="getOrangeTestdata")
	public void verifyAddempTest(String Lastname,String Firstname,String Middlename,String Nickname) throws Exception {
		Thread.sleep(2000);
		pim.verifynewAddemp(Lastname, Firstname, Middlename, Nickname);
		
		
	
	
	}
	
/*	@Test(priority=2)
	public void verifyAddempTest() throws Exception {
		
		 pim.verifynewAddemp("uma", "sai", "rahul");
		
    
	}*/
	
	
	@Test(priority=3)
	public void verifyemptest() throws Exception {
		homePage.verifyPimLink();
		pim.verifyEmployeeList();
	}
	
	/* @AfterMethod
	public void teardown() {
		driver.quit();
	}  */



}
