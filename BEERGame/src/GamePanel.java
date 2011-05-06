import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class GamePanel extends JPanel implements MouseListener {

	private Image img;
	private Game myGame;

	public GamePanel(Image img, Game g) {
		this.addMouseListener(this);
		this.myGame = g;
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setLayout(null);

	}

	public void paintComponent(Graphics g) {
		
			g.drawImage(myGame.getCurrentView().getCurrentImage().getImage(), 0, 0, null);
			ArrayList<Region> regionList = myGame.getCurrentView().getRegions();
			for (int i = 0; i <regionList.size(); i++) {
			g.drawRect(regionList.get(i).getX(), regionList.get(i).getY(), 
					regionList.get(i).getWidth(), regionList.get(i).getHeight());
			}
		}

	public void checkRegion(int x, int y) {
		ArrayList<Region> regionList = myGame.getCurrentView().getRegions();
		Region currentRegion;
		
		for (int i = 0; i < regionList.size(); i++) {
			currentRegion = regionList.get(i);
			if (currentRegion.isInsideRegion(x,y)) {
				if (regionList.get(i).hasItem()) {
					if (!this.myGame.getCurrentPlayer().returnInventory().contains(currentRegion.getItem())) {
						
					myGame.changeView(myGame.getCurrentView().getViews().get(0));
					this.myGame.getCurrentPlayer().addItem(currentRegion.getItem());
					this.repaint();
				}
			}
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println(myGame.getCurrentView().getCurrentDescription());
		checkRegion(arg0.getX(), arg0.getY());
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