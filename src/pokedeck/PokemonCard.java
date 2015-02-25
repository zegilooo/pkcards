package pokedeck;

public class PokemonCard extends Card{
	
	public EnergyType energyType;	
	public String name;
	public int hp;
	public int stage;
	public int collectorCardNumber;
	
	public PokemonCard (String name, EnergyType energyType, int hp, int stage, int collectorCardNumber){
		super("PokemonCard");
		this.name = name;
		this.energyType = energyType;		
		this.hp = hp;	
		this.stage = stage;	
		this.collectorCardNumber = collectorCardNumber;	
	}
	
	public String toString(){
		return this.name+" "+this.energyType+" "+this.hp+" "+this.stage+" "+this.collectorCardNumber;
	}
	public String toJson(){
		return super.toJson(this);
	}
	public void fromJson(){}
	
}
