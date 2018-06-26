package com.ebay.Testcase;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.base.Base;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class ScrollandSwipe extends Base {
	AndroidDriver driver;
	Dimension size;
	@BeforeTest
	public void setUpdriver() throws MalformedURLException {
		driver=appiumAndroidDriver();
	}
	@Test(priority=0)
	public void scroll() throws Exception {
        timeToWait(driver, 40);
	    driver.scrollTo("Handpicked by eBay");

		
	}
	@Test(priority=1)
	public void Swipe() {
        timeToWait(driver, 40);
        size = driver.manage().window().getSize();
		System.out.println(size);
		  
		  //Find swipe x points from screen's with and height.
		  //Find x1 point which is at right side of screen.
		  int x1 = (int) (size.width * 0.20);
		  //Find x2 point which is at left side of screen.
		  int x2 = (int) (size.width * 0.80);
		  
		  driver.scrollTo("Handpicked by eBay");
		  
		  TouchAction action = new TouchAction((MobileDriver)driver);
		  driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);

		  //Find element to swipe from right to left.
		  WebElement ele1 =  (WebElement) driver.findElementsById("com.ebay.mobile:id/carousel_card_view").get(1);  
		  //Create swipe action chain and perform horizontal(right to left) swipe.
		  //Here swipe to point x1 Is at left side of screen. So It will swipe element from right to left.
		  action.longPress(ele1).moveTo(x1,580).release().perform();
		  
		  //Find element to swipe from left to right.
		  WebElement ele2 =  (WebElement) driver.findElementsById("com.ebay.mobile:id/carousel_card_view").get(0);
		  //Create swipe action chain and perform horizontal(left to right) swipe.
		  //Here swipe to point x2 Is at right side of screen. So It will swipe element from left to right.
		  action.longPress(ele2).moveTo(x2,580).release().perform();


		
	}
	
	@AfterTest
    public void terminatedriver() throws MalformedURLException {
		terminate(driver);
	}

}
