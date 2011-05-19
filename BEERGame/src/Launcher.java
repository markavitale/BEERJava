import java.awt.FlowLayout;
import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	private GameBar gameBar;

	/**
	 * on creation of a Launcher object, the game is created and initialized
	 */
	public Launcher() {
//		Item dynamiteItem = new Item("dynamite",
//				"The dynamite is missing a wick",
//				new ImageIcon("images/dynamite.jpg"), new Region(15, 300, 70,
//						70), "La dynamite est manquant une mèche");
//		Item matchesItem = new Item("matches",
//				"These matches can light things on fire",
//				new ImageIcon("images/matches.jpg"),
//				new Region(15, 150, 70, 70), "Ces matchs peuvent allumer des choses");
//		Item keysItem = new Item("keys",
//				"These keys unlock safety deposit boxes", new ImageIcon(
//						"images/keys.jpg"), new Region(15, 75, 70, 70),
//				"Ces clefs déverrouiller boîtes de sécurité");
//		Item taserItem = new Item("taser", "This taser can be used on bad guys",
//				new ImageIcon("images/taser.jpg"), new Region(15, 0, 70, 70),
//				"Ce pistolet à impulsion électrique peut être utilisé sur les méchants");
//		Item stringItem = new Item("string", "This string could possibly be used as a wick...",
//				new ImageIcon("images/string.jpg"),
//				new Region(15, 225, 70, 70), "Cette corde peut éventuellement être utilisé comme unemèche...");
//		Item dynamiteWithStringItem = new Item("dynamitewithstring", "The dynamite now has a wick",
//				new ImageIcon("images/stringanddynamite.jpg"), new Region(15, 225, 70, 70),
//				"Maintenant la dynamite a une mèche");
//		
//		
//		Region newGame = new Region(0,0,800,600);
//		View gameOverView = new View("You win", new ImageIcon("images/youwin.jpg"),
//				"Vous avez gagner!", new ImageIcon("images/youwinfrench.jpg"), newGame);
//		Region explosionRegion = new Region(gameOverView, new Point(0,0), 800, 600, gameOverView);
//		View explosionView = new View("kaboom!", new ImageIcon("images/kaboom.jpg"),
//				"Bang!", explosionRegion);
//		Region endGameRegion = new Region(gameOverView,new Point(0,0) ,800,600, explosionView); 
//		View dynamiteLitView = new View("The dynamite is lit, back away!", new ImageIcon("images/vaultdynamitematch.jpg"),
//				"Vous avez allumé la dynamite, reculez!", endGameRegion);
//		Region dynamiteRegionOnGround = new Region(new Point(114,294),560,566, dynamiteLitView, matchesItem);
//		View dynamiteView = new View("You place the dynamite on the ground", new ImageIcon("images/vaultdynamite.jpg"),
//				"Vous mettez la dynamite sur le terrain", dynamiteRegionOnGround);
//		Region setDynamite = new Region(new Point(114,294),560,566,dynamiteView, dynamiteWithStringItem);
//		View vaultMain = new View("You see a closed vault door and trapped employees", new ImageIcon("images/vaultmain.jpg"),
//				"Vous voyez une porte fermée  et les employés attraper",setDynamite);
//		Region leftRegion = new Region(0,0,100,600, vaultMain);
//		View emptyDepositBoxes = new View("You took the dynamite", new ImageIcon("images/depositboxesempty.jpg"),
//				"Vous avez pris la dynamite", leftRegion);
//		Region dynamiteRegion = new Region(new Point(221,101),132,60,dynamiteItem, emptyDepositBoxes);
//		View depositBoxesDynamite = new View("There is dynamite in the deposit box", new ImageIcon("images/depositboxesdynamite.jpg"),
//				"Il y a de la dynamite dans la boîte", dynamiteRegion);
//		
//		Region dynamiteBox = new Region(new Point(190,90),182,83,depositBoxesDynamite, keysItem);
//		View depositBoxesNoString = new View("You took the string", new ImageIcon("images/depositboxesstringempty.jpg"),
//				"Vous avez pris la corde", dynamiteBox);
//		Region stringRegion = new Region(new Point(526,186),100,55,stringItem, depositBoxesNoString);
//		View depositBoxStringView = new View("There is a string in the deposit box", new ImageIcon("images/depositboxesstring.jpg"),
//				"Il y a une corde dans la boîte", stringRegion);
//		Region depositBoxString = new Region(new Point(515,169), 142, 98,depositBoxStringView, keysItem);
//		View depositBoxes = new View("A room full of safety deposit boxes", new ImageIcon("images/depositboxes.jpg"),
//				"Une salle plein des boîtes de sécurité", depositBoxString);
//		Region rightRegionVault = new Region(700,0,100,600, depositBoxes);
//		View firstVaultView = new View("Bank employees are stuck in the vault with you!", new ImageIcon("images/vaultmainhelp.jpg"),
//				"Employés de la Banque sont coincés dans la voûte avec vous!",new ImageIcon("images/vaultmainhelpfrench.jpg"),rightRegionVault);
//		Region rightRegion = new Region(700,0,100,600, firstVaultView);
//		
//		View matchesEmptyDeposit = new View("You took the matches", new ImageIcon("images/matchesdepositboxempty.jpg"),
//				"Vous avez pris les matchs", new ImageIcon("images/matchesdepositboxemptyfrench.jpg"), rightRegion);
//		Region matchesRegion = new Region(new Point(378,172),116,88,matchesItem,matchesEmptyDeposit);
//		View matchDepositBoxView = new View("There are matches in the deposit box", new ImageIcon("images/matchesdepositbox.jpg"),
//				"Il y a des matchs dans la boîte", new ImageIcon("images/matchesdepositboxfrench.jpg"), matchesRegion);
//		Region matchDepositBox = new Region(new Point(378,177),144,88,matchDepositBoxView, keysItem);
//		View robberDownKeys = new View("You took the keys from the security guard", new ImageIcon("images/robberdownnokeys.jpg")
//		, "Vous avez pris les clefs du gardien de sécurité", new ImageIcon("images/robberdownnokeysfrench.jpg"),matchDepositBox);
//		Region keyRegion = new Region(new Point(520, 520), 85, 60, keysItem, robberDownKeys);
//		View robberDown = new View("You knocked the robber unconscious", new ImageIcon(
//				"images/robberdown.jpg"),
//				"Vous avez frappé le voleur inconscient", new ImageIcon(
//						"images/robberDown.jpg"), keyRegion);
//		Region badGuyRegion = new Region(new Point(435, 111), 200, 300, robberDown,
//				taserItem);
//		View noTaser = new View("You took the taser", new ImageIcon(
//				"images/noTaser.jpg"), "Vous avez pris le pistolet à impulsion électrique", new ImageIcon(
//				"images/noTaserFrench.jpg"), badGuyRegion);
//
//		Region taserRegion = new Region(new Point(32, 495), 60, 90, taserItem, noTaser);
//		View main = new View("A bank robber has a gun in front of you", new ImageIcon(
//				"images/main.jpg"), "Un braqueur de banque a une pistol en face de vous", new ImageIcon(
//				"images/mainfrench.jpg"), taserRegion);
//		Region homeRegion = new Region(0, 0, 800, 600, main);
//		View home = new View("Welcome to the game", new ImageIcon(
//				"images/homeEnglish.jpg"), "Bienvenue dans le jeu",
//				new ImageIcon("images/homeFrench.jpg"), homeRegion);
//		
//		Region pauseRegion = new Region(0,0,800,600);
//		View pauseView = new View("The game is paused", new ImageIcon(
//				"images/pause.jpg"), "Le jeu est pausé", new ImageIcon(
//						"images/pausefrench.jpg"), pauseRegion);
//		Player p = new Player("Tyler");
//		this.game = new Game(p, home, pauseView);
//		this.game.setDynamiteItem(dynamiteWithStringItem);
		

	}

	/**
	 * @return the game created by this launcher.
	 */
	public Game getGame() {
		return this.game;
	}

	/**
	 * @param g
	 * 			- the game to be set
	 * sets the current game to g
	 */
	public void setGame(Game g) {
		this.game = g;
	}

	/**
	 * @return the gamepanel
	 */
	public GamePanel getGamePanel() {
		return this.gamePanel;
	}
	
	/**
	 * @param p
	 * 			-	the gamepanel to be set
	 * sets the gamepanel
	 */
	public void setGamePanel(GamePanel p) {
		this.gamePanel = p;
	}

	/**
	 * @param g
	 * 			- serializable function to write the current game to file
	 * @throws Exception
	 */
	public void writeGame(Game g) throws Exception {
		ObjectOutputStream objectOut = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("objects.bin")));
		objectOut.writeObject(g);
		objectOut.close();
	}

	/**
	 * @return the game written from file
	 * @throws Exception
	 */
	public Game readGame() throws Exception {
		ObjectInputStream objectIn = null;

		objectIn = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("objects.bin")));
		Game g = (Game) objectIn.readObject();
		objectIn.close();
		return g;

	}
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return this.frame;
	}
	
	void setFrame(JFrame j) {
		frame = j;
	}
	/**
	 * @return the username
	 */
	public String getUserName() {
		return this.userName;
	}
	
	GameBar getGameBar() {
		return gameBar;
	}
	
	void setGameBar(GameBar gB) {
		gameBar = gB;
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
		l.setGame(l.readGame());
		l.getGame().setLanguage("english");
		l.userName = JOptionPane.showInputDialog(null,
				"What is your name?", "Enter your name",
				JOptionPane.QUESTION_MESSAGE);
		l.getGame().getCurrentPlayer().setPlayerName(l.userName);
		SidePanel sidePanel = new SidePanel(l);
		l.gamePanel = new GamePanel(l, sidePanel);
		l.frame = new JFrame();

		l.gameBar = new GameBar(l);
		l.frame.setTitle(l.userName + "'s Game");
		l.frame.setJMenuBar(l.gameBar);
		l.frame.setLayout(new FlowLayout());
		l.frame.add(l.gamePanel);
		l.frame.add(sidePanel);
		
		l.frame.pack();
		l.frame.setVisible(true);
		l.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
