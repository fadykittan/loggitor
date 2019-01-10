package com.loggitor.v2.loggitor;

import java.io.IOException;
import java.util.Set;

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
import com.loggitor.v2.loggitor.entity.DefectRepo;
import com.loggitor.v2.loggitor.entity.ReadLog;

@SpringBootApplication
public class LoggitorApplication {

	private static final Logger logger = LoggerFactory.getLogger(LoggitorApplication.class);

	@Autowired 
	private AppRepo appRepo;
	@Autowired 
	private DefectRepo defectRepo;

	public static void main(String[] args) {
		SpringApplication.run(LoggitorApplication.class, args);

		logger.info("Hello sping boot");

	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

			/*
			 * PROCESS THE FILE 
			 */
			ReadLog log = new ReadLog(
					"C:\\Users\\Fady\\eclipse-workspace\\loggitor\\src\\main\\java\\com\\loggitor\\v2\\loggitor\\TestLog.log");

			try {
				log.processFile();
			} catch (IOException e) {
				System.out.println(e.getMessage() + " -> error occurred while processing the file");
			}

			
			/*
			 * ADD TO DB
			 */
			Set<Defect> defects = log.getDefects();
			Set<App> apps = log.getApps();
			
			if(defects.isEmpty())
				System.out.println("Defects set is empty!");
			
			if(apps.isEmpty())
				System.out.println("Apps set is empty!");
			
				
			defectRepo.saveAll(defects);
			appRepo.saveAll(apps);
			
			

		};
	}


}
