
/**
 * @author vitalema and hannantt
 *
 *This class represents the current state of the game
 */
public class Game {
	Player currentPlayer;
	View currentView;
	boolean isMuted;
	boolean isPaused;
	
	/**
	 * @param p - the player who is playing the game.
	 * @param v - the starting view 
	 * 
	 * The constructor for making a new game instance.
	 */
	public Game(Player p, View v){
		currentPlayer = p;
		currentView = v;
		isMuted = false;
		isPaused = false;
	}
	
	/**
	 * @return the current view
	 */
	public View getCurrentView() {
		return this.currentView;
	}
	
	/**
	 * @return the current player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	void changeView(View v){
		currentView = v;
		}
	void pauseGame(){
		isPaused = true;
	}
	void unpauseGame(){
		isPaused = false;
	}
	void muteGame(){
		isMuted = true;
	}
	void unmuteGame(){
		isMuted = false;
	}
	
	Boolean isMuted(){
		return isMuted;
	}
	
	Boolean isPaused(){
		return isPaused;
	}
}
