import java.io.Serializable;
import java.util.TimerTask;

/**
 * @author vitalema and hannantt
 * 
 *         This class represents the current state of the game
 */
@SuppressWarnings("serial")
public class Game extends TimerTask implements Serializable {
	/**
	 * 
	 */
	Player currentPlayer;
	View currentView;
	boolean isMuted;
	boolean isPaused;
	String language;
	Item dynamiteItem;
	View pauseView;

	/**
	 * @param p
	 *            - the player who is playing the game.
	 * @param v
	 *            - the starting view
	 * @param pauseV
	 *            - the pause view The constructor for making a new game
	 *            instance.
	 */
	public Game(Player p, View v, View pauseV) {
		language = "english";
		currentPlayer = p;
		currentView = v;
		isMuted = false;
		isPaused = false;
		pauseView = pauseV;
	}

	/**
	 * @param lang
	 *            - the language for the game to be run in
	 * 
	 *            set what language the game should be in
	 */
	public void setLanguage(String lang) {
		this.language = lang;
	}

	/**
	 * @param i
	 *            - dynamite item sets the dynamite item
	 */
	public void setDynamiteItem(Item i) {
		this.dynamiteItem = i;
	}

	/**
	 * @return the dynamite item
	 */
	public Item getDynamiteItem() {
		return this.dynamiteItem;
	}

	/**
	 * @return the current view
	 */
	public View getCurrentView() {
		return this.currentView;
	}

	/**
	 * @return the pause view
	 */
	public View getPauseView() {
		return this.pauseView;
	}

	/**
	 * @return the language the game should be played in.
	 */
	public String getLanguage() {
		return this.language;
	}

	/**
	 * @return the current player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	void changeView(View v) {
		currentView = v;
	}

	void pauseGame() {
		isPaused = true;
	}

	void unpauseGame() {
		isPaused = false;
	}

	void muteGame() {
		isMuted = true;
	}

	void unmuteGame() {
		isMuted = false;
	}

	Boolean isMuted() {
		return isMuted;
	}

	Boolean isPaused() {
		return isPaused;
	}

	@Override
	public void run() {
		changeView(currentView.getRegions().get(0).getWaitView());

	}
}
