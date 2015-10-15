package spi.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import spi.framework.GlobalConfig;


public class Wrapper {
	
	
	protected static WebDriver driver = GlobalConfig.currentdriver;
		
	
	public static void refresh(){
	
		driver.navigate().refresh();
	}
	
	public static void implicitwait (int seconds){
		
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
				
	}
	
	public static String getURL(){
		return driver.getCurrentUrl();
	}
	

	public static String getTitle(String title){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}

	
}
