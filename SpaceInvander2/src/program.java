import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
public class program extends JFrame implements KeyListener

{

	/**
	 * @param args
	 */
	private Surface we = new Surface();

	public program()
	{
		InitUI();
	}

	public static void main(String[] args)
	{
		System.out.print("STARTED");
		SwingUtilities.invokeLater(new Runnable() {

			public void run()
			{

				program programFrame = new program();
				programFrame.setVisible(true);


			}

		});
		// TODO Auto-generated method stub

	}

	private void InitUI()
	{
		setTitle("SPACE INVANDER");
		Dimension size=new Dimension(300,600);
		setSize(size);
		setResizable(false);
		
		Timer a = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{

				if (we.isAlive() == false || we.isRambo())
				{
					
					we.resetPlayer();

				}

				we.repaint();
			}
		});
		a.start();
		add(we);
		this.addKeyListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e)
	{

		switch (e.getKeyChar())
			{
				case 'D' :
				case 'd' :
					we.moveRight();
					break;

				case 'a' :
				case 'A' :
					we.moveLeft();
					break;

				case 'w' :
				case 'W' :
					we.fire();
					break;
			}

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

}
