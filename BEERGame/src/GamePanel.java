import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

class GamePanel extends JPanel implements MouseListener, MouseMotionListener {

	private Image img;
	private Game myGame;
	private InventoryPanel invPanel;
	private boolean mouseIsInsideRegion;
	private SidePanel sidePanel;
	public GamePanel(Launcher l, SidePanel sidePane) {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.sidePanel = sidePane;
		invPanel = sidePanel.getInvPanel();
		mouseIsInsideRegion = false;
		this.myGame = l.getGame();
		this.img = myGame.getCurrentView().getCurrentImage().getImage();
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setLayout(new FlowLayout());

	}
	
	public SidePanel getSidePanel() {
		return this.sidePanel;
	}

	public void paintComponent(Graphics g) {
		View v;
		if (myGame.getLanguage() == "french"
				&& (myGame.getCurrentView().getFrenchAlternate() != null)) {
			v = myGame.getCurrentView().getFrenchAlternate();
		} else {
			v = myGame.getCurrentView();
		}
		g.drawImage(v.getCurrentImage().getImage(), 0, 0, null);
		if (mouseIsInsideRegion == true) {
			ArrayList<Region> regionList = v.getRegions();
			for (int i = 0; i < regionList.size(); i++) {
				g.setColor(Color.RED);
				g.drawRect(regionList.get(i).getX(), regionList.get(i).getY(),
						regionList.get(i).getWidth(), regionList.get(i)
								.getHeight());
			}
		}
	}

	public void checkRegion(int x, int y) {
		Region currentRegion = myGame.getCurrentView().getRegions().get(0);
		if (currentRegion.isInsideRegion(x, y)) {
			if (currentRegion.hasItem()) {
				if (!this.myGame.getCurrentPlayer().getInventory()
						.contains(currentRegion.getItem())) {
					myGame.changeView(currentRegion.getView());
					mouseIsInsideRegion = false;
					sidePanel.updateText();
					this.myGame.getCurrentPlayer().addItem(
							currentRegion.getItem());
					this.invPanel.updateInventory();
					this.repaint();
				}
			} else {
				myGame.changeView(currentRegion.getView());
				sidePanel.updateText();
				mouseIsInsideRegion = false;
				this.repaint();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (myGame.getCurrentView().getRegions().get(0)
				.isInsideRegion(e.getX(), e.getY())) {
			mouseIsInsideRegion = true;
			this.repaint();
		}else {
			mouseIsInsideRegion = false;
			this.repaint();
		}
		// TODO Auto-generated method stub

	}
}