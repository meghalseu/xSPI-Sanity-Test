package spi.qa.testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import spi.framework.TestCaseBase;
import spi.logger.Log;
import spi.pom.MD5_List_Search_Tab;
import spi.pom.Samples_Page;


@Test
public class SanityTotalData_02 extends TestCaseBase {
	
	protected String md5list;

	public void run() {

		DOMConfigurator.configure("log4j.xml");

		Log.startTestCase("SanityTotalData_02 ");

		Samples_Page samplespage = new Samples_Page();

		samplespage.getSamplesPage();

		samplespage.setQuery("source.source_id:\"S9223370614536616013\"");

		Log.info("Query Entered : Total Samples by Sanity Source ID. ");

		samplespage.clickSearchbtn();
		
		samplespage.getResult();
		
		if(samplespage.getResult().equalsIgnoreCase("33"))
			Log.info("TEST PASS");
		else
			Log.warn("TEST FAIL");
		
		Log.info("Actual: " + samplespage.getResult() +", Expected : 33" );

		Assert.assertEquals(samplespage.getResult(), "33");
		
		samplespage.getMD5ListSearchTab();
		
		MD5_List_Search_Tab md5list = new MD5_List_Search_Tab();
			
		md5list.setList("Sheet1", 25, 4);
		
		Log.info("Entered list of MD5");
		
		md5list.setMD5SearchBtn();
		
		md5list.getResult();
		
		if(md5list.getResult().equalsIgnoreCase("33"))
			Log.info("TEST PASS");
		else
			Log.warn("TEST FAIL");
		
		Assert.assertEquals(md5list.getResult(), "33");
				
		Log.endTestCase("SanityTotalData_02 ");

	}
}
