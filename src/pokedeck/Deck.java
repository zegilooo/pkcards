package pokedeck;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson; 
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class Deck {
	
	public ArrayList<Card> cards;
	private static final Gson gson = new Gson(); 
	private static Deck instance = null;
	
	public Deck (){
		this.cards = new ArrayList<Card>();
	}
	
	public static Deck getInstance(){
		//needed to keep the same instance during the program
		if(instance == null)
			instance = new Deck();
		return instance;
	}
	
	public String toString(){
		String string = "";
		for (int i = 0; i < this.cards.size(); i++) {
			string += Integer.toString(i)+"\t"+this.cards.get(i).toString();
			if(i < this.cards.size()-1) string += "\n";
		}
        return string;
	}
	
	public String toJson(){
		 return gson.toJson(this.cards);
	}
	
	public void saveLastDeck() throws IOException{
		String json = this.toJson();
		this.saveToFile("backup.json", json);
	}

	public void restoreLastDeck() throws IOException{
		this.readFromFile("backup.json");
	}
	
	public void deserialize(JsonElement je)
	        throws JsonParseException
	    {
	        JsonElement content = je.getAsJsonObject().get("cardType");
	        String cardType = content.toString();
	        switch (cardType)
	        {
	          case "\"PokemonCard\"":
	        	  this.cards.add(gson.fromJson(je, PokemonCard.class));
	            break;
	          case "\"EnergyCard\"":
	        	  this.cards.add(gson.fromJson(je, EnergyCard.class));
	            break;
	          case "\"TrainerCard\"":
	        	  this.cards.add(gson.fromJson(je, TrainerCard.class));
	            break;
	          default :
	      		System.out.println("Deck.deserialize() error");
	        }
	    }
	
	public void readFromFile(String path) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(path));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(path)));
	        JsonParser jsonParser = new JsonParser();
	        JsonArray cardArray= jsonParser.parse(reader).getAsJsonArray();
	        for ( JsonElement aCard : cardArray ) {
	        	deserialize(aCard);
	        	}
	        
	    } finally {
	        br.close();
	    }
	} 
	
	public void saveToFile(String path, String content) throws IOException{
		FileWriter writer = null;
		try{
		     writer = new FileWriter(path, true);
		     writer.write(content,0,content.length());
		}catch(IOException ex){
		    ex.printStackTrace();
		}finally{
		  if(writer != null){
		     writer.close();
		  }
		}
	}
}
