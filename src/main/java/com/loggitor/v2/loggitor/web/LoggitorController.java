package com.loggitor.v2.loggitor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loggitor.v2.loggitor.entity.App;
import com.loggitor.v2.loggitor.entity.AppRepo;
import com.loggitor.v2.loggitor.entity.Defect;
import com.loggitor.v2.loggitor.entity.DefectRepo;

@RestController
public class LoggitorController {

	@Autowired
	private AppRepo appRepo;
	@Autowired
	private DefectRepo defRepo; 
	
	
	@RequestMapping("/apps")
	public Iterable<App> getApps(){
		return appRepo.findAll();
	}
	
	@RequestMapping("/defs")
	public Iterable<Defect> getDefs(){
		return defRepo.findAll();
	}
	
	
}
