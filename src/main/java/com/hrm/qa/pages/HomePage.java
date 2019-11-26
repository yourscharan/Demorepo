package com.hrm.qa.pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//*[@id=\"pim\"]/a/span")
	WebElement pimlink;
	
	@FindBy(xpath="/html/body/div[4]/ul/li[3]/a/span")
	WebElement leavelink;
	
	public HomePage() throws IOException {
		
		PageFactory.initElements(driver,this);
	}
	
	
	
	public String verifyHomePageTitle() {
		//pimlink.click();
		return driver.getTitle();
		
	
	}
	
	public pimPage verifyPimLink() throws Exception {
Actions act = new Actions(driver);
act.moveToElement(pimlink).build().perform();
return new pimPage();


	}
	
	public LeavePage verifyLeavelink() {
		leavelink.click();
		return new LeavePage();
	}
	
	

}
