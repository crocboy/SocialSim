package com.socialsim.people;



import java.awt.Point;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import com.socialsim.misc.Util;
import com.socialsim.regions.Region;


//This class defines a basic person
public abstract class Person 
{
	
	//STATIC INT's
	public static final int ALIVE = 0;
	public static final int DEAD = 1;
	
	public ArrayList<Person> children = new ArrayList<Person>(); // their kids
	
	//The very Basic things every person has, public vars
	public String Name;            //The person's name
	public String Surname = "";		   //Family surname
	public int Age;                //The person's age in days
	public String ID;              //The person's unique ID
	public Point originLocation;   //The coordinates of birth
	public Point currentLocation;  //The coordinates of current locations
	public int Generation = 0;
	public int lifeState = ALIVE;
	public boolean hasChildren = false;
	public Person Dad = null;
	public Person Mom = null;
	public Person Spouse = null; 
	public String MaidenName = null;
	
	public DefaultMutableTreeNode Node = null;
	
	//Some private variables
	public Region region; //The world
	
	
	//A person's attributes (Patience, Intelligence, etc.)
		
		/* Attributes */
	
		
	/* Default constructor */
	public Person(String id, String name, Region world) 
	{
		this.ID = id;
		this.Name = name;
		region = world;
	}
	
	/* Optional constructors */
	public Person(String id, String name, String surname, int age, Region world) 
	{
		this.ID = id;
		this.Name = name;
		this.Age = age;
		this.Surname = surname;
		this.MaidenName = surname;
		
		region = world;
	}
	
	/* Live next day */
	/* Each class that extends Person needs to define this method */
	/* This does the basic stuff (Age, death, etc)
	 * If you WANT to override it, go ahead, add stuff like birth, disease, etc.
	 */
	public void nextDay() 
	{

		if(this.lifeState == Person.ALIVE && Util.getDeathChance(this.Age) == true) 
		{
			
			die();
			
		}
		else 
		{
			
			Age++;
			
		}
	}
	
	//Return couple name
	public String getMarriageName() 
	{
		if(this.Spouse != null) 
		{
			return this.Name + " and " + this.Spouse.Name + " " + this.Surname;
		}
		return this.Name + " " + this.Surname;
	}
	
	
	//Return a good representation of a person
	@Override
	public String toString() 
	{
		String s = ("Name: " + Name + " " + Surname + " , Age: " + Age/365 + " , " + "Gen: " + Generation + " , " + "Parents: " + Dad.Name + " and " + Mom.Name + " " + Dad.Surname + " , " +"Sex: " + this.getClass().toString().replace("class",""));
		return s;
	}
	
	
	//Return a newline-seperated string, suitable for displaying in a window
	public String getExtendedString() 
	{
		String total = "";
		total += "Name: " + fullName() + "\n";
		if(this.Spouse != null) 
		{
			total+= "Spouse: " + this.Spouse.fullName() + "\n";
		}
		total += "Age: " + Util.daysToYears(this.Age) + "\n";
		total += "Sex: " + this.getClass().toString().replace("class","") +  "\n";
		total += "Children: ";
		for(Person p : children) 
		{
			total += p.fullName() + ",";
		}
		return total;
	}
	
	
	/* Perform dying actions */
	public void die() 
	{
		
		this.lifeState = Person.DEAD;
		region.LOG.logLine("R.I.P " + this.Name + " " + this.Surname + " at age " + Util.daysToYears(this.Age) + "!");
		this.region.DeathQueue.add(this);
		
	}
	
	//Return their full name
	public String fullName() 
	{
		return this.Name + " "  + this.Surname;
	}
	
	
	
	
	
}
	
	
