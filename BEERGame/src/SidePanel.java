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
	private JTextArea textAreaBottom;
	private JTextArea invDesc;

	public SidePanel(Launcher launch) {
		l = launch;
		textAreaViews = new JTextArea(l.getGame().getCurrentView()
				.getCurrentDescription(), 5, 1);
		textAreaViews.setLineWrap(true);
		textAreaViews.setWrapStyleWord(true);
		textAreaViews.setEditable(false);
		JPanel top = new JPanel();
		top.add(textAreaViews);
		JPanel middle = new JPanel();
		invPanel = new InventoryPanel(l.getGame(), this);
		invDesc = new JTextArea("Inventory");
		invDesc.setEditable(false);
		invDesc.setOpaque(false);
		// invDesc.setBackground(Color.LIGHT_GRAY);
		middle.add(invDesc);
		middle.add(invPanel);
		JPanel bottom = new JPanel();
		textAreaBottom = new JTextArea("no item selected", 4, 1);
		textAreaBottom.setEditable(false);
		textAreaBottom.setLineWrap(true);
		textAreaBottom.setWrapStyleWord(true);
		bottom.add(textAreaBottom);
		top.setPreferredSize(new Dimension(100, 100));
		middle.setPreferredSize(new Dimension(100, 400));
		bottom.setPreferredSize(new Dimension(100, 100));
		setPreferredSize(new Dimension(100, 600));
		this.setLayout(new FlowLayout());
		add(top);
		add(middle);
		add(bottom);

	}
	public JTextArea getTopTextArea() {
		return textAreaViews;
	}
	
	public JTextArea getMiddleTextArea() {
		return invDesc;
	}
	
	public JTextArea getBottomTextArea() {
		return textAreaBottom;
	}

	public InventoryPanel getInvPanel() {
		return this.invPanel;
	}
	
	public void setInvPanel(InventoryPanel inv) {
		this.invPanel = inv;
		}

	public void updateText() {
		if (l.getGame().getLanguage() == "english") {
			textAreaViews.setText(l.getGame().getCurrentView()
					.getCurrentDescription());
			invDesc.setText("Inventory");
			if (invPanel.selected != null) {
				textAreaBottom.setText(invPanel.selected.getDescription());
			}

		} else {
			if (invPanel.selected != null) {
				textAreaBottom
						.setText(invPanel.selected.getFrenchDescription());
			}
			invDesc.setText("French Inventory");
			if (l.getGame().getCurrentView().getFrenchImage() != null) {
				textAreaViews.setText(l.getGame().getCurrentView()
						.getFrenchDescription());
			}
		}

		
	}

}
