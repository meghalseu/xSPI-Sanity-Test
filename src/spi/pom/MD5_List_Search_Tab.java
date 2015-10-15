package spi.pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import spi.framework.GlobalConfig;
import spi.utility.ExcelDataReader;


public class MD5_List_Search_Tab {
	
	WebDriver driver = GlobalConfig.currentdriver;
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	public void getMD5ListTab(){
		WebElement sampleslink = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.linkText("Samples")));
		sampleslink.click();
		
		WebElement md5list = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.linkText("MD5 List Search")));
		md5list.click();
	}
	
	
	public void setList(String Sheetname, int row, int col){
		String md5list = null;
		try {
			md5list = ExcelDataReader.getExcelData(GlobalConfig.EXCEL_DATA_FILE, Sheetname, row, col);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WebElement md5box = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ids")));
		md5box.sendKeys(md5list);
	}
	
	public void setMD5SearchBtn() {
		
		WebElement searchbtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
				("html/body/div[2]/div[2]/div/div[2]/div[3]/form/div[2]/div/input")));
		searchbtn.click();
	}
	
	public String getResult() {

		String noentries = "No entries found";
		String result = null;
		String form;
		String Actual = null;
		
		try{
			form = wait.until(ExpectedConditions
					.presenceOfElementLocated(By
							.xpath(".//*[@id='search-ids']/form"))).getText();
				
		if (form.contains(noentries))
			return noentries;
		
		else 
			result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
				  ("html/body/div[2]/div[2]/div/div[2]/div[3]/form/div[3]/div[1]/div[1]"))).getText();
		            
		
					

		if (result.contains("all"))
			Actual =  wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath("html/body/div[2]/div[2]/div/div[2]/div[3]/form/div[3]/div[1]/div[1]/b"))).getText().substring(4);

		else if (result.contains("total"))
			Actual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
					("html/body/div[2]/div[2]/div/div[2]/div[3]/form/div[3]/div[1]/div[1]/b[2]"))).getText();
		              
					  
		else //1entry
			Actual = wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath("html/body/div[2]/div[2]/div/div[2]/div[3]/form/div[3]/div[1]/div[1]/b"))).getText();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
	}
		return Actual;
	}

	
	
	
}
