import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Surface extends JPanel
{

	// Image of every object
	private BufferedImage playerG;
	private BufferedImage enemyG;
	private BufferedImage lightG;

	private int w, h;
	private Player player;

	// /////////////////////
	// /______PLAYER____///
	// ///////////////////

	// Starting positions of player

	private int xPosition = 0;
	private int yPosition = 465;

	// Set maximal possible positions of Player
	private int maxLeft = 0;
	private int maxRight = 100;

	//
	private int counterOfHits = 0;
	private boolean isPlayerAlive = true;
	private int points = 0;

	// true if Player has killed all the enemies
	private boolean amIRambo = false;

	// Starting positions of enemies -- changed in setEnemies function

	private int yPositionEnemy = 0;
	private int xPositionEnemy = 0;

	Player playerO = new Player(0, 0, 75, 75, maxLeft, 600);
	Enemy wrod = new Enemy(100, 100, 100, 100);

	public boolean isRambo()
	{
		return amIRambo;
	}
	public boolean isAlive()
	{
		return isPlayerAlive;
	}

	private long startTime;

	public void setX(int x)
	{
		xPosition = x;
	}

	public void setY(int y)
	{
		yPosition = 0;
	}

	public void moveRight()
	{
		if (xPosition < maxRight - 80 - 5)
			xPosition += 5;

	}

	public void moveLeft()
	{
		if (xPosition > maxLeft)
			xPosition -= 5;
	}

	public void fire()
	{
		if (playerO.shoot())
		{
			Dimension bulletSize = new Dimension(9, 9);
			bulletsO.add(new Bullet(playerO.getPosition().x + 20, playerO
					.getPosition().y, bulletSize.width, bulletSize.height, 0,
					playerO));
		}
	}

	ArrayList<Point> Enemies = new ArrayList<Point>();
	ArrayList<Point> bullets = new ArrayList<Point>(); // p.x+=1;
	ArrayList<Point> enemyBullet = new ArrayList<Point>();
	ArrayList<Bullet> enemyBulletO = new ArrayList<Bullet>();
	ArrayList<Bullet> bulletsO = new ArrayList<Bullet>();
	ArrayList<Enemy> EnemiesO = new ArrayList<Enemy>();

	public void resetPlayer()
	{

		startTime = 0;
		this.counterOfHits = 0;
		if (!isPlayerAlive)
			points -= 10;
		isPlayerAlive = true;

		amIRambo = false;
		xPosition = 0;
		yPosition = 465;
		xPositionEnemy = 0;
		yPositionEnemy = 0;
		EnemiesO.clear();
		// enemyBullet.clear();
		enemyBulletO.clear();
		bulletsO.clear();

		setEnemies();

	}

	public Surface()
	{
		setEnemies();
	}

	public void setEnemies()
	{

		EnemiesO.add((Enemy) new Enemy(xPosition + 30, 0, 80, 80)
				.setStartTime(startTime));
		EnemiesO.add((Enemy) new Enemy(xPosition + 80 + 30, 0, 80, 80)
				.setStartTime(startTime));
		EnemiesO.add((Enemy) new Enemy(xPosition + 160 + 30, 0, 80, 80)
				.setStartTime(startTime));

		playerO = (Player) new Player(0, 0, 75, 75, maxLeft, 600)
				.setStartTime(startTime);

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if (playerO.getState())
		{
			this.doDrawings(g);

		} else
		{

			isPlayerAlive = false;
			return;
		}

	}

	public void doDrawings(Graphics g)
	{
		Graphics2D graphics2D = (Graphics2D) g;

		Dimension size = getSize();
		Insets insets = getInsets();

		// /Get windows size
		w = size.width - insets.left - insets.right;
		h = size.height - insets.top - insets.bottom;
		maxRight = w;
		graphics2D.setColor(Color.black);
		graphics2D.fillRect(0, 0, w, h);

		wrod.moveDown(3);
		wrod.Paint(graphics2D);

		this.drawStars(graphics2D);

		if (isPlayerAlive)
		{

			playerO.setPosition(xPosition, h - 80);
			playerO.Paint(graphics2D);

		}

		// Player has killed all the enemies
		if (EnemiesO.size() == 0)
		{
			this.amIRambo = true;
		}

		

		// //////////////////////////////////
		// //////////Enemies move////////////
		// //////////////////////////////////
		this.moveTheEnemies(System.currentTimeMillis(), startTime, graphics2D);
		
		// ///////////////////////////////////////
		// /////////////////////Players's bullets
		// //////////////////////////////////////
		this.movePlayersBullets(graphics2D);

		// ///////////////////////////////////////
		// /////////////////////Enemies's bullets
		// //////////////////////////////////////
		this.moveEnemiesBullets(graphics2D);
		
		
		

		graphics2D.setColor(Color.orange);
		graphics2D.drawString("POINTS: " + this.points, w - 80, h - 10);
	}
	// //Functions:

	private void moveTheEnemies(long endTime, long startTime,
			Graphics2D graphics2D)
	{

		
		for (Enemy p : EnemiesO)
		{

			if ((((endTime - startTime)) / 1000) % 5 == 0)
			{

				p.moveDown(1);
			} else
			{
				if ((((endTime - startTime)) / 1000) % 2 == 1)
				{
					p.moveRight(1);

				} else
					p.moveLeft(1);
			}

			if ((p.getPosition().y + 65 > yPosition
					&& p.getPosition().x + 35 > xPosition && p.getPosition().x + 35 < xPosition + 65)
					|| p.getPosition().y > h)

			{
				isPlayerAlive = false;

			}

			p.Paint(graphics2D);

			yPositionEnemy = p.getPosition().y;

			xPositionEnemy = p.getPosition().x;

			int xMin = xPositionEnemy;
			int xMax = xPositionEnemy + 65;

			int yMin = yPositionEnemy;
			int yMax = yPositionEnemy + 65;

			graphics2D.setColor(Color.orange);
			// ENEMY SHOOTING
			if ( endTime % 5 == 0)
				if (xPosition > xMin && xPosition + 20 < xMin + 70 && p.shoot())
				{
					Dimension bulletSize = new Dimension(9, 9);

					enemyBulletO.add(new Bullet(p.getPosition().x + 20, p
							.getPosition().y + p.getSize().height,
							bulletSize.width, bulletSize.height, h, p));

				}

		}

	}
	private void movePlayersBullets(Graphics2D graphics2D)
	{
		Enemy toRemove = null;
		for (Bullet singleB : bulletsO)
		{
			boolean shouldIBreak = false;

			if (singleB.getState())
			{
				singleB.Paint(graphics2D);
				singleB.moveUp(2);
				for (Enemy p : EnemiesO)
				{
					singleB.hit(p);
					if (!p.getState())
					{

						toRemove = p;
						points += 10;
						// EnemiesO.remove(p);
						bulletsO.remove(singleB);
						shouldIBreak = true;
						break;
					}

				}
			} else
			{
				bulletsO.remove(singleB);
				break;
			}
			if (shouldIBreak)
				break;
		}
		EnemiesO.remove(toRemove);
	}
	private void moveEnemiesBullets(Graphics2D graphics2D)
	{
		for (Bullet singleB : enemyBulletO)
		{

			if (singleB.getState())
			{

				int speed=2;
				
				switch(EnemiesO.size())
				{
					case 1: speed=4;break;
					case 2:speed=3;break;
				}
				
				
					singleB.moveDown(speed);
				singleB.Paint(graphics2D);
				singleB.hit(playerO);
			} else

			{
				enemyBulletO.remove(singleB);
				break;
			}

		}

	}
	private void drawStars(Graphics2D graphics2D)
	{
	Random r = new Random();
	// /Draw "stars"
	for (int i = 0; i < 50; ++i)
	{
		graphics2D.setColor(Color.blue);
		int x = Math.abs(r.nextInt()) % w;
		int y = Math.abs(r.nextInt()) % h;
		int length = Math.abs(r.nextInt()) % 15;
		if (Math.abs(r.nextInt() % 20) < 5)
		{
			graphics2D.setColor(Color.gray);
		}

		graphics2D.drawLine(x, y, x, y + length);
	}
	}
}
