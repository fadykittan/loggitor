package com.loggitor.v2.loggitor.entity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DefectByApp {
	
	
	private String _defectType;
	private String _appName;
	private Map<String, DefectCode> _defectCode;
	private int _firstDefectCode;
	private int _totalCount;
	private int _criticalSeverityCount;
	private int _errorSeverityCount;
	private int _warningSeverityCount;
	private static String newLine ="\r\n";
	
	
	public DefectByApp(String appName,String defectType, int defectCode) {
		super();
		
		_criticalSeverityCount=0;
		_warningSeverityCount=0;
		_errorSeverityCount=0;
		_defectCode = new HashMap<String, DefectCode>();
		
		// calculate severity
		int severity = defectCode % 10;
		
		
		switch(severity)
		{
		//critical
		case 1:	_criticalSeverityCount++;
		break;
		case 2:	_criticalSeverityCount++;
		break;
		case 3: _criticalSeverityCount++;
		break;
		//error
		case 4:	_errorSeverityCount++;
		break;
		case 5:	_errorSeverityCount++;
		break;
		case 6: _errorSeverityCount++;
		break;
		//warning
		default: _warningSeverityCount++;
		break;
		}
		
		
		this._firstDefectCode = defectCode;
		this._appName = appName;
		this._defectType = defectType;
		this._totalCount=1;
		_defectCode.put(Integer.toString(defectCode), new DefectCode(defectCode,1));
		
	}



	public String getDefectType() {
		return _defectType;
	}



	public String getAppName() {
		return _appName;
	}



	public int getCount() {
		return _totalCount;
	}



	
	public void addDefectCode(int code)
	{
		// calculate severity
		int severity = code % 10;
		
		switch(severity)
		{
		//critical
		case 1:	_criticalSeverityCount++;
		break;
		case 2:	_criticalSeverityCount++;
		break;
		case 3: _criticalSeverityCount++;
		break;
		//error
		case 4:	_errorSeverityCount++;
		break;
		case 5:	_errorSeverityCount++;
		break;
		case 6: _errorSeverityCount++;
		break;
		//warning
		default: _warningSeverityCount++;
		break;
		}
		
		_totalCount++;
		
		DefectCode temp = _defectCode.get(Integer.toString(code));
		
		if(temp == null)
		{
			_defectCode.put(Integer.toString(code), new DefectCode(code,1));
		}
		else
		{
			temp.addOne();
			_defectCode.replace(Integer.toString(code), temp);
		}
		
	}
	
	
	
	public int getFirstDefectCode()
	{
		return this._firstDefectCode;
	}
	
	
	
	
	
	
	public String toString()
	{
		String report = this._appName + " " + this._defectType;
		report += DefectByApp.newLine;
		report += "--------------" + DefectByApp.newLine;
		report += "Number of defects with critical severity is: " + _criticalSeverityCount + DefectByApp.newLine;
		report += "Number of defects with error severity is: " + _errorSeverityCount + DefectByApp.newLine;
		report += "Number of defects with error warning is: " + _warningSeverityCount + DefectByApp.newLine;
		report += "Defects codes for this app:" + DefectByApp.newLine;
		
		// iterate over hashMap
		Iterator<Entry<String, DefectCode>> it = _defectCode.entrySet().iterator();
		Map.Entry<String, DefectCode> pair;
		
		while(it.hasNext())
		{
			pair = (Map.Entry<String, DefectCode>) it.next();
			report += "Defect Code: " + pair.getValue().getCode() + " occurred " + pair.getValue().getCount();
			report += DefectByApp.newLine;
		}
		
		report += "=================";
		
		return report;
	}
	
	
	
	
	
	
	
	
	
	/*
	public void setCount(int count) {
		this._count = count;
	}
	*/
	
	
	
	
	
}
