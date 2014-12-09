
public class Player extends PlayableObject
{
	
	private int leftMargin;
	private int rightMargin;

	public Player(int x, int y, int width, int height,int leftM,int rightM)
	{
		super(x, y, width, height, "enemy3.png");
		// TODO Auto-generated constructor stub
		
		
		
		
	}
	public void moveLeft(int value)
	{
		
		if (getPosition().x-value <= leftMargin)
		{
			System.out.println("Trying to leave main field");
	
	
		}
		else
			
		super.moveLeft(value);
	}
	
	public void moveRight(int value)
	{
		if (getPosition().x+value >= leftMargin)
		{
			System.out.println("Trying to leave main field");
	
	
		}
		else
			
		super.moveRight(value);
	}
	
	

}
