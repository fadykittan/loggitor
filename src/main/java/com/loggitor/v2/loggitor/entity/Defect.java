package com.loggitor.v2.loggitor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
