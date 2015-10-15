package spi.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import spi.framework.GlobalConfig;

public class Samples_Page {

	WebDriver driver = GlobalConfig.currentdriver;
	WebDriverWait wait = new WebDriverWait(driver, 35);

	// -------------- getSamplesPage = Threat Name Search Tab
	// -----------------------------------------------------

	public void getSamplesPage() {
		WebElement sampleslink = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.linkText("Samples")));
		sampleslink.click();
	}

	public void setQuery(String query) {

		WebElement querybox = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("search_query")));
		querybox.sendKeys(query);
	}

	public void clickSearchbtn() {

		WebElement searchbtn = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.name("commit")));
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
							.xpath(".//*[@id='search-threat-names']/form"))).getText();
		
		
		
		if (form.contains(noentries))
			return noentries;
		
		else 
			result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
				  ("html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[8]/div[1]/div[1]"))).getText();
		
					

		if (result.contains("all"))
			Actual =  wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath("html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[8]/div[1]/div[1]/b")))
					.getText().substring(4);

		else if (result.contains("total"))
			Actual = wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath("html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[8]/div[1]/div[1]/b[2]")))
					.getText();

		else
			Actual = wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath("html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[8]/div[1]/div[1]/b")))
					.getText();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
	}
		return Actual;
	}

	

	// ---------------- Hash Search Tab
	// -------------------------------------------------------------------

	public void getHashSearchTab() {

		WebElement hashsearch = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.linkText("Hash Search")));
		hashsearch.click();
	}

	// ------------------ MD5 List Search Tab
	// -----------------------------------------------------------------

	public void getMD5ListSearchTab() {

		WebElement md5list = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.linkText("MD5 List Search")));
		md5list.click();
	}

	// ------------------------- Reports Tab
	// -----------------------------------------------------------

	public void getReportsTab() {

		WebElement reports = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.linkText("Reports")));
		reports.click();
	}
	
	//__________________________________________________________________________________________//
	//Test Functions
	
	
	
	/*public String (get)Result() {

		String noentries = "No entries found";

		WebElement form = wait.until(ExpectedConditions
				.presenceOfElementLocated(By
						.xpath("html/body/div[2]/div[2]/div/div[2]/div[1]/form")));

		if (form.getText().contains("No entries found"))
			return noentries;

		else if (form.getText().contains("all"))
			return wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath("html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[8]/div[1]/div[1]/b")))
					.getText().substring(4);

		else if (form.getText().contains("total"))
			return wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath("html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[8]/div[1]/div[1]/b[2]")))
					.getText();

		else
			return wait
					.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath("html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[8]/div[1]/div[1]/b")))
					.getText();

	}*/

	
}