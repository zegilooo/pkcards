
public class Pkenergycard extends Pkcard{
	
	private EnergyType energyType;
	
	public Pkenergycard (EnergyType energyType){
		super("");	
		this.energyType = energyType;
	}
	
	public String toString(){
		return this.energyType.toString();
	}
	
	public String toJson(){
		return "{\"energyType\":\""+this.energyType.toString()+"\"}";
	}
}

