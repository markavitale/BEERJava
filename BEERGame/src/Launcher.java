import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Launcher {

	/**
	 * @param args
	 */
	private ImageIcon image;
	private Player p;
	private View v1;
	private View v2;
	private Game game;

	public Launcher() {
		this.image = new ImageIcon("main.jpg");
		this.p = new Player("Tyler");
		Item taserItem = new Item("taser", "this taser hurts bad guys",new ImageIcon("taser.jpg"));
		Region taserRegion = new Region(56, 320, 25, 60, taserItem);
		this.v1 = new View("main image view", image);
		this.v2 = new View("taser is gone!",new ImageIcon("notaser.jpg"));
		v1.addRegion(taserRegion);
		v1.addView(v2);
		this.game = new Game(p, v1);
	//	ctx.bind("game1", game);

	}
	public Game getGame() {
		return this.game;
	}

	public static void main(String[] args) throws Exception {
		Launcher l = new Launcher();
		ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(
		        new FileOutputStream("C:/Users/Administrator/Documents/csse376/BEERJava/BEERGame/objects.bin")));
		objectOut.writeObject(l.game);
		ObjectInputStream objectIn = null;
		Game game2 = null;
		objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(
        "C:/Users/Administrator/Documents/csse376/BEERJava/BEERGame/objects.bin")));
		objectOut.close();
		game2 = (Game) objectIn.readObject();
		objectIn.close();
		InventoryPanel invPanel = new InventoryPanel(game2);
		GamePanel panel = new GamePanel(game2, invPanel);
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.add(panel);
		frame.add(invPanel);
		frame.pack();
		frame.setVisible(true);
	}


}



