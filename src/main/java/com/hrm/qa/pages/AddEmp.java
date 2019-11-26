package com.hrm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class AddEmp extends TestBase {

	public AddEmp() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="txtEmpLastName")
	WebElement lname;
	
	@FindBy(name="txtEmpFirstName")
	WebElement fname;
	
	@FindBy(name="txtEmpMiddleName")
	WebElement mname;
	
	@FindBy(xpath="/html/body/form/div/div[1]/div[2]/div[2]/input[1]")
	WebElement objsave;
	
	public void createNewEmp(String lastname,String firstname,String midname) {
		
		lname.sendKeys(lastname);
		fname.sendKeys(firstname);
		mname.sendKeys(midname);
		
		objsave.click();
		
		
		
		
	}
	
	
	
	

}
