import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Launcher {

	/**
	 * @param args
	 */
	public ImageIcon image;
	private Player p;
	private View v;
	private Game game;
	
	public Launcher() {
		this.image = new ImageIcon("main.jpg");
		this.p = new Player("Tyler");
		this.v =new View("main image view", image);
		this.game = new Game(p,v);
	}
	public GamePanel createPanel() {
		GamePanel panel = new GamePanel(game.getCurrentView().getCurrentImage().getImage());
		return panel;
	}
	
	public static void main(String[] args) {
		GamePanel panel = new GamePanel(new ImageIcon("main.jpg").getImage());
		JFrame frame = new JFrame();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
	class GamePanel extends JPanel implements MouseListener{
		
		private Image img;

		public GamePanel(Image img) {
			this.addMouseListener(this);
			this.img = img;
			Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
			setPreferredSize(size);
			setLayout(null);
	
		}
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
			
		}
		public void setImage(ImageIcon image) {
			this.img = image.getImage();
			this.repaint();
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.out.println(new Point(arg0.getX(), arg0.getY()));
			setImage(new ImageIcon("notaser.jpg"));
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


