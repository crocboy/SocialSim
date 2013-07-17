package com.socialsim.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import com.socialsim.misc.Util;
import com.socialsim.regions.World;

/* A window that reads the Log file and displays it */
	public  class LogWindow extends JFrame 
	{
		
		public LogWindow(World w) 
		{
			final JFrame ref = this;
			final World world = w;
			setSize(600,900);
			setTitle("World Log");
			setLayout(new BorderLayout());
			JPanel panel = new JPanel();
			
			//The search field
			final JTextField text = new JTextField(40);
			text.setEditable(true);
			/*Dimension d = new Dimension();
			d.width = 50;
			d.height = 20;
			text.setSize(d);*/
			text.setBorder(new LineBorder(Color.BLACK));
			
			//Main log window
			JTextArea l = new JTextArea();
			l.setEditable(false);
			
			final JEditorPane pane = new JEditorPane();
			
			pane.setBounds(3, 38, 577, 850);
			final Highlighter highlighter = pane.getHighlighter();
			pane.setEditable(false);
			pane.setText(w.LOG.toString());
			final JScrollPane spane = new JScrollPane(pane);
			
			//Help Button
			JButton helpButton = new JButton("Help!");
			helpButton.setBounds(385,3,70,27);
			helpButton.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					Util.popup(ref, "TELL ME HOW TO SEARCH!", "How to Search");
				}
			});
			
			//The search button
			JButton search = new JButton("Search");
			search.setBounds(300,3,80,27);
			search.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
					String s = text.getText();
					if (!s.equals(""))
					{
					ArrayList<Integer> al = Util.logSearch(world, s);
					int found = 0;
					highlighter.removeAllHighlights();
					for (Integer i: al)
					{
						found++;
						try
						{
						highlighter.addHighlight(i, i+s.length(), DefaultHighlighter.DefaultPainter);
						} catch (Exception e)
						{
							System.out.println("Search error: " + e.toString());
						}
					}
					Util.popup(ref, "Found " + found + " results.", "Search");
				}else
				{
					Util.popup(ref, "Found " + 0 + " results.", "Search");
				}
				}
			});
			
			
			
			//Add 'em all!
			add(spane,BorderLayout.CENTER);
			panel.add(text);
			panel.add(search);
			//panel.add(helpButton);
			add(panel,BorderLayout.PAGE_START);
		}
		
	
	}
