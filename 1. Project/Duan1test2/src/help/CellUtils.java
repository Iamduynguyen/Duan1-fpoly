package help;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class CellUtils {
	public static String getCellStringValue(Cell cell) {
		if (null != cell) {
			switch (cell.getCellTypeEnum()) {
			case BLANK:
				return "";
			case ERROR:
				return "";
			case FORMULA:
				return "";
			case NUMERIC:
			    if (cell.getCellStyle().getDataFormatString().contains("%")) {
			        // Detect Percent Values 
			        Double value = cell.getNumericCellValue() * 100;
			        return value.toString() +"%";
			    } else {
					Double d = cell.getNumericCellValue();
					Long l = d.longValue();
					if (l.doubleValue() == d) {
						return l.toString();
					} else {
						return d.toString();
					}
			    }
			default:
				return cell.getStringCellValue();
			}
		}
		return "";
	}

	/** Count max number of nonempty cells in sheet rows */
	public static int getColumnsCount(Sheet sheet) {
		int result = 0;
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			List<Cell> cells = new ArrayList<>();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				cells.add(cellIterator.next());
			}
			for (int i = cells.size(); i >= 1; i--) {
				Cell cell = cells.get(i - 1);
				if (cell.toString().trim().isEmpty()) {
					cells.remove(i - 1);
				} else {
					result = cells.size() > result ? cells.size() : result;
					break;
				}
			}
		}
		return result;
	}
}
