package com.prodezy.plantmaster;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ImportData {


		public ImportData() throws Exception {
		//
		// An excel file name. You can create a file name with a full
		// path information.
		//
		String fileName = "D:\\plant_master.xls";


		// Create an ArrayList to store the data read from excel sheet.
		//
		List sheetData = new ArrayList();

		FileInputStream fis = null;
		try {
		fis = new FileInputStream(fileName);

		//
		// Create an excel workbook from the file system.
		//
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		//
		// Get the first sheet on the workbook.
		//
		HSSFSheet sheet = workbook.getSheetAt(0);

		//
		// When we have a sheet object in hand we can iterator on
		// each sheet's rows and on each row's cells. We store the
		// data read on an ArrayList so that we can printed the
		// content of the excel to the console.
		//
		Iterator rows = sheet.rowIterator();
		while (rows.hasNext()) {
		HSSFRow row = (HSSFRow) rows.next();
		Iterator cells = row.cellIterator();

		List data = new ArrayList();
		while (cells.hasNext()) {
		HSSFCell cell = (HSSFCell) cells.next();
		data.add(cell);
		}
		sheetData.add(data);
		}
		} catch (IOException e) {
		e.printStackTrace();
		} finally {
		if (fis != null) {
		fis.close();
		}
		}

		showExelData(sheetData);
		}

		private static void showExelData(List sheetData) {
		//
		// Iterates the data and print it out to the console.
		//
		for (int i = 0; i < sheetData.size(); i++) {
		List list = (List) sheetData.get(i);
		//for (int j = 0; j < list.size(); j++) {
		HSSFCell employeeid = (HSSFCell) list.get(0);
		HSSFCell department = (HSSFCell) list.get(3);
		HSSFCell date = (HSSFCell) list.get(5);
		System.out.print(employeeid.getRichStringCellValue().getString()+" , ");
		System.out.print(department.getRichStringCellValue().getString()+" , ");
		System.out.print(date.getRichStringCellValue().getString());
		//if (j < list.size() - 1) {
		// System.out.print(", ");
		//}
		// }
		System.out.println("");
		}
		}
		}

