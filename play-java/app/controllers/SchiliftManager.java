package controllers;

import java.util.List;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import models.Schilift;

public class SchiliftManager {
	private SchiliftManager() {
	}

	private static class SingletonHelper {
		private static final SchiliftManager INSTANCE = new SchiliftManager();
	}

	public static SchiliftManager getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public List<Schilift> getSchilifte() {
		List<Schilift> schilifte = new ArrayList<Schilift>();
		ExcelManager excelManager = ExcelManager.getInstance();
		HSSFWorkbook workbook = excelManager.getWorkbook("Aufstiegshilfen_fix.xls"); // TODO: auslagern in .properties file
		HSSFSheet sheet = excelManager.getSheet(workbook);
		List<Row> rows = excelManager.getRows(sheet);
		for(Row row : rows) {
			schilifte.add(new Schilift(row));
		}
		return schilifte;
	}
	
	public static void main(String[] args) {
		SchiliftManager schiliftManager = SchiliftManager.getInstance();
		for(Schilift schilift : schiliftManager.getSchilifte()) {
			System.out.println(schilift);
		}
	}
}
