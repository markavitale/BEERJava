
public class Game {
	Player currentPlayer;
	View currentView;
	boolean isMuted;
	boolean isPaused;
	
	public Game(Player p, View v){
		currentPlayer = p;
		currentView = v;
		isMuted = false;
		isPaused = false;
	}
	
	void changeView(View v){
		//TODO
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
}
