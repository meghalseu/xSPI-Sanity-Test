package spi.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class GlobalConfig {

	public static WebDriver currentdriver = null;
	
	
	public static final String SPI_QA_URL = "http://had-gateway-qatest.ssdcorp.net/";
	public static final String SPI_PROD_URL = "http://spi.tts.local/";
	public static final String EXCEL_DATA_FILE = "C:\\Users\\meghal.patel\\Desktop\\selenium-learning\\xSPI-Sanity-Test\\test-data\\SanityData.xlsx";
	
	
		
	public static WebDriver TestWithBrowser(String browser) {
		
		if (browser.equalsIgnoreCase("ie")) 
			return new InternetExplorerDriver();
		if (browser.equalsIgnoreCase("chrome")) 
			return new ChromeDriver();
			else return new FirefoxDriver();
		}
	
}
