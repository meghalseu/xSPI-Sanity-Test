package spi.framework;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import spi.logger.Log;
import spi.utility.Wrapper;

public class TestCaseBase {

	

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {

		// Setup. Launch browser
		DOMConfigurator.configure("log4j.xml");

		GlobalConfig.currentdriver = GlobalConfig
				.TestWithBrowser("chrome");

		WebDriver driver = GlobalConfig.currentdriver;

		driver.manage().window().maximize();
		
		Log.info("Inside Test Setup");

		//driver.get(GlobalConfig.SPI_QA_URL); //Test against QA Environment
		driver.get(GlobalConfig.SPI_PROD_URL); //Uncomment this if you want to run test against PROD

		Log.info("Current URL : " + Wrapper.getURL());
		Log.info("");

	}

	@AfterMethod
	public void afterMethod() {

		// Cleanup. Quit Browser
		//GlobalConfiguration.currentdriver.quit();
		Log.info("Inside Test Cleanup");
		Log.info(".");
		Log.info(".");
		Log.info(".");
	}

}
