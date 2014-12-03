import java.util.ArrayList;

public class Init {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pkdeck deck = new Pkdeck();
		deck.add(new Pkpkcard("pokemon", EnergyType.GRASS, 10, 20, 30));
		deck.add(new Pkenergycard(EnergyType.DRAGON));
		deck.add(new Pktrainercard("trainer", TrainerType.STADIUM, "blablabla"));
		
		//IHM ihm = new IHM(new Pkdeck());

		IHM ihm = new IHM(deck);
		ihm.start();
		
		/*
		Pkdeck deck = new Pkdeck();
		deck.add(new Pkpkcard("pokemon", EnergyType.GRASS, 10, 20, 30));
		deck.add(new Pkenergycard(EnergyType.DRAGON));
		deck.add(new Pktrainercard("trainer", TrainerType.STADIUM, "blablabla"));
		
		System.out.println("----------------- The deck toString -----------------");
        System.out.println(deck);
		System.out.println("-----------------  The deck toJson  -----------------");
        System.out.println(deck.toJson());
        
        deck.remove(1);
        
		System.out.println("----------------- The deck toString -----------------");
        System.out.println(deck);
		System.out.println("-----------------  The deck toJson  -----------------");
        System.out.println(deck.toJson());
        */
		
	}

}
