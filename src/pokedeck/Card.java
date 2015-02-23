package pokedeck;
import com.google.gson.Gson;

abstract public class Card {
	private String Pkname;
	private static final Gson gson = new Gson(); 
	
	public Card(String name){
		this.Pkname=name;
	}
	
	public String getName(){
		return this.Pkname;
	}
	
	public String toString(){
		return " Pkname :"+ this.Pkname;
	}
	
	public String toJson(Object o){
		return gson.toJson(o);
	}
	
}
