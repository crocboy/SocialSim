package com.socialsim.gui;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;import javax.swing.JTextField;

import com.socialsim.overlay.TerrainOverlay;
import com.socialsim.regions.Terrain;
import com.socialsim.regions.World;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** This class holds a GPanel **/
public class MapFrame extends JFrame 
{

	

	public World world;
	public int W;
	public int H;
	
	/* Constructor */
	public MapFrame(World w) 
	{
		
		/* Initialize the GUI */
		world = w;
		W = w.mapSize;
		H=W;
		initGUI();
	}
	
	
	
	/** Do all the GUI crap */
	private void initGUI() 
	{
		
		getContentPane().setLayout(new BorderLayout());
		setSize(800,800);
		setTitle("Map");
		
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		JButton genBtn = new JButton("Generate");
		final JLabel label = new JLabel("Seed:");
		
		final JLabel seedLabel = new JLabel("Seed:");
		final JLabel roughLabel = new JLabel("Roughness:");
		
		final JRadioButton topoButton = new JRadioButton("Topo Map");
		final JRadioButton terrainButton = new JRadioButton("Terrain Map");
		final JRadioButton politicalButton = new JRadioButton("Political Map");
		
		/* Group the radio buttons. */
	    ButtonGroup group = new ButtonGroup();
	    group.add(topoButton);
	    group.add(terrainButton);
	    group.add(politicalButton);
	    
		
		final MapPanel mapPanel = new MapPanel();
		mapPanel.Overlays.add(new TerrainOverlay(new Terrain(W,H,10, 10)));
		
		/* Set up the two text boxes */
		final JTextField seedBox = new JTextField(10);
		seedBox.setEditable(true);
		
		final JTextField roughBox = new JTextField(10);
		roughBox.setText("1");
		roughBox.setEditable(true);
		
		
		/* Generate new terrain on the button press */
		genBtn.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{

				String s = seedBox.getText();
				String r = roughBox.getText();
				int seed = 0;
				int roughness = 1;
				
				if(s.length() == 0) 
				{
					seed = new Random().nextInt(1000000000);
				}
				try 
				{
					
					seed = Integer.parseInt(s);
					roughness = Integer.parseInt(r);
					
				} catch(Exception e) 
				{
					seed = new Random().nextInt(1000000000);
				}
				
				label.setText("Seed: " + String.valueOf(seed));
				Terrain terrain = new Terrain(W, H, roughness, seed);
				TerrainOverlay to = new TerrainOverlay(terrain);
				
				mapPanel.Overlays.clear();
				mapPanel.Overlays.add(to);
				
				mapPanel.repaint();
			}
		});
		
		add(mapPanel, BorderLayout.CENTER);
		
		topPanel.add(seedLabel);
		topPanel.add(seedBox);
		topPanel.add(roughLabel);
		topPanel.add(roughBox);
		topPanel.add(genBtn);
		topPanel.add(label);
		
		bottomPanel.add(topoButton);
		bottomPanel.add(terrainButton);
		bottomPanel.add(politicalButton);
		
		add(topPanel,BorderLayout.PAGE_START);
		add(bottomPanel, BorderLayout.PAGE_END);
		
	}

}
