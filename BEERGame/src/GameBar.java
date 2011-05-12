import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameBar extends JMenuBar {
	private Launcher l;
	private JMenuItem french;
	private JMenuItem english;
	private JMenu languageMenu;
	public GameBar(JFrame frame, Launcher launch) {
		frame = frame;
		l = launch;
		languageMenu = new JMenu("Language");
		french = new JMenuItem("French");
		french.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameBar.this.l.getGame().setLanguage("french");
				GameBar.this.languageMenu.setText("Language in french");
				GameBar.this.l.getFrame().setTitle(GameBar.this.l.getUserName() +"'s game in french");
				GameBar.this.l.getGamePanel().repaint();
				GameBar.this.l.getGamePanel().getSidePanel().updateText();
			}

		});
		languageMenu.add(french);
		english = new JMenuItem("English");
		english.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameBar.this.l.getGame().setLanguage("english");
				GameBar.this.languageMenu.setText("Language");
				GameBar.this.l.getFrame().setTitle(GameBar.this.l.getUserName()+ "'s game");
				GameBar.this.l.getGamePanel().repaint();
				GameBar.this.l.getGamePanel().getSidePanel().updateText();
			}

		});
		languageMenu.add(english);
		this.add(languageMenu);
	}
}