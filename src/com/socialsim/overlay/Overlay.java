package com.socialsim.overlay;


import java.awt.Graphics;
import java.awt.Graphics2D;

/* This class is passed into the MapFrame */
/* Classes will extend from this to draw custom objects */
/** This class is passed into the MapFrame.  
 Classes will extend from this to draw custom objects */
public abstract class Overlay 
{
	
	

	
	/** Called every time the Overlay is drawn or re-drawn. 
	 * Gives subclasses a chance to do custom drawing. **/
	public abstract void onDraw(Graphics g, int width, int height);
	
	


}
