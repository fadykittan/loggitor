package com.loggitor.v2.loggitor.entity;

public class DefectCode {
	
	private int _code;
	private int _count;
	
	
	public DefectCode(int code, int count) {
		super();
		this._code = code;
		this._count = count;
	}


	public int getCode() {
		return _code;
	}


	public int getCount() {
		return _count;
	}
	
	
	public void addOne()
	{
		this._count++;
	}
	
	
}
