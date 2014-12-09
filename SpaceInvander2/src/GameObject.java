import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class GameObject
{
	
	protected boolean error=false;
	private Point position=new Point();
	private Dimension size=new Dimension();
	protected BufferedImage image;
	protected Graphics2D graphics;
	protected long startTime;
	
	
	

	public abstract void loadImageFromFilename(String filename);
	// /GETTERS

	public Point getPosition()
	{
		return position;
	}
	public Dimension getSize()
	{
		return size;
	}
	public boolean isError()
	{
		return this.error;
	}
	public long getStartTime()
	{
		return this.startTime;
	}

	
	// SETTERS

	public void setPosition(Point p)
	{
		position = p;
	}
	public void setPosition(int x, int y)
	{
		position.x = x;
		position.y = y;
	}
	public void setSize(Dimension dim)
	{
		size = dim;
	}
	public void setSize(int w, int h)
	{
		size.width = w;
		size.height = h;
	}
	public GameObject setStartTime(long startTime)
	{
		this.startTime=startTime;
		return this;
	}
	
	//METHODS
	
	protected void Paint(Graphics g)
	{
		this.graphics = (Graphics2D) g;		
		graphics.drawImage(image,this.getPosition().x,this.getPosition().y,this.getSize().width,this.getSize().height,null);
	}
	
	
	protected void loadImage(String imageName) throws IOException
	{
		this.image=ImageIO.read(new File(imageName));
		
	}
	
	public void moveLeft(int value)
	{
		position.x-=value;
		
	}
	public void moveRight(int value)
	{
		position.x+=value;
		
	}
	public void moveUp(int value)
	{
		position.y-=value;
		
	}
	public void moveDown(int value)
	{
		position.y+=value;
		
	}
	
	
	
}
