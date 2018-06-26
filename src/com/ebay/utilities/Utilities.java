package com.ebay.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



public class Utilities {
	
	public Utilities(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	 String[][] myData;
	 List <String>list=new ArrayList<String>();
	
	  public List<String> POI() throws IOException{
        	String  filePath=System.getProperty("user.dir")+"\\src\\com\\ebay\\resources";

		    File file =    new File(filePath+"\\"+"excel.xls");

		    FileInputStream inputStream = new FileInputStream(file);

		    Workbook book = new HSSFWorkbook(inputStream);

		    //Read sheet inside the workbook by its name

		    Sheet sheet = book.getSheetAt(0);

		    //Find number of rows in excel file

		    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		   

		    for (int i = 1; i < rowCount+1; i++) {

		        Row row = sheet.getRow(i);

		        //Create a loop to print cell values in a row

		          for (int j = 0; j < row.getLastCellNum(); j++) {

		            //Print Excel data in console 

		               System.out.print(i+""+j+row.getCell(j).getStringCellValue()+"|| ");//
                       list.add(row.getCell(j).getStringCellValue());

		        }
		          

		        System.out.println();

		    }
			return list;


}
	  
	  public  String Propertyfile()  {
		  File file = new File(System.getProperty("user.dir")+"\\src\\com\\ebay\\resources\\NotepadData.properties");
		  
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
			
			//load properties file
			try {
				prop.load(fileInput);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
	        System.out.println(prop.getProperty("Password"));

			return prop.getProperty("Password");
		}

}
