package com.socialsim.people;



import java.util.ArrayList;
import java.util.Random;

import com.socialsim.misc.Util;
import com.socialsim.regions.Region;


//Define a man
public class Man extends Person 
{

	public static final int MALE = 0;
	public ArrayList<Person> childs = new ArrayList<Person>();
	
	/* Constructors */
	public Man(String id, String name, Region region) 
	{
		super(id, name, region);
	}
	
	public Man(String id, String name, String surname, int age, Region region) 
	{
		super(id, name, surname, age, region);
	}

	@Override
	public void nextDay() 
	{
		
		//Call the superclass method
		super.nextDay();
		
		//Work, etc.
		if(Age > 7300 && Age < 12000 && Spouse == null) 
		{
			
			if(Util.getMarriageChance()) 
			{
				
				ArrayList<Person> candidates = new ArrayList<Person>();
				
				for (Person p : region.Alive) 
				{
					
					if (Util.marriageEligible(p , this))
					{
						candidates.add(p);
					}
				}
				
					if (candidates.size() > 0) 
					{
						
						Random r = new Random();
						int i = r.nextInt((candidates.size()-1) - 0 + 1) + 0;
						Person choice = candidates.get(i);
						Spouse = choice;
						choice.Spouse = this;
						Util.log(region, this.Name + " " + this.Surname + " is now married to " + choice.Name + " " + choice.Surname + "!");
						choice.Surname = this.Surname;
					
					}
			  }
		}
		
		
	}


}
