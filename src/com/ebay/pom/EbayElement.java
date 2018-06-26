package com.ebay.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EbayElement {
	
	public EbayElement(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.ebay.mobile:id/search_box")
	private static  WebElement searchBox;
	
	
	@FindBy(id = "com.ebay.mobile:id/search_src_text")
	private static  WebElement searchTextBox;
	
	@FindBy(name = "Buy It Now")
	private static  WebElement buyNow;
	
	@FindBy(id = "com.ebay.mobile:id/cell_collection_item")
	private static  WebElement listOfitem;
	
	public static WebElement clickSerachBox() throws Exception {
		return searchBox ;
	}
	public static WebElement setSerachBoxValue() throws Exception {
		return searchTextBox ;
	}
	public static WebElement buyNow() throws Exception {
		return buyNow ;
	}
	public static WebElement listOfItem() throws Exception {
		return listOfitem ;
	}



}
