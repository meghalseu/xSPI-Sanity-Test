package spi.qa.testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import spi.framework.TestCaseBase;
import spi.logger.Log;
import spi.pom.Home_Page;
import spi.pom.Icons_Page;
import spi.pom.Iris_Page;
import spi.pom.Samples_Page;
import spi.utility.Wrapper;

public class VerifyMenuLinks_01 extends TestCaseBase{
 

@Test
  public void run01(){
	  
	 DOMConfigurator.configure("log4j.xml");
	  
	  Log.startTestCase("VerifyMenuLinks_01");
	  
	  Samples_Page SamplesPage = new Samples_Page();
	  
	  SamplesPage.getSamplesPage();
	  
	  Log.info("Page Title : " + Wrapper.getTitle("Samples - SPI"));
	  Log.info("Page url : " + Wrapper.getURL());
	  
	  Wrapper.refresh();
	  	  
	  Icons_Page IconsPage = new Icons_Page();
	  
	  IconsPage.getIconsPage();
	  
	 	    
	  Log.info("Page Title : " + Wrapper.getTitle("Icons - SPI"));
	  Log.info("Page url : " + Wrapper.getURL());
	  
	 Wrapper.refresh();
	  
	  Iris_Page IrisPage = new Iris_Page();
	  
	  IrisPage.getIrisPage();
	  
	  Log.info("Page Title : " + Wrapper.getTitle("Sources - SPI"));
	  Log.info("Page url : " + Wrapper.getURL());
	  
	  Wrapper.refresh();
	  
	  Home_Page homepage = new Home_Page();
	  
	  homepage.getHomePage();
	  
	  	  
	  Log.info("Page Title : " + Wrapper.getTitle("SPI"));
	  Log.info("Page url : " + Wrapper.getURL());
	  	  
	  Log.endTestCase("VerifyMenuLinks_01");
	  
  }
}
