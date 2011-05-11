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
	Region outline;
	public InventoryPanel( Game g) {
		this.addMouseListener(this);
		this.myGame = g;
		Dimension size = new Dimension(100,300);
		setPreferredSize(size);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.fillRect(0,0,100,400);

		for (int i = 0; i <myGame.getCurrentPlayer().getInventory().size(); i ++) {
			g2.drawImage(myGame.getCurrentPlayer().getInventory().get(i).getItemImage().getImage(),0,0,null);
		}
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(5));
		if (outline!= null) {
		g.drawRect(outline.getX(),outline.getY(), outline.getWidth(), outline.getHeight());
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		checkImageClick(arg0);
		this.repaint();
		updateInventory();
		
	}
	
	public void checkImageClick(MouseEvent arg0) {
		for (int i = 0; i <myGame.getCurrentPlayer().getInventory().size(); i ++) {
			if (myGame.getCurrentPlayer().getInventory().get(i).getRegion()
					.isInsideRegion(arg0.getX(), arg0.getY())) {
				this.outline = myGame.getCurrentPlayer().getInventory().get(i).getRegion();
			}
		}

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
