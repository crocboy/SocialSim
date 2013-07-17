package com.socialsim.simulations;

public class Log 
{
	
	private StringBuilder sb; //The TOTAL StringBuilder for EVERYTHING
	
	public Log() 
	{
		sb = new StringBuilder();
	}
	
	public void log(String s) 
	{
		sb.append(s);
	}
	
	public void logLine(String s) 
	{
		sb.append(s + "\n");
	}
	
	@Override
	public String toString() 
	{
		return sb.toString();
	}

}
