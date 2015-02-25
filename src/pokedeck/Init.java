package pokedeck;
import ihm.Menu;

import java.io.IOException;

public class Init {
	public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException {
		
		Menu menu = new Menu();
		
		/*Deck deck = new Deck();		

		deck.cards.add(new PokemonCard("pokemon", EnergyType.GRASS, 10, 20, 30));
		deck.cards.add(new EnergyCard(EnergyType.DRAGON));
		deck.cards.add(new TrainerCard("trainer", TrainerType.STADIUM, "blablabla"));
		
		deck.cards.add(new PokemonCard("pokemon", EnergyType.GRASS, 15, 25, 35));
		deck.cards.add(new EnergyCard(EnergyType.FIGHTING));
		deck.cards.add(new TrainerCard("trainer", TrainerType.SUPPORTER, "blablabliblabla"));
	
		Card test = (Card)deck.cards.get(3);
		System.out.println(test.toJson(test));
		
		String json = deck.toJson();
		deck.saveToFile("test.json", json);
				
		Deck deck2 = new Deck();
		deck2.readFromFile("test.json");
		
		Card test2 = (Card)deck2.cards.get(1);
		System.out.println(test2.toJson(test2));
		
		String json2 = deck2.toJson();
		deck2.saveToFile("test2.json", json2);
*/
	}

}
