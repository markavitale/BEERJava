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

	private ImageIcon image;
	private Player p;
	private View v1;
	private View v2;
	private View v3;
	private Game game;
	private String language;
	private GamePanel gamePanel;

	/**
	 * on creation of a Launcher object, the game is created and initialized
	 */
	public Launcher() {
		this.language = "english";
		this.image = new ImageIcon("main.jpg");
		this.p = new Player("Tyler");
		Item taserItem = new Item("taser", "this taser hurts bad guys",new 
				ImageIcon("taser.jpg"), new Region(0,0,32,60));
		Region taserRegion = new Region(56, 320, 25, 60, taserItem);
		
		this.v3 = new View("french image view",
				new ImageIcon("mainfrench.jpg"));
		this.v1 = new View("main image view", image, v3);
		this.v2 = new View("taser is gone!",new ImageIcon("notaser.jpg"));
		v1.addRegion(taserRegion);
		v1.addView(v2);
		this.game = new Game(p, v1);
		

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
		//l.writeGame(l);
		
		
		
		l.setGame(l.readGame());
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

	public static class GameBar extends JMenuBar {
		public Launcher l;
		public GameBar (JFrame frame, Launcher launch) {
			frame = frame;
			l = launch;
			JMenu languageMenu = new JMenu("Language");
			JMenuItem french = new JMenuItem("French");
			french.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					GameBar.this.l.getGame().setLanguage("french");
					GameBar.this.l.gamePanel.repaint();
				}

			});
			languageMenu.add(french);
			JMenuItem english = new JMenuItem("English");
			english.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					GameBar.this.l.getGame().setLanguage("english");
					GameBar.this.l.gamePanel.repaint();
				}

			});
			languageMenu.add(english);
			this.add(languageMenu);
		}
	}


}



