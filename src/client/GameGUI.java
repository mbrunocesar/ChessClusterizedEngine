package client;

import javax.swing.JPanel;

import javax.swing.JFrame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;


public class GameGUI extends Thread {
	JFrame mainWindow;
	JPanel panel;
	Canvas squares[][];

	Color white = Color.WHITE;
	Color black = Color.GREEN;
	

	public static void main(String[] args) {
		GameGUI gg = new GameGUI();
		gg.start();
	}
	
	public GameGUI() {
		mainWindow = new JFrame("Chess Game");
		squares = new Canvas[8][8];
		
		Dimension baseDimension = new Dimension(50, 50);
		boolean isWhite = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Canvas currentSquare = new Canvas();
				currentSquare.setBackground(isWhite ? white : black);
				currentSquare.setLocation((50 * i), (50 * j));
				currentSquare.setPreferredSize(baseDimension);
				currentSquare.setVisible(true);
				isWhite = !isWhite;
				
				squares[i][j] = currentSquare;
			}
			isWhite = !isWhite;
		}

		panel = new JPanel();

		panel.setPreferredSize(new Dimension(460, 460));

		mainWindow.add(panel);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				panel.add(squares[i][j]);
			}
		}

		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.pack();
	}

	@Override
	public void run() {	
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.err.println("[ERROR] Thread Killed");
			}
		}

	}

}
