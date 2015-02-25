package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class Menu extends AWindow {

	private JButton addButton;
	private JButton exploreButton;
	private JButton exitButton;
	
	public Menu(){
		super();
		this.init();
		this.changeSize(400,400);
	}
	
	public void init() {
		this.addButton = new JButton("Restore last data");
		this.addButton.addActionListener(new MenuListener());
		this.panel.add(this.addButton);
		
		this.addButton = new JButton("Add a card");
		this.addButton.addActionListener(new MenuListener());
		this.panel.add(this.addButton);
		
		this.exploreButton = new JButton("List cards");
		this.exploreButton.addActionListener(new MenuListener());
		this.panel.add(this.exploreButton);

		this.addButton = new JButton("Backup this data");
		this.addButton.addActionListener(new MenuListener());
		this.panel.add(this.addButton);
		
		this.exitButton = new JButton("Exit");
		this.exitButton.addActionListener(new MenuListener());
		this.panel.add(this.exitButton);
	}
	
	private class MenuListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
			
				case "Restore last data":
					try {
						deck.restoreLastDeck();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					break;
				
				case "Add a card":
					new AddCard();
					break;
					
				case "List cards":
					new ListCards();
					break;
					
				case "Backup this data":
					try {
						deck.saveLastDeck();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					break;
					
				case "Exit":
					System.exit(0);
					break;
			}
		}
		
	}

}
