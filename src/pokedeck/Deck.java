package pokedeck;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson; 
import com.google.gson.reflect.TypeToken;

public class Deck {
	
	private ArrayList<Card> deck;
	private static final Gson gson = new Gson(); 
	
	public Deck (){
		this.deck = new ArrayList<Card>();
	}
	
	public void add(Card card){
		this.deck.add(card);
	}
	
	public Card get(int i){
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
		 return gson.toJson(this.deck);
	}
	
	public String readFromFile(String path) throws IOException{
		String content ="";
		BufferedReader br = new BufferedReader(new FileReader(path));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        content = sb.toString();
	        ArrayList<Object> tempo = gson.fromJson(content, new TypeToken<ArrayList<Object>>(){}.getType());
	        for (int i = 0; i < tempo.size(); i++) {
				System.out.println(tempo.get(i));
			}

	    } finally {
	        br.close();
	    }

		return content;
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
