import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Launcher {

	/**
	 * @param args
	 */
	public ImageIcon image;
	private Player p;
	private View v;
	private Game game;

	public Launcher() {
		this.image = new ImageIcon("main.jpg");
		this.p = new Player("Tyler");
		this.v = new View("main image view", image);
		v.addRegion(new Region(56, 320, 25, 60));
		this.game = new Game(p, v);
	}

	public static void main(String[] args) {
		Launcher l = new Launcher();
		GamePanel panel = new GamePanel(l.image.getImage(), l.game);
		JFrame frame = new JFrame();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}



