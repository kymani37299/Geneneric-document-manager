package grafeditor.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.Iterator;

import javax.swing.JFrame;

import JevLanguageManager.JevLanguageManager;
import grafeditor.actions.JevGraphicActionManager;
import grafeditor.command.GraphicCommandManager;
import grafeditor.event.UpdateEvent;
import grafeditor.event.UpdateListener;
import grafeditor.factory.DiagramElementAbstractFactory;
import grafeditor.factory.DiagramElementFactory;
import grafeditor.model.JevGraphicElement;
import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.DiagramElement;
import grafeditor.state.StateManager;
import jevDesktop.view.JevSlotView;

@SuppressWarnings("serial")
public class DiagramView extends JFrame implements UpdateListener{
	
	private JevGraphicElement graphicElement;
	private Framework framework;
    private ToolBar toolbar;
    
    private JevGraphicActionManager actionManager;
	private StateManager stateManager;
	private DiagramElementAbstractFactory factory;
	private GraphicCommandManager commandManager;
	DiagramController diagramController = new DiagramController();

	private Point2D lastPosition;
	public enum Handle {NorthWest, North, NorthEast, West, East, SouthWest, South, SouthEast}
	private static final int handleSize = 5;
	
	public DiagramView(JevGraphicElement graphicElement) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)d.getWidth() / 2, (int)d.getHeight() / 2); 
		this.setTitle((JevLanguageManager.getInstance().getText("Edit")));
		this.setLocationRelativeTo(null);
		
		this.actionManager = new JevGraphicActionManager(this);
		this.stateManager = new StateManager(this);
		this.factory = new DiagramElementFactory();
		this.commandManager = new GraphicCommandManager(this);
		this.lastPosition = null;
		
 	    setVisible(true);
 	    
 	    this.toolbar = new ToolBar(this.actionManager);
 	    
 	    this.graphicElement = graphicElement; 
 	    this.framework = new Framework(graphicElement);
 	    this.framework.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
 	    this.framework.setBackground(Color.GRAY);
 	    this.framework.setLayout(new BorderLayout());
 	    this.framework.setPreferredSize(new Dimension(JevSlotView.slotWidth, JevSlotView.slotHeight));
 	    this.framework.setMaximumSize(new Dimension(JevSlotView.slotWidth, JevSlotView.slotHeight));
 	    this.framework.setMinimumSize(new Dimension(JevSlotView.slotWidth, JevSlotView.slotHeight));
		
		this.setLayout(new BorderLayout());
		this.add(this.toolbar, BorderLayout.NORTH);
		this.add(this.framework, BorderLayout.CENTER);
		
		framework.addMouseListener(diagramController);
		framework.addMouseMotionListener(diagramController);
		
		this.graphicElement.getModel().addUpdateListener(this);
		this.graphicElement.getSelectionModel().addUpdateListener(this);
	}
	
	public JevGraphicElement getDiagram() {
		return graphicElement;
	}
    
	public StateManager getStateManager() {
		return stateManager;
	}
		
	public JevGraphicActionManager getActionManager() {
		return actionManager;
	}

	public DiagramElementAbstractFactory getFactory() {
		return factory;
	}

	public GraphicCommandManager getCommandManager() {
		return this.commandManager;
	}

	private class DiagramController extends MouseAdapter implements MouseMotionListener{

		public void mousePressed(MouseEvent e) {
			   lastPosition=e.getPoint();
			   getStateManager().getCurrentState().mousePressed(e);
		}

		public void mouseReleased(MouseEvent e) {
			   getStateManager().getCurrentState().mouseReleased(e);
		}
		
		public void mouseDragged(MouseEvent e ){
			   getStateManager().getCurrentState().mouseDragged(e);
		}
		public void mouseMoved(MouseEvent e) {
			getStateManager().getCurrentState().mouseMoved(e);
		}
	}

	public void updatePerformed(UpdateEvent e) {
		repaint();
	}
	
	public DiagramController getDiagramController(){
		return diagramController;
	}
		
	public Framework getFramework() {
		return this.framework;
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

	public void setMouseCursor(Point2D point){
		
		Handle handle = getDeviceAndHandleForPoint(point);

		if(handle != null){
			Cursor cursor = null;
			
			switch(handle){
			case North: cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);break;
			case South: cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);break;
			case East: cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);break;
			case West: cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);break;
			case SouthEast: cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);break;
			case NorthWest: cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);break;
			case SouthWest: cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);break;
			case NorthEast: cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);break;
			}
			framework.setCursor(cursor);
		}
		else
			framework.setCursor(Cursor.getDefaultCursor());
	}
	
	public Handle getDeviceAndHandleForPoint(Point2D point){
		DiagramElement element;
		
		Iterator<DiagramElement> it = graphicElement.getSelectionModel().getSelectionListIterator();
		while(it.hasNext()){
			element = it.next();
			return getHandleForPoint(element, point);
		}
		return null;
	}
	
	private Handle getHandleForPoint(DiagramElement element, Point2D point){
		for(Handle h: Handle.values()){
			if(isPointInHandle(element, point, h)){
				return h;
			}
		}
		return null;
	}
	
	private boolean isPointInHandle(DiagramElement element, Point2D point, Handle handle){
		if (element instanceof DiagramDevice){
			DiagramDevice device=(DiagramDevice)element;
			Point2D handleCenter = getHandlePoint(device.getPosition(), device.getSize(), handle);
			return ( (Math.abs(point.getX()-handleCenter.getX())<=(double)handleSize/2) && 
					(Math.abs(point.getY()-handleCenter.getY())<=(double)handleSize/2) );
		}	else 
			return false;
	}

	public Point2D getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Point2D lastPosition) {
		this.lastPosition = lastPosition;
	}
}
