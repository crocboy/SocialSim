package com.socialsim.gui;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.socialsim.overlay.Overlay;

public class MapPanel extends JPanel
{

	
	public ArrayList<Overlay> Overlays = new ArrayList<Overlay>();
	
	public MapPanel() 
	{
		
		addComponentListener(new ComponentAdapter() 
		{
		    @Override
		    public void componentResized(ComponentEvent e)
		    {
		        //repaint();
		    }
		});
	}
	
	public void paintComponent(Graphics g) 
	{
		
		for (Overlay o : Overlays) 
		{
			o.onDraw(g, getParent().getWidth(), getParent().getHeight());
		}
		
	}

}
