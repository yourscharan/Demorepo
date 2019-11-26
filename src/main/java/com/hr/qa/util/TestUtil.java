package com.hr.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.hrm.qa.base.TestBase;

public class TestUtil extends TestBase {

	// Actions action;
	
	public static String Testdata_sheet_path="D:\\QAplanet\\OrangeHRMPOM\\src\\main\\java\\com\\hrm\\qa\\Testdata\\orangehrmpom.xls";
    static org.apache.poi.ss.usermodel.Workbook book;
    static org.apache.poi.ss.usermodel.Sheet sheet;
	
	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public void switchtoframe() {
		driver.switchTo().frame("rightMenu");
	}
	
	
	public static Object[][] getTestData(String sheetname) throws EncryptedDocumentException, IOException{
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(Testdata_sheet_path);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		book = WorkbookFactory.create(file);
		
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
		
		
		
        		
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileHandler.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	
	
	/* public WebElement FindElementByLoc(String identifier,String locator)
	{
		WebElement e=null;
		switch (identifier)
		{
		case "id" : 
			e=driver.findElement(By.id(locator));
		              	break;
		case "className" : 
			e=driver.findElement(By.className(locator));
					  	break;
		case "tagName" : 
			e=driver.findElement(By.tagName(locator));
						break;
		case "name" : 
			e=driver.findElement(By.name(locator));
						break;		 
		case "linkText" : 
			e=driver.findElement(By.linkText(locator));
						break;		 
		case "partialLinkText" : 
			e=driver.findElement(By.partialLinkText(locator));
						break;          
		case "cssSelector" : 
			e=driver.findElement(By.cssSelector(locator));
						break;
		case "xpath" :
			e=driver.findElement(By.xpath(locator));
						break;
		default : 
			System.out.println("Locator not found");
       	 			e=null;
		}
		return e;
	}+

	public void startAction()
	{
		action =new Actions(driver);
	}
	//move to element
	public void MouseOverToElement(String identifier,String locator)
	{		
		WebElement e=FindElementByLoc(identifier, locator);
		action.moveToElement(e).perform();
	}
	*/
	
	
		


	
	
}
