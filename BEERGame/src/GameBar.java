import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameBar extends JMenuBar {
	public Launcher l;

	public GameBar(JFrame frame, Launcher launch) {
		frame = frame;
		l = launch;
		JMenu languageMenu = new JMenu("Language");
		JMenuItem french = new JMenuItem("French");
		french.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameBar.this.l.getGame().setLanguage("french");
				GameBar.this.l.getGamePanel().repaint();
				GameBar.this.l.getGamePanel().getSidePanel().updateText();
			}

		});
		languageMenu.add(french);
		JMenuItem english = new JMenuItem("English");
		english.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameBar.this.l.getGame().setLanguage("english");
				GameBar.this.l.getGamePanel().repaint();
				GameBar.this.l.getGamePanel().getSidePanel().updateText();
			}

		});
		languageMenu.add(english);
		this.add(languageMenu);
	}
}