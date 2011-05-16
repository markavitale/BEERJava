import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

class GamePanel extends JPanel implements MouseListener, MouseMotionListener {

	private Image img;
	private Game myGame;
	private InventoryPanel invPanel;
	private boolean mouseIsInsideRegion;
	private SidePanel sidePanel;
	private Timer t;

	public GamePanel(Launcher l, SidePanel sidePane) {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		t = new Timer();
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
		View v = myGame.getCurrentView();
		if (myGame.getLanguage() == "french"
				&& (myGame.getCurrentView().getFrenchImage() != null)) {
			g.drawImage(v.getFrenchImage().getImage(), 0, 0, null);
		} else {
			g.drawImage(v.getCurrentImage().getImage(), 0, 0, null);
		}
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

	public void checkRegion(int x, int y){
		
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
					this.invPanel.repaint();
					this.repaint();
					
				}
			} else {
				if (currentRegion.hasRequiredItem()) {
					if (currentRegion.getRequiredItem() == invPanel.selected) {
						myGame.changeView(currentRegion.getView());
						
						sidePanel.updateText();
						mouseIsInsideRegion = false;
						this.repaint();
						
						if (currentRegion.getRequiredItem().getName()=="dynamitewithstring") {
							myGame.getCurrentPlayer().getInventory().remove(myGame.getCurrentPlayer().getInventory().get(3));
							
							invPanel.setSelected(myGame.getCurrentPlayer().getInventory().get(2));
							invPanel.repaint();
						}
					} else {
						// do nothing
					}
				} else {
					myGame.changeView(currentRegion.getView());
					sidePanel.updateText();
					mouseIsInsideRegion = false;
					this.repaint();
					
				}
			}
		}
		checkForWaitView();
	}

	public void checkForWaitView() {
	
		if (myGame.getCurrentView().getRegions().get(0).hasWaitView()) {
			
			t.schedule(new WaitViewUpdate(),2000);
			
		}
		
	}
//		if (myGame.getCurrentView().getRegions().get(0).hasWaitView()) {
//			Thread.sleep(500);
//			this.repaint();
//			System.out.println("here");
//			Thread.sleep(4000);
//			checkRegion(50,50);
//			
//		}
	class WaitViewUpdate extends TimerTask {
		public void run() {
			GamePanel.this.checkRegion(50,50);
			
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
		} else {
			mouseIsInsideRegion = false;
			this.repaint();
		}
		// TODO Auto-generated method stub

	}
}