package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelManager {
	private ExcelManager() {
	}

	private static class SingletonHelper {
		private static final ExcelManager INSTANCE = new ExcelManager();
	}

	public static ExcelManager getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public HSSFWorkbook getWorkbook(String filename) {
		HSSFWorkbook workbook = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			 workbook = new HSSFWorkbook(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}
	
	public HSSFSheet getSheet(HSSFWorkbook workbook) {
		return workbook.getSheetAt(0);
	}
	
	public List<Row> getRows(HSSFSheet sheet) {
		List<Row> rows=new ArrayList<Row>();
		Iterator<Row> rowIterator=sheet.rowIterator();
		while(rowIterator.hasNext()) {
			rows.add(rowIterator.next());
		}
		return rows;
	}
	
	public List<Cell> getCells(Row row) {
		List<Cell> cells=new ArrayList<Cell>();
		Iterator<Cell> cellIterator=row.cellIterator();
		while(cellIterator.hasNext()) {
			cells.add(cellIterator.next());
		}
		return cells;
	}
}
