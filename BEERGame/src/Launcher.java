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
		View noTaserFrench = new View("taser is gone french", new ImageIcon("images/noTaserFrench.jpg"),badGuyRegion);
		View noTaser = new View("taser is gone", 
			new ImageIcon("images/noTaser.jpg"), noTaserFrench, badGuyRegion);
		Item taserItem = new Item("taser", "this taser hurts bad guys",new 
			ImageIcon("images/taser.jpg"), new Region(0,0,32,60));
		Region taserRegion =new Region(32, 495, 60, 90, taserItem, noTaser);
		View mainFrench = new View("opening view in french",
				new ImageIcon("images/mainfrench.jpg"), taserRegion);
		View main = new View("opening view in english", 
				new ImageIcon("images/main.jpg"), mainFrench, taserRegion);
		Region homeRegion = new Region(0,0,800,600, main);
		View homeFrench = new View("home view in french", 
				new ImageIcon("images/homeFrench.jpg"), homeRegion);
		View home = new View("home view in english",
				new ImageIcon("images/homeEnglish.jpg"), homeFrench, homeRegion);
		
		
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
	//	l.writeGame(l);
		
		
		
		//l.setGame(l.readGame());
		String response = JOptionPane.showInputDialog(null, "What is your name?",
				  "Enter your name", JOptionPane.QUESTION_MESSAGE);
		l.getGame().getCurrentPlayer().setPlayerName(response);
		InventoryPanel invPanel = new InventoryPanel(l.getGame());
		l.gamePanel = new GamePanel(l.getGame(), invPanel);
		JFrame frame = new JFrame();
		GameBar bar = new GameBar(frame, l);
		frame.setTitle(response +"'s Game");
		frame.setJMenuBar(bar);
		frame.setLayout(new FlowLayout());
		frame.add(l.gamePanel);
		frame.add(invPanel);
		frame.pack();
		frame.setVisible(true);
	}



}



