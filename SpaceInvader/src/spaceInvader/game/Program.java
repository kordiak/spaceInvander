package spaceInvader.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JFrame;

import javax.swing.SwingUtilities;

//import android.util.Log;

public class Program  
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.print("S");
		try {
			Runtime.getRuntime().exec("clear");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("K");
			
		}
		System.out.print("W");
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				Surface sk = new Surface();

				//sk.addKeyListener(this);
				//sk.setFocusable(true);
				// Point rv=new Point();

				// sk.setLocation(rv);
				sk.setVisible(true);

			}
		});

	}

	

}
