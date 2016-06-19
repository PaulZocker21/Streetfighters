package us.paul.walid;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game extends JFrame implements ActionListener{

	public static final int WIDTH = 300;
	public static final int HEIGHT = WIDTH/16*9;
	public static final int SCALE = 3;
	
	private JButton start;
	private JButton info;
	private JButton end;
	
	public static void main(String[] args){
		Game game = new Game("");
		
		
		game.setResizable(false);
		game.setSize(WIDTH,HEIGHT*SCALE);
		game.setTitle("Menu");

		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setLocationRelativeTo(null);
		game.setLayout(null);

		game.setVisible(true);
	}
	
	public Game(String title){
		super(title);
		
		start = new JButton("START");
		start.setBounds(WIDTH/2-80,HEIGHT-40, 160, 40);
		start.addActionListener(this);
		add(start);
		
		info = new JButton("INFO");
		info.setBounds(WIDTH/2-80,HEIGHT+20, 160, 40);
		info.addActionListener(this);
		add(info);
		
		end = new JButton("END");
		end.setBounds(WIDTH/2-80,HEIGHT+80, 160, 40);
		end.addActionListener(this);
		add(end);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()== start){
			InGame();;
		}
		
		if(e.getSource()== info){
			Object[] option = {"OK"};
			JOptionPane.showOptionDialog(null, "by Paul && Walid", "Credits", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
		}
		
		if(e.getSource()== end){
			System.exit(0);
		}
	}

	private void InGame() {
		JFrame InGame = new JFrame();	
		
		InGame.setResizable(false);
		InGame.setSize(WIDTH*SCALE,HEIGHT*SCALE);
		InGame.setTitle("FIGHT!");

		InGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InGame.setLocationRelativeTo(null);
		
		InGame.add(new Screen());
		
		InGame.setVisible(true);
		
	}
}
