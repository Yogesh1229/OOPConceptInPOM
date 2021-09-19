package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Map<String, String> getMapData() throws IOException {

		Map<String, String> testData = new HashMap<String, String>();

		try {
			FileInputStream stream = new FileInputStream("./files/MapDemoData.xlsx");
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheetAt(0);

			// Once we get the sheet, we would need to verify the number of rows
			int lastRowNumber = sheet.getLastRowNum(); // How many rows are in sheet?

			for (int i = 0; i <= lastRowNumber; i++) {
				Row row = sheet.getRow(i);

				Cell keyCell = row.getCell(0);
				String keyValue = keyCell.getStringCellValue().trim();

				Cell colCell = row.getCell(1);
				String colValue = colCell.getStringCellValue().trim();

				testData.put(keyValue, colValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return testData;
	}

	public static List<Map<String, String>> getMapDataList() throws IOException {

		List<Map<String, String>> mapListOfTestData = null;
		Map<String, String> testData = null;

		try {
			FileInputStream stream = new FileInputStream("./files/MapDemoData.xlsx");
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheetAt(0);

			// Once we get the sheet, we would need to verify the number of rows
			int lastRowNumber = sheet.getLastRowNum(); // How many rows are in sheet?

			// Will return total number of columns
			int lastColNum = sheet.getRow(0).getLastCellNum();

			// Read excel file headers and add to list collection
			List list = new ArrayList();

			// Now read header
			for (int i = 0; i < lastColNum; i++) {
				Row row = sheet.getRow(0);
				Cell cell = row.getCell(i);
				String rowHeader = cell.getStringCellValue().trim();
				list.add(rowHeader);
			}

			// Iterate through all the rows and increase column count

			for (int i = 0; i <= lastRowNumber; i++) {
				Row row = sheet.getRow(i);

				Cell keyCell = row.getCell(0);
				String keyValue = keyCell.getStringCellValue().trim();

				Cell colCell = row.getCell(1);
				String colValue = colCell.getStringCellValue().trim();

				testData.put(keyValue, colValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return mapListOfTestData;

	}

}
