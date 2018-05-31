package jevDesktop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.JevSlot;
import model.element.JevElement;
import view.MainFrame;

public class JevSlotView extends JPanel implements Observer{

	public static final int slotWidth = JevPageView.pageWidth-10;
	public static final int slotHeight = JevPageView.pageHeight/JevPageView.slotsPerPage - 10;
	private JevSlot slot;
	private JevElementView elementView;
	private JScrollPane scrollPanel;
	private JPanel mainPanel;
	
	public JevSlotView(JevSlot slot){
		this.slot = slot;
		this.mainPanel = new JPanel(new BorderLayout());
		this.setLayout(new BorderLayout());
		slot.addObserver(this);
		this.setPreferredSize(new Dimension(slotWidth, slotHeight));
		this.setMaximumSize(new Dimension(slotWidth, slotHeight));
		this.setBackground(Color.WHITE);
		
		if(slot.hasChildren()){
			this.addElement((JevElement)slot.getChildren().get(0));
		}
		this.scrollPanel = new JScrollPane(this.mainPanel);
		this.add(this.scrollPanel);
	}
	
	private void addElement(JevElement element){
		if(this.elementView==null){
			this.elementView = new JevElementView(element);
			this.mainPanel.add(this.elementView);
		}
	}
	
	private void removeElement(){
		if(elementView!=null){
			this.elementView.removeAll();
			this.elementView.setVisible(false);
			this.mainPanel.remove(elementView);
			this.elementView = null;
			this.updateDesktop();
		}
		this.updateDesktop();
	}
	
	public JevSlot getSlot(){
		return this.slot;
	}
	
	private void updateDesktop(){
		MainFrame.getInstance().getDesktop().update();
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg!=null && arg instanceof Boolean){
			if((Boolean)arg){
				this.addElement((JevElement)slot.getChildren().get(0));
			}else{
				this.removeElement();
			}
		}
		this.updateDesktop();
	}
	

}
