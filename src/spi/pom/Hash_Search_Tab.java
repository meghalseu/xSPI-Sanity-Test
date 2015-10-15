package spi.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import org.openqa.selenium.support.ui.WebDriverWait;

import spi.framework.GlobalConfig;

public class Hash_Search_Tab {
	WebDriver driver = GlobalConfig.currentdriver;
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	public void getHashSearchTab(){
		WebElement sampleslink = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.linkText("Samples")));
		sampleslink.click();
		
		WebElement hashsearch = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.linkText("Hash Search")));
		hashsearch.click();
	}

	public void setMD5(String md5) {

		WebElement querybox = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("hashes__id")));
		querybox.sendKeys(md5);
	}
	
	public void setCRC6(String crc6) {

		WebElement querybox = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("hashes_meta.crc6")));
		querybox.sendKeys(crc6);
	}
	
	public void setCRC8(String crc8) {

		WebElement querybox = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("hashes_meta.crc8")));
		querybox.sendKeys(crc8);
	}
	
	public void setIcon8(String icon8) {

		WebElement querybox = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("hashes_meta.icon8")));
		querybox.sendKeys(icon8);
	}
	
	public void setSHA1(String sha1) {

		WebElement querybox = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("hashes_meta.sha1")));
		querybox.sendKeys(sha1);
	}
	
	public void setSHA256(String sha256) {

		WebElement querybox = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("hashes_meta.sha256")));
		querybox.sendKeys(sha256);
	}
	
	public void clicSearchBtn() {
	

		WebElement searchbtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
				("html/body/div[2]/div[2]/div/div[2]/div[2]/form/div[7]/div/input")));
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
							.xpath(".//*[@id='search-hashes']/form"))).getText();
				
		if (form.contains(noentries))
			return noentries;
		
		else 
			result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
				  ("html/body/div[2]/div[2]/div/div[2]/div[2]/form/div[8]/div[1]/div[1]"))).getText();
		                     
							

		if (result.contains("all"))
			Actual =  wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath("html/body/div[2]/div[2]/div/div[2]/div[2]/form/div[8]/div[1]/div[1]/b"))).getText().substring(4);
		                           
		else if (result.contains("total"))
			Actual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
					("html/body/div[2]/div[2]/div/div[2]/div[2]/form/div[8]/div[1]/div[1]/b[2]"))).getText();
		             
					  
		else //1entry
			Actual = wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath("html/body/div[2]/div[2]/div/div[2]/div[2]/form/div[8]/div[1]/div[1]/b"))).getText();
		}                           
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
	}
		return Actual;
	}
	
	

}
