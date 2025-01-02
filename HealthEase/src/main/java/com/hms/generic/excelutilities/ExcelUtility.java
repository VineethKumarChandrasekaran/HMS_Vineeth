package com.hms.generic.excelutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	// Fetch Data from Excel
	public Object getDataFromExcel(String sheetname, int rowIndex, int colIndex)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resource/HealthEase.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Cell cell = workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex);
		switch (cell.getCellType()) {
		case STRING:
			return workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getStringCellValue();
		case NUMERIC:
			return workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
		case BOOLEAN:
			return workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
		}
		return false;
	}

	// Fetch LocalDateTime Data from Excel
	public LocalDateTime getDateFromExcel(String sheetname, int rowIndex, int colIndex)
			throws EncryptedDocumentException, IOException {
		try (FileInputStream file = new FileInputStream("./src/test/resource/HealthEase.xlsx");
				Workbook workbook = WorkbookFactory.create(file)) {
			return workbook.getSheet(sheetname).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
		}
	}
	
	// Write Data in the Excel
	public void writeDatainExcel(String sheetname, int rowIndex, int colIndex, String data) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resource/vtiger.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Cell cell = workbook.getSheet(sheetname).getRow(rowIndex).createCell(colIndex,CellType.STRING);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./src/test/resource/TestData/HealthEase.xlsx");
		workbook.write(fos);
		workbook.close();
	}
	
	//Get LastRow Number in the Excel
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resource/HealthEase.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetname).getLastRowNum();
	}
}
