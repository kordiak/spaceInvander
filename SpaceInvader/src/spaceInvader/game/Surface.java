package spaceInvader.game;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

class Surface extends JPanel {

	private Rectangle rect =new Rectangle(0, 0, 20, 20);

	public void moveToRight() {
		System.out.print(rect);
		Point point =rect.getLocation();
		point.x=point.x+1;
		point.y=point.y+1;
		rect.setLocation(point.x, point.y);

	}

	private void createPicture() {

		// image=ImageIO.read(new File("enemy3.png"));

		

	}

	private void doDrawing(Graphics g) {

		//createPicture();
		Graphics2D g2d = (Graphics2D) g;

		// g2d.drawString("Java 2D", 50, 50);
		// g2d.drawRect(WIDTH/2, HEIGHT/2, 100, 100);

		// ImageObserver observer = null;
		// g2d.drawImage(image, 0, 0, observer);

		// g2d.fillRect(0, 0, 100, 100);
		Color color = new Color(20, 40, 0);
		g2d.setPaint(new GradientPaint(0, 0, color.RED, 100, 0, color.RED));
		g2d.draw(rect);
		g2d.setPaint(new GradientPaint(0, 0, color.WHITE, 100, 0, color.BLACK));

		

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}
}
