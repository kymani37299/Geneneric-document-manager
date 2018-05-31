package jevDesktop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import jevTree.model.IJevTreeNode;
import model.JevPage;
import model.JevSlot;
import view.MainFrame;

public class JevPageView extends JPanel implements Observer{
	
	public static final int pageWidth = JevInternalFrame.frameWidth-50;
	public static final int pageHeight = JevInternalFrame.frameHeight-50;
	public static final int slotsPerPage = 3;
	
	private JevPage page;
	private JLabel pageCountLabel;
	private ArrayList<JevSlotView> slots;
	private JPanel content;
	
	public JevPageView(JevPage node,int pageCount){
		this.page = (JevPage) node;
		this.setPreferredSize(new Dimension(pageWidth, pageHeight));
		this.setMaximumSize(new Dimension(pageWidth, pageHeight));
		this.setMinimumSize(new Dimension(pageWidth, pageHeight));
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		pageCountLabel = new JLabel("-- " + pageCount + " --");
		pageCountLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(pageCountLabel,BorderLayout.PAGE_END);
		
		this.content = new JPanel();
		this.content.setLayout(new BoxLayout(this.content, BoxLayout.PAGE_AXIS));
		this.content.setPreferredSize(new Dimension(pageWidth-10, pageHeight-20));
		this.content.setBackground(Color.WHITE);
		this.content.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane(this.content);
		
		this.add(scrollPane,BorderLayout.PAGE_START);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		this.slots = new ArrayList<>();
		this.page.addObserver(this);
		this.add(Box.createRigidArea(new Dimension(5, 5)));
		if(!this.page.getChildren().isEmpty()){
			for(IJevTreeNode slot : this.page.getChildren()){
				this.addSlot((JevSlot)slot);
			}
		}
		
	}
	
	private boolean contains(JevSlot slot){
		for(JevSlotView view : slots){
			if(view.getSlot() == slot) return true;
		}
		return false;
	}
	
	private void updateDesktop(){
		MainFrame.getInstance().getDesktop().update();
	}
	
	private void addSlot(JevSlot slot){
		JevSlotView newSlot = new JevSlotView(slot);
		this.content.add(newSlot);
		this.content.add(Box.createRigidArea(new Dimension(5, 5)));
		this.slots.add(newSlot);
	}
	
	private void removeSlot(JevSlot slot){
		JevSlotView toDelete = null;
		for(JevSlotView view : slots){
			if(view.getSlot() == slot){
				toDelete = view;
				this.content.remove(toDelete);
				break;
			}
		}
		this.slots.remove(toDelete);
	}
	
	public JevPage getPage(){
		return this.page;
	}
	
	public void setPageCount(int pageCount){
		this.pageCountLabel.setText("-- " + pageCount + " --");
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg!=null && arg instanceof JevSlot){
			JevSlot slot = (JevSlot)arg;
			if(this.contains(slot)){
				this.removeSlot(slot);
			}else{
				this.addSlot(slot);
			}
		}
		this.updateDesktop();
	}
	
}
