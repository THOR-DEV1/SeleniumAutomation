package utilities;  
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;  
public class testing2_0 {  
    public testing2_0 read(String x) {  
        try (OutputStream os = new FileOutputStream("Javatpoint.xls")) {  
        Workbook wb = new HSSFWorkbook();  
        Sheet sheet = wb.createSheet("Sheet"); 
        System.out.println("File Created");
        Row row = sheet.createRow(2);
        row.createCell(0).setCellValue(x); // Float value  
        System.out.println("Data Entered");
        wb.write(os);  
        }catch(Exception e) {  
            System.out.println(e.getMessage());  
        }
		return this;  
    }  
} 