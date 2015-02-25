package ihm;

import pokedeck.Deck;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public abstract class AWindow {
	
	private Window window;
	public Deck deck;
	protected JPanel panel;
	
	public AWindow(){
		this.window = Window.getInstance();
		this.deck = Deck.getInstance();
		this.panel = new JPanel(new GridLayout(0, 1, 0, 0));
		this.window.addPanel(panel);
	}
	
	abstract public void init();
	
	protected void changeSize(int w, int h){
		this.window.changeSize(w, h);
	}
	
	protected void changeMainPanelLayoutManager(LayoutManager lm){
		this.panel.setLayout(lm);
	}
	
	protected void validateWindow(){
		this.window.validate();
	}
}
