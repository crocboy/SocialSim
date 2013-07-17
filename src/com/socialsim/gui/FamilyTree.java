package com.socialsim.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.socialsim.people.Person;

/* This subclass defines a FamilyTree window */
	/* A window that shows a family tree */
	public class FamilyTree extends JFrame 
	{
		
		ArrayList<Person> firstGen = new ArrayList<Person>();
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("World");
		JTree tree = new JTree(rootNode);
		
		//The initializer, this is where we construct the tree
		public FamilyTree(ArrayList<Person> people) 
		{
			
			initGUI();
			firstGen = getFirstGen(people);
			addAllNodes(firstGen);
			
			
		} //End Constructor
		
		//This function sets up the GUI components
		public void initGUI() 
		{
			setSize(750,800);
			setTitle("Family Tree");
			setLayout(new BorderLayout());
			JScrollPane pane = new JScrollPane(tree);
			getContentPane().add(pane, BorderLayout.CENTER);
		}
		
		//Add root nodes, and add all of the rest
		public void addAllNodes(ArrayList<Person> root) 
		{
			
			//Add the first gen's
			for(Person p : root) 
			{
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(p.getMarriageName());
				p.Node = node;
				addNodes(p);
				rootNode.add(node);
			}
			
		}
		
		//Recursively add nodes for ONLY MEN! (It shows their marriage name)
		public void addNodes(Person p) 
		{
			if(!p.getClass().toString().toLowerCase().contains("woman")) 
			{
			if(p.Dad.Node != null) 
			{
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(p.getMarriageName());
				p.Dad.Node.add(node);
				p.Node = node;
			}
			if(p.hasChildren) 
			{
				for(Person kid : p.children) 
				{
					addNodes(kid);
				}
			}
			}
		}
		
		//Get all the first-genners
		public ArrayList<Person> getFirstGen(ArrayList<Person> people) 
		{
			//Find all of the first gen men
			ArrayList<Person> first = new ArrayList<Person>();
			for(Person p : people) 
			{
				if(p.Generation == 1 && p.getClass().toString().contains("Man")) 
				{
					first.add(p);
				}
				if(p.Generation > 1) 
				{ //We don't want any second-genners
					break;
				}
			}
			
			return first;
		}

	}
