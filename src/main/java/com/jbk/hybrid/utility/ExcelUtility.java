package com.jbk.hybrid.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	// read and write
	
	public static String getData(String fileName, String sheetName, int row , int col)throws Exception {
	
	FileInputStream fis= new FileInputStream(fileName);
	
	Workbook wb =WorkbookFactory.create(fis);
	
	Sheet sh= wb.getSheet(sheetName);
	
	Cell cell=sh.getRow(row).getCell(col);
	
	String data=cell.toString();
	
	return data;
	
	}
	
}

/*sh.createRow(5).createCell(0).setCellValue("writing in XLS file");
	
	FileOutputStream fos= new FileOutputStream("Test.xls");
	wb.write(fos);
	wb.close();*/
