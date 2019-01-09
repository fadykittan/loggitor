package com.loggitor.v2.loggitor;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.loggitor.v2.loggitor.entity.App;
import com.loggitor.v2.loggitor.entity.AppRepo;
import com.loggitor.v2.loggitor.entity.Defect;
import com.loggitor.v2.loggitor.entity.DefectByApp;
import com.loggitor.v2.loggitor.entity.DefectRepo;
import com.loggitor.v2.loggitor.entity.ReadLog;
import com.loggitor.v2.loggitor.entity.WriteReport;





@SpringBootApplication
public class LoggitorApplication {

	
	private static final Logger logger = LoggerFactory.getLogger(LoggitorApplication.class);
	
	@Autowired
	private AppRepo arepo;
	
	@Autowired
	private DefectRepo drepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LoggitorApplication.class, args);
		
		logger.info("Hello sping boot");
		
		//run();
		
		
	}
	
	
	@Bean
    CommandLineRunner runner(){
      return args -> {
    	  
    	  Defect d6 = new Defect(6);
    	  Defect d4 = new Defect(4);
    	  Defect d36 = new Defect(36);
    	  
    	  drepo.save(d6);
    	  drepo.save(d4);
    	  drepo.save(d36);
    	  
    	     	  
    	  /*
    	  App blm6 = new App("BLM", "c", d6);
    	  App blm4 = new App("BLM", "c", d4);
    	  App clm6 = new App("CLM", "c", d6);
    	  App clm4 = new App("CLM", "c", d4);
    	  App klm = new App("KLM", "c", d36);*/
    	  
    	  
    	  App blm = new App("BLM", "c", d6);
    	  blm.addDefect(d4);
    	  App clm = new App("CLM", "c", d6);
    	  clm.addDefect(d4);
    	  App klm = new App("KLM", "c", d36);
    	  
    	  
    	  
    	  arepo.save(blm);
    	  arepo.save(clm);
    	  arepo.save(klm);
    	  
    	 
      };
    } 
	
	
	
	
	private static void run()
	{
		/*
		 * code for testing
		 */
		
		
		/*int count = args.length;
		if(count != 2)
		{
			System.out.println("You must enter one input file name and one output file name.");
			System.exit(1);
		}*/
		
		
		//ReadLog log = new ReadLog(args[0]);
		/*ReadLog log = new ReadLog("C:\\Users\\Fady\\eclipse-workspace\\loggitor\\src\\main\\java\\com\\loggitor\\v2\\loggitor\\TestLog.log");
		
		
		try {
			log.processFile();
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage() + " -> error occurred while processing the file");
		}
		
		Map<String, DefectByApp> defects = log.getDefects();
		
		//WriteReport writer = new WriteReport(args[1],defects);
		WriteReport writer = new WriteReport(
				"C:\\Users\\Fady\\eclipse-workspace\\loggitor\\src\\main\\java\\com\\loggitor\\v2\\loggitor\\log.txt"
				,defects);
		
		if(writer.isEmpty())
		{
			System.out.println("There is no defect to print.");
			System.exit(1);
		}
		
		
		try {
			writer.printLog();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage() + " -> error occurred while printing to the file");
		}
		
		/*
		 * end code of testing
		 */
	}
	
	

}

