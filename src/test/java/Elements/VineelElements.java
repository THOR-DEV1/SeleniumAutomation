package Elements;

import java.io.FileOutputStream;

import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import BrowserSetup.BrowserDriver;
import utilities.excelWrite;
import utilities.testing2_0;

public class VineelElements {
	WebDriver driver=BrowserDriver.getCurrentDriver();
	excelWrite write;
	testing2_0 excel;
	@FindBy(xpath="//*[@id=\"InvestingPlanning\"]/div[3]/ul/li/div[3]/span[1]/span") WebElement btnyes;
	@FindBy(xpath="//*[@id=\"wzrk_wrapper\"]/div[2]") WebElement Alert;
	@FindBy(xpath="//*[@id=\"wzrk-cancel\"]") WebElement Cancel;
	@FindBy(xpath="//*[@id=\"salary\"]") WebElement Amount;
	@FindBy(xpath="//*[@id=\"year\"]") WebElement year;
	@FindBy(xpath="//*[@id=\"graduity_calc_btn\"]") WebElement Submitbtn;
	@FindBy(xpath="//*[@id=\"graduity_amt\"]") WebElement CalAmount;
	public VineelElements ClickOnYes() {
		btnyes.click();
		return this;
		
	}
	public VineelElements Alerts() {
		boolean s=Alert.isDisplayed();
		if(s==true) {
			Cancel.click();
		}else {
			System.out.println("no popup");
		}
		return this;
		
	}
	public VineelElements Amountenter() {
		Amount.sendKeys("20000");
		return this;
		
	}
	public VineelElements Yearsenter() {
		year.sendKeys("12");
		return this;
		
	}
	public VineelElements Subbtn() {
		Submitbtn.click();
		
		return this;
		
	}
	public VineelElements validate() {
		String s1=CalAmount.getText();
		float i=Float.parseFloat(s1.replace(",", ""));
		float Execpted=Math.round(i);
		float d= (float) ((0.5769230769230769)*20000*12);
		float Actual= Math.round(d);
		if(Execpted==Actual) {
			System.out.println("Actual Amount==Execpted Amount");
		}else {
			System.out.println("Actual!=Execpted");
		}
		return this;
		
	}
	public VineelElements excelwrite() {
		
		String s=CalAmount.getText();
		String a=Amount.getAttribute("value");
		String b=year.getAttribute("value");
		
		System.out.println(a);
		 try (OutputStream os = new FileOutputStream("src\\test\\resources\\Javatpoint.xls")) {  
		        Workbook wb = new HSSFWorkbook();  
		        Sheet sheet = wb.createSheet("Sheet"); 
		        System.out.println("File Created");
		       
		        Row row = sheet.createRow(1);  
		        row.createCell(0).setCellValue(" "+new Date());    
		        row.createCell(1).setCellValue(a);
		        row.createCell(2).setCellValue(b);
		        row.createCell(3).setCellValue(s); 
		        row.createCell(4).setCellValue(true);
		        
		        System.out.println("Data Entered");
		        wb.write(os);  
		        }catch(Exception e) {  
		            System.out.println(e.getMessage());  
		        }
		 		return this;
		
	}
	public VineelElements Close() {
		driver.close();
		return this;
	}
	
}
