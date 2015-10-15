package spi.logger;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class Log4j {
	
	
	public static void tcInfoLog(String message) throws IOException{
		
	BasicConfigurator.configure();
	Logger log = LogManager.getLogger("TestCaseLogger");
	
	log.addAppender(new FileAppender(new HTMLLayout(),"C:\\Users\\meghal.patel\\Desktop\\SPI_Sanity_LogFile.html"));
	
	log.info(message);
				
	 }
	
	public static void fwLogger(String message) throws IOException {
		
	
	 Logger log = LogManager.getLogger("FrameworkLogger");
	 
	 log.addAppender(new FileAppender(new HTMLLayout(),"C:\\Users\\meghal.patel\\Desktop\\SPI_Sanity_LogFile.html"));
	
	 log.info(message);
	 
	 
	}
	

}
