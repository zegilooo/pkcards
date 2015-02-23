package pokedeck;

public class EnergyCard extends Card{
	
	private EnergyType energyType;
	
	public EnergyCard (EnergyType energyType){
		super("");	
		this.energyType = energyType;
	}
	
	public String toString(){
		return this.energyType.toString();
	}
	
	public String toJson(){
		return super.toJson(this);
	}
}

