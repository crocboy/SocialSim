package com.socialsim.regions;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.socialsim.people.Person;
import com.socialsim.simulations.Log;


//A class that defines a region -
//An area (rectangle) that holds people and has leadership

public class Region 
{

	public ArrayList<Person> people = new ArrayList<Person>(); //Holds all of the people
	public Rectangle bounds;  //Bounds of area
	
	public Log LOG = new Log(); //A log for storing data
	
	public ArrayList<Person> Queue = new ArrayList<Person>();
	public ArrayList<Person> DeathQueue = new ArrayList<Person>();
	public ArrayList<Person> Alive = new ArrayList<Person>();
	public ArrayList<Person> Dead = new ArrayList<Person>();
	
	public int deadCount = 0;
	public int liveCount = 0;
	public int currentDay = 0;
	

}
