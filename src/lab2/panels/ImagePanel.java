package lab2.panels;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import lab2.globaldata.BackgoundData;
import lab2.globaldata.CoursorData;
import lab2.shapes.MyShape;

public class ImagePanel extends JPanel {

	private static final int LINE_THICKNESS = 3;
	final static float dash1[] = { 10.0f };
	final static BasicStroke normal = new BasicStroke(LINE_THICKNESS);
	final static BasicStroke dashed = new BasicStroke(LINE_THICKNESS, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
			10.0f, dash1, 0.0f);

	private static final long serialVersionUID = 5275308904348754719L;

	private Point startDrag, endDrag;

	private int editRecPosition = -1;

	public ImagePanel() {
		super();
		setLayout(new GridLayout(1, 1));

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point clickPoint = e.getPoint();

				if (BackgoundData.isSelected()) {
					for (int i = 0; i < BackgoundData.getSelectedShapePoints().length; i++) {
						if (BackgoundData.getSelectedShapePoints()[i].contains(clickPoint)) {
							editRecPosition = i;
						}
					}
				}
				startDrag = clickPoint;
				endDrag = startDrag;
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				if (!isSelectedEditing()) {
					Shape newShape = makeShape();
					BackgoundData.addShape(newShape);
				} else {
					editRecPosition = -1;
				}
				startDrag = null;
				endDrag = null;
				repaint();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				endDrag = e.getPoint();
				if(isSelectedEditing()){
					MyShape actualMyShape = BackgoundData.getSelectedShape();
					actualMyShape.setShape(updateShape(editRecPosition,actualMyShape,endDrag));
				}
				repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		paintBackgound(g);

		for (int i = 0; i < BackgoundData.SHAPES_LIST.size(); i++) {
			MyShape shape = BackgoundData.SHAPES_LIST.get(i);
			g2.setStroke(normal);
			g2.setPaint(shape.getPaint());
			if (i == BackgoundData.SELECTED_SHAPE_ID) {
				for (Rectangle2D point : shape.getPoints()) {
					g2.fill(point);
				}
				g2.setStroke(dashed);
			}
			g2.draw(shape.getShape());
		}

		if (startDrag != null && endDrag != null && !isSelectedEditing()) {
			g2.setPaint(CoursorData.getPaint());
			g2.setStroke(normal);
			Shape r = makeShape();
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

	private Ellipse2D.Float makeElipse(int x1, int y1, int x2, int y2) {
		return new Ellipse2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
	}

	private Shape makeShape() {
		if (CoursorData.SHAPE_COURSOR == 0) {
			return makeRectangle(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
		} else {
			return makeElipse(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
		}
	}
	
	private Shape updateShape(int apexCount, MyShape myShape, Point actualPoint) {
		int startX  = (int) myShape.getStartX();
		int startY = (int) myShape.getStartY();
		int endX = (int) myShape.getEndX();
		int endY = (int) myShape.getEndY();
		if (apexCount == 0 ){
			startX = (int) actualPoint.getX();
			startY = (int) actualPoint.getY();
		} else if ( apexCount == 1){
			startX = (int) actualPoint.getX();
			endY = (int) actualPoint.getY();
		} else if (apexCount == 2){
			endX = (int) actualPoint.getX();
			startY = (int) actualPoint.getY();
		} else {
			endX = (int) actualPoint.getX();
			endY = (int) actualPoint.getY();
		}
		if (myShape.getShapeType() == 0) {
			return makeRectangle(startX, startY, endX, endY);
		} else {
			return makeElipse(startX, startY, endX, endY);
		}
	}

	private boolean isSelectedEditing() {
		return editRecPosition != -1;
	}

}
