package jevDesktop.view;



import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.JevDocument;
import model.JevPage;
import view.MainFrame;

@SuppressWarnings("serial")
public class JevInternalFrame extends JInternalFrame implements Observer{
	
	public static final int frameWidth = 500;
	public static final int frameHeight = 500;
	
	private ArrayList<JevPageView> pages;
	private JPanel content;
	
	private static final int xOffset = 30, yOffset = 30;

	public JevInternalFrame(JevDocument document) {
		super(document.getName(),
		          true, true, true, true);
		this.setSize(frameWidth,frameHeight);
		int openFrameCount = MainFrame.getInstance().getDesktop().getOpenFrameCount();
		this.setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
		this.setVisible(true);
		
		this.content = new JPanel();
		JScrollPane scrollPane = new JScrollPane(this.content);
		content.setBackground(Color.LIGHT_GRAY);
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		content.setBorder(BorderFactory.createEmptyBorder(11,11,11,11));
		this.setContentPane(scrollPane);
		this.pages = new ArrayList<JevPageView>();
		document.addObserver(this);
	
	}

	private boolean contains(JevPage page){
		for(JevPageView view : pages){
			if(view.getPage() == page) return true;
		}
		return false;
	}
	
	public void addPage(JevPage node,int pageCount) {
		JevPageView newPage = new JevPageView(node,pageCount);
		this.content.add(newPage);
		this.content.add(Box.createRigidArea(new Dimension(5,5)));
		this.pages.add(newPage);
	}

	private void updateDesktop(){
		MainFrame.getInstance().getDesktop().update();
	}
	
	public void removePage(JevPage page){
		int i=1;
		JevPageView toDelete = null;
		for(JevPageView view : this.pages){
			if(view.getPage() == page){
				toDelete = view;
				this.content.remove(view);
			}else{
				view.setPageCount(i++);
			}
		}
		this.pages.remove(toDelete);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		JevDocument document = (JevDocument)o;
		this.setTitle(document.getName());
		if(arg!=null && arg instanceof JevPage){
			JevPage page = (JevPage)arg;
			if(this.contains(page)){
				this.removePage(page);
			}else{
				this.addPage(page,document.getChildren().size());
			}
		}
		this.updateDesktop();
	}

}
