import java.util.ArrayList;

public class Init {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Pkcard> deck = new ArrayList<Pkcard>();
		
		deck.add(new Pkpkcard("pokemon", EnergyType.GRASS, 10, 20, 30));
		deck.add(new Pkenergycard("energy", EnergyType.DRAGON));
		deck.add(new Pktrainercard("trainer", TrainerType.STADIUM, "blablabla"));
		
		String json = "[";
		for (int i = 0; i < deck.size(); i++) {
			json += deck.get(i).toJson();
			if(i < deck.size()-1) json += ", ";
		}
		json += "]";

        System.out.println(json);
		
	}

}
