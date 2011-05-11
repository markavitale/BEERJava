import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class InventoryPanel extends JPanel implements MouseListener {


	private Game myGame;
	Item selected;
	SidePanel sidePanel;
	public InventoryPanel( Game g, SidePanel side) {
		this.addMouseListener(this);
		sidePanel = side;
		this.myGame = g;
		Dimension size = new Dimension(100,300);
		setPreferredSize(size);
		Item dynamiteItem = new Item("dynamite", "this dynamite can be used to blow things up, be careful!",
				new ImageIcon("images/dynamite.jpg"), new Region(15,225,70,70),
				"dynamite description in french");
			Item matchesItem = new Item("matches", "these matches can be used to light things on fire",
					new ImageIcon("images/matches.jpg"), new Region(15,150, 70, 70), 
					"matches description in french");
			Item keysItem = new Item("keys", "these keys unlock security deposity boxes", 
				new ImageIcon("images/keys.jpg"), new Region(15,75,70,70),
				"taser description in french");
			myGame.getCurrentPlayer().addItem(dynamiteItem);
			myGame.getCurrentPlayer().addItem(matchesItem);
			myGame.getCurrentPlayer().addItem(keysItem);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.fillRect(0,0,100,400);
		ArrayList<Item> inv = myGame.getCurrentPlayer().getInventory();
		for (int i = 0; i <inv.size(); i ++) {
			g2.drawImage(inv.get(i).getItemImage().getImage(),
					inv.get(i).getRegion().getX(),
					inv.get(i).getRegion().getY(),null);
		}
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(5));
		if (selected!= null) {
		g.drawRect(selected.getRegion().getX(),selected.getRegion().getY(),
				selected.getRegion().getWidth(), selected.getRegion().getHeight());
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		checkImageClick(arg0);
		this.repaint();
		sidePanel.updateText();
		
		
	}
	public Item returnSelected() {
		return this.selected;
	}
	
	public void checkImageClick(MouseEvent arg0) {
		for (int i = 0; i <myGame.getCurrentPlayer().getInventory().size(); i ++) {
			if (myGame.getCurrentPlayer().getInventory().get(i).getRegion()
					.isInsideRegion(arg0.getX(), arg0.getY())) {
				this.selected = myGame.getCurrentPlayer().getInventory().get(i);
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
