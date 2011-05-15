import java.awt.FlowLayout;
import java.awt.Point;
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
 *         the class that launches the game.
 */
public class Launcher {

	private Game game;
	private GamePanel gamePanel;
	private JFrame frame;
	private String userName;

	/**
	 * on creation of a Launcher object, the game is created and initialized
	 */
	public Launcher() {
		Item dynamiteItem = new Item("dynamite",
				"this dynamite can be used to blow things up, be careful!",
				new ImageIcon("images/dynamite.jpg"), new Region(15, 300, 70,
						70), "matches description in french");
		Item matchesItem = new Item("matches",
				"these matches can be used to light things on fire",
				new ImageIcon("images/matches.jpg"),
				new Region(15, 150, 70, 70), "matches description in french");
		Item keysItem = new Item("keys",
				"these keys unlock security deposity boxes", new ImageIcon(
						"images/keys.jpg"), new Region(15, 75, 70, 70),
				"taser description in french");
		Item taserItem = new Item("taser", "this taser hurts bad guys",
				new ImageIcon("images/taser.jpg"), new Region(15, 0, 70, 70),
				"taser description in french");
		Item stringItem = new Item("string", "a very simple string",
				new ImageIcon("images/string.jpg"),
				new Region(15, 225, 70, 70), "string description in french");
		Item dynamiteWithStringItem = new Item("dynamitewithstring", "dynamite with string",
				new ImageIcon("images/stringanddynamite.jpg"), new Region(15, 225, 70, 70),
				"dynamite with string in french");
		
		
		Region newGame = new Region(0,0,800,600);
		View gameOverView = new View("you win", new ImageIcon("images/youwin.jpg"),
				"you win in french", new ImageIcon("images/youwinfrench.jpg"), newGame);
		Region endGameRegion = new Region(gameOverView,new Point(0,0) ,800,600, gameOverView); 
		View dynamiteLitView = new View("the dynamite is lit, back away!", new ImageIcon("images/vaultdynamitematch.jpg"),
				"the dynamite is lit in french", endGameRegion);
		Region dynamiteRegionOnGround = new Region(new Point(114,294),560,566, dynamiteLitView, matchesItem);
		View dynamiteView = new View("dynamite is on the ground", new ImageIcon("images/vaultdynamite.jpg"),
				"dynamite is on ground in french", dynamiteRegionOnGround);
		Region setDynamite = new Region(new Point(114,294),560,566,dynamiteView, dynamiteWithStringItem);
		View vaultMain = new View("vault main view", new ImageIcon("images/vaultmain.jpg"),
				"vault main view in french",setDynamite);
		Region leftRegion = new Region(0,0,100,600, vaultMain);
		View emptyDepositBoxes = new View("empty deposit boxes", new ImageIcon("images/depositboxesempty.jpg"),
				"empty deposit boxes in french", leftRegion);
		Region dynamiteRegion = new Region(new Point(221,101),132,60,dynamiteItem, emptyDepositBoxes);
		View depositBoxesDynamite = new View("deposit boxes dynamite", new ImageIcon("images/depositboxesdynamite.jpg"),
				"deposit boxes dynamite in french", dynamiteRegion);
		
		Region dynamiteBox = new Region(new Point(190,90),182,83,depositBoxesDynamite, keysItem);
		View depositBoxesNoString = new View("deposit boxes no string", new ImageIcon("images/depositboxesstringempty.jpg"),
				"deposit boxes no string french", dynamiteBox);
		Region stringRegion = new Region(new Point(526,186),100,55,stringItem, depositBoxesNoString);
		View depositBoxStringView = new View("deposit box with string", new ImageIcon("images/depositboxesstring.jpg"),
				"deposit box with string french", stringRegion);
		Region depositBoxString = new Region(new Point(515,169), 142, 98,depositBoxStringView, keysItem);
		View depositBoxes = new View("deposit boxes", new ImageIcon("images/depositboxes.jpg"),
				"deposit boxes in french", depositBoxString);
		Region rightRegionVault = new Region(700,0,100,600, depositBoxes);
		View firstVaultView = new View("people yelling help", new ImageIcon("images/vaultmainhelp.jpg"),
				"people yelling help in french",new ImageIcon("images/vaultmainhelpfrench.jpg"),rightRegionVault);
		Region rightRegion = new Region(700,0,100,600, firstVaultView);
		
		View matchesEmptyDeposit = new View("matches deposit box empty", new ImageIcon("images/matchesdepositboxempty.jpg"),
				"matches deposit box empty in french", new ImageIcon("images/matchesdepositboxemptyfrench.jpg"), rightRegion);
		Region matchesRegion = new Region(new Point(378,172),116,88,matchesItem,matchesEmptyDeposit);
		View matchDepositBoxView = new View("matches deposit box", new ImageIcon("images/matchesdepositbox.jpg"),
				"matches deposit box in french", new ImageIcon("images/matchesdepositboxfrench.jpg"), matchesRegion);
		Region matchDepositBox = new Region(new Point(378,177),144,88,matchDepositBoxView, keysItem);
		View robberDownKeys = new View("the keys are gone", new ImageIcon("images/robberdownnokeys.jpg")
		, "the keys are gone in french", new ImageIcon("images/robberdownnokeysfrench.jpg"),matchDepositBox);
		Region keyRegion = new Region(new Point(520, 520), 85, 60, keysItem, robberDownKeys);
		View robberDown = new View("the robber is unconscious", new ImageIcon(
				"images/robberdown.jpg"),
				"the robber is unconscious in french", new ImageIcon(
						"images/robberDown.jpg"), keyRegion);
		Region badGuyRegion = new Region(new Point(435, 111), 200, 300, robberDown,
				taserItem);
		View noTaser = new View("taser is gone", new ImageIcon(
				"images/noTaser.jpg"), "taser is gone french", new ImageIcon(
				"images/noTaserFrench.jpg"), badGuyRegion);

		Region taserRegion = new Region(new Point(32, 495), 60, 90, taserItem, noTaser);
		View main = new View("opening view in english", new ImageIcon(
				"images/main.jpg"), "opening view in french", new ImageIcon(
				"images/mainfrench.jpg"), taserRegion);
		Region homeRegion = new Region(0, 0, 800, 600, main);
		View home = new View("home view in english", new ImageIcon(
				"images/homeEnglish.jpg"), "home view in french",
				new ImageIcon("images/homeFrench.jpg"), homeRegion);

		Player p = new Player("Tyler");
		this.game = new Game(p, home);
		getGame().setDynamiteItem(dynamiteWithStringItem);

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
	
	public void setGamePanel(GamePanel p) {
		this.gamePanel = p;
	}

	public void writeGame(Game  g) throws Exception {
		ObjectOutputStream objectOut = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("objects.bin")));
		objectOut.writeObject(g);
		objectOut.close();
	}

	public Game readGame() throws Exception {
		ObjectInputStream objectIn = null;

		objectIn = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("objects.bin")));

		return (Game) objectIn.readObject();

	}
	public JFrame getFrame() {
		return this.frame;
	}
	
	public String getUserName() {
		return this.userName;
	}

	/**
	 * @param args
	 * @throws Exception
	 * 
	 *             the main method for BEER. This creates the game and launches
	 *             the GUI
	 */
	public static void main(String[] args) throws Exception {
		Launcher l = new Launcher();
		//l.writeGame(l.getGame());

		// l.setGame(l.readGame());
		l.userName = JOptionPane.showInputDialog(null,
				"What is your name?", "Enter your name",
				JOptionPane.QUESTION_MESSAGE);
		l.getGame().getCurrentPlayer().setPlayerName(l.userName);
		SidePanel sidePanel = new SidePanel(l);
		l.gamePanel = new GamePanel(l, sidePanel);
		l.frame = new JFrame();

		GameBar bar = new GameBar(l.frame, l);
		l.frame.setTitle(l.userName + "'s Game");
		l.frame.setJMenuBar(bar);
		l.frame.setLayout(new FlowLayout());
		l.frame.add(l.gamePanel);
		l.frame.add(sidePanel);

		l.frame.pack();
		l.frame.setVisible(true);
	}

}
