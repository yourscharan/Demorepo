package com.hrm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrm.qa.base.TestBase;

public class pimPage extends TestBase {

	
	
	
 @FindBy(linkText="PIM")
 WebElement objpim;
 
 @FindBy(xpath="//div[@class=\"mainHeading\"]/h2")
 WebElement pimtitle;

 @FindBy(linkText="Add Employee")
 WebElement objaddemp;
 
 @FindBy(linkText="Employee List")
 WebElement objemplist;
 
 @FindBy(xpath="//input[@id='txtEmpLastName']")
 WebElement lname;
	
 @FindBy(xpath="//input[@id='txtEmpFirstName']")
 WebElement fname;
	
 @FindBy(xpath="//input[@id='txtEmpMiddleName']")
 WebElement mname;
	
 @FindBy(name="txtEmpNickName")
 WebElement nname;
 
 @FindBy(xpath="/html/body/form/div/div[1]/div[2]/div[2]/input[1]")
 WebElement objsave;  
 

	public pimPage() throws IOException {
	
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
 public void verifypimpage() {
	 objpim.click();
 }
 
 public String verifyPIMpageTitle() {
	 
	 
return pimtitle.getText();	 
	 
	 
 }
 
 
 
 public void verifynewAddemp(String ltname,String ftname,String mdname,String niname) throws Exception {
	 
	 objaddemp.click();
driver.switchTo().frame("rightMenu");
Thread.sleep(5000);
	 lname.sendKeys(ltname);
	 fname.sendKeys(ftname);
	 mname.sendKeys(mdname);
	 nname.sendKeys(niname);
	 objsave.click();
	 
		
		
	}
 
 public void verifyEmployeeList() {
	 
	 objemplist.click();
	 
	 
 }
	 


 
 
	

}
