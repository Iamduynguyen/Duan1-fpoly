package com.upload;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONArray;

public class ReadExcelFile {

	
		public JSONArray readExcel(String file_path) {
			
			JSONArray array = new JSONArray();
			
			try {
				Workbook workbook = WorkbookFactory.create(new File(file_path));
				Sheet sheet =  workbook.getSheetAt(0); // nó đọc trang excel đầu tiên  
				
				
				DataFormatter dataFormatter = new DataFormatter();
				
				// gio doc file excel va goi no
				for(Row row : sheet) {
					
					JSONArray value = new JSONArray();
					for(Cell cell : row) {
						String cell_value =dataFormatter.formatCellValue(cell);
						value.add(cell_value);
						
						
					}
					
					array.add(value);
					
				}
				
				workbook.close();
				
			} catch (EncryptedDocumentException | IOException e) {
			
				e.printStackTrace();
			}
			
			
			
			return array;
			
		}
}
