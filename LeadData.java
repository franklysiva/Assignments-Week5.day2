package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeadData {

	public static String[][] getLeadDatas(String filename) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./data/"+filename+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(1).getLastCellNum();
		String[][] data = new String[rowCount][columnCount];
		for (int i = 1; i<=rowCount; i++) {
			for (int j = 0; j<columnCount; j++) {
				String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue; 
				}
			}
		book.close();
		return data;
		}
}
