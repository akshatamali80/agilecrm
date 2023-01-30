package com.agilecrmautomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelDataRead {
	static Workbook wb;

	public static void main(String[] args) throws IOException, FileNotFoundException {

		// file path
		String filePath = ("D:\\JDK\\AutomationTestData.xlsx");
		// get file path extension
		String extension = filePath.substring(filePath.indexOf("."));
		System.out.println(extension);
		// get the control of excel file
		FileInputStream input = new FileInputStream(filePath);
		// based on the file extension, take the control of workbook
		if (extension.equals(".xlsx")) {
			wb = new XSSFWorkbook(input);
		} else {
			wb = new HSSFWorkbook(input);
		}
		// take the control of sheet using workbook
		Sheet sheet = wb.getSheet("AutomationTestData");
		// get total number of rows from the sheet
		int totalrows = sheet.getPhysicalNumberOfRows();
		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = 1; i < totalrows; i++) {
			// take the control on rows based on the i value
			Row row = sheet.getRow(i);
			for (int j = 0; j < totalColumns; j++) {
				// take the control of cell using row reference
				Cell cell = row.getCell(j);
				// get the cell value using cell reference
				String value = cell.getStringCellValue();
				
				System.out.print(value+ " ");
	 		}
			
			System.out.println();
		}
		wb.close();
		input.close();

	}
}
