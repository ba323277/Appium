package com.ebay.Testcase;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.base.Base;
import com.ebay.pom.EbayElement;
import com.ebay.pom.ElementEbay;

public class Addtocart extends Base {
	WebDriver driver;
	EbayElement EbEle;
	
	@BeforeTest
	public void setUpdriver() throws MalformedURLException {
		driver=appiumRemoteWebDriver();
		EbEle= new EbayElement(driver);
	}
	@Test
	public void addToCart() throws Exception {
		EbEle.clickSerachBox().click();
		timeToWait(driver, 80);
		hideKeyboard(driver);
		EbEle.setSerachBoxValue().sendKeys("bag");
		List<WebElement> list=driver.findElements(ElementEbay.suggestionList);
		list.get(0).click();


	/*	String item="LeeRooy Laptop Backpack College Bags for Girls Boys Man and Woman";
		String xpath="//android.widget.TextView[contains(text(),'"+item+"')]";
		driver.findElement(By.xpath(xpath)).click();*/


		List<WebElement> item=driver.findElements(ElementEbay.itemList);
		item.get(0).click();

		EbEle.buyNow().click();
        timeToWait(driver, 80);
		
	}
	
	@AfterTest
    public void terminatedriver() throws MalformedURLException {
		terminate(driver);
	}

}
