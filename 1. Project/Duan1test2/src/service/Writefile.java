package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import model.Lop;
import model.Sinhvien;

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

public class Writefile {

    public static void writeBS(List<String> ngathi, List<Sinhvien> lstsv, Lop lop, List<Integer> cathi) {
        try {
//			Blank workbook
            XSSFWorkbook workbook = new XSSFWorkbook();
            for (int x = 0; x < ngathi.size(); x++) {

//			Create a blank sheet
                XSSFSheet sheet = workbook.createSheet(ngathi.get(x));
                /*			On an Excel spreadsheet, you can set a column width of 0 to 255, 
			with one unit equal to the width of one character that can be displayed in a cell formatted with the standard font. 
			public void setColumnWidth(int columnIndex, int width)
			Set the width (in units of 1/256th of a character width)
			The maximum column width for an individual cell is 255 characters. */
                sheet.setColumnWidth(0, 4 * 256);		//3.67
                sheet.setColumnWidth(1, 14 * 256); 	//13.67
                sheet.setColumnWidth(2, 24 * 256); 	//24
                sheet.setColumnWidth(3, 13 * 256);	//13.33
                sheet.setColumnWidth(4, 11 * 256);	//11.33
                sheet.setColumnWidth(5, 7 * 256);		//6.67
                sheet.setColumnWidth(6, 9 * 256);		//9

//			Test info dump
                Row tieude1 = sheet.createRow(0);
                Row tieude2 = sheet.createRow(1);

//			Style 2 dĂ²ng Ä‘áº§u
                CellStyle tieudeStyle = workbook.createCellStyle();

                XSSFFont tdfont = ((XSSFWorkbook) workbook).createFont();
                tdfont.setFontName("Times New Roman");
                tdfont.setFontHeightInPoints((short) 12);
                tdfont.setBold(true);
                tieudeStyle.setFont(tdfont);
                tieudeStyle.setAlignment(HorizontalAlignment.CENTER);

//			Style 2 dĂ²ng tiáº¿p
                CellStyle detailStyle = workbook.createCellStyle();

                XSSFFont dtfont = ((XSSFWorkbook) workbook).createFont();
                dtfont.setFontName("Times New Roman");
                dtfont.setFontHeightInPoints((short) 11);
                dtfont.setBold(true);
                detailStyle.setFont(dtfont);
                detailStyle.setAlignment(HorizontalAlignment.CENTER);

//			Style dĂ²ng tiáº¿p
                CellStyle detailStyleLeftAlign = workbook.createCellStyle();

                XSSFFont dtfont2 = ((XSSFWorkbook) workbook).createFont();
                dtfont2.setFontName("Times New Roman");
                dtfont2.setFontHeightInPoints((short) 11);
                dtfont2.setBold(true);
                detailStyleLeftAlign.setFont(dtfont);

                CellStyle detailStyleRightAlign = workbook.createCellStyle();

                detailStyleRightAlign.setFont(dtfont);
                detailStyleRightAlign.setAlignment(HorizontalAlignment.RIGHT);

//			Táº¡o tiĂªu Ä‘á»�
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
                String stringBlock = lop.getKihoc() + lop.getThoigian();
                cell.setCellValue(stringBlock);
//			Merge cell 
                firstRow = 1;
                lastRow = firstRow;
                firstCol = 2;
                lastCol = 6;
                sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //C2:G2

//			Táº¡o cĂ¡c dĂ²ng thĂ´ng tin thi
                Row detail1 = sheet.createRow(2);
                Row detail2 = sheet.createRow(3);
                Row detail3 = sheet.createRow(4);

                cell = detail1.createCell(0);
                cell.setCellStyle(detailStyle);
                String stringCourse = "Môn thi: " + lop.getMamon();
                cell.setCellValue(stringCourse);
//			Merge cell 
                firstRow = 2;
                lastRow = firstRow;
                firstCol = 0;
                lastCol = 6;
                sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //A3:G3

                cell = detail2.createCell(0);
                cell.setCellStyle(detailStyle);
                String stringRoom = "Phòng thi: " + lop.getCheck();
                cell.setCellValue(stringRoom);
//			Merge cell 
                firstRow = 3;
                lastRow = firstRow;
                firstCol = 0;
                lastCol = 6;
                sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //A4:G4

                cell = detail3.createCell(0);
                cell.setCellStyle(detailStyleLeftAlign);
                String examDate = ngathi.get(x);
                cell.setCellValue(examDate);

                cell = detail3.createCell(3);
                cell.setCellStyle(detailStyleRightAlign);
                String examTime = "Giá»� thi: " + "16:20:00 Ä‘áº¿n: 18:20:00";
                cell.setCellValue(examTime);

                cell = detail3.createCell(5);
                cell.setCellStyle(detailStyleLeftAlign);
                String examType = "Láº§n thi: " + "Báº£o vá»‡";
                cell.setCellValue(examType);

//			Add FPT Logo
//			Merge cell 
                sheet.addMergedRegion(CellRangeAddress.valueOf("A1:B2"));
//			Read the input image into InputStream
                File logoFile = new File("..\\Duan1test\\img\\logo.jpg");
//			System.out.println("Vá»‹ trĂ­ file logo: " + logoFile.getCanonicalPath());
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

//			Dá»¯ liá»‡u phĂ­a dÆ°á»›i danh sĂ¡ch
                Row footer1 = sheet.createRow(lstsv.size() + 7);	//thay báº±ng i = dĂ²ng cuá»‘i danh sĂ¡ch sv + 2
                Row footer2 = sheet.createRow(lstsv.size() + 8);
                Row footer3 = sheet.createRow(lstsv.size() + 14);

//			Style máº·c Ä‘á»‹nh
                CellStyle defaultStyle = workbook.createCellStyle();

                XSSFFont defaultfont = ((XSSFWorkbook) workbook).createFont();
                defaultfont.setFontName("Times New Roman");
                defaultfont.setFontHeightInPoints((short) 12);
                defaultStyle.setFont(defaultfont);

//			Style máº·c Ä‘á»‹nh cÄƒn giá»¯a
                CellStyle defaultStyleCenterAlign = workbook.createCellStyle();

                defaultStyleCenterAlign.setFont(defaultfont);
                defaultStyleCenterAlign.setAlignment(HorizontalAlignment.CENTER);

//			Style header báº£ng 
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

//			Style báº£ng
                CellStyle tableStyle = workbook.createCellStyle();
                tableStyle.setFont(defaultfont);
                tableStyle.setBorderBottom(BorderStyle.THIN);
                tableStyle.setBorderLeft(BorderStyle.THIN);
                tableStyle.setBorderRight(BorderStyle.THIN);
                tableStyle.setBorderTop(BorderStyle.THIN);

//			Style báº£ng cÄƒn giá»¯a
                CellStyle tableStyleCenterAlign = workbook.createCellStyle();
                tableStyle.setFont(defaultfont);
                tableStyleCenterAlign.setBorderBottom(BorderStyle.THIN);
                tableStyleCenterAlign.setBorderLeft(BorderStyle.THIN);
                tableStyleCenterAlign.setBorderRight(BorderStyle.THIN);
                tableStyleCenterAlign.setBorderTop(BorderStyle.THIN);

                cell = footer1.createCell(1);
                cell.setCellStyle(defaultStyle);
                cell.setCellValue("Tá»•ng sá»‘ SV dá»± thi:");

                cell = footer1.createCell(3);
                cell.setCellStyle(defaultStyle);
                String stringSumStudent = lstsv.size() + "";	//thay báº±ng sá»‘ sv dá»± thi
                cell.setCellValue(stringSumStudent);

                cell = footer2.createCell(0);
                cell.setCellStyle(defaultStyleCenterAlign);
                cell.setCellValue("GiĂ¡m thá»‹ 1");
//			Merge cell 
                firstRow = lstsv.size() + 8;
                lastRow = firstRow;
                firstCol = 0;
                lastCol = 2;
                sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //A22:C22

                cell = footer2.createCell(3);
                cell.setCellStyle(defaultStyleCenterAlign);
                cell.setCellValue("GiĂ¡m thá»‹ 2");
//			Merge cell 
                firstRow = lstsv.size() + 8;
                lastRow = firstRow;
                firstCol = 3;
                lastCol = 6;
                sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //D22:G22

                cell = footer3.createCell(0);
                cell.setCellStyle(defaultStyleCenterAlign);
                String stringSupervisorName1 = "Ä�áº·ng Quang Minh";
                cell.setCellValue(stringSupervisorName1);
//			Merge cell 
                firstRow = lstsv.size() + 14;
                lastRow = firstRow;
                firstCol = 0;
                lastCol = 2;
                sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //A22:C22

                cell = footer3.createCell(3);
                cell.setCellStyle(defaultStyleCenterAlign);
                String stringSupervisorName2 = "Tráº§n Thá»‹ Loan";
                cell.setCellValue(stringSupervisorName2);
//			Merge cell 
                firstRow = lstsv.size() + 14;
                lastRow = firstRow;
                firstCol = 3;
                lastCol = 6;
                sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol)); //D22:G22

//			Dá»¯ liá»‡u chĂ­nh
//			This data needs to be written (Object[])
                Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
                data.put(1, new Object[]{"TT", "MSSV", "Họ tên", "Lớp", "Ký tên", "Điểm", "Ghi chú"});
                for (int i = 1; i <= 13; i++) {
                for (Sinhvien sv : lstsv) {
                    data.put(i + 1, new Object[]{i, sv.getMasv(), sv.getTensv(), lop.getMalop(), cathi.get(x), "", ""});
                    i++;
                }
                }

//                // Iterate over data and write to sheet
                Set<Integer> keyset = data.keySet();
//                Map<String, Object[]> data = new TreeMap<String, Object[]>();
//                data.put("1", new Object[]{"TT", "MSSV", "Há»� tĂªn", "Lá»›p", "KĂ½ tĂªn", "Ä�iá»ƒm", "Ghi chĂº"});
//                int i = 1;
//                for (Sinhvien sv : lstsv) {
//                    data.put("" + i + 1, new Object[]{i, sv.getMasv(), sv.getTensv(), lop.getMalop(), cathi.get(x), "", ""});
//                    i++;
//                }
                // Iterate over data and write to sheet
//                Set<String> keyset = data.keySet();

                int rownum = 5;
                for (Integer key : keyset) {
                    // create a row of excelsheet
                    Row row = sheet.createRow(rownum);

                    // get object array of prerticuler key
                    Object[] objArr = data.get(key);

                    int cellnum = 0;

                    for (Object obj : objArr) {
                        cell = row.createCell(cellnum++);
                        if (rownum == 5) {
                            cell.setCellStyle(tableStyleBoldCenterAlign);
                        } else {
                            if (cellnum == 0) {
                                cell.setCellStyle(tableStyleCenterAlign);
                            } else {
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

    public static List<Sinhvien> fakelst() {
        List<Sinhvien> lst = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            Sinhvien sv = new Sinhvien();
            sv.setMasv("" + i);
            lst.add(sv);
        }
        return lst;
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        List<Sinhvien> lstsv = new ArrayList<>();
        Lop lop = new Lop();
        lop.setMalop("abc");
        lop.setMamon("bbbb");
        lop.setCheck(2);
        List<Integer> cathi = new ArrayList<>();
        cathi.add(1);
        cathi.add(2);
        cathi.add(3);
        writeBS(a, fakelst(), lop, cathi);
    }

}
