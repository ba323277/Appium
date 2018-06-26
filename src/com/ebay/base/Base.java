package com.ebay.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Base {
	
	   WebDriver driver;
	   AndroidDriver androidDriver;
	   DesiredCapabilities capabilities;
	   AppiumDriver appiumDriver;

		Dimension size;
		 String destDir;
		 DateFormat dateFormat;
		
		public DesiredCapabilities appiumCapabilities() throws MalformedURLException {
			File classpathRoot = new File(System.getProperty("user.dir"));
			File app = new File(classpathRoot, "com.ebay.mobile_v5.21.0.19-128_Android-5.0.apk");

			 capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("deviceName", "Galaxy J5");
			capabilities.setCapability("platformVersion", "6.0.1");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "com.ebay.mobile");
			capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
			
			 //both the below capabilities used for hiding  keyboard in mobile runtimely
			/*capabilities.setCapability("unicodeKeyboard", true);
			capabilities.setCapability("resetKeyboard", true); 
			*/
			  return capabilities;

			
		}
		public WebDriver appiumRemoteWebDriver() throws MalformedURLException {
		      driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), appiumCapabilities());
           return driver;
		}
		public AndroidDriver appiumAndroidDriver() throws MalformedURLException {
			androidDriver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), appiumCapabilities());
         return androidDriver;
		}
		/*public AppiumDriver appiumDriver() throws MalformedURLException {
			appiumDriver= new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),appiumCapabilities());
       return appiumDriver;
		}
     */
		
		public void terminate(WebDriver driver) {
			driver.quit();
		}
		public void terminate(AndroidDriver driver) {
			driver.closeApp();
		}
        
		public void hideKeyboard(WebDriver driver) {
			driver.navigate().back();
		}
		
		public void sendKeys(WebDriver driver,By element,String message) {
			
			driver.findElement(element).sendKeys(message);
		}
        public void sendKeys(AndroidDriver driver,By element,String message) throws InterruptedException {
        	//  elementHighlight(driver,element);
				driver.findElement(element).sendKeys(message);
		}
        public void click(AndroidDriver driver,By element) {
			
			driver.findElement(element).click();
		}
        public void click(WebDriver driver,By element) throws InterruptedException {
        //	elementHighlight(driver,element);
			driver.findElement(element).click();
		}
        public void elementHighlight(WebDriver driver,By element) throws InterruptedException {
        WebElement e=driver.findElement(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			for (int iCnt = 0; iCnt < 2; iCnt++) {
				// Execute javascript
				js.executeScript(
						"arguments[0].style.border='4px solid orange'", e);
				Thread.sleep(200);
				js.executeScript("arguments[0].style.border=''", e);
			}
		
        }
        public void timeToWait(WebDriver driver,long time) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

        }
        public void timeToWait(AndroidDriver driver,long time) {
               try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             }

        public void takeScreenShot(WebDriver driv) {
  		  // Set folder name to store screenshots.
  		  destDir = System.getProperty("user.dir")+"\\target\\";
  		  // Capture screenshot.
  		  File scrFile = ((TakesScreenshot) driv).getScreenshotAs(OutputType.FILE);
  		  // Set date format to set It as screenshot file name.
  		  dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
  		  // Set file name using current date time.
  		  String destFile = dateFormat.format(new Date()) + ".png";

  		  try {
  		   // Copy paste file at destination folder location
  		   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
  		  } catch (IOException e) {
  		   e.printStackTrace();
  		  }
  		 }

}
