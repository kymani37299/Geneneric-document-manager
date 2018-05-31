package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import controller.JevTreeController;
import jevDesktop.actions.JevDesktopActionManager;
import jevDesktop.controller.JevDesktopController;
import jevDesktop.view.JevDesktop;
import jevTree.actions.OpenDocumentAction;
import jevTree.model.JevTreeNode;
import jevTree.view.JevTree;
import model.JevWorkspace;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private static MainFrame instance = null;
	private JPanel mainPanel;
	private JevTree jevTree;
	private JScrollPane treeScrollPane;
	private JSplitPane splitPane;
	private JevDesktop desktop;
	private JevToolBar toolBar;
	
	private MainFrame() {
		super();
		
		this.mainPanel = new JPanel(new BorderLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(d.getWidth() / 1.5), (int)(d.getHeight() / 1.5)); 
		this.setTitle("Jevandjelisti GeRuDok");
		this.setLocationRelativeTo(null);
		
		this.jevTree = new JevTree(new JevTreeNode(new JevWorkspace()), new JevTreeController());
		this.jevTree.addMouseListener(new OpenDocumentAction(this.jevTree));
		
		this.desktop = new JevDesktop();
		this.desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		this.desktop.addController(new JevDesktopController(this.desktop));
		this.desktop.addActionManager(new JevDesktopActionManager(this.desktop.getController()));
		
		this.toolBar = new JevToolBar(this.jevTree);
		this.setJMenuBar(new JevMenuBar(this.jevTree,this.desktop));
		
		this.treeScrollPane = new JScrollPane(this.jevTree);
		this.treeScrollPane.setMinimumSize(new Dimension(150, 0));
		
		
		this.splitPane = new JSplitPane();
		this.splitPane.setLeftComponent(this.treeScrollPane);
		this.splitPane.setRightComponent(desktop);
		this.splitPane.setDividerLocation(150);
		
		this.setLayout(new BorderLayout());
		this.mainPanel.add(this.toolBar, BorderLayout.NORTH);
		this.mainPanel.add(this.splitPane, BorderLayout.CENTER);
		
		this.add(mainPanel);
	}
	
	public static MainFrame getInstance() {
		
		if(instance == null)
			instance = new MainFrame();
		
		return instance;
	}

	public JevDesktop getDesktop() {
		return desktop;
	}

	public JevTree getJevTree() {
		return jevTree;
	}
}