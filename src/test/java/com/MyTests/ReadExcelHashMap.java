package com.MyTests;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.utilities.ExcelUtility;

public class ReadExcelHashMap {

	@Test
	public void test1() {
		
		try {
			Map<String, String> testData = ExcelUtility.getMapData();
			for (Entry<String, String> map : testData.entrySet()) {
				System.out.println("Key = " + map.getKey()+", Value = " + map.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
