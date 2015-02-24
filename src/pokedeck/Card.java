package pokedeck;
import com.google.gson.Gson;

abstract public class Card {
	public String cardType;
	private static final Gson gson = new Gson(); 
	
	public Card(String cardType){
		this.cardType=cardType; // needed for the method 'fromJson'
	}
	
	public String toString(){
		return "cardType :"+ this.cardType;
	}
	public String toJson(Object o){
		return gson.toJson(o);
	}
	
}
