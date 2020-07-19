package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil{
	
	private static Workbook book;
	private static Sheet sheet;
	
	private static String TEST_DATA_SHEET_PATH = "./src/main/java/com/qa/hubspot/testdata/HubSpot_TestData.xlsx";
	
	public static Object[][] getTestData(String sheetName)  {
		
		Object data[][] = null;
		
		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			try {
				book = WorkbookFactory.create(ip);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			
			System.out.println(rowCount);
			System.out.println(colCount);
			data = new Object[rowCount][colCount];
			
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
					//System.out.println(data[i][j]);
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}
}
