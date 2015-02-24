package pokedeck;

public class TrainerCard extends Card{
	
	private TrainerType trainerType;
	private String name;
	private String trainerRule;
	
	public TrainerCard (String name, TrainerType trainerType, String trainerRule){
		super("TrainerCard");	
		this.name = name;
		this.trainerType = trainerType;
		this.trainerRule = trainerRule;
	}
	
	public String toString(){
		return this.name+" "+this.trainerType.toString()+" "+this.trainerRule;
	}
	
	public String toJson(){
		return super.toJson(this);
	}
	
}

