import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author vitalema and hannantt
 * 
 *         This class represents the sidepanel for the game
 */
@SuppressWarnings("serial")
public class SidePanel extends JPanel implements Serializable {
	private Launcher l;
	private InventoryPanel invPanel;
	private JTextArea textAreaViews;
	private JTextArea textAreaBottom;
	private JTextArea invDesc;
	private JButton combineButton;

	/**
	 * @param launch
	 * 			- the current launcher
	 */
	public SidePanel(Launcher launch) {
		l = launch;
		//l.getGame().setLanguage("english");
		textAreaViews = new JTextArea(l.getGame().getCurrentView()
				.getCurrentDescription(), 4, 1);
		textAreaViews.setLineWrap(true);
		textAreaViews.setWrapStyleWord(true);
		textAreaViews.setEditable(false);
		JPanel top = new JPanel();
		top.add(textAreaViews);
		JPanel middle = new JPanel();
		invPanel = new InventoryPanel(l, this);
		invDesc = new JTextArea("Inventory");
		invDesc.setEditable(false);
		invDesc.setOpaque(false);
		// invDesc.setBackground(Color.LIGHT_GRAY);
		middle.add(invDesc);
		middle.add(invPanel);
		combineButton = new JButton();
		combineButton.setText("Combine");
		combineButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SidePanel.this.invPanel.checkCombineItem();

			}
		});

		JPanel bottom = new JPanel();
		textAreaBottom = new JTextArea("No Item Selected", 6, 1);
		textAreaBottom.setEditable(false);
		textAreaBottom.setLineWrap(true);
		textAreaBottom.setWrapStyleWord(true);
		bottom.add(combineButton);
		bottom.add(textAreaBottom);
		top.setPreferredSize(new Dimension(100, 70));
		middle.setPreferredSize(new Dimension(100, 400));
		bottom.setPreferredSize(new Dimension(100, 130));
		setPreferredSize(new Dimension(100, 600));
		this.setLayout(new FlowLayout());
		add(top);
		add(middle);
		add(bottom);

	}

	JTextArea getTopTextArea() {
		return textAreaViews;
	}

	JTextArea getMiddleTextArea() {
		return invDesc;
	}

	JTextArea getBottomTextArea() {
		return textAreaBottom;
	}

	JButton getCombine() {
		return combineButton;
	}
	InventoryPanel getInvPanel() {
		return this.invPanel;
	}

	void setInvPanel(InventoryPanel inv) {
		this.invPanel = inv;
	}

	void updateText() {
		if (l.getGame().getLanguage() == "english") {
			textAreaViews.setText(l.getGame().getCurrentView()
					.getCurrentDescription());
			combineButton.setText("Combine");
			invDesc.setText("Inventory");
			if (invPanel.selected != null) {
				textAreaBottom.setText(invPanel.selected.getDescription());
			} else {
				textAreaBottom.setText("No Item Selected");
			}

		} else {
			if (invPanel.selected != null) {
				textAreaBottom
						.setText(invPanel.selected.getFrenchDescription());
			} else {
				textAreaBottom.setText("Pas de description");
			}

			combineButton.setText("Combiner");
			invDesc.setText("Inventaire");
			if (l.getGame().getCurrentView()!=null) {
			if (l.getGame().getCurrentView().getFrenchImage() != null) {
				textAreaViews.setText(l.getGame().getCurrentView()
						.getFrenchDescription());
			}
			}
		}

	}

}
