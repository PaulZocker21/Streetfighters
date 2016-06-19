package us.paul.walid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.JPanel;

public class Screen extends JPanel implements ActionListener{

	Timer time;
	Image bgimg;
	Image caimg;
	
	int x_Achse, y_Achse;
	int x_run, y_run;
	
	int key;
	
	public Screen(){
		
		setFocusable(true);
		ImageIcon background = new ImageIcon(getClass().getResource("background.jpg"));
		bgimg = background.getImage();
		
		ImageIcon character = new ImageIcon(getClass().getResource("character.png"));
		caimg = character.getImage();
		
		addKeyListener(new AL());
		
		time = new Timer(2,this);
		time.start();
	}
	
	public void actionPerformed(ActionEvent e){
		move();
		repaint();
//		System.out.println(x_Achse);
		
		if(x_Achse > 0){
			x_run = -1;
		}
		
		if(x_Achse < -1015){
			x_run = 1;
		}
	}

	public void paint(Graphics g){
		
		super.paint(g);
		Graphics2D f2 = (Graphics2D)g;
		
		f2.drawImage(bgimg, x_Achse , 0, null);
		f2.drawImage(caimg, x_Achse, 235, null);
	}
	
	private void move() {
		x_Achse += x_run;
		
	}
	
	private class AL extends KeyAdapter{
		public AL(){}
		
		public void keyPressed(KeyEvent e){
			key = e.getKeyCode();
			
			if( key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D){
				x_run = -1;
			}
			if( key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A){
				x_run = 1;
			}

		}
		public void keyReleased(KeyEvent e){
			
			key = e.getKeyCode();
			
			if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A){
				x_run = 0;
			}
			
		}

	}
}

