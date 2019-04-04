//import MercuryDemoTours;

package  AONATIONALITIES;
import org.testng.annotations.Test;

import org.openqa.selenium.JavascriptExecutor;

import CommonUtil.*;

import HTMLReport.TestHTMLReporter6;
import ExcelUtil.ExcelApiTest3;
import Login.Login;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.apache.commons.io.FileUtils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.io.*;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.net.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.*;
/*
 Openbrowser
 openurL
 login
Nationalities
 logout
 */

 
public class Nationality
{
	public String UserName,Password;
	public String NNAME;
	
	public  int iRow;
	
	
	WebDriver driver;
	String HtmlOutputFileName="";
	String error;
	TestHTMLReporter6 TH3;

	public  void Nationality(WebDriver driver,String HtmlOutputFileName,TestHTMLReporter6 TH3 )throws Exception
	{  
			  this.driver=driver;
			  this.HtmlOutputFileName=HtmlOutputFileName;
			  this.TH3=TH3;
	}
	
	public WebElement findElement(By by)throws Exception {
	    WebElement elem = driver.findElement(by);
	 
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	    } 
	    Thread.sleep(10);
	    
	    return elem;
	    
	}
	
	
	
	@Test
	public  void AONationality_datadriventest( )throws Exception
	{  
		
		
		
		
		  ExcelApiTest3 eat = new ExcelApiTest3();
		  int numberowsInputdata=eat.getRowCount("C://HTML Report//OrangeHRM6//TC01_Nationality.xls","Sheet1");

				 for(int i=1;i<2 ;i++)
				 {		 
					 UserName="Admin";
					 
					 Password="admin123";
					 
					 
					 NNAME=eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nationality.xls","Sheet1",i,0);
					 System.out.println(" NNAME is "+NNAME);
					  iRow=i;
					  
						call_allmethods(iRow);
						
						
						
					 
				 }
			
				 
				 driver.quit();
				 
	}
	
	
	
	
	public   void call_allmethods(int iRow )throws Exception
	{  
		
		String str=String.valueOf(iRow);
		TH3= new TestHTMLReporter6();
		HtmlOutputFileName=TH3.CretaeHTMLFile("TC01_Nationality_Iteration_" + str,"Chrome");
		
		
		if (iRow==1)
		{
			
		driver=TestBrowser.OpenChromeBrowser();	
		
		Login l1=new Login();
		l1.Login(driver ,HtmlOutputFileName,TH3);
	
		l1.openOrangeHRM();
		l1.OrangeHRMlogin(UserName,Password);
		
		TH3.HTMLScreenShot("Enter user Name and Password","User Name and password Succefully Entered","Pass", HtmlOutputFileName,driver);
		l1.OrangeHRMSigninClick();

		
		}
		
		
		
		Nationality NL =new Nationality();
	    NL.Nationality(driver, HtmlOutputFileName, TH3);
		NL.NANAME(iRow,NNAME);
		NL.Export_Nationality(iRow);
		TH3.HTMLCloser(HtmlOutputFileName);
		TH3=null;
		System.gc();

		
	}	
	
	

	public   void NANAME(int iRow,String NNAME )throws Exception
	{  
		
		System.out.println("reached here");
		try 
		{
		
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=findElement(By.xpath(OR.AOAdmin_Focus));
		 actions.moveToElement(ele).click().perform();
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("Admin focus highlight","Admin  clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 
		 Actions actions1 = new Actions(driver);   
		System.out.println("reached here2");
		 WebElement ele1=findElement(By.xpath(OR.AO_Nation_CK));
		 actions1.moveToElement(ele1).click().perform();
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("AdminQua focus highlight","AdminQua  clicked Succefully ","Pass", HtmlOutputFileName,driver);

		 findElement(By.xpath(OR.AO_ADD_Ck)).click();
		 Thread.sleep(100);
		 TH3.HTMLScreenShot("location click highlight","location  clicked Succefully ","Pass", HtmlOutputFileName,driver);

			System.out.println("reached here11");

		
		
		 
		 findElement(By.xpath(OR.AO_NNAME_Sk)).sendKeys(NNAME);
		 System.out.println("reached here3");

		 TH3.HTMLScreenShot("Enter NNAME","NNAME Succefully Entered","Pass", HtmlOutputFileName,driver);
		 
		 Actions actions2 = new Actions(driver);   
			System.out.println("reached here2");
			 WebElement ele2=findElement(By.xpath(OR.AO_Save_CK));
			 actions2.moveToElement(ele2).click().perform();
			 Thread.sleep(100);
			 TH3.HTMLScreenShot("Save focus highlight","Save  clicked Succefully ","Pass", HtmlOutputFileName,driver);

		 
		} 
		catch(Exception e)
		{
			
		}
		 
		 
	}
	
	
	public   void Export_Nationality(int iRow )throws Exception
	
	{  
		
		System.out.println("reached here");
		 
		
		Actions actions = new Actions(driver);   
		System.out.println("reached here1");
		 WebElement ele=findElement(By.xpath(OR.AOAdmin_Focus));
		 actions.moveToElement(ele).click().perform();
		 Thread.sleep(100);

		 TH3.HTMLScreenShot("Admin focus highlight","Admin  clicked Succefully ","Pass", HtmlOutputFileName,driver);
		 
		 
		 Actions actions1 = new Actions(driver);   
			System.out.println("reached here2");
			 WebElement ele1=findElement(By.xpath(OR.AO_Nation_CK));
			 actions1.moveToElement(ele1).click().perform();
			 Thread.sleep(100);
			 TH3.HTMLScreenShot("Nationality focus highlight","Nationality  clicked Succefully ","Pass", HtmlOutputFileName,driver);

		
			System.out.println("reached here11");
			 

			
			 
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//WebElement Element=findElement(By.xpath(OR.AO_Footer));
		//js.executeScript("arguments[0].scrollintoView();",Element);
			 
			 JavascriptExecutor jse = (JavascriptExecutor)driver;
			 jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			// ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scr‌​ollHeight);");
		
		TH3.HTMLScreenShot("Entire Table Screen Shot","All Web Table SCreen shot","Pass", HtmlOutputFileName,driver);
		 Thread.sleep(100);
			 
		 List  columns = driver.findElements(By.xpath(OR.AO_NCOLMNS)); 
	     System.out.println("No of columns are : " + columns.size());
	     
	     //No.of rows 
	     List  rows = driver.findElements(By.xpath(OR.AO_NROWS)); 
	     System.out.println("No of rows are : " + rows.size());
	     
	    
	   
	     			ExcelApiTest3 eat = new ExcelApiTest3();
	      
					    for ( int i=1 ; i<=rows.size() ;i++)
					    {
					    	  for ( int j=2 ,k=0; j<=columns.size();j++,k++)
					    	   {
					    		  
					    		  System.out.println("hai....112");
					      		   String str1="//*[@id='resultTable']/tbody/tr["  + i +  "]"  + "/td" + "[" + j +"]";
					      		
					      		 System.out.println("hai....113");
					      		   
					    		    WebElement CellText1=driver.findElement(By.xpath(str1));
					    		    
					    		    System.out.println("hai....114");
					    		   
					    	        String valueIneed1 = CellText1.getText();
					    	        System.out.println("Cell Text Value is: " + valueIneed1);
					    	        
					    	        if (valueIneed1 !=null)
					    	
					    	        	eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_Nationality.xls","Sheet5",i,k,valueIneed1);
					    	  
					    	        else
					    	        eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_Nationality.xls","Sheet5",i,k,"Blank Data");
					    	       
					    	        
					    	   }
					    	  
					    	 
					    }
					    
					    
					    TH3.HTMLScreenShot(" Location details exported C://HTML Report//OrangeHRM6//TC01_Nationality.xls","Locations export success ","Pass", HtmlOutputFileName,driver);

					    

					    
			} 

	/*@BeforeTest
	   public void suiteSetup1() throws Exception {
			
			
			
			//TestNGXML tn1 = new TestNGXML();
			//tn1.TestNG_Generate();
			
			
			 String xlsFile="C://HTML Report//HtmlTemplates//TC05.xls";
			 String xlsFileSheet="Sheet1";
			 
			 ExcelApiTest3 eat = new ExcelApiTest3();
			 eat.clearsheetdata(xlsFile,xlsFileSheet);
	   }  	
		
		@AfterTest
	 
	   public void AftersuiteSetup2() throws Exception {
			 
			 TestHTMLReporter6 TH8 = new TestHTMLReporter6();	
			 TH8.Regression_CretaeHTMLFile();
			 
			 
			
			
	   }   */ 
		
		




	

	
}