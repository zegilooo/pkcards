import java.util.ArrayList;

public class Pkdeck {
	
	private ArrayList<Pkcard> deck;
	
	public Pkdeck (){
		this.deck = new ArrayList<Pkcard>();
	}
	
	public void add(Pkcard card){
		this.deck.add(card);
	}
	
	public Pkcard get(int i){
		return this.deck.get(i);
	}
	
	public void remove(int i){
		this.deck.remove(i);
	}
	
	public String toString(){
		String string = "";
		for (int i = 0; i < this.deck.size(); i++) {
			string += Integer.toString(i)+"\t"+this.deck.get(i).toString();
			if(i < this.deck.size()-1) string += "\n";
		}
        return string;
	}
	
	public String toJson(){
		String json = "[";
		for (int i = 0; i < this.deck.size(); i++) {
			json += this.deck.get(i).toJson();
			if(i < this.deck.size()-1) json += ", ";
		}
		json += "]";
        return json;
	}
}
