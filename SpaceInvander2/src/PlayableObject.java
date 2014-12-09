import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;


public class PlayableObject extends GameObject implements IFightable

{
	

	//PLAYABLEOBJECT
	//-----------------------------------------------------------------------
	public PlayableObject(int x,int y,int width, int height,String fileName)
	{
		
		loadImageFromFilename(fileName);
		super.setPosition(x, y);
		super.setSize(width, height);
		
		
	}
	//------------------------------------------------------------------------
	//GAMEOBJECT
	
	public void Paint(Graphics g)
	{	
		super.Paint(g);
	}
	@Override
	public void loadImageFromFilename(String filename)
	{
		try
		{
			super.loadImage(filename);
		}
		catch(IOException ex)
		{
			
			this.image=null;
			this.error=true;
			
		}
		
	}

	
	//IFIGHTABLE
	
	//-------------------------------------------------------------------------
	private int timesHit;
	private int timesShot;
	private int limitOfShots=6;
	private int limitOfHits=4;
	private boolean isAlive=true;
	
	
	@Override
	public boolean shoot()
	{
		
		if(timesShot<limitOfShots)
		{
			
			this.timesShot+=1;
			
			return true;
			//TODO: CREATE AN BULLET
		}
		return false;
	}

	@Override
	public void hit()
	{
		
		this.timesHit+=1;
		if(this.timesHit>=this.limitOfHits)
			this.isAlive=false;
	}
	
	public int getHits()
	{
		return timesHit;
	}
	public int getShots()
	{
		return timesShot;
	}
	public boolean getState()
	{
		
		return this.isAlive;
	}
	
	public void shotAchivedPosition()
	{
		
		this.timesShot=-1;
		 
	}
	
	public void setLimitOfHits(int value)
	{
		this.limitOfHits=value;
		
	}
	public void setLimitOfShots(int value)
	{
		if (value >=0)
		{
			this.limitOfShots=value;
		}
	}
	
	//---------------------------------------------------------------------------
}

