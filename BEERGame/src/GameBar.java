import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameBar extends JMenuBar implements Serializable {
	private Launcher l;
	private JMenuItem french;
	private JMenuItem english;
	private JMenuItem pause;
	private JMenu fileMenu;
	private JMenuItem newGame;
	public GameBar(JFrame frame, Launcher launch) {
		frame = frame;
		l = launch;
		fileMenu = new JMenu("File");
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameBar.this.l.setGame(GameBar.this.l.getGame());
			}
		});
		
		
		french = new JMenuItem("French");
		french.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameBar.this.l.getGame().setLanguage("french");
				GameBar.this.fileMenu.setText("File in French");
				GameBar.this.newGame.setText("New game in french");
				GameBar.this.l.getFrame().setTitle(GameBar.this.l.getUserName() +"'s game in french");
				GameBar.this.l.getGamePanel().repaint();
				GameBar.this.l.getGamePanel().getSidePanel().updateText();
			}

		});
		fileMenu.add(french);
		english = new JMenuItem("English");
		english.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameBar.this.l.getGame().setLanguage("english");
				GameBar.this.fileMenu.setText("File");
				GameBar.this.newGame.setText("New game");
				GameBar.this.l.getFrame().setTitle(GameBar.this.l.getUserName()+ "'s game");
				GameBar.this.l.getGamePanel().repaint();
				GameBar.this.l.getGamePanel().getSidePanel().updateText();
			}

		});
		fileMenu.add(english);
		pause = new JMenuItem("Pause");
		pause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameBar.this.l.getGame().pauseGame();
				GameBar.this.l.getFrame().setTitle(GameBar.this.l.getUserName()+ "'s game");
				GameBar.this.l.getGamePanel().repaint();
				GameBar.this.l.getGamePanel().getSidePanel().updateText();
			}

		});
		fileMenu.add(pause);
		this.add(fileMenu);
	}
}