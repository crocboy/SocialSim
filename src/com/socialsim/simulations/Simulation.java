package com.socialsim.simulations;
import javax.swing.JProgressBar;

import com.socialsim.people.Person;
import com.socialsim.regions.World;



public class Simulation 
{
	
	private onEndListener onEnd = null;
	private onProgressChangedListener onProgressListener = null;
	
	public int CurrentDay = 0;
	public boolean Completed = false;
	public JProgressBar bar = null;
	public int rootFamilies = 1;
	public int Progress = 0;
	public long Time = 0;
	private int Years = 0;
	private int Days = 0;
	public World w;
	
	private boolean isRunning = true;
	
	/* Default constructor */
	public Simulation(int years) 
	{
		this.Years = years;
		this.Days = this.Years * 365;
	}
	
	
	//Start the sim
	public void start() 
	{
		
		Time = 0;
		long st = System.currentTimeMillis();
		Completed = false;
		isRunning = true;
		w = new World(1000, this.rootFamilies);
		
		//This is where we actually run the simulation
		for(int i = 0; i < this.Days && isRunning != false; i++) 
		{
			w.nextDay();
			CurrentDay = i;
			
			if(i % 1000 == 0) 
			{
				double current = i;
				double total = this.Days;
				this.Progress = (int)((current/total)*100);
				if(onProgressListener != null) 
				{
					onProgressListener.onProgressChanged(this.Progress);
				}
			}
			//Check to see if we're all extinct!
			if(w.isExtinct) 
			{
				w.LOG.logLine("All humanity is extinct!");
				break;
			}
		}
		
		this.Completed = true;
		
		//Write to the log
		for(Person p : w.people)
		{
			w.LOG.logLine(p.toString());
		}
		
		long et =System.currentTimeMillis();
		Time = et-st;
		double total = this.Time;
		double days = this.Days;
		double perDay = total/days;
		boolean endedEarly = !(CurrentDay+1 == this.Days);
		if(!endedEarly) 
		{
			if(!(onProgressListener == null)) 
			{
				onProgressListener.onProgressChanged(100);
			}
		}
		if(onEnd != null & w != null) 
		{
			onEnd.onEnd(w, this.Time , perDay, endedEarly);
		}
		
		
	}
	
	
	//Stop the sim
	public void stop() 
	{
		isRunning = false;
		this.Completed = true;
	}
	
	public World getWorld() 
	{
		if(w != null) 
		{
		return w;
		}
		else 
		{
			return new World(1000, this.rootFamilies);
		}
	}
	
	//Set the listener
	public void setOnEndListener(onEndListener l) 
	{
		onEnd = l;
	}
	
	public void setOnProgressChangedListener(onProgressChangedListener l) 
	{
		onProgressListener = l;
	}
	
	//This sets the callbacks for when the world ends
	public interface onEndListener 
	{
		
		//The world is ended, pass on the World object and the time it took to run
		void onEnd(World w, long time, double msPerDay, boolean endedEarly);
		
	}
	
	public interface onProgressChangedListener 
	{
		void onProgressChanged(int progress);
	}
	
}
