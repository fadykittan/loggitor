package com.loggitor.v2.loggitor.entity;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class WriteReport {
	
	
	private BufferedWriter writer = null;
	private Map<String, DefectByApp> defectsList = null;
	private static String newLine ="\r\n";
	
	
	
	public WriteReport(String fileName, Map<String, DefectByApp> List) {
		super();
				
		this.defectsList = List;
		
		try {
			FileWriter fileW = new FileWriter(fileName);
			writer = new BufferedWriter(fileW);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage() + " -> unable to write to the file");
		}
		
	}
	
	
	
	public void printLog() throws IOException
	{
		Iterator<Entry<String, DefectByApp>> ite = defectsList.entrySet().iterator();
		Map.Entry<String, DefectByApp> err;
		
		while(ite.hasNext())
		{
			err = (Map.Entry<String, DefectByApp>) ite.next();
			
			try {
			writer.append(err.getValue().toString());
			writer.append(newLine);
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage() + " -> error occurred while writing to the file");
			}
			
			
		}
		
		writer.close();
		
	}
	
	
	
	public boolean isEmpty()
	{
		if(defectsList == null)
			return true;
		else
			return false;
	}
	
}
