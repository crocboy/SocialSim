package com.socialsim.regions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;

/** Used to generate Terrain, and hold the data **/
public class Terrain implements TerrainGenerator 
{
	
	/* These static ints are used to access the FIRST index of "data" */
	/* Each corresponds to a different type of map */
	
	public static final int TOPO_MAP = 0;
	public static final int TERRAIN_MAP = 1;
	public static final int COLOR_MAP = 2;
	
	/* Describes different types of terrain */
	public static final int TERRAIN_WATER = 0;
	public static final int TERRAIN_GRASS = 1;
	public static final int TERRAIN_DESERT = 2;
	
	/* Constant parameters */
	public static final int TERRAIN_MIN = -100;
	public static final int TERRAIN_MAX = 100;
	
	public double waterRatio = 0.

			
			
			
			;
	
	
	public final int width;
	public final int height;
	public final int roughness;
	public final long seed;
	
	public float[][] grid;
	
	
	/** Holds the actual terrain data.
		The first index refers to the type of map (see above).  
		The next two are the X & Y coordinates.  
		The resulting integer is the actual data value. **/
	public int[][][] data;
	
	/** Used to generate the random terrain **/
	Random random;
	
	/* Dimensions */
	public int x = 0;
	public int y = 0;
	
	
	public Terrain(final int width, final int height, final int roughness)
    {
        this(width, height, roughness, System.currentTimeMillis());
    }
    
    
    public Terrain(final int width, final int height, final int roughness, final long seed)
    {
        this.width = width;
        this.height = height;
        this.roughness = roughness;
        this.seed = seed;
        
        Noise noise = new Noise(new Random(seed), 5f, width, height);
        noise.initialise();
        
        grid = noise.grid_;
        
        this.data = new int[3][width][height];
        
        this.data[Terrain.TOPO_MAP] = getTerrain();
        
        fillRGBArray();
        
        fillTerrainTypeArray();
        
        //writeToFile();
        
    }
    
	
    /** Return the topo map **/
    public int[][] getTerrain()
    {
        double [][] tempResult = new double[width][height];
        for(int scale = roughness; scale < 8; ++scale)
        {
            int [][] intermediate = generateOneOctave(width, height, seed + scale, 256 >> scale);
            for(int x = 0; x < width; ++x)
                for(int y = 0; y < height; ++y)
                    tempResult[x][y] += ((double)intermediate[x][y]) / (2 << (scale - roughness));
        }
        
        int [][] result = new int[width][height];
        for(int x = 0; x < width; ++x)
            for(int y = 0; y < height; ++y)
                result[x][y] = (byte)((int)tempResult[x][y]);
        
        
        return result;
        
        
    }
    
    
    /** Populate the RGB part of the array **/
    public void fillRGBArray() 
    {
    	
    	//16711680 is Red
    	//65280 is blue
    	//255 is green
    	
    	/* loop through all values */
		for(int x = 0; x < data[Terrain.TOPO_MAP].length; x++) 
		{
			for(int y = 0; y < data[Terrain.TOPO_MAP][x].length; y++) 
			{
				
				/* Loop through X & Y's here */
				if(data[Terrain.TOPO_MAP][x][y] <= 0) 
				{
					data[Terrain.COLOR_MAP][x][y] = 65280;
				}
				else if(data[Terrain.TOPO_MAP][x][y] > 0) 
				{
					data[Terrain.COLOR_MAP][x][y] = 255;
				}
				
			}
		}
    	
    	
    	
    }
    
    
    public void fillTerrainTypeArray() 
    {
    	
    	/* loop through all values */
		for(int x = 0; x < data[Terrain.TOPO_MAP].length; x++) 
		{
			for(int y = 0; y < data[Terrain.TOPO_MAP][x].length; y++) 
			{
				
				/* Loop through X & Y's here */
				if(data[Terrain.TOPO_MAP][x][y] <= 0) 
				{
					data[Terrain.TERRAIN_MAP][x][y] = Terrain.TERRAIN_WATER;
				}
				else if(data[Terrain.TOPO_MAP][x][y] > 0) 
				{
					if(isDesert(x,y)) 
					{
						data[Terrain.TERRAIN_MAP][x][y] = Terrain.TERRAIN_DESERT;
					}
					else 
					{
						data[Terrain.TERRAIN_MAP][x][y] = Terrain.TERRAIN_GRASS;
					}
				}
				
			}
		}
    	
    }
    
    
    /** Warning!  Proceed with caution.  The following methods can be quite nasty. **/
    
    
    /** Tests is certain coordinates are desert or not **/
    public boolean isDesert(int x, int y) 
    {
    	
    	return false;
    	
    }
    
	
	
	/** Correctly shift a given terrain to meet the water ratio **/
	public static void adjustSeaLevel(int[][] data, double quota) 
	{
		
		int currentWaters = 0;
		
		/* Count our current water blocks */
		for(int x = 0; x < data.length; x++) 
		{
			for(int y = 0; y < data[x].length; y++) 
			{
				
				/* Loop through X & Y's here */
				if(data[x][y] <= 0) 
				{
					currentWaters += 1;
				}
				
			}
		}
	}
	
	
	/** Make and odd-dimensioned array even-dimensioned **/
	public static int[][] makeEven(int[][] data) 
	{
		
		if(data.length % 2 == 0 && data[0].length % 2 == 0) 
		{
			return data;
		}
		
		else
			return data;
	}
	
	
	
	private int[][] generateOneOctave(final int width, final int height, final long seed, final double scale)
    {
        final ArrayList<ArrayList<Double>> G = new ArrayList<ArrayList<Double>>();
        final Random r = new Random(seed);

        while(G.size() < 256)
        {
            while(true)
            {
                final double first = r.nextDouble() * 2 - 1;
                final double second = r.nextDouble() * 2 - 1;

                final double length = Math.sqrt(first * first + second * second);
                if(length < 1.0)
                {
                    final ArrayList<Double> newElem = new ArrayList<Double>();
                    newElem.add(first / length);
                    newElem.add(second / length);
                    G.add(newElem);
                    break;
                }
            }
        }
        
        final int[] P = new int[256];
        for(int i = 0; i < P.length; i++)
        {
            P[i] = i;
        }

        for(int i = P.length - 1; i > 0; i--)
        {
            final int index = r.nextInt(i);
            final int temp = P[index];
            P[index] = P[i];
            P[i] = temp;
        }

        final int[][] result = new int[width][height];
        for(int x = 0; x < width; ++x)
        {
            for(int y = 0; y < height; ++y)
            {
                result[x][y] = (int) ((noise(x / scale, y / scale, P, G) + 1) * 128);
            }
        }

        return result;
    }

    
    
    private double drop(final double a)
    {
        final double b = Math.abs(a);
        return 1.0 - b * b * b * (b * (b * 6 - 15) + 10);
    }

    
    
    private double Q(final double u, final double v)
    {
        return drop(u) * drop(v);
    }

    
    
    private double dotProduct(final ArrayList<Double> b, final double[] a)
    {
        return a[0] * b.get(0) + a[1] * b.get(1);
    }

    
    
    private double noise(final double x, final double y, final int[] P, final ArrayList<ArrayList<Double>> G)
    {
        final double[] cell = new double[] 
        {Math.floor(x), Math.floor(y)};

        double sum = 0.0;
        for(int r = 0; r <= 1; ++r)
        {
            for(int s = 0; s <= 1; ++s)
            {
                final double i = cell[0] + r;
                final double j = cell[1] + s;

                final double[] uv = new double[] 
                {x - i, y - j};

               // try  	
                int check = (byte) i;
                int index = P[Math.abs(check)];
                index = P[(index + (int) j) % P.length];
                final ArrayList<Double> grad = G.get(index % G.size());
                sum += Q(uv[0], uv[1]) * dotProduct(grad, uv);
                
               /* } catch(Exception e) 
               {
                	System.out.println("ERROR");
                }*/
                
            }
        }

        return Math.max(Math.min(sum, 1.0), -1.0);
    }
    
    /** Write the topo data to file **/
    public void writeToFile() 
    {
    	try 
    	{
    		
			FileOutputStream os = new FileOutputStream("terrain.txt");
			for(int x = 0; x < data[Terrain.TOPO_MAP].length; x++) 
			{
				for(int y = 0; y < data[Terrain.TOPO_MAP][x].length; y++) 
				{
					
					/* Write it out! */
					os.write(("," +String.valueOf(data[Terrain.TOPO_MAP][x][y])).getBytes());
					
				}
				
				/* Add a newline */
				os.write("\n".getBytes());
			}
			
			os.close();
			
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public int[][] getArray() 
    {
    	
    	int[][] grid_ = new int[width][height];
    	
        int xh = grid_.length - 1;
        int yh = grid_[0].length - 1;
        
        Random rand_ = new Random();

        // set the corner points
        grid_[0][0] = (int) (rand_.nextFloat() - 0.5f);
        grid_[0][yh] = (int) (rand_.nextFloat() - 0.5f);
        grid_[xh][0] = (int) (rand_.nextFloat() - 0.5f);
        grid_[xh][yh] = (int) (rand_.nextFloat() - 0.5f);

        // generate the fractal
        return generate(0, 0, xh, yh, grid_);
    }


    // Add a suitable amount of random displacement to a point
    private float roughen(float v, int l, int h) 
    {
        return v + roughness * (float) (new Random().nextGaussian() * (h - l));
    }


    // generate the fractal
    private int[][] generate(int xl, int yl, int xh, int yh, int[][] grid_) 
    {
    	
    	
        int xm = (xl + xh) / 2;
        int ym = (yl + yh) / 2;
        if ((xl == xm) && (yl == ym)) return grid_;

        grid_[xm][yl] = (int) (0.5f * (grid_[xl][yl] + grid_[xh][yl]));
        grid_[xm][yh] = (int) (0.5f * (grid_[xl][yh] + grid_[xh][yh]));
        grid_[xl][ym] = (int) (0.5f * (grid_[xl][yl] + grid_[xl][yh]));
        grid_[xh][ym] = (int) (0.5f * (grid_[xh][yl] + grid_[xh][yh]));

        float v = roughen(0.5f * (grid_[xm][yl] + grid_[xm][yh]), xl + yl, yh
                + xh);
        grid_[xm][ym] = (int) v;
        grid_[xm][yl] = (int) roughen(grid_[xm][yl], xl, xh);
        grid_[xm][yh] = (int) roughen(grid_[xm][yh], xl, xh);
        grid_[xl][ym] = (int) roughen(grid_[xl][ym], yl, yh);
        grid_[xh][ym] = (int) roughen(grid_[xh][ym], yl, yh);

        generate(xl, yl, xm, ym, grid_);
        generate(xm, yl, xh, ym, grid_);
        generate(xl, ym, xm, yh, grid_);
        generate(xm, ym, xh, yh, grid_);
        
        return grid_;
    }

	
	
	

}
