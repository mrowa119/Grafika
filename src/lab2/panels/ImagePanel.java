package lab2.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import lab2.globaldata.BackgoundData;
import lab2.globaldata.CoursorData;
import lab2.shapes.MyShape;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 5275308904348754719L;

	private Point startDrag, endDrag;

	public ImagePanel() {
		super();
		setLayout(new GridLayout(1, 1));
		setBackground(Color.GREEN);

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				startDrag = new Point(e.getX(), e.getY());
				endDrag = startDrag;
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				Shape newShape = makeRectangle(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
				BackgoundData.addShape(newShape);
				startDrag = null;
				endDrag = null;
				repaint();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				endDrag = new Point(e.getX(), e.getY());
				repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		paintBackgound(g);
		
		for (MyShape s: BackgoundData.shapesList){
			g2.setPaint(s.getPaint());
			g2.draw(s.getShape());
		}
		
		if(startDrag != null && endDrag != null){
			g2.setPaint(CoursorData.getPaint());
			Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
			g2.draw(r);
		}
	}

	private void paintBackgound(Graphics g) {
		if (BackgoundData.isBackgroundSet()) {
			Graphics2D g2d = (Graphics2D) g.create();
			int tileWidth = ((BufferedImage) BackgoundData.BACKGORUND_IMAGE).getWidth();
			int tileHeight = ((BufferedImage) BackgoundData.BACKGORUND_IMAGE).getHeight();
			for (int y = 0; y < getHeight(); y += tileHeight) {
				for (int x = 0; x < getWidth(); x += tileWidth) {
					g2d.drawImage(BackgoundData.BACKGORUND_IMAGE, x, y, this);
				}
			}
			g2d.dispose();
		}
	}

	private Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2) {
		return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
	}

}
