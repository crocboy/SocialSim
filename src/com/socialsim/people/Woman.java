package com.socialsim.people;
import com.socialsim.misc.Util;
import com.socialsim.regions.Region;





//Define a woman
public class Woman extends Person 
{

	public static final int FEMALE = 1;
	
	public Woman(String id, String name, Region region) 
	{
		super(id, name, region);
	}
	public Woman(String id, String name, String surname, int age, Region region) 
	{
		super(id, name, surname, age, region);
	}

	@Override
	public void nextDay() 
	{
		
		//Call the superclass method
		super.nextDay();
				
		if(Age > 7300 && Age < 12000 && this.Spouse != null) 
		{
		if(Util.getBirthChance()) 
		{
			giveBirth();
		  }
		}
	}
	
	public void giveBirth() 
	{
		int gender = Util.getNewGender();
		Person kid;
		if(gender == Man.MALE) 
		{
			kid = new Man("ID",Util.getMaleName(), Surname,0, this.region);
		}
		else 
		{
			kid = new Woman("ID",Util.getFemaleName(),Surname,0,this.region);
		}
		
		kid.Mom = this;
		kid.Dad = this.Spouse;
		kid.Generation = this.Generation + 1;
		this.children.add(kid);
		this.Spouse.children.add(kid);
		
		this.hasChildren = true;
		this.Spouse.hasChildren = true;
		
		this.region.Queue.add(kid);
		Util.log(region, Spouse.Name + " and " + this.Name + " " + Spouse.Surname + " begot " + kid.Name + " " + kid.Surname + ".");
	}


}
