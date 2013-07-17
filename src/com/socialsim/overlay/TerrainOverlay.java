package com.socialsim.overlay;

import java.awt.BasicStroke;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;

import com.socialsim.misc.Util;
import com.socialsim.regions.Terrain;

/** Used to draw terrain on a map. **/
public class TerrainOverlay extends Overlay 
{
	
	/** Holds all terrain data **/
	int[][][] data;
	int dim;
	int pixsquares;
	
	
	public Terrain terrain;
	
	
	/** Public constructor.  Pass in a valid Terrain object **/
	public TerrainOverlay(Terrain terrain_) 
	{
		
		dim = terrain_.width;
		pixsquares = dim;
		data = terrain_.data;
		
		this.terrain = terrain_;
		
	}
	
	
	/** Override the onDraw of the superclass, drawing our custom terrain data **/
	@Override
	public void onDraw(Graphics g, int w, int h) 
	{
		
		/* Cast to a new object */
		Graphics2D graphics = (Graphics2D) g;
		
		
		/*for(int x = 0; x < dim; x++) 
		{
			for(int y = 0; y < dim; y++) 
			{
				
				//float alpha = (data[Terrain.TOPO_MAP][x][y]+127) / 256f;
				Color c = new Color(data[Terrain.COLOR_MAP][x][y]);
				graphics.setColor(c);
				graphics.fillRect(x, y, 1, 1);
			}
		}*/
		
		int mapside = Math.min(w, h);		//Length of a side of the square the map is drawn in
		//int psres;							
		int offset = (w-mapside)/2;			//x offset for the map
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, w, h);   				//draw background
		graphics.setColor(Color.white);
		/*Integer highestacceptableint = 1;
		for (int c=1; c<dim; c*=2)
		{
			if (mapside*c > dim)
			{
				c=dim;
			}else
			{
				highestacceptableint = c;
			}
		}
		psres = highestacceptableint*2; 		//number of blocks displayed in one pixsquare*/
		double psdim = (((double) mapside)/((double) pixsquares));	//number of pixels per pixsquare
			double px = 0;
			double py = 0;
			for (int psx=0; psx<pixsquares; psx++)
			{	
				px+=psdim;
				py=0;
				for (int psy=0; psy<pixsquares; psy++)
				{
					py+=psdim;
					Color c = new Color(data[Terrain.COLOR_MAP][psx][psy]);
					graphics.setColor(c);
					if (psdim <= 2)
					{
						graphics.drawRect(offset+(int)px,(int)py,(int)psdim,(int)psdim);
					}else
					{
						graphics.fillRect(offset+(int)px,(int)py,(int)Math.ceil(psdim),(int)Math.ceil(psdim));
					}
			
				}
			}
		
	}

}
