package jevDesktop.actions;

import jevDesktop.controller.JevDesktopController;

public class JevDesktopActionManager {

	private TileViewAction tileViewAction;
	private CascadeViewAction cascadeViewAction;
	private HorizontalTileViewAction horizontalTileViewAction;
	private VerticalTileViewAction verticalTileViewAction;
	
	public JevDesktopActionManager(JevDesktopController controller){
		this.tileViewAction = new TileViewAction(controller);
		this.cascadeViewAction = new CascadeViewAction(controller);
		this.horizontalTileViewAction = new HorizontalTileViewAction(controller);
		this.verticalTileViewAction = new VerticalTileViewAction(controller);
	}
	
	public TileViewAction getTileViewAction(){
		return this.tileViewAction;
	}
	
	public CascadeViewAction getCascadeViewAction(){
		return this.cascadeViewAction;
	}

	public HorizontalTileViewAction getHorizontalTileViewAction() {
		return horizontalTileViewAction;
	}

	public VerticalTileViewAction getVerticalTileViewAction() {
		return verticalTileViewAction;
	}
	
	
	
}
