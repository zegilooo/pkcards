package pokedeck;

public class PokemonCard extends Card{
	
	private EnergyType energyType;	
	private int hp;
	private int stage;
	private int collectorCardNumber;
	
	public PokemonCard (String name, EnergyType energyType, int hp, int stage, int collectorCardNumber){
		super(name);
		this.energyType = energyType;		
		this.hp = hp;	
		this.stage = stage;	
		this.collectorCardNumber = collectorCardNumber;	
	}
	
	public String toString(){
		return super.getName()+" "+this.energyType+" "+this.hp+" "+this.stage+" "+this.collectorCardNumber;
	}
	public String toJson(){
		return super.toJson(this);
	}
	public void fromJson(){}
	
}
