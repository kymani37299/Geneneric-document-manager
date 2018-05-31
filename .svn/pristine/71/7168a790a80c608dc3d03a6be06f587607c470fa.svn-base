package grafeditor.state;

import java.io.Serializable;

import grafeditor.view.DiagramView;

@SuppressWarnings("serial")
public class StateManager implements Serializable {
	
	private State currentState;
	
	private CircleState circleState; 
	private RectangleState rectangleState;
	private TriangleState triangleState;
	private SelectState selectState;
	private MoveState moveState;
	private ResizeState resizeState;
	private LassoState lassoState;
	private LinkState linkState;
	
	public StateManager(DiagramView diagramView){
		circleState = new CircleState(diagramView); 
		rectangleState = new RectangleState(diagramView);
		triangleState = new TriangleState(diagramView);
		selectState = new SelectState(diagramView);
		moveState = new MoveState(diagramView);
		lassoState = new LassoState(diagramView);
		linkState = new LinkState(diagramView);
		resizeState = new ResizeState(diagramView);
     	currentState = selectState;
	}
	
	public void setCircleState() { 
		currentState = circleState; 
	}
	
	public void setRectangleState(){ 
		currentState = rectangleState; 
	}
	
	public void setTriangleState(){
		currentState = triangleState;
	}
	
	public void setSelectState(){ 
		currentState = selectState; 
	}
	
	public void setMoveState(){
		currentState = moveState;
	}
	
	public void setResizeState() {
		currentState = resizeState;
	}

	public void setLassoState(){
		currentState = lassoState;
	}
	
	public void setLinkState(){
		currentState = linkState;
	}
	
	public State getCurrentState() {
		return currentState;
	}
}
