import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author vitalema and hannantt
 * 
 *         This class represents the inventory panel on the side
 */
@SuppressWarnings("serial")
public class InventoryPanel extends JPanel implements MouseListener,
		Serializable {

	Item selected;
	SidePanel sidePanel;
	boolean combineItem;
	private Launcher l;

	/**
	 * @param launch
	 *            - the launcher
	 * @param side
	 *            - the sidepanel
	 */
	public InventoryPanel(Launcher launch, SidePanel side) {
		this.addMouseListener(this);
		l = launch;
		sidePanel = side;
		Dimension size = new Dimension(100, 400);
		combineItem = true;
		combineItem = false;
		setPreferredSize(size);

	}

	/**
	 * This method checks to see if you have dynamite or string
	 * selected, and if you have pressed combine and then select
	 * the other one it will set combineItem to true 
	 */
	public void checkCombineItem() {
		if (returnSelected() != null) {
			if (((returnSelected().getName().equals("dynamite")) | (returnSelected()
					.getName().equals("string")))
					&& (l.getGame().getCurrentPlayer().getInventory().size() == 5)) {
				combineItem = true;
			}
		} else {
			combineItem = false;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, 100, 400);
		ArrayList<Item> inv = l.getGame().getCurrentPlayer().getInventory();
		for (int i = 0; i < inv.size(); i++) {
			g2.drawImage(inv.get(i).getItemImage().getImage(), inv.get(i)
					.getRegion().getX(), inv.get(i).getRegion().getY(), null);
		}
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(5));
		if (selected != null) {
			g.drawRect(selected.getRegion().getX(),
					selected.getRegion().getY(), selected.getRegion()
							.getWidth(), selected.getRegion().getHeight());
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (l.getGame().getCurrentPlayer().getInventory().size() > 0) {
			checkCombineClick(arg0.getPoint());
			checkImageClick(arg0.getPoint());
			this.repaint();
			sidePanel.updateText();
		}

	}

	/**
	 * @return the selected item
	 */
	public Item returnSelected() {
		return this.selected;
	}

	/**
	 * @param  i
	 * 			- the item to be set
	 * sets the selected item to i
	 */
	public void setSelected(Item i) {
		this.selected = i;
	}

	/**
	 * @param p
	 * 			- the point clicked
	 * checks to see if you combineItem is true then checks to see
	 * if you are clicking on dynamite or string and 
	 * combines them into one item
	 */
	public void checkCombineClick(Point p) {
		if (combineItem) {
			if (selected.getName().equals("dynamite")) {
				if (l.getGame().getCurrentPlayer().getInventory().get(3)
						.getRegion()
						.isInsideRegion((int) p.getX(), (int) p.getY())) {
					l.getGame()
							.getCurrentPlayer()
							.removeItem(
									l.getGame().getCurrentPlayer()
											.getInventory().get(3));
					l.getGame()
							.getCurrentPlayer()
							.removeItem(
									l.getGame().getCurrentPlayer()
											.getInventory().get(3));
					l.getGame().getCurrentPlayer()
							.addItem(l.getGame().getDynamiteItem());
					this.setSelected(l.getGame().getDynamiteItem());

					sidePanel.updateText();
					checkCombineItem();
					this.repaint();

				}
			} else if (selected.getName().equals("string")) {
				if (l.getGame().getCurrentPlayer().getInventory().get(4)
						.getRegion()
						.isInsideRegion((int) p.getX(), (int) p.getY())) {
					l.getGame()
							.getCurrentPlayer()
							.removeItem(
									l.getGame().getCurrentPlayer()
											.getInventory().get(3));
					l.getGame()
							.getCurrentPlayer()
							.removeItem(
									l.getGame().getCurrentPlayer()
											.getInventory().get(3));
					l.getGame().getCurrentPlayer()
							.addItem(l.getGame().getDynamiteItem());
					this.setSelected(l.getGame().getDynamiteItem());

					sidePanel.updateText();
					checkCombineItem();
					this.repaint();
				}
			}

		}
	}

	/**
	 * @param p
	 * 			- the point clicked
	 * This method checks to see what item you are clicking on
	 */
	public void checkImageClick(Point p) {
		for (int i = 0; i < l.getGame().getCurrentPlayer().getInventory()
				.size(); i++) {
			if (l.getGame().getCurrentPlayer().getInventory().get(i)
					.getRegion().isInsideRegion((int) p.getX(), (int) p.getY())) {
				setSelected(l.getGame().getCurrentPlayer().getInventory()
						.get(i));
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
