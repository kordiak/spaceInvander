
public interface IFightable
{

	
	
	
	public boolean shoot();
	public void hit();
	
	public int getHits();
	public int getShots();
	
	
	public void shotAchivedPosition();
	//Used when we want to know that our bullet was destroyed.
	
	public void setLimitOfShots(int value);
	//Used when we want to set the limit of possible shots.
	
	
	
	
	
	
}
