package grafeditor.view;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import grafeditor.actions.JevGraphicActionManager;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar{
	
	public ToolBar(JevGraphicActionManager actionManager){
		super(JToolBar.HORIZONTAL);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		ButtonGroup group = new ButtonGroup();

		JToggleButton cursorButton=new JToggleButton(actionManager.getPhandCursorAction());
		group.add(cursorButton);
		add(cursorButton);
		addSeparator();
		
		JToggleButton rectangleButton=new JToggleButton(actionManager.getpRectangleAction());
		group.add(rectangleButton);
		add(rectangleButton);
		addSeparator();
		
		JToggleButton circleButton=new JToggleButton(actionManager.getpCircleAction());
		group.add(circleButton);
		add(circleButton);
		addSeparator();
		
		JToggleButton triangleButton=new JToggleButton(actionManager.getpTriangleAction());
		group.add(triangleButton);
		add(triangleButton);
		addSeparator();
		
		JToggleButton linkButton = new JToggleButton(actionManager.getLinkAction());
		group.add(linkButton);
		add(linkButton);
		addSeparator();
		
		JButton undoButton = new JButton(actionManager.getUndoAction());
	  	add(undoButton);
		addSeparator();

		JButton redoButton = new JButton(actionManager.getRedoAction());
		add(redoButton);
		addSeparator();

		JButton deleteButton = new JButton(actionManager.getDeleteAction());
		add(deleteButton);
		addSeparator();
	}
}
