package com.ebay.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface ElementEbay {
	
	public static final By register=By.xpath("//android.widget.Button[contains(@text, 'Register')]");
	public static final By firstname= By.xpath("//android.widget.EditText[contains(@resource-id, 'firstname')]");
	public static final By lastname= By.xpath("//android.widget.EditText[contains(@resource-id, 'lastname')]");
	public static final By email= By.xpath("//android.widget.EditText[contains(@resource-id, 'email')]");
	public static final By passowrd= By.xpath("//android.widget.EditText[contains(@resource-id, 'PASSWORD')]");
	public static final By returnHome=By.id("com.ebay.mobile:id/home");
	public static final By suggestionList= By.id("com.ebay.mobile:id/suggestionList");
	public static final By itemList=By.id("com.ebay.mobile:id/cell_collection_item");

	
}