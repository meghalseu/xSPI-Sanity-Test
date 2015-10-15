package spi.utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataReader {
	
	public static String getExcelData(String filePath, String sheetName, int rowNumber, int colNumber) throws IOException
	{
		
				
		XSSFWorkbook workbook = new XSSFWorkbook(filePath);
		System.out.println("SheetCount : " + workbook.getNumberOfSheets());
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		String retValue = sheet.getRow(rowNumber).getCell(colNumber).getStringCellValue();
		System.out.println(retValue);
		
		workbook.close();
		return retValue;
		
	}

}
