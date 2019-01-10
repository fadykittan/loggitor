package com.loggitor.v2.loggitor.entity;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddToDB {

	@Autowired
	private AppRepo appRepo;
	@Autowired
	private DefectRepo defectRepo;
	
	private Set<Defect> defects = null;
	private Set<App> apps = null;
	
	
	public AddToDB(Set<Defect> defects, Set<App> apps) {
		super();
		this.defects = defects;
		this.apps = apps;
	}
	
	
	
	
	public void addDefects()
	{
		Iterator <Defect> ite = this.defects.iterator(); 
		
		
		while(ite.hasNext())
		{
			defectRepo.save(ite.next());
		}
		
	}
	
	
	
	public void addApps()
	{
		Iterator <App> ite = this.apps.iterator();
		
		while(ite.hasNext())
		{
			appRepo.save(ite.next());
		}
	}
	
	
	
}
