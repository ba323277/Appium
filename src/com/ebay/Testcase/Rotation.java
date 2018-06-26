package com.ebay.Testcase;

import java.net.MalformedURLException;

import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.base.Base;

import io.appium.java_client.android.AndroidDriver;

public class Rotation extends Base{
	
		AndroidDriver driver;
		Dimension size;
		@BeforeTest
		public void setUpdriver() throws MalformedURLException {
			driver=appiumAndroidDriver();
		}
		@Test
		public void scroll() throws Exception {
			  System.out.println("*--*--*-- Current screen orientation Is : " + driver.getOrientation());
			  System.out.println("*--*--*-- Changing screen Orientation to LANDSCAPE.");
			  //Changing screen Orientation to LANDSCAPE.
			  driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
			  //Get and print screen orientation after changing It.
			  System.out.println("*--*--*-- Now screen orientation Is : "+ driver.getOrientation());
			  timeToWait(driver, 500);
			  // Scroll till element which contains "Handpicked by eBay" text If It Is not visible on screen.
			  driver.scrollTo("Handpicked by eBay");
			  // Click on Views.
			  System.out.println("*--*--*-- Changing screen Orientation to PORTRAIT.");
			  //Changing screen Orientation to PORTRAIT.
			  driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
			  //Get and print screen orientation after changing It.
			  System.out.println("*--*--*-- Now screen orientation Is : "+ driver.getOrientation());
			  Thread.sleep(5000);
		}
			
		
		
		@AfterTest
	    public void terminatedriver() throws MalformedURLException {
			terminate(driver);
		}

	

}
