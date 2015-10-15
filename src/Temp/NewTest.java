package Temp;

import org.testng.annotations.Test;
import spi.framework.TestCaseBase;
import spi.pom.Samples_Page;


public class NewTest extends TestCaseBase{
  @Test
  public void run() {
	  
	  Samples_Page samples = new Samples_Page();
	  samples.getSamplesPage();
	  //samples.setQuery("det.authentium.scan_result.full:\"sss\"");
	  //samples.setQuery("source.source_id:\"S9223370614536616013\"");
	  //samples.setQuery("source.job_id:\"S9223370614536616013-J9223370612049005264\"");
	  //samples.setQuery("source.sample_name:\"PhotoScape_kllm;m;m;m;V3.7.exe\"");
	  //samples.setQuery("source.sample_name:\"4db76384a3ec4171e208fe455bec1994\""); //prod 1 entry
	  //samples.setQuery("source.sample_name:\"grass1.atlas\"");// prod 4entries
	  //samples.setQuery(""); //prod total
	  samples.clickSearchbtn();
	  //samples.testresults(); 
	  samples.getResult();
	  System.out.println("This is test : "+samples.getResult()); 
  }
}
