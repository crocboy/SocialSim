package com.socialsim.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.LineBorder;


import com.socialsim.misc.Util;
import com.socialsim.overlay.TerrainOverlay;
import com.socialsim.regions.Terrain;
import com.socialsim.regions.World;
import com.socialsim.simulations.Simulation;


//MainFrame is the main GUI to our simulation!
public class MainFrame extends JFrame 
{

	private static final long serialVersionUID = 1L;
	//Some of our global GUI variables
	//GUI variables that we need to update from multiple plavces
	private JFrame frmSocialsim;
	JProgressBar simProgress = null;
	private JTextField yearsField;
	private JLabel lblYears;
	private JButton startButton;
	private JButton showBookBtn;
	private Simulation s = null;
	private Book book = null;
	private MapFrame mapFrame = null;
	private JLabel statusLabel;
	private JButton stopButton;
	private JTextArea statusArea;
	
	//The "current" simulation thread
	private SimTask currentSimTask = null;
	private JButton showLogBtn;
	private JButton showTreeBtn;
	private JButton btnClearLog;
	private JTextField rootFamiliesField;

	/**
	 * Launch the application.
	 */
	
	//THE MAIN ENTRY POINT!
	public static void main(String[] args) 
	{

		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					
					//Get a new MainFrame, and show it
					new MainFrame().frmSocialsim.setVisible(true);
					//Namer n = new Namer();

					
					//See random crap
					/*for(int i = 5; i < 200; i++) 
					{
						Util.print(n.generate(5));
					}*/
					
				} catch (Exception e) 
				{
					Util.print("MainFrame start-up error: " + e.toString());
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() 
	{
		initialize();
		frmSocialsim.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//This is for GUI setup
	//It also contains listener methods for all of the buttons
	private void initialize() 
	{

		//The frame that contains everything
		frmSocialsim = new JFrame();
		frmSocialsim.setTitle("SocialSim");
		frmSocialsim.setSize(1078,732);
		frmSocialsim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//The menu bar at the top
		JMenuBar menuBar = new JMenuBar();
		frmSocialsim.setJMenuBar(menuBar);
		frmSocialsim.getContentPane().setLayout(null);
		
		//Our simulation progress bar
		simProgress = new JProgressBar(0,100);
		simProgress.setStringPainted(true);
		simProgress.setBounds(12, 612, 1036, 27);
		frmSocialsim.getContentPane().add(simProgress);
		
		//The button that will show the complete book
		showBookBtn = new JButton("Show Complete Book");
		showBookBtn.setBounds(54, 13, 163, 25);
		showBookBtn.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(book != null) 
				{
					book.setVisible(true);
				}
			}
			
		});
		
		//The panel that contains parameter controls and the start/stop buttons
		JPanel paramsPanel = new JPanel();
		paramsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		paramsPanel.setBounds(12, 13, 490, 586);
		frmSocialsim.getContentPane().add(paramsPanel);
		paramsPanel.setLayout(null);
		
		//The label that says "Years: "
		lblYears = new JLabel("Years: ");
		lblYears.setBounds(159, 54, 41, 16);
		paramsPanel.add(lblYears);
		
		//The textBox that inputs the number of years
		yearsField = new JTextField();
		yearsField.setBounds(212, 51, 116, 22);
		yearsField.setText("100");
		paramsPanel.add(yearsField);
		yearsField.setColumns(10);
		
		rootFamiliesField = new JTextField();
		rootFamiliesField.setText("1");
		rootFamiliesField.setColumns(10);
		rootFamiliesField.setBounds(212, 88, 116, 22);
		paramsPanel.add(rootFamiliesField);
		
		//The button that starts the simulation, and it's ActionListener
		startButton = new JButton("Start");
		startButton.setBounds(159, 13, 80, 25);
		
		/* This is where the user starts the simulation! */
		startButton.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				setButtons(false, showBookBtn,showLogBtn,showTreeBtn, btnClearLog);
				stopButton.setEnabled(true);
				startButton.setEnabled(false);
				int years = Integer.parseInt(yearsField.getText());
				int roots = Integer.parseInt(rootFamiliesField.getText());
				statusLabel.setText("Simulating " + yearsField.getText() + " years (" + years*365 + " days) of civilization...");
				setStatus("Running simulation...\n");
				s = new Simulation(years);
				s.rootFamilies = roots;
				
				/* Called when the simulation ends */
				s.setOnEndListener(new Simulation.onEndListener() 
				{

					@Override
					public void onEnd(World w, long time, double msPerDay, boolean endedEarly) 
					{
						
						setStatus("Simulation done!");
						
						if(endedEarly) 
						{
							
							setStatus("Simulation ended early!");
							
						}
						
						else 
						{
							
							simProgress.setValue(100);
						}
						
						book = new Book(w);
						setButtons(true, showBookBtn,showLogBtn,showTreeBtn, startButton, btnClearLog);
						
						String status = w.toString();
						statusArea.append("Simulation done in " + time + "ms (" + time/1000 + " seconds)...\n");
						statusArea.append("Ms per day: " + msPerDay + "\n");
						statusArea.append(status);
						statusArea.setCaretPosition(statusArea.getDocument().getLength());
						stopButton.setEnabled(false);
				
					}
				});
				
				/* Start the simulation in a thread, and set it to update our progress bar */
				currentSimTask = new SimTask(s);
				
				currentSimTask.addPropertyChangeListener(new PropertyChangeListener() 
				{
					@Override
					public void propertyChange(PropertyChangeEvent evt) 
					{
						if ("progress" == evt.getPropertyName()) 
						{
				            int progress = (Integer) evt.getNewValue();
				            simProgress.setValue(progress);
				        } 
				    }
				});
				currentSimTask.execute();
				
			}
		});
		paramsPanel.add(startButton);
		
		//The button that stops the simulation, and its ActionListener
		stopButton = new JButton("Stop");
		stopButton.setBounds(244, 13, 80, 25);
		paramsPanel.add(stopButton);
		stopButton.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(s != null) 
				{
					s.stop();
					setButtons(true, showBookBtn,showLogBtn,showTreeBtn, startButton);
					stopButton.setEnabled(false);
					book = new Book(s.getWorld());
					setStatus("Simulation stopped!");
				}
			}
			
		});
		
		//The panel that holds all of the results components
		JPanel resultsPanel = new JPanel();
		resultsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		resultsPanel.setBounds(514, 13, 534, 586);
		resultsPanel.setLayout(null);
		
		resultsPanel.add(showBookBtn);
		
		frmSocialsim.getContentPane().add(resultsPanel);
		
		//The scroll pane that holds the end-of-sim basic log
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 44, 510, 509);
		resultsPanel.add(scrollPane);
		
		//The text area that displays ending sim data
		statusArea = new JTextArea();
		scrollPane.setViewportView(statusArea);
		
		//The button that will show the log window
		showLogBtn = new JButton("Show Log");
		showLogBtn.setBounds(229, 13, 97, 25);
		
		showLogBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(s != null ) 
				{
					LogWindow log = new LogWindow(s.getWorld());
					log.setVisible(true);
				}
			}
		});
		resultsPanel.add(showLogBtn);
		
		//The button that will show the family tree
		showTreeBtn = new JButton("Show Family Tree");
		showTreeBtn.setBounds(338, 13, 137, 25);
		showTreeBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(s != null ) 
				{
					FamilyTree tree =new FamilyTree(s.getWorld().people);
					tree.setVisible(true);
				}
			}
		});
		resultsPanel.add(showTreeBtn);
		
		//The button that will clear the small log window
		btnClearLog = new JButton("Clear Log");
		btnClearLog.setBounds(229, 556, 97, 25);
		btnClearLog.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(statusArea != null)
					statusArea.setText("");
				setStatus("Log cleared!");
			}
		});
		resultsPanel.add(btnClearLog);
		
		//The label that contains the status of the sim
		statusLabel = new JLabel("Status label!");
		statusLabel.setBounds(12, 644, 837, 16);
		frmSocialsim.getContentPane().add(statusLabel);
		
		stopButton.setEnabled(false);
		
		JLabel lblRootFams = new JLabel("Root Couples:");
		lblRootFams.setBounds(113, 91, 80, 16);
		paramsPanel.add(lblRootFams);
		
		
		
		
	}
	
	//Set the status message
	public void setStatus(String s) 
	{
		if(statusLabel != null) 
		{
			statusLabel.setText(s);
		}
	}
	
	//Define the thread that will run the simulation in the background
	class SimTask extends SwingWorker<Void, Void> 
	{

		Simulation sim;
		
		public SimTask(Simulation s) 
		{
			sim = s;
		}
		@Override
		protected Void doInBackground() throws Exception 
		{
			if(s != null) 
			{
				
				//Set the onProgressChanged listener
				sim.setOnProgressChangedListener(new Simulation.onProgressChangedListener() 
				{
					@Override
					public void onProgressChanged(int progress) 
					{
						setProgress(progress);
					}
				});
				sim.start();
				Util.print("Done!");
			}
			return null;

		}
		
	};
	
	//Change the state of many buttons at once
	public void setButtons(boolean flag, JButton... buttons ) 
	{
		for(JButton b : buttons) 
		{
			b.setEnabled(flag);
		}
	}
}
