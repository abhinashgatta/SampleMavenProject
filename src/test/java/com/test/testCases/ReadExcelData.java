package com.test.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.test.Base.Constants;

public class ReadExcelData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File ip = new File(Constants.excelData);
		FileInputStream fis = new FileInputStream(ip);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet("");
		
		HSSFCell cell;
		sheet.getLastRowNum();
		short lastcol = sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int col =0; col<=lastcol;col++) {
				cell = sheet.getRow(i).getCell(col);
			}
		}
		//cell.getCellType();
		
		workbook.close();
		
		
	}

}
