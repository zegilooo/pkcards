
public class Pkenergycard extends Pkcard{
	
	private EnergyType energyType;
	
	public Pkenergycard (String name, EnergyType energyType){
		super("Pkenergycard", name);	
		this.energyType = energyType;
	}
	
	public String toString(){
		return super.getName()+" "+this.energyType;
	}
	public String toJson(){
		return "{\"name\":\""+super.getName()+"\",\"energyType\":\""+this.energyType+"\"}";
	}
}

