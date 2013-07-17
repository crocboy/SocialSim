package com.socialsim.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import com.socialsim.regions.World;



/* This class is a book
 * It displays information about the world, after it's over
 * It has subclasses (Windows) that display other information
 */
public class Book extends JFrame 
{

	/* Initializer, do most of our GUI work here */
	public Book(final World w) 
	{
		
		//Set the size, title, etc.
		setSize(350,200);
		setTitle("Book");
		
		//FamilyTree ft = new FamilyTree(w.people);
		
		//Get the content pane, and add our buttons and such
		Container parent = getContentPane();
		getContentPane().setLayout(new FlowLayout());
		
		//Add a button that opens the family tree window
		JButton showTreeButton = new JButton("Show Family Tree");
		showTreeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				FamilyTree ft = new FamilyTree(w.people);
				ft.setVisible(true);
			}
		});
		
		JButton showMapBtn = new JButton("Show Map");
		getContentPane().add(showMapBtn);
		parent.add(showTreeButton);
		
		//Add a button to show the log
		JButton showLogButton = new JButton("Show Log");
		showLogButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				LogWindow lw = new LogWindow(w);
				lw.setVisible(true);
			}
		});
		
		/* Show the MapFrame */
		showMapBtn.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{

				MapFrame mapFrame = new MapFrame(w);
				mapFrame.setVisible(true);
			}
		});
		
		
		parent.add(showLogButton);
		
	}
	
	
	
	
	
	
	
	
	
}
