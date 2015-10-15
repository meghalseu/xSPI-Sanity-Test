package spi.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import org.openqa.selenium.support.ui.WebDriverWait;

import spi.framework.GlobalConfig;

public class Icons_Page {

	WebDriver driver = GlobalConfig.currentdriver;
	WebDriverWait wait = new WebDriverWait(driver, 15);
			
	public void getIconsPage() {
		WebElement iconlink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Icons")));
		iconlink.click();
		
	}
	
}
