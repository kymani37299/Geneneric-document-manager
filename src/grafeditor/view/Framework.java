package grafeditor.view;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import grafeditor.model.JevGraphicElement;
import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.LinkElement;
import grafeditor.view.DiagramView.Handle;
import grafeditor.view.painters.ElementPainter;

@SuppressWarnings("serial")
public class Framework extends JPanel implements Observer {
	private static final int handleSize = 5;
	private JevGraphicElement graphicElement;
	private Rectangle2D selectionRectangle;
	
	public Framework(JevGraphicElement element) {
		this.graphicElement = element;
		this.graphicElement.addObserver(this);
		this.selectionRectangle = new Rectangle2D.Double();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Iterator<DiagramElement> it = graphicElement.getModel().getElementsIterator();
		while(it.hasNext()){
			DiagramElement d = (DiagramElement) it.next();
			ElementPainter paint =  (ElementPainter) d.getPainter();
			paint.paint(g2, d);
			
		}
		
		paintSelectionHandles(g2);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
				BasicStroke.JOIN_BEVEL, 1f, new float[]{(float)3, (float)6}, 0 ));
		g2.draw(selectionRectangle);			
	}
	
	private void paintSelectionHandles(Graphics2D g2) {
		
		Iterator<DiagramElement> it = this.graphicElement.getSelectionModel().getSelectionListIterator();
		while(it.hasNext()){
			DiagramElement element =  it.next();
			if (element instanceof DiagramDevice){
				DiagramDevice device=(DiagramDevice)element;

				g2.setStroke(new BasicStroke((float)2, BasicStroke.CAP_SQUARE, 
						BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0 ));
				g2.setPaint(Color.BLACK);
			
				g2.drawRect((int)device.getPosition().getX(), (int)device.getPosition().getY(),
						(int)device.getSize().getWidth(), (int)device.getSize().getHeight());
			
				for(Handle e: Handle.values()){
					paintSelectionHandle(g2, getHandlePoint(device.getPosition(), device.getSize(), e));
				}			
			}else {
				if(element instanceof LinkElement) {
					LinkElement link = (LinkElement)element;
					Stroke originalStroke = link.getStroke();
					link.setStroke(new BasicStroke((float)4, BasicStroke.CAP_SQUARE, 
							BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0 ));
					ElementPainter paint =  (ElementPainter) link.getPainter();
					paint.paint(g2, link);
					link.setStroke(originalStroke);
				}
				
			}
		}
	}
	
	private void paintSelectionHandle(Graphics2D g2, Point2D position){
		double size = handleSize;
		g2.fill(new Rectangle2D.Double(position.getX()-size/2, position.getY()-size/2, 
				size, size));	
	}
	
	private Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handlePosition ){
		double x=0, y=0;
	
		if(handlePosition == Handle.NorthWest || handlePosition == Handle.North || handlePosition == Handle.NorthEast){
			y = topLeft.getY();
		}
		if(handlePosition == Handle.East || handlePosition == Handle.West){
			y = topLeft.getY()+size.getHeight()/2;
		}
		if(handlePosition == Handle.SouthWest || handlePosition == Handle.South || handlePosition == Handle.SouthEast){
			y = topLeft.getY() + size.getHeight();
		}

		if(handlePosition == Handle.NorthWest || handlePosition == Handle.West || handlePosition == Handle.SouthWest){
			x = topLeft.getX();
		}
		if(handlePosition == Handle.North || handlePosition == Handle.South){
			x = topLeft.getX() + size.getWidth()/2;
		}
		if(handlePosition == Handle.NorthEast || handlePosition == Handle.East || handlePosition == Handle.SouthEast){
			x = topLeft.getX() + size.getWidth();
		}
		
		return new Point2D.Double(x,y);
	}

	public Rectangle2D getSelectionRectangle() {
		return selectionRectangle;
	}

	public void setSelectionRectangle(Rectangle2D selectionRectangle) {
		this.selectionRectangle = selectionRectangle;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}
}
