
abstract public class Pkcard {
	private String Pktype;
	private String Pkname;
	
	public Pkcard(String type, String name){
		this.Pktype=type;
		this.Pkname=name;
	}
	
	public String getName(){
		return this.Pkname;
	}
	
	public String toString(){
		return "Pktype : "+this.Pktype+" Pkname :"+ this.Pkname;
	}
	
	public String toJson(){
		return "{\"Pktype\" : \""+this.Pktype+"\", \"Pkname\" : \""+ this.Pkname+"\"}";
	}
	
}
