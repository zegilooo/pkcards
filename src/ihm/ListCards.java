package ihm;

import pokedeck.EnergyCard;
import pokedeck.PokemonCard;
import pokedeck.TrainerCard;
import pokedeck.Card;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListCards extends AWindow {
	
	public ListCards(){
		super();
		this.init();
		this.changeSize(1400, 550);
	}
	
	public void init() {		
		this.panel.add(this.constructHeaderPanel());		
		this.panel.add(this.constructCardTablesPanel());	
		this.panel.add(this.constructButtonPanel());
	}
	
	private JPanel constructHeaderPanel() {
		JPanel countPanel = new JPanel();
		
		countPanel.add(new JLabel("Number of cards : " + super.deck.cards.size()));
		
		return countPanel;
	}
	
	private JPanel constructButtonPanel() {
		JPanel buttonsPanel = new JPanel();
		JButton menuButton = new JButton("Menu");
		
		menuButton.addActionListener(new ListCardsListener());
		buttonsPanel.add(menuButton);
		
		return buttonsPanel;
	}
	
	private JPanel constructCardTablesPanel(){
		JPanel cardTablePanel = new JPanel();
		
		ArrayList<Card> cards = super.deck.cards;
		ArrayList<EnergyCard> energyCards = new ArrayList<EnergyCard>();
		ArrayList<TrainerCard> trainerCards = new ArrayList<TrainerCard>();
		ArrayList<PokemonCard> pokemonCards = new ArrayList<PokemonCard>();
		
		for(Card c : cards){
			if(c instanceof EnergyCard){
				energyCards.add((EnergyCard) c);
			}else if(c instanceof TrainerCard){
				trainerCards.add((TrainerCard) c);
			}else if(c instanceof PokemonCard){
				pokemonCards.add((PokemonCard) c);
			}
		}
		
		cardTablePanel.add(new JScrollPane(this.constructEnergyCardTable(energyCards)));
		cardTablePanel.add(new JScrollPane(this.constructTrainerCardTable(trainerCards)));
		cardTablePanel.add(new JScrollPane(this.constructPokemonCardTable(pokemonCards)));
		
		return cardTablePanel;
	}
	
	private JTable constructEnergyCardTable(ArrayList<EnergyCard> energyCards){
		String[] energyCardTableHeader = new String[] {"Name", "Energy Type"};
		String[][] energyCardsData = new String[energyCards.size()][energyCardTableHeader.length];
		JTable energyCardsTable = new JTable(energyCardsData, energyCardTableHeader);
		
		int i = 0;
		for(EnergyCard ec : energyCards){
			energyCardsData[i][0] = ec.energyType.toString();
			i++;
		}
		
		return energyCardsTable;
	}
	
	private JTable constructTrainerCardTable(ArrayList<TrainerCard> trainerCards){
		String[] trainerCardTableHeader = new String[] {"Name", "Trainer Type", "Rule"};
		String[][] traineCardsData = new String[trainerCards.size()][trainerCardTableHeader.length];
		JTable trainerCardsTable = new JTable(traineCardsData, trainerCardTableHeader);
		
		int i = 0;
		for(TrainerCard tc : trainerCards){
			traineCardsData[i][0] = tc.name;
			traineCardsData[i][1] = tc.trainerType.toString();
			traineCardsData[i][2] = tc.trainerRule;
			i++;
		}
		
		return trainerCardsTable;
	}

	private JTable constructPokemonCardTable(ArrayList<PokemonCard> pokemonCards){
		String[] pokemonCardTableHeader = new String[] {"Name", "Energy Type", "Health Points", "Stage", "Collector Card Number"};
		String[][] pokemonCardsData = new String[pokemonCards.size()][pokemonCardTableHeader.length];
		JTable pokemonCardsTable = new JTable(pokemonCardsData, pokemonCardTableHeader);
		
		int i = 0;
		for(PokemonCard pc : pokemonCards){
			pokemonCardsData[i][0] = pc.name;
			pokemonCardsData[i][1] = pc.energyType.toString();
			pokemonCardsData[i][2] = new Integer(pc.hp).toString();
			pokemonCardsData[i][3] = new Integer(pc.stage).toString();
			pokemonCardsData[i][4] = new Integer(pc.collectorCardNumber).toString();
			
			i++;
		}
		
		return pokemonCardsTable;
	}

	private class ListCardsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
				case "Menu":
					new Menu();
					break;
			}
		}
		
	}
}
