package utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelWrite {
 static String excelpath="C:\\Users\\MeesalaVineelSai\\eclipse-workspace\\Vineel\\src\\test\\resources\\data.xlsx";
 public XSSFWorkbook wb;

 private static XSSFWorkbook workbook;

 private static XSSFSheet sheet;

 private static XSSFRow row;

 private static XSSFCell cell;
 public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException {

	//creating a new cell in row and setting value to it

	sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);

	FileOutputStream outputStream = new FileOutputStream(excelFilePath);

	workbook.write(outputStream);

	}
}
