package com.loggitor.v2.loggitor.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ReadLog {

	private BufferedReader log = null;
	private Set<Defect> defects = new HashSet<Defect>();
	private Set<App> apps = new HashSet<App>();

	// keywords
	private static String errorKeyword = "Caused by";
	private static char lLimit = '(';
	private static char rLimit = ')';
	private static char dash = '-';
	private static char coreCode = '1';
	private static String core = "Core";
	private static String custom = "Custom";

	public ReadLog(String fileName) {
		super();
		try {
			FileReader fileReader = new FileReader(fileName);
			log = new BufferedReader(fileReader);

		} catch (Exception e) {
			System.out.println(e.getMessage() + " -> unable to open/read the file");
		}

	}

	
	public Set<Defect> getDefects() {
		return defects;
	}



	public Set<App> getApps() {
		return apps;
	}



	public void processFile() throws IOException {
		String line = log.readLine();
		// for debuging
		int i = 1;

		while (line != null) {
			// for debuging
			System.out.println(i);
			System.out.println(line);

			processLine(line);
			line = log.readLine();

			// for debuging
			i++;
		}

	}

	private void processLine(String line) {

		String temp = null;

		int i = 0;
		int iL = 0;
		int iR = 0;

		while (i != -1) {

			try {
				i = line.indexOf(errorKeyword, i);
				iL = line.indexOf(lLimit, i);
				iR = line.indexOf(rLimit, iL);

				if (i != -1 && iL != -1 && iR != -1) {
					temp = line.substring(iL + 1, iR);
					this.addToSets(temp);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage() + " -> unrecognized defect error");
			}

			temp = null;

			if (i == -1)
				break;
			else
				i = iR;
		}

	}

	private void addToSets(String err) {
		/*
		 * err in this form => BLM1-0006
		 */
		if (err == null)
			return;

		// return DefectByApp object ready to insert in the map
		Defect defect = getDefectObj(err);

		if (!defects.contains(defect)) {
			defects.add(defect);
		}

		//create app object
		App app = getAppObj(err);

		if (apps.contains(app)) {

			// find
			App temp = findAppInSet(app);
			// remove
			apps.remove(temp);
			// add defect to app
			temp.addDefect(defect);
			// add
			apps.add(temp);
		} else {
			app.addDefect(defect);
			apps.add(app);
		}

		////// ********************************////////
		////// ********************************////////
		/*
		 * pick up from here just created a defect obj check if the defect obj exist and
		 * add the defect obj to the set create app obj check if the app obj exist and
		 * add it to the app set
		 */
		////// ********************************////////

	}

	

	private Defect getDefectObj(String err) {

		// locate the dash
		int i = err.indexOf(dash);
		return new Defect(Integer.parseInt(err.substring(i)));

	}

	
	
	

	private App getAppObj(String err) {

		String appName;

		// locate the dash
		int i = err.indexOf(dash);

		if (err.charAt(i - 1) != coreCode) { // create for custom app
			// remove custom code and get the app name
			appName = err.substring(0, i - 1);

			// create custom defect object
			return new App(appName, ReadLog.custom);
		} else {
			// create for core app
			appName = err.substring(0, i);

			// create core defect object
			return new App(appName, ReadLog.core);
		}

	}


	

	private App findAppInSet(App app) {
		Iterator<App> ite = apps.iterator();
		App temp;

		while (ite.hasNext()) {
			temp = ite.next();
			if (temp.equals(app)) {
				return temp;
			}
		}

		return null;

	}

}
