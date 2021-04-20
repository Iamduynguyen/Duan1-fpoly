package Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {
	public static void writeBS() {
		try {
//			Blank workbook
			XSSFWorkbook workbook = new XSSFWorkbook();
//			Create a blank sheet
			XSSFSheet sheet = workbook.createSheet("Thu, 04.03");
/*			On an Excel spreadsheet, you can set a column width of 0 to 255, 
			with one unit equal to the width of one character that can be displayed in a cell formatted with the standard font. 
			public void setColumnWidth(int columnIndex, int width)
			Set the width (in units of 1/256th of a character width)
			The maximum column width for an individual cell is 255 characters. */
			sheet.setColumnWidth(0, 4*256);		//3.67
			sheet.setColumnWidth(1, 14*256); 	//13.67
			sheet.setColumnWidth(2, 24*256); 	//24
			sheet.setColumnWidth(3, 13*256);	//13.33
			sheet.setColumnWidth(4, 11*256);	//11.33
			sheet.setColumnWidth(5, 7*256);		//6.67
			sheet.setColumnWidth(6, 9*256);		//9
			
//			Test info dump
			Row tieude1 = sheet.createRow(0);
			Row tieude2 = sheet.createRow(1);
			
//			Style 2 dòng đầu
			CellStyle tieudeStyle = workbook.createCellStyle();

			XSSFFont tdfont = ((XSSFWorkbook) workbook).createFont();
			tdfont.setFontName("Times New Roman");
			tdfont.setFontHeightInPoints((short) 12);
			tdfont.setBold(true);
			tieudeStyle.setFont(tdfont);
			tieudeStyle.setAlignment(HorizontalAlignment.CENTER);
			
//			Style 2 dòng tiếp
			CellStyle detailStyle = workbook.createCellStyle();

			XSSFFont dtfont = ((XSSFWorkbook) workbook).createFont();
			dtfont.setFontName("Times New Roman");
			dtfont.setFontHeightInPoints((short) 11);
			dtfont.setBold(true);
			detailStyle.setFont(dtfont);
			detailStyle.setAlignment(HorizontalAlignment.CENTER);
			
//			Style dòng tiếp
			CellStyle detailStyleLeftAlign = workbook.createCellStyle();

			XSSFFont dtfont2 = ((XSSFWorkbook) workbook).createFont();
			dtfont2.setFontName("Times New Roman");
			dtfont2.setFontHeightInPoints((short) 11);
			dtfont2.setBold(true);
			detailStyleLeftAlign.setFont(dtfont);
			
			CellStyle detailStyleRightAlign = workbook.createCellStyle();

			detailStyleRightAlign.setFont(dtfont);
			detailStyleRightAlign.setAlignment(HorizontalAlignment.RIGHT);
			
//			Tạo tiêu đề
			Cell cell = null;
			cell = tieude1.createCell(2); //C1
			cell.setCellStyle(tieudeStyle);
			cell.setCellValue("DANH SÁCH SINH VIÊN THI");
//			Merge cell 
			int firstRow = 0;
			int lastRow = firstRow;
			int firstCol = 2;
			int lastCol = 6;
			sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //C1:G1

			cell = tieude2.createCell(2);
			cell.setCellStyle(tieudeStyle);
			String stringBlock = "BLOCK 1 - KỲ SPRING 2021";
			cell.setCellValue(stringBlock);
//			Merge cell 
			firstRow = 1;
			lastRow = firstRow;
			firstCol = 2;
			lastCol = 6;
			sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //C2:G2
			
//			Tạo các dòng thông tin thi
			Row detail1 = sheet.createRow(2);
			Row detail2 = sheet.createRow(3);
			Row detail3 = sheet.createRow(4);
			
			cell = detail1.createCell(0);
			cell.setCellStyle(detailStyle);
			String stringCourse = "Môn thi: " + "Tin học (COM107)";
			cell.setCellValue(stringCourse);
//			Merge cell 
			firstRow = 2;
			lastRow = firstRow;
			firstCol = 0;
			lastCol = 6;
			sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //A3:G3
			
			cell = detail2.createCell(0);
			cell.setCellStyle(detailStyle);
			String stringRoom = "Phòng thi: " + "online";
			cell.setCellValue(stringRoom);
//			Merge cell 
			firstRow = 3;
			lastRow = firstRow;
			firstCol = 0;
			lastCol = 6;
			sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //A4:G4
			
			cell = detail3.createCell(0);
			cell.setCellStyle(detailStyleLeftAlign);
			String examDate = "Ngày thi: " + "04/03/2021";
			cell.setCellValue(examDate);

			cell = detail3.createCell(3);
			cell.setCellStyle(detailStyleRightAlign);
			String examTime = "Giờ thi: " + "16:20:00 đến: 18:20:00";
			cell.setCellValue(examTime);

			cell = detail3.createCell(5);
			cell.setCellStyle(detailStyleLeftAlign);
			String examType = "Lần thi: " + "Bảo vệ";
			cell.setCellValue(examType);
			
//			Add FPT Logo
//			Merge cell 
			sheet.addMergedRegion(CellRangeAddress.valueOf("A1:B2"));
//			Read the input image into InputStream
			File logoFile = new File("..\\Duan1test\\img\\logo.png");
//			System.out.println("Vị trí file logo: " + logoFile.getCanonicalPath());
			InputStream my_banner_image = new FileInputStream(logoFile);
//			Convert Image to byte array
			byte[] bytes = IOUtils.toByteArray(my_banner_image);
//			Add Picture to workbook and get a index for the picture
			int my_picture_id = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
//			Close Input Stream
			my_banner_image.close();
//			Create the drawing container
			XSSFDrawing drawing = sheet.createDrawingPatriarch();
//			Create an anchor point
			ClientAnchor my_anchor = new XSSFClientAnchor();
//			Define top left corner, and we can resize picture suitable from there
			my_anchor.setCol1(0);
			my_anchor.setRow1(0);
//			Invoke createPicture and pass the anchor point and ID
			XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
//			Call resize method, which resizes the image
			my_picture.resize();

//			Dữ liệu phía dưới danh sách
			Row footer1 = sheet.createRow(20);	//thay bằng i = dòng cuối danh sách sv + 2
			Row footer2 = sheet.createRow(21);
			Row footer3 = sheet.createRow(26);

//			Style mặc định
			CellStyle defaultStyle = workbook.createCellStyle();

			XSSFFont defaultfont = ((XSSFWorkbook) workbook).createFont();
			defaultfont.setFontName("Times New Roman");
			defaultfont.setFontHeightInPoints((short) 12);
			defaultStyle.setFont(defaultfont);
			
//			Style mặc định căn giữa
			CellStyle defaultStyleCenterAlign = workbook.createCellStyle();

			defaultStyleCenterAlign.setFont(defaultfont);
			defaultStyleCenterAlign.setAlignment(HorizontalAlignment.CENTER);
			
//			Style header bảng 
			CellStyle tableStyleBoldCenterAlign = workbook.createCellStyle();
			XSSFFont defaultfontbold = ((XSSFWorkbook) workbook).createFont();
			defaultfontbold.setFontName("Times New Roman");
			defaultfontbold.setFontHeightInPoints((short) 12);
			defaultfontbold.setBold(true);
			tableStyleBoldCenterAlign.setFont(defaultfontbold);
			tableStyleBoldCenterAlign.setAlignment(HorizontalAlignment.CENTER);			 
			tableStyleBoldCenterAlign.setBorderBottom(BorderStyle.THIN);
			tableStyleBoldCenterAlign.setBorderLeft(BorderStyle.THIN);
			tableStyleBoldCenterAlign.setBorderRight(BorderStyle.THIN);
			tableStyleBoldCenterAlign.setBorderTop(BorderStyle.THIN);
			
//			Style bảng
			CellStyle tableStyle = workbook.createCellStyle();
			tableStyle.setFont(defaultfont);		 
			tableStyle.setBorderBottom(BorderStyle.THIN);
			tableStyle.setBorderLeft(BorderStyle.THIN);
			tableStyle.setBorderRight(BorderStyle.THIN);
			tableStyle.setBorderTop(BorderStyle.THIN);
			
//			Style bảng căn giữa
			CellStyle tableStyleCenterAlign = workbook.createCellStyle();
			tableStyle.setFont(defaultfont);		 
			tableStyleCenterAlign.setBorderBottom(BorderStyle.THIN);
			tableStyleCenterAlign.setBorderLeft(BorderStyle.THIN);
			tableStyleCenterAlign.setBorderRight(BorderStyle.THIN);
			tableStyleCenterAlign.setBorderTop(BorderStyle.THIN);
			
			cell = footer1.createCell(1);
			cell.setCellStyle(defaultStyle);
			cell.setCellValue("Tổng số SV dự thi:");
			
			cell = footer1.createCell(3);
			cell.setCellStyle(defaultStyle);
			String stringSumStudent = "12";	//thay bằng số sv dự thi
			cell.setCellValue(stringSumStudent);

			cell = footer2.createCell(0);
			cell.setCellStyle(defaultStyleCenterAlign);
			cell.setCellValue("Giám thị 1");
//			Merge cell 
			firstRow = 22;
			lastRow = firstRow;
			firstCol = 0;
			lastCol = 2;
			sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //A22:C22
			
			cell = footer2.createCell(3);
			cell.setCellStyle(defaultStyleCenterAlign);
			cell.setCellValue("Giám thị 2");
//			Merge cell 
			firstRow = 22;
			lastRow = firstRow;
			firstCol = 3;
			lastCol = 6;
			sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //D22:G22

			cell = footer3.createCell(0);
			cell.setCellStyle(defaultStyleCenterAlign);
			String stringSupervisorName1 = "Đặng Quang Minh";
			cell.setCellValue(stringSupervisorName1);
//			Merge cell 
			firstRow = 27;
			lastRow = firstRow;
			firstCol = 0;
			lastCol = 2;
			sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //A22:C22
			
			cell = footer3.createCell(3);
			cell.setCellStyle(defaultStyleCenterAlign);
			String stringSupervisorName2 = "Trần Thị Loan";
			cell.setCellValue(stringSupervisorName2);
//			Merge cell 
			firstRow = 27;
			lastRow = firstRow;
			firstCol = 3;
			lastCol = 6;
			sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //D22:G22
			
//			Dữ liệu chính
//			This data needs to be written (Object[])
			Map<String, Object[]> data = new TreeMap<String, Object[]>();
			data.put("1", new Object[] { "TT", "MSSV", "Họ tên", "Lớp", "Ký tên", "Điểm", "Ghi chú" });
			data.put("2", new Object[] { 1, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("3", new Object[] { 2, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("4", new Object[] { 3, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("5", new Object[] { 4, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("6", new Object[] { 5, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("7", new Object[] { 6, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("8", new Object[] { 7, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("9", new Object[] { 8, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("10", new Object[] { 9, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("11", new Object[] { 10, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("12", new Object[] { 11, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("13", new Object[] { 12, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			data.put("14", new Object[] { 13, "PH08918", "Đỗ Minh Hiếu", "PB17131-MA", "", "", "" });
			
			// Iterate over data and write to sheet
			Set<String> keyset = data.keySet();

			int rownum = 5;
			for (String key : keyset) {
				// create a row of excelsheet
				Row row = sheet.createRow(rownum);
				
				// get object array of prerticuler key
				Object[] objArr = data.get(key);

				int cellnum = 0;

				for (Object obj : objArr) {
					cell = row.createCell(cellnum++);
					if(rownum == 5) {
						cell.setCellStyle(tableStyleBoldCenterAlign);
					}
					else {
						if (cellnum == 0) {
							cell.setCellStyle(tableStyleCenterAlign);
						}
						else {
							cell.setCellStyle(tableStyle);
						}						
					}
					if (obj instanceof String) {
						cell.setCellValue((String) obj);
					} else if (obj instanceof Integer) {
						cell.setCellValue((Integer) obj);
					}
				}
				rownum++;
			}

			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File("D:\\demo Excel.xlsx"));
			System.out.println("Successfully written on disk.");
			workbook.write(out);
			out.close();
			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		WriteToExcel.writeBS();
	}

}
