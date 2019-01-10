package com.loggitor.v2.loggitor.entity;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Defect {

	private static String critical = "Critical";
	private static String warning = "Warning";
	private static String error = "Error";
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String severity;
	private int code;


	@ManyToMany(mappedBy = "defects") 
    private Set<App> apps = new HashSet<App>();
	
	
	
	public Defect() {
		// empty constructor
	}

	
	
	// constructor
	public Defect(int code) {
		super();
		this.code = code;

		// calculate severity
		int sev = code % 10;

		switch (sev) {
		// critical
		case 1:
			severity = new String(critical);
			break;
		case 2:
			severity = new String(critical);
			break;
		case 3:
			severity = new String(critical);
			break;
		// error
		case 4:
			severity = new String(error);
			break;
		case 5:
			severity = new String(error);
			break;
		case 6:
			severity = new String(error);
			break;
		// warning
		default:
			severity = new String(warning);
			break;
		}
	}

	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
	public void addApp(String app, String type)
	{
		apps.add(new App(app, type));
	}

	
	
	
	

	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		
		if (!Defect.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
		
		Defect other = (Defect) obj;
		
		if(this.code == other.getCode())
			return true;
		else
			return false;
	}
	
	
}
