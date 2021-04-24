package service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.CellType.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import help.ArrayToString;
import help.CellUtils;
import help.StringFormat;
import model.Course;
import model.Score;
import model.Student;

public class ReadExcel {
	private static Workbook wb;
//    private static String filepath = null;
	private static List<Score> lstscore = new ArrayList<>();
	private static List<Student> lstSV = new ArrayList<>();
	private static Course course = new Course();

	public static void getwb(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String[] getRow(Row row, int noOfColumns) {
		String rowValue[] = new String[noOfColumns];
		for (int i = 0; i < noOfColumns; i++) {
			String cellvalue = CellUtils.getCellStringValue(row.getCell(i));
			rowValue[i] = cellvalue;
		}
		return rowValue;
	}

	public static void getData(Workbook wb) {
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();

		boolean studentliststart = false;
		ArrayList<String[]> studentRow = new ArrayList<String[]>();

		int noOfColumns = CellUtils.getColumnsCount(sheet);

		String header[] = new String[noOfColumns];

		while (iterator.hasNext()) {
			String cellvalue = "";
			String rowValue[] = new String[noOfColumns];
			Row currentRow = iterator.next();
//			for (int i = 0; i < noOfColumns; i++) {
			rowValue = getRow(currentRow, noOfColumns);
			System.out.println("row values: " + ArrayToString.arrayToString(rowValue));
			if (rowValue[0].equalsIgnoreCase("STT")) {
				header = rowValue;
			}
			if (StringFormat.isInt(rowValue[0])) {
				studentRow.add(rowValue);
			}
//			}
		}

		for (String[] row : studentRow) {
			for (int i = 4; i < row.length; i++) { // cột 4 bắt đầu có điểm
				lstscore.add(new Score(header[i], Double.parseDouble(row[i])));
			}
			lstSV.add(new Student(row[1], row[2], lstscore));
		}

		System.out.println("==================");
		System.out.println("header row: " + ArrayToString.arrayToString(header));
		System.out.println("student row: " + studentRow.size());
		System.out.println("list sv size: " + lstSV.size());
		System.out.println("==================");

	}

	public static void getData2(Workbook wb) {
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		int headerIndex = 0;
		int studentListStartIndex = 0;
		int studentListEndIndex = 0;
		boolean studentliststart = false;

		int noOfColumns = CellUtils.getColumnsCount(sheet);
//		System.out.println("so cot: " + noOfColumns);

		String header[] = new String[noOfColumns];
		int i = 0;
		while (iterator.hasNext()) {
			String cellvalue = "";
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
//			System.out.println("row: " + i);
			String rowValueArray[] = new String[noOfColumns];
			while (cellIterator.hasNext()) {
				int j = 0;
				Cell currentCell = cellIterator.next();
				cellvalue = CellUtils.getCellStringValue(currentCell);
//				System.out.println("cell: " + currentCell.getColumnIndex());
//				System.out.println("cell value: " + cellvalue);
//				System.out.println("getlastcellnum: " + currentRow.getLastCellNum());				
				rowValueArray[j] = cellvalue;
				if (cellvalue.trim().equalsIgnoreCase("STT")) {
//					System.out.println("header row: " + i);
					headerIndex = i;
				} else if (currentCell.getColumnIndex() == 0 && currentCell.getCellTypeEnum() == CellType.NUMERIC
						&& !studentliststart) {
//					System.out.println("student row start: " + i);
					studentListStartIndex = i;
					studentliststart = true;
				} else if (currentCell.getColumnIndex() == 0 && currentCell.getCellTypeEnum() == CellType.NUMERIC
						&& studentliststart) {
//					System.out.println("student row end: " + i);
					studentListEndIndex = i;
				}
				j++;
			}
			if (i == headerIndex) {
				header = rowValueArray;
			} else if (i >= studentListStartIndex && i <= studentListEndIndex) {
				System.out.println("header.length: " + header.length);
				for (int x = 3; x < header.length; x++) {
					System.out.println("x: " + x);
					System.out.println("header x: " + header[x]);
//					lstscore.add(new Score(header[x], Double.parseDouble(rowValueArray[x])));
				}
//				lstSV.add(new Student(rowValueArray[1], rowValueArray[2], lstscore));
			}
			i++;
		}
		System.out.println("==================");
		System.out.println("header row index: " + headerIndex);
		System.out.println("student list start row index: " + studentListStartIndex);
		System.out.println("student list end row index: " + studentListEndIndex);
		System.out.println("header: " + header);
		System.out.println("list sv: " + lstSV);
		System.out.println("==================");
	}
}
