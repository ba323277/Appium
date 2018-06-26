package com.ebay.Testcase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.base.Base;
import com.ebay.pom.ElementEbay;
import com.ebay.utilities.Utilities;

public class EbayRegister extends Base{
	
	WebDriver driver;
	Utilities uti;
	String firstName;
	String lastName;
	String email;
	String password;
	
	@BeforeTest
	public void setUpdriver() throws MalformedURLException {
		driver=appiumRemoteWebDriver();
		uti=new Utilities(driver);
		
	}
	@Test(priority=0)
	public void getdata() throws IOException {
		List<String>list=uti.POI();
       /* for(int i=0;i<arr[0].length;i++) {
        	firstName=arr[i][1];
        	lastName=arr[i][1];
        	email=arr[i][1];
        }*/
		firstName=list.get(0);
		lastName=list.get(1);
		email=list.get(2);
    	password=uti.Propertyfile();

	}
	@Test(priority=1)
	public void register() throws Exception {
		timeToWait(driver,80);

		click(driver, ElementEbay.register);		
		timeToWait(driver,80);
			sendKeys(driver, ElementEbay.firstname, firstName);
			sendKeys(driver, ElementEbay.lastname, lastName);			
			sendKeys(driver, ElementEbay.email, email);			
   			sendKeys(driver, ElementEbay.passowrd, password);			
        timeToWait(driver,80);
		click(driver,ElementEbay.returnHome);		

	}
	
	@AfterTest
    public void terminatedriver() throws MalformedURLException {
		terminate(driver);
	}
}
