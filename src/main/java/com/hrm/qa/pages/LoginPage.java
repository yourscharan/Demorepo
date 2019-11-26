package com.hrm.qa.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.*;


import com.hrm.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	public LoginPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	
	}
	
	@FindBy(name="txtUserName")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement loginbtn;
	
	
	

	public void validateLoginTitle() {
		String logintitle = driver.getTitle();
		if(logintitle.equals("OrangeHRM - New Level of HR Management")) {
			Reporter.log("Login page displayed");
		}
		else
		{
			Reporter.log("login page not displayed");
		}
	}
	
	public  HomePage Login(String un,String pwd) throws Exception {
	
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return  new HomePage();
		
	}
	
	
}
