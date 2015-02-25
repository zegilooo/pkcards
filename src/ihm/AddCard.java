package ihm;

import pokedeck.EnergyType;
import pokedeck.TrainerType;
import pokedeck.EnergyCard;
import pokedeck.PokemonCard;
import pokedeck.TrainerCard;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCard extends AWindow {

	private String[] cardTypes = new String[] {"Energy", "Trainer", "Pokemon"};

	private JPanel cardInfoPanel;
	private JPanel energyPanel;
	private JPanel trainerPanel;
	private JPanel pokemonPanel;
	
	private JComboBox<String> cardTypeCombobox;
	private JComboBox<EnergyType> energyTypeComboBox;
	private JComboBox<TrainerType> trainerTypeComboBox;
		
	private JTextField cardName;
	private JTextField trainerRule;
	private JTextField pokemonHp;
	private JTextField pokemonStage;
	private JTextField pokemonCollectorCardNumber;
	
	public AddCard(){
		super();
		this.init();
		this.changeSize(350, 300);
	}
	
	public void init() {		
		this.changeMainPanelLayoutManager(new BorderLayout());		
		this.panel.add(this.constructHeaderPanel(), BorderLayout.PAGE_START);		
		this.panel.add(this.constructCardInfoPanel(), BorderLayout.CENTER);		
		this.panel.add(this.constructButtonPanel(), BorderLayout.PAGE_END);
	}
	
	private JPanel constructHeaderPanel(){
		JPanel cardTypePanel = new JPanel();
		
		this.cardTypeCombobox = new JComboBox<String>(cardTypes);
		this.cardTypeCombobox.setSelectedIndex(0);
		this.cardTypeCombobox.addActionListener(new AddCardListener());
		
		cardTypePanel.add(new JLabel("Card type : "));
		cardTypePanel.add(this.cardTypeCombobox);
		
		return cardTypePanel;
	}
	
	private JPanel constructButtonPanel(){
		JPanel buttonsPanel = new JPanel();
		JButton menuButton = new JButton("Menu");
		JButton saveButton = new JButton("Save");
		
		menuButton.addActionListener(new AddCardListener());
		saveButton.addActionListener(new AddCardListener());
		
		buttonsPanel.add(menuButton);
		buttonsPanel.add(saveButton);
		
		return buttonsPanel;
	}
	
	private JPanel constructCardInfoPanel(){
		this.cardInfoPanel = new JPanel();		
		
		this.cardInfoPanel.add(this.constructEnergyPanel());
		
		return this.cardInfoPanel;
	}
	
	private JPanel constructEnergyPanel(){		
		this.energyPanel = new JPanel(new GridLayout(0, 2));
		this.energyTypeComboBox = new JComboBox<EnergyType>(EnergyType.values());
		
		this.energyPanel.add(new JLabel("Energy Type :"));
		this.energyPanel.add(this.energyTypeComboBox);
		
		return this.energyPanel;
	}
	
	private JPanel constructTrainerPanel(){
		this.trainerPanel = new JPanel(new GridLayout(0, 2));
		
		this.trainerTypeComboBox = new JComboBox<TrainerType>(TrainerType.values());		
		this.cardName = new JTextField();
		this.trainerRule = new JTextField();
		
		this.trainerPanel.add(new JLabel("Card Name :"));
		this.trainerPanel.add(this.cardName);
		
		this.trainerPanel.add(new JLabel("Trainer Type :"));
		this.trainerPanel.add(this.trainerTypeComboBox);
		
		this.trainerPanel.add(new JLabel("Rule :"));
		this.trainerPanel.add(this.trainerRule);
		
		return this.trainerPanel;
	}
	
	private JPanel constructPokemonPanel(){
		this.pokemonPanel = new JPanel(new GridLayout(0, 2));
		
		this.cardName = new JTextField();
		this.pokemonHp = new IntegerField();
		this.pokemonStage = new IntegerField();
		this.pokemonCollectorCardNumber = new IntegerField();
		this.energyTypeComboBox = new JComboBox<EnergyType>(EnergyType.values());
		
		this.pokemonPanel.add(new JLabel("Card Name :"));
		this.pokemonPanel.add(this.cardName);
		
		this.pokemonPanel.add(new JLabel("Energy Type :"));
		this.pokemonPanel.add(this.energyTypeComboBox);
		
		this.pokemonPanel.add(new JLabel("Health Points (1-9) :"));
		this.pokemonPanel.add(this.pokemonHp);
		
		this.pokemonPanel.add(new JLabel("Stage (1-9) :"));
		this.pokemonPanel.add(this.pokemonStage);
		
		this.pokemonPanel.add(new JLabel("Collector Card Number (1-9) :"));
		this.pokemonPanel.add(this.pokemonCollectorCardNumber);
		
		return this.pokemonPanel;
	}
	
	private void showCardInfoPanel(String cardType){
		this.cardInfoPanel.removeAll();
		
		switch(cardType){
			case "Energy":
				this.cardInfoPanel.add(this.constructEnergyPanel());
				break;
				
			case "Trainer":
				this.cardInfoPanel.add(this.constructTrainerPanel());
				break;
				
			case "Pokemon":
				this.cardInfoPanel.add(this.constructPokemonPanel());
				break;
		}
		
		this.validateWindow();
		this.panel.repaint();
	}
	
	private void saveCard(String cardType){
		switch(cardType){
			case "Energy":	
				EnergyCard aEnergyCard = new EnergyCard(
						this.energyTypeComboBox.getItemAt( this.energyTypeComboBox.getSelectedIndex()));
				this.deck.cards.add(aEnergyCard);
				break;
				
			case "Trainer":
				TrainerCard aTrainerCard = new TrainerCard(
						this.cardName.getText(),
						this.trainerTypeComboBox.getItemAt(this.trainerTypeComboBox.getSelectedIndex()),
						this.trainerRule.getText());
				this.deck.cards.add(aTrainerCard);
				break;
				
			case "Pokemon":
				int hp = Integer.parseInt(this.pokemonHp.getText());
				int stage = Integer.parseInt(this.pokemonStage.getText()); 
				int collectorCardNumber = Integer.parseInt(this.pokemonCollectorCardNumber.getText()); 
				
				PokemonCard aPokemonCard = new PokemonCard(
						this.cardName.getText(),
						this.energyTypeComboBox.getItemAt( this.energyTypeComboBox.getSelectedIndex()),
						hp,
						stage,
						collectorCardNumber);
				this.deck.cards.add(aPokemonCard);
				break;
		}
		
		this.showCardInfoPanel(cardType);
	}
	
	private class AddCardListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
				case "Menu":
					new Menu();
					break;
					
				case "comboBoxChanged":
					if(e.getSource() == cardTypeCombobox)
						showCardInfoPanel(cardTypeCombobox.getSelectedItem().toString());
					break;
					
				case "Save":
					saveCard(cardTypeCombobox.getSelectedItem().toString());
					break;
			}
		}
		
	}
}
