package spaceInvader.game;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JFrame;

import javax.swing.SwingUtilities;





public class Player extends JFrame implements KeyListener
{
	  public Player() {

	        initUI();
	    }
	  private Surface gracz;

	    private void initUI() {

	        setTitle("Simple Java 2D example");

	        gracz=new Surface();
	        
	        
	        add(gracz);
	        

	        setSize(500, 500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        
	        
	        loop();
	    }
	    public void moveGracz()
	    {
	    	gracz.moveToRight();
	    }
	    private void loop()
	    {
	    	for(int i=0;i<200;i++)
	    	{
	    		moveGracz();
	    		
	    		
	    	}
	    	
	    
	    }

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			moveGracz();
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		

}
