
public class Pktrainercard extends Pkcard{
	
	private TrainerType trainerType;
	private String trainerRule;
	
	public Pktrainercard (String name, TrainerType trainerType, String trainerRule){
		super("Pktrainercard", name);	
		this.trainerType = trainerType;
		this.trainerRule = trainerRule;
	}
	
	public String toString(){
		return super.getName()+" "+this.trainerType+" "+this.trainerRule;
	}
	
	public String toJson(){
		return "{\"name\":\""+super.getName()+"\",\"trainerType\":\""+this.trainerType+"\",\"trainerRule\":\""+this.trainerRule+"\"}";
	}
	
}

