import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Bullet extends GameObject
{

	private PlayableObject parent;
	private int yLimit; // where bullet will be destroyed
	private boolean isAlive = true;

	@Override
	public void loadImageFromFilename(String filename)
	{
		// not used
	}
	public Bullet(int x, int y, int width, int height, int yLimit,
			PlayableObject parent)
	{

		
		setPosition(x, y);
		setSize(width, height);
		this.yLimit = yLimit;
		this.parent = parent;
		startTime=parent.getStartTime();
				

	}
	public Bullet(Point position, Dimension size, int yLimit,
			PlayableObject parent)
	{

		setPosition(position);
		setSize(size);
		this.yLimit = yLimit;
		this.parent = parent;
		startTime=parent.getStartTime();

	}

	// GETTER

	public boolean getState()
	{
		return isAlive;
	}

	// FUNCTIONS

	private void objectHit(PlayableObject antagonist)
	{
		antagonist.hit();
		if (parent != null)
			parent.shotAchivedPosition();
		this.isAlive = false;
	}
	public void hit(PlayableObject antagonist) //,Graphics2D graph
	{
		if (antagonist != null && antagonist != parent)
		{
			int x = antagonist.getPosition().x+5;
			int y = antagonist.getPosition().y;

			int width = antagonist.getSize().width-10;
			int height = antagonist.getSize().height-10;

			int bulletPositionX = this.getPosition().x;
			int bulletPositionY = this.getPosition().y;

			
			//graph.setColor(Color.lightGray);
			//graph.fillRect(x, y, width, height);
			
			

			if (y > parent.getPosition().y)
			{
				
				
				if (bulletPositionY >= y)
				{
					
					if (bulletPositionX+5 >= x && bulletPositionX <= x + width)
					{
						
						objectHit(antagonist);
					}

				}
			}
			// Bullets go from bottom to up
			else
			{
				if (bulletPositionY - this.getSize().height <= y+height)
				{
					if (bulletPositionX >= x && bulletPositionX <= x + width)
					{
						objectHit(antagonist);
					}

				}

			}

		}

	}
	public void moveUp(int value)
	{
		if (this.getPosition().y <= this.yLimit)
		{
			this.isAlive = false;
			if(parent!=null)
				parent.shotAchivedPosition();
			return;
		}

		super.moveUp(value);
	}
	public void moveDown(int value)
	{
		if (this.getPosition().y > this.yLimit)
		{
			this.isAlive = false;
			
			if(parent!=null)
				parent.shotAchivedPosition();
			return;
			
		}
		
		super.moveDown(value);
	}

	public void Paint(Graphics g)
	{

		int x = super.getPosition().x;
		int y = super.getPosition().y;

		
		Graphics2D graphics2D = (Graphics2D) g;
		graphics2D.setColor(Color.red);
		if ((int) (System.currentTimeMillis() - startTime) / 100 % 2 == 0)
		{
			graphics2D.setColor(Color.green);
			graphics2D.fillRoundRect(x, y, 7, 7, 10, 10);
			graphics2D.drawOval(x - 1, y - 1, 9, 9);
		} else
			graphics2D.fillRoundRect(x, y, 7, 7, 10, 10);
	}

}
