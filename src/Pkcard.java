
abstract public class Pkcard {
	private String Pkname;
	
	public Pkcard(String name){
		this.Pkname=name;
	}
	
	public String getName(){
		return this.Pkname;
	}
	
	public String toString(){
		return " Pkname :"+ this.Pkname;
	}
	
	public String toJson(){
		return "{\"Pkname\" : \""+ this.Pkname+"\"}";
	}
	
}
