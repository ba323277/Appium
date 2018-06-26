package com.ebay.Testcase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.base.Base;


public class ScreenShot extends Base{
	WebDriver wdriver;
	@BeforeTest
	public void setUpdriver() throws MalformedURLException {
		wdriver=appiumRemoteWebDriver();
	}

	@Test
	public void sceenshot() throws MalformedURLException, InterruptedException {
           Thread.sleep(5000);
		
 		  takeScreenShot(wdriver);

	}
	
	@AfterTest
    public void terminatedriver() throws MalformedURLException {
		terminate(wdriver);
	}

	
	
}
