package com.socialsim.regions;

import java.awt.Rectangle;

import com.socialsim.misc.Namer;
import com.socialsim.misc.Util;
import com.socialsim.people.Man;
import com.socialsim.people.Person;
import com.socialsim.people.Woman;



//The world defines the world (I know, great explanation)
//It holds all the people, and manages time, etc

public class World extends Region 
{
	
	/* Basic variables */
	  //Keep track of day
	public Woman woman;
	public Namer namer = new Namer();
	public boolean isExtinct = false;
	public Terrain t; 
	public int mapSize;
	
	/* Constructor */
	public World(int size, int roots) 
	{
		mapSize = size;
		bounds = new Rectangle(0,0,size,size);
		
		//generate the terrain
		
		
		
		//Loop through our root families, and create them
		for(int i = 0; i < roots; i++) 
		{
			
			Man man =new Man("",Util.getMaleName(), Util.getSurname(),7300,this);
			woman =new Woman("",Util.getFemaleName(), man.Surname,7300,this);
			man.Mom = new Woman("ID","God","",0,this);
			man.Dad = new Man("ID","God","",0,this);
			woman.Mom = new Woman("ID","God","",0,this);
			woman.Dad = new Man("ID","God","",0,this);
			man.Spouse = woman;
			woman.Spouse = man;
			man.Generation = 1;
			woman.Generation = 1;
			this.people.add(man);
			this.people.add(woman);
			this.Alive.add(man);
			this.Alive.add(woman);
			Util.log(this, "God created " + man.Name + " and " + woman.Name + " " + man.Surname + ".");
			
		}
		liveCount = 2*roots;
		
	}
	
	
	/* Live next day */
	public int nextDay() 
	{
		long s = System.currentTimeMillis();
		
		for(Person p : Alive) 
		{
			
			if(p.lifeState == Person.ALIVE) 
			{ 
				
				p.nextDay();
				if (Util.extinctionCheck(this) == true)
				{
					isExtinct = true;
				}
			}
			
		}
		
		Alive.addAll(Queue);
		Alive.removeAll(DeathQueue);
		people.addAll(Queue);
		liveCount += Queue.size();
		
		Queue.clear();
		DeathQueue.clear();
		
		currentDay++;
		long e = System.currentTimeMillis();
		
		return currentDay;
	}
	
	//Returns a new ID for the person
	public String getNewId() 
	{
		return "ERROR";
	}
	
	
	//Return a good representation of the world
	@Override
	public String toString() 
	{
		String total = "World summary: \n\n\tWorld population: " + String.valueOf(people.size()) + "\n";
		total += "\tTotal days: " + String.valueOf(currentDay) + "\n\n";
		//total += 
		return total;
	}

}
