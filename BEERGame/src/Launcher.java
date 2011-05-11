import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 * @author vitalema
 *
 * the class that launches the game.
 */
public class Launcher {

	private Game game;
	private GamePanel gamePanel;

	/**
	 * on creation of a Launcher object, the game is created and initialized
	 */
	public Launcher() {
		
		Region badGuyRegion = new Region(435,111,200,300);
		View noTaser = new View("taser is gone", 
			new ImageIcon("images/noTaser.jpg"), "taser is gone french",
			new ImageIcon("images/noTaserFrench.jpg"), badGuyRegion);
		Item taserItem = new Item("taser", "this taser hurts bad guys",new 
			ImageIcon("images/taser.jpg"), new Region(0,0,32,60), 
			"taser description in french");
		Region taserRegion =new Region(32, 495, 60, 90, taserItem, noTaser);
		View main = new View("opening view in english", 
				new ImageIcon("images/main.jpg"), "opening view in french",
				new ImageIcon("images/mainfrench.jpg"), taserRegion);
		Region homeRegion = new Region(0,0,800,600, main);
		View home = new View("home view in english",
				new ImageIcon("images/homeEnglish.jpg"), "home view in french",
				new ImageIcon("images/homeFrench.jpg"), homeRegion);
		
		
		Player p = new Player("Tyler");
		this.game = new Game(p, home);
		

	}
	/**
	 * @return the game created by this launcher.
	 */
	public Game getGame() {
		return this.game;
	}
	public void setGame(Game g) {
		this.game = g;
	}
	public GamePanel getGamePanel() {
		return this.gamePanel;
	}
	public void writeGame(Launcher l) throws Exception {
		ObjectOutputStream objectOut = new ObjectOutputStream(
				new BufferedOutputStream(
		        new FileOutputStream("objects.bin")));
		objectOut.writeObject(l.getGame());
		objectOut.close();
	}
	public Game readGame() throws Exception {
		ObjectInputStream objectIn = null;
		
		objectIn = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("objects.bin")));
		
		return  (Game) objectIn.readObject();
		
	}
	/**
	 * @param args
	 * @throws Exception
	 * 
	 * the main method for BEER.  This creates the game and launches the GUI
	 */
	public static void main(String[] args) throws Exception {
		Launcher l = new Launcher();
		l.writeGame(l);
		
		
		
		//l.setGame(l.readGame());
		String response = JOptionPane.showInputDialog(null, "What is your name?",
				  "Enter your name", JOptionPane.QUESTION_MESSAGE);
		l.getGame().getCurrentPlayer().setPlayerName(response);
		SidePanel sidePanel = new SidePanel(l);
		l.gamePanel = new GamePanel(l, sidePanel);
		JFrame frame = new JFrame();
	
	
		GameBar bar = new GameBar(frame, l);
		frame.setTitle(response +"'s Game");
		frame.setJMenuBar(bar);
		frame.setLayout(new FlowLayout());
		frame.add(l.gamePanel);
		frame.add(sidePanel);

		frame.pack();
		frame.setVisible(true);
	}



}



