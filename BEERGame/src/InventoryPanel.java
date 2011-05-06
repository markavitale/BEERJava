import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class InventoryPanel extends JPanel implements MouseListener {


	private Game myGame;

	public InventoryPanel( Game g) {
		this.myGame = g;
		Dimension size = new Dimension(100,400);
		setPreferredSize(size);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,100,400);
		
		for (int i = 0; i <myGame.getCurrentPlayer().getInventory().size(); i ++) {
			g.drawImage(myGame.getCurrentPlayer().getInventory().get(i).getItemImage().getImage(),0,0,null);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("uh over here bud");
		this.repaint();
		updateInventory();
		
	}
	void updateInventory() {
		this.repaint();
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
