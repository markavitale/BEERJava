import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class InventoryPanel extends JPanel implements MouseListener {

	private Game myGame;
	Item selected;
	SidePanel sidePanel;
	boolean combineItem;

	public InventoryPanel(Game g, SidePanel side) {
		this.addMouseListener(this);
		sidePanel = side;
		this.myGame = g;
		Dimension size = new Dimension(100, 400);
		combineItem = true;
		combineItem = false;
		setPreferredSize(size);

		Item taserItem = new Item("taser", "this taser hurts bad guys",
				new ImageIcon("images/taser.jpg"), new Region(15, 0, 70, 70),
				"taser description in french");
		Item dynamiteItem = new Item(
				"dynamite",
				"this dynamite could be used to blow things up, but its missing something",
				new ImageIcon("images/dynamite.jpg"), new Region(15, 300, 70,
						70), "dynamite description in french");
		Item stringItem = new Item("string", "a very simple string",
				new ImageIcon("images/string.jpg"),
				new Region(15, 225, 70, 70), "string description in french");

		Item matchesItem = new Item("matches",
				"these matches can be used to light things on fire",
				new ImageIcon("images/matches.jpg"),
				new Region(15, 150, 70, 70), "matches description in french");
		Item keysItem = new Item("keys",
				"these keys unlock security deposity boxes", new ImageIcon(
						"images/keys.jpg"), new Region(15, 75, 70, 70),
				"taser description in french");
		myGame.getCurrentPlayer().addItem(taserItem);
		myGame.getCurrentPlayer().addItem(keysItem);
		myGame.getCurrentPlayer().addItem(matchesItem);
		myGame.getCurrentPlayer().addItem(stringItem);
		myGame.getCurrentPlayer().addItem(dynamiteItem);
	}

	public void setCombineItemTrue() {
		combineItem = true;
	}
	
	public void setCombineItemFalse() {
		combineItem = false;
	}
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, 100, 400);
		ArrayList<Item> inv = myGame.getCurrentPlayer().getInventory();
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
		checkCombineClick(arg0.getPoint());
		checkImageClick(arg0.getPoint());
		this.repaint();
		sidePanel.updateText();

	}

	public Item returnSelected() {
		return this.selected;
	}

	public void setSelected(Item i) {
		this.selected = i;
	}
	public void checkCombineClick(Point p) {
		if (combineItem && (myGame.getCurrentPlayer().getInventory().size() == 5)) {
			Item dynamiteWithStringItem = new Item("dynamitewithstring", "dynamite with string",
					new ImageIcon("images/stringanddynamite.jpg"), new Region(15, 225, 70, 70),
					"dynamite with string in french");
			if (selected.getName() == "dynamite" ) {
				if (myGame.getCurrentPlayer().getInventory().get(3).getRegion().isInsideRegion((int) p.getX(),(int)p.getY())) {
					System.out.println("combining!");
					myGame.getCurrentPlayer().removeItem(myGame.getCurrentPlayer().getInventory().get(3));
					myGame.getCurrentPlayer().removeItem(myGame.getCurrentPlayer().getInventory().get(3));
					myGame.getCurrentPlayer().addItem(dynamiteWithStringItem);
					this.setSelected(dynamiteWithStringItem);
					System.out.println(this.returnSelected().getDescription());
					sidePanel.updateText();
					this.repaint();
				
				}
			} else if (selected.getName() == "string" ) {
				if (myGame.getCurrentPlayer().getInventory().get(4).getRegion().isInsideRegion((int) p.getX(),(int)p.getY())) {
					System.out.println("combining!");
					myGame.getCurrentPlayer().removeItem(myGame.getCurrentPlayer().getInventory().get(3));
					myGame.getCurrentPlayer().removeItem(myGame.getCurrentPlayer().getInventory().get(3));
					myGame.getCurrentPlayer().addItem(dynamiteWithStringItem);
					this.setSelected(dynamiteWithStringItem);
					System.out.println(this.returnSelected().getDescription());
					sidePanel.updateText();
					this.repaint();
				}
			}
			
		}
	}
	public void checkImageClick(Point p) {
		for (int i = 0; i < myGame.getCurrentPlayer().getInventory().size(); i++) {
			if (myGame.getCurrentPlayer().getInventory().get(i).getRegion()
					.isInsideRegion((int)p.getX(),(int) p.getY())) {
				setSelected(myGame.getCurrentPlayer().getInventory().get(i));
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
