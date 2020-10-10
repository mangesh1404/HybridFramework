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
	String data= null;
	FileInputStream fis= new FileInputStream(fileName);
	
	Workbook wb =WorkbookFactory.create(fis);
	
	Sheet sh= wb.getSheet(sheetName);
	
	Cell cell=sh.getRow(row).getCell(col);
	
	if(cell.getCellType()==cell.CELL_TYPE_NUMERIC) {	
		double num= cell.getNumericCellValue();//123456.0
		data = String.valueOf(num).substring(0, String.valueOf(num).indexOf('.'));//123456
		return data;
	}
	else
		data=cell.toString();
	
	return data;
	
	}
	
	public static int getRows(String fileName, String sheetName)throws Exception {
		
		FileInputStream fis= new FileInputStream(fileName);
		
		Workbook wb =WorkbookFactory.create(fis);
		
		Sheet sh= wb.getSheet(sheetName);
		
		return sh.getPhysicalNumberOfRows();	
	}
	
	
	
	
	
	
}

/*sh.createRow(5).createCell(0).setCellValue("writing in XLS file");
	
	FileOutputStream fos= new FileOutputStream("Test.xls");
	wb.write(fos);
	wb.close();*/
