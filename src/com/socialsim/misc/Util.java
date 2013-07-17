package com.socialsim.misc;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import com.socialsim.people.Man;
import com.socialsim.people.Person;
import com.socialsim.people.Woman;
import com.socialsim.regions.Region;


//Util will hold basic utility functions

public class Util 
{
	
	//Get the gender for a new child
	public static int getNewGender() 
	{
		Random r = new Random();
		int i = r.nextInt();
		if(i > (i/2)) 
		{
			return Woman.FEMALE;
		}
		else 
		{
			return Man.MALE;
		}
	}
	
	//Return the chance of birth
	public static boolean getBirthChance() 
	{
		Random r = new Random();
		int i = r.nextInt(1000 - 0 + 1) + 0;
		if(i < 1) 
		{
			return true;
		}
		return false;
	}
	
	//Return the chance of marriage
		public static boolean getMarriageChance() 
		{
			Random r = new Random();
			int i = r.nextInt(2500 - 0 + 1) + 0;
			if(i < 1) 
			{
				return true;
			}
			return false;
		}
	
	
	
	public static String getMaleName() 
	{
		try 
		{
		Random r = new Random();
		int i = r.nextInt(1200 - 0 + 1) + 0;
		BufferedReader in  = new BufferedReader(new FileReader("NAMES_MALE.txt"));
		String raw = "";
		ArrayList<String> names = new ArrayList<String>();
		while((raw = in.readLine()) != null) 
		{
			names.add(raw);
		}
		in.close();
		 return names.get(i);
		 
		} catch(Exception e) 
		{
			Util.print("Male Name get error: " + String.valueOf(e));
			return "MALE " + String.valueOf(e);
		}
	}
	
	
	public static String getFemaleName() 
	{
		try 
		{
		Random r = new Random();
		int i = r.nextInt(2999 - 0 + 1) + 0;
		BufferedReader in  = new BufferedReader(new FileReader("NAMES_FEMALE.txt"));
		String raw = "";
		ArrayList<String> names = new ArrayList<String>();
		while((raw = in.readLine()) != null) 
		{
			String end = raw.substring(1, raw.length());
			String start = raw.substring(0,1);
			start = start.toUpperCase();
			String fin = start + end;
			names.add(fin);
		}
		in.close();
		 return names.get(i);
		 
		} catch(Exception e) 
		{
			Util.print("Female Name get error: " + String.valueOf(e));
			return "FERMALE " + String.valueOf(e);
		}
	}
	
	public static String getSurname() 
	{
		try 
		{
		Random r = new Random();
		int i = r.nextInt(4500 - 0 + 1) + 0;
		BufferedReader in  = new BufferedReader(new FileReader("SURNAMES.txt"));
		String raw = "";
		ArrayList<String> names = new ArrayList<String>();
		while((raw = in.readLine()) != null) 
		{
			String end = raw.substring(1, raw.length());
			String start = raw.substring(0,1);
			start = start.toUpperCase();
			String fin = start + end;
			names.add(fin);
		}
		in.close();
		 return names.get(i);
		 
		} catch(Exception e) 
		{
			Util.print("Surname Name get error: " + String.valueOf(e));
			return "SURNAME " + String.valueOf(e);
		}
	}
	
	//Tests whether a woman (Person p) is eligible to marry a man (Person m).
	//tests for unmarried status, unrelated-ness (commented out due to everyone having the same surname), gender,
	//age, and life status
	
	
	public static boolean marriageEligible(Person p, Man m) 
	{

		return ((p.Age > 7300 && p.Age < 12000) &&  p.Spouse == null && !(m.Surname.equals(p.Surname)) && p.getClass().toString().contains("Woman"));
		
	}
	
	public static void log(Region region , String str)
	{
		region.LOG.logLine(Util.daysToYears(region.currentDay) + ": " + str);
		//System.out.println(str);
	}
	
	//Tests whether all hope for humanity is lost
	
	public static boolean extinctionCheck(Region r) 
	{
		boolean result = true;
		for (Person p : r.people)
		{
			if (p.lifeState == 0)
			{
				result = false;
			}
		}
		return result;
	}
	
	//Returns ArrayList of all indices of a given substring in LOG
	
	public static ArrayList<Integer> logSearch(Region reg , String sub) 
	{
		String m = reg.LOG.toString();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int r = 0;
		while (i <= m.length() && r != -1)
		{
			r = m.indexOf(sub , i);
			if (r != -1)
			{
				i = r+sub.length();
				list.add(r);
			}
		}
		return list;
	}
	
	//Put in a number of days (ie, 456)
	//And get out years:days
	public static String daysToYears(int days) 
	{
		int years = days/365;
		int leftOvers = days - (years*365);
		String total = String.valueOf(years) + ":" + String.valueOf(leftOvers);
		return total;
	}
	
	//Show a popup dialog
	public static void popup(Component parent, String message, String title) 
	{
		JOptionPane.showMessageDialog(parent, message, title, 1);
	}
	
	//Print to the screen
		public static void print(String s) 
		{
			System.out.println(s);
		}
		public static void print(int s) 
		{
			System.out.println(s);
		}
	
	public static  boolean getDeathChance(int Age) 
	{
		double age = Age;
		double a = 3.85412 * (Math.pow(10, -10));
		double b = 1.232295;
		double chance = a * (Math.pow(b, age));
		chance *= 100;
		int prob = getRand(100);
		//Util.print("Rand: " + prob);
		///Util.print("Chance: " + chance);
		
		//This is a hack together for now
		if(Age > 28000) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public static int getRand(int high) 
	{
		Random r = new Random();
		return r.nextInt(high - 0 + 1) + 0;
	}
	
	public static int floorToPowerofTwo(int i)
	{	//returns the closest lower power of to from i
		int r = 1;
		for (int c=1; c<=i; c*=2)
		{
			r=c;
		}
		return r;
	}

}
