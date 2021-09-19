package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	private FileInputStream file; // Holding the file path
	private Workbook book;
	private Sheet sh;
	private Cell cell;
	private Row row;
	private CellStyle cellstyle;
	private Map<String, String> columns = new HashMap<>();
	private String ExcelPath;

	// Whenever we want ro read any data from excel
	public void setExcelFile(String excelpath, String sheetname) throws Exception {
		try {
			File f = new File(excelpath);
			book = WorkbookFactory.create(f);
			sh = book.getSheet(sheetname);
			this.ExcelPath = excelpath;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getCellData(int rownum, int colnum) {

		cell = sh.getRow(rownum).getCell(colnum);
		String cellData = null;
		switch (cell.getCellType()) {
		case STRING:
			cellData = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				cellData = String.valueOf(cell.getDateCellValue());
			} else {
				cellData = String.valueOf((long) cell.getNumericCellValue());
			}
			break;
		case BOOLEAN:
			cellData = Boolean.toString(cell.getBooleanCellValue());
			break;
		case BLANK:
			cellData = "";
			break;
		}
		return cellData;
	}
}
