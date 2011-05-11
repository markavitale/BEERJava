import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class SidePanel extends JPanel {
	private Launcher l;
	private InventoryPanel invPanel;
	private JTextArea textAreaViews;
	
	public SidePanel(Launcher launch) {
		l = launch;
		textAreaViews = new JTextArea(l.getGame().getCurrentView().getCurrentDescription(),3,1);
		textAreaViews.setLineWrap(true);
		textAreaViews.setWrapStyleWord(true);
		textAreaViews.setEditable(false);
		JPanel top = new JPanel();
		top.add(textAreaViews);
		JPanel middle = new JPanel();
		invPanel = new InventoryPanel(l.getGame());
		middle.add(invPanel);
		JPanel bottom = new JPanel();
		JTextArea textAreaBottom = new JTextArea("item descriptions");
		textAreaBottom.setEditable(false);
		bottom.add(textAreaBottom);
		top.setPreferredSize(new Dimension(100, 100));
		middle.setPreferredSize(new Dimension(100, 300));
		bottom.setPreferredSize(new Dimension(100, 100));
		setPreferredSize(new Dimension(100, 600));
		this.setLayout(new FlowLayout());
		add(top);
		add(middle);
		add(bottom);
		//this.setBackground(Color.WHITE);
	}
	
	public InventoryPanel getInvPanel() {
		return this.invPanel;
	}
	
	public void updateText() {
		if (l.getGame().getLanguage() == "english") {
		textAreaViews.setText(l.getGame().getCurrentView().getCurrentDescription());
		} else {
			if (l.getGame().getCurrentView().getFrenchAlternate()!= null) {
			textAreaViews.setText(l.getGame().getCurrentView().getFrenchAlternate().getCurrentDescription());
		}
		}


	}

	}

