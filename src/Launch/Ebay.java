package Launch;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Ebay {
   WebDriver driver;
   AndroidDriver Adriver;
   DesiredCapabilities capabilities;
	
	@Test(priority=0)
	public void setUp() throws MalformedURLException {
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

    //   driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	//	AppiumDriver driver= new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
	}
	
	//@Test(priority=1)
	public void Register() {
	        //driver.findElementByXPath("//android.widget.Button[contains(@text, 'Register')]").click();
		    driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'Register')]")).click();
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

						
				driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id, 'firstname')]")).sendKeys("Balaram");
				driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id, 'lastname')]")).sendKeys("sahoo");
				driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id, 'email')]")).sendKeys("sahoobalaram989@gmail.com");
				driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id, 'PASSWORD')]")).sendKeys("jayanti@1995");
				driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

				 //driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'Register')]")).click();
	             driver.findElement(By.id("com.ebay.mobile:id/home")).click();

	}
	//@Test(priority=2)
	public void AddtoCart() throws InterruptedException {
		driver.findElement(By.id("com.ebay.mobile:id/search_box")).click();
		driver.findElement(By.id("com.ebay.mobile:id/search_src_text")).sendKeys("bag");
		driver.navigate().back();  //is also used for hiding virtual keyboard
		List<WebElement> a=driver.findElements(By.id("com.ebay.mobile:id/suggestionList"));
		a.get(0).click();


	/*	String item="LeeRooy Laptop Backpack College Bags for Girls Boys Man and Woman";
		String xpath="//android.widget.TextView[contains(text(),'"+item+"')]";
		driver.findElement(By.xpath(xpath)).click();*/


		List<WebElement> A=driver.findElements(By.id("com.ebay.mobile:id/cell_collection_item"));
		A.get(0).click();

		driver.findElement(By.name("Buy It Now")).click();
		//driver.navigate().back();
		Thread.sleep(5000);
		
		driver.quit();

	}
	//@Test(priority=1)
	public void scroll() throws MalformedURLException, Exception {
		 Adriver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
         Thread.sleep(5000);
	     Adriver.scrollTo("Handpicked by eBay");
	    // page.swipe(SwipeElementDirection.UP, 400);

		
		//List<MobileElement> A=Adriver.findElements(By.id("com.ebay.mobile:id/carousel_card_view"));
	    //A.get(0).click();
		
		//WebElement e=driver.findElement(By.id("com.ebay.mobile:id/textview_collections"));
	//	WebElement element = driver.findElement(By.id("//android.widget.TextView[contains(@text,'Handpicked by eBay')]"));

		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
		//((JavascriptExecutor) driver) .executeScript("window.scrollTo(0,document.body.scrollHeight)");
	     while(driver.findElements(By.id("your_id")).size()==0){
          Dimension 	    	 size = driver.manage().window().getSize();
	    	 int starty = (int) (size.height * 0.80);
	    	 int endy = (int) (size.height * 0.20);
	    	 int startx = size.width / 2;
	    	 System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

	    	 Adriver.swipe(startx, starty, startx, endy, 3000);
	    	 Thread.sleep(2000);
	    	 Adriver.swipe(startx, endy, startx, starty, 3000);
	    	 Thread.sleep(2000);
	    	 }
	}
	@Test(priority=1)
	public void swipe() throws Exception {
		 Adriver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		/* while(driver.findElements(By.id("your_id")).size()==0){
	          Dimension 	    	 size = driver.manage().window().getSize();
		    	 int starty = (int) (size.height * 0.80);
		    	 int endy = (int) (size.height * 0.20);
		    	 int startx = size.width / 2;
		    	 System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		    	 Adriver.swipe(startx, starty, startx, endy, 3000);
		    	 Thread.sleep(2000);
		    	 Adriver.swipe(startx, endy, startx, starty, 3000);
		    	 Thread.sleep(2000);
		    	 }*/
		//Get the size of screen.
		  size = Adriver.manage().window().getSize();
		  System.out.println(size);
		  
		  //Find swipe x points from screen's with and height.
		  //Find x1 point which is at right side of screen.
		  int x1 = (int) (size.width * 0.20);
		  //Find x2 point which is at left side of screen.
		  int x2 = (int) (size.width * 0.80);
		  Thread.sleep(5000);
		  Adriver.scrollTo("Handpicked by eBay");
		  //Create object of TouchAction class.
		  TouchAction action = new TouchAction((MobileDriver)Adriver);
		  Adriver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);

		  //Find element to swipe from right to left.
		  WebElement ele1 =  (WebElement) Adriver.findElementsById("com.ebay.mobile:id/carousel_card_view").get(1);  
		  //Create swipe action chain and perform horizontal(right to left) swipe.
		  //Here swipe to point x1 Is at left side of screen. So It will swipe element from right to left.
		  action.longPress(ele1).moveTo(x1,580).release().perform();
		  
		  //Find element to swipe from left to right.
		  WebElement ele2 =  (WebElement) Adriver.findElementsById("com.ebay.mobile:id/carousel_card_view").get(0);
		  //Create swipe action chain and perform horizontal(left to right) swipe.
		  //Here swipe to point x2 Is at right side of screen. So It will swipe element from left to right.
		  action.longPress(ele2).moveTo(x2,580).release().perform();
	}
	//@Test(priority=1)
	public void abc() throws Exception {
		 Adriver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		  System.out.println("*--*--*-- Current screen orientation Is : " + Adriver.getOrientation());
		  System.out.println("*--*--*-- Changing screen Orientation to LANDSCAPE.");
		  //Changing screen Orientation to LANDSCAPE.
		  Adriver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		  //Get and print screen orientation after changing It.
		  System.out.println("*--*--*-- Now screen orientation Is : "+ Adriver.getOrientation());
		  Thread.sleep(5000);
		  // Scroll till element which contains "Views" text If It Is not visible on screen.
		 Adriver.scrollTo("Handpicked by eBay");
		  // Click on Views.
		//  Adriver.findElement(By.name("more")).click();  
		  System.out.println("*--*--*-- Changing screen Orientation to PORTRAIT.");
		  //Changing screen Orientation to PORTRAIT.
		  Adriver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		  //Get and print screen orientation after changing It.
		  System.out.println("*--*--*-- Now screen orientation Is : "+ Adriver.getOrientation());
		  Thread.sleep(5000);
	}
	//@Test(priority=1)
	public void sceenshot() throws MalformedURLException, InterruptedException {
		 Adriver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
           Thread.sleep(5000);
		  // Scroll till element which contains "Views" text If It Is not visible on screen.
 		  takeScreenShot(Adriver);

		  Adriver.scrollTo("Handpicked by eBay");
	}
	
	 Dimension size;
	 String destDir;
	 DateFormat dateFormat;
	
	public void takeScreenShot(WebDriver driv) {
		  // Set folder name to store screenshots.
		  destDir = "G:\\eclipse\\AppiumProject\\target\\";
		  // Capture screenshot.
		  File scrFile = ((TakesScreenshot) driv).getScreenshotAs(OutputType.FILE);
		  // Set date format to set It as screenshot file name.
		  dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		  // Create folder under project with name "screenshots" provided to destDir.
		 // new File(destDir).mkdirs();
		  // Set file name using current date time.
		  String destFile = dateFormat.format(new Date()) + ".png";

		  try {
		   // Copy paste file at destination folder location
		   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }
    @Test(enabled=false)
	public  void maina() throws MalformedURLException {
		// TODO Auto-generated method stub

		File classpathRoot = new File(System.getProperty("user.dir"));
		File app = new File(classpathRoot, "com.ebay.mobile_v5.21.0.19-128_Android-5.0.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Galaxy J5");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.ebay.mobile");
		capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
		capabilities.setCapability("unicodeKeyboard", true);//
		capabilities.setCapability("resetKeyboard", true);  //both used for hiding virtual keyboard

   //	WebDriver driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	//	AppiumDriver driver= new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	//	WebDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		
	//	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	  // driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
		//com.ebay.mobile:id/button_sign_in
           /*  Dimension   size = driver.manage().window().getSize();
             System.out.println(size);
             
             //Find swipe x points from screen's with and height.
             //Find x1 point which is at right side of screen.
             int x1 = (int) (size.width * 0.20);
             //Find x2 point which is at left side of screen.
             int x2 = (int) (size.width * 0.80);
             
             TouchAction a= new TouchAction((MobileDriver) driver);
             
             
             
*/


	 /*   MobileElement ele=(MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text(),'Handpicked by eBay']"));	
	    TouchAction action = new TouchAction((MobileDriver) driver);
		action.longPress(ele).release().perform();
	    */
	
	

		
        // driver.findElement(By.id("com.ebay.mobile:id/button_all_collections")).click();	
       // driver.findElement(By.xpath("//android.widget.Button[@text='more']")).click();

		/*TouchActions action = new TouchActions(driver);
		action.scroll(element, 1153, 714);
		action.perform();*/
	}

}
