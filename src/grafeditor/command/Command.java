package grafeditor.command;

public abstract class Command {
	public abstract void redo();
	public abstract void undo();
}
