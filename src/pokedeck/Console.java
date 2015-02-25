package pokedeck;
import java.util.Scanner;

public class Console {
	
	Deck deck;
	Scanner scanner;
	boolean exit;
	
	
	public Console(Deck deck){
		this.deck = deck;
		this.exit = false;
	}
	
	public void start(){
		while(this.exit==false) this.menu();
		System.out.println("------ Au revoir ! -------");
	}
	
	public void menu(){
		this.scanner = new Scanner(System.in);
		System.out.println("--------- Menu ----------");
		System.out.println("Ajouter une carte : \t1");
		System.out.println("Supprimer une carte : \t2");
		System.out.println("Lister les cartes : \t3");
		System.out.println("Arreter le programme : \t0");
		int i = this.scanner.nextInt();
		switch(i){
			case 0: 
				this.exit = true;
			break;
			case 1: 
				this.addCard();
			break;
			case 2: 
				this.removeCard();
			break;
			case 3: 
				this.listCards();
			break;
		}		
	}
	
	public void addCard(){
		this.scanner = new Scanner(System.in);
		System.out.println("Type de la carte à ajouter");
		System.out.println("Pokemon : \t1");
		System.out.println("Energy : \t2");
		System.out.println("Trainer : \t3");
		int i = this.scanner.nextInt();
		switch(i){
			case 1: 
				this.addPokemonCard();
			break;
			case 2: 
				this.addEnergyCard();
			break;
			case 3: 
				this.addTrainerCard();
			break;
		}
		
	}
	
	public void removeCard(){
		this.scanner = new Scanner(System.in);
		System.out.println("Quelle carte voulez vous supprimer ?");
		System.out.println(this.deck);
		int i = this.scanner.nextInt();
		if (i >-1) this.deck.cards.remove(i);
	}

	public void listCards(){
		System.out.println(this.deck);
	}
	
	public void addPokemonCard(){
		
	}
	public void addEnergyCard(){
		
	}
	public void addTrainerCard(){
		
	}
	
	
}
