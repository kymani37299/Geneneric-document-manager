package jevDesktop.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import grafeditor.model.JevGraphicElement;
import grafeditor.view.Framework;
import model.element.JevElement;
import model.element.JevTextElement;
import view.MainFrame;

@SuppressWarnings("serial")
public class JevElementView extends JPanel implements Observer{
	
	public JevElementView(JevElement element){
		element.addObserver(this);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.updatePanel(element);
	}
	
	private void updatePanel(JevElement element){
		if(element instanceof JevTextElement){
			this.setBackground(Color.WHITE);
			JevTextElement textElement = (JevTextElement)element;
			JTextArea taText = new JTextArea(textElement.getText());
			taText.setEditable(false);
			taText.setBackground(Color.WHITE);
			this.add(taText);
			
		}else{
			JevGraphicElement diagramElement = (JevGraphicElement)element;			
			this.add(new Framework(diagramElement));
			this.setPreferredSize(new Dimension(1000, 600));
		}
	}
	
	private void updateDesktop(){
		MainFrame.getInstance().getDesktop().update();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.removeAll();
		JevElement element = (JevElement)o;
		this.updatePanel(element);
		this.updateDesktop();
		
	}
}
