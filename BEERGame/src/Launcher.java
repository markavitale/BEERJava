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
	private View v1;
	private View v2;
	private Game game;

	public Launcher() {
		this.image = new ImageIcon("main.jpg");
		this.p = new Player("Tyler");
		Item taserItem = new Item("taser", "this taser hurts bad guys");
		Region taserRegion = new Region(56, 320, 25, 60, taserItem);
		this.v1 = new View("main image view", image);
		this.v2 = new View("taser is gone!",new ImageIcon("notaser.jpg"));
		v1.addRegion(taserRegion);
		v1.addView(v2);
		this.game = new Game(p, v1);
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



