package grafeditor.command;

import java.util.ArrayList;

import grafeditor.view.DiagramView;

public class GraphicCommandManager {
	
	private DiagramView diagramView;
	
	private ArrayList<Command> commands = new ArrayList<Command>();
	private int currentCommand = 0;
	
	public GraphicCommandManager(DiagramView view){
		this.diagramView = view;
	}
	
	public void addCommand(Command command){
		while(currentCommand < commands.size())
			commands.remove(currentCommand);
		commands.add(command);
		doCommand();
	}
	
	public void doCommand(){
		if(currentCommand < commands.size()){
			commands.get(currentCommand++).redo();
			diagramView.getActionManager().getUndoAction().setEnabled(true);
		}
		if(currentCommand==commands.size()){
			diagramView.getActionManager().getRedoAction().setEnabled(false);
		}
	}
	
	public void undoCommand(){
		if(currentCommand > 0){
			diagramView.getActionManager().getRedoAction().setEnabled(true);
			commands.get(--currentCommand).undo();
		}
		if(currentCommand==0){
			diagramView.getActionManager().getUndoAction().setEnabled(false);
		}
	}

}
