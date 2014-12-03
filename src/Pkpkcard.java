
public class Pkpkcard extends Pkcard{
	
	private EnergyType energyType;	
	private int hp;
	private int stage;
	private int collectorCardNumber;
	
	public Pkpkcard (String name, EnergyType energyType, int hp, int stage, int collectorCardNumber){
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
		return "{\"name\":\""+super.getName()+"\",\"energyType\":\""+this.energyType+"\", \"hp\":"+this.hp+", \"stage\": "+
				this.stage+", \"collectorCardNumber\":"+this.collectorCardNumber+"}";
	}
}
