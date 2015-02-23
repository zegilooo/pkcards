package pokedeck;
import java.io.IOException;
import java.lang.reflect.Field;


public class Init {
	public static void getObject(Object obj) throws IllegalArgumentException, IllegalAccessException {
	    for (Field field : obj.getClass().getDeclaredFields()) {
	        System.out.println(field.getName()
	                 + " - " + field.getType()
	                 + " - " + field.get(obj));
	    }
	}   
	public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException {
		
		Deck deck = new Deck();
		deck.readFromFile("test.json");
		
	/*	
		deck.add(new Pkpkcard("pokemon", EnergyType.GRASS, 10, 20, 30));
		deck.add(new Pkenergycard(EnergyType.DRAGON));
		deck.add(new Pktrainercard("trainer", TrainerType.STADIUM, "blablabla"));
		
		deck.add(new Pkpkcard("pokemon", EnergyType.GRASS, 10, 20, 30));
		deck.add(new Pkenergycard(EnergyType.DRAGON));
		deck.add(new Pktrainercard("trainer", TrainerType.STADIUM, "blablabla"));
	*/	


		//Pkcard test = (Pkcard)deck.get(0);
		//getObject(test);
		//System.out.println(test.toJson(test));
		
	/*
		String json = deck.toJson();
		deck.saveToFile("test.json", json);
		
		System.out.println(deck.readFromFile("test.json"));
		
		Pkdeck deck2 = new Pkdeck();
		
	*/
		
	/*
		Console ihm = new Console(deck);
		ihm.start();
	*/

	}

}
