package Launch;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class StartApplication {

	
	//private static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		File classpathRoot = new File(System.getProperty("user.dir"));
		//File appDir = new File(classpathRoot, "/Apps/Amazon/");
		File app = new File(classpathRoot, "in.amazon.mShop.android.shopping_2018-04-05.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Galaxy J5");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		
		/*capabilities.setCapability("appPackage", "<App package name>");
		capabilities.setCapability("appActivity", "<App activity name>");
		AndroidDriver	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
*/
		
		
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
	//	capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		capabilities.setCapability("appActivity", "com.amazon.micron.StartupActivity");
		//capabilities.setCapability("appActivity", "com.amazon.micron.SignInPromptActivity");


		WebDriver driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/sign_in_button")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id, 'ap_email_login')]")).sendKeys("9742108784"); //Enter Mobile No
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'continue')]")).click();
		Thread.sleep(5000);
		driver.quit();
//	    driver.findElementById("in.amazon.mShop.android.shopping:id/action_bar_burger_icon").click();
		
}
}
