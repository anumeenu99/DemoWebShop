package com.demowebshop.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demowebshop.constants.Constants;

public class ExcelUtility {
	public static XSSFWorkbook wb;
    public static XSSFSheet sh;
    public static FileInputStream f;
	public static List<ArrayList<String>> excelDataReader(String sheetName){
	    DataFormatter formatter = new DataFormatter();
	    try {
	        f = new FileInputStream(System.getProperty("user.dir") + Constants.EXCEL_PATH);
	    } catch (FileNotFoundException e) {
	        throw new RuntimeException(e);
	    }
	    try {
	        wb = new XSSFWorkbook(f);
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	    sh = wb.getSheet(sheetName);
	    List<ArrayList<String>> excelRows = new ArrayList<>();
	    int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
	    for (int i = 0; i < rowCount + 1; i++) {
	        int x = 0;
	        Row row = sh.getRow(i);
	        String[] columnList = new String[row.getLastCellNum()];
	        for (int j = 0; j < columnList.length; j++) {
	            columnList[j] = formatter.formatCellValue(row.getCell(x));
	            x++;
	        }
	        excelRows.add(new ArrayList<>(Arrays.asList(columnList)));
	    }
	    return excelRows;
	}
	public  Object[][] dataProviderRead(String sheetName) {
	    DataFormatter formatter = new DataFormatter();
	    try {
	        f = new FileInputStream(System.getProperty("user.dir") + Constants.EXCEL_PATH);
	    } catch (FileNotFoundException e) {
	        throw new RuntimeException(e);
	    }
	    try {
	        wb = new XSSFWorkbook(f);
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	    sh = wb.getSheet(sheetName);

	    int rows =sh.getLastRowNum()+1;
	    int cols = sh.getRow(0).getLastCellNum();
	    Object[][]  data = new Object[rows][cols];

	    for (int i = 0; i < rows; i++) {
	        Row row = sh.getRow(i);
	        String[] columnList = new String[row.getLastCellNum()];
	        for (int j = 0; j < cols; j++) {
	            Cell cell =row.getCell(j);
	            data[i][j] = cell.getStringCellValue();
	        }
	    }
	    return data;
	}
}
