// File: Deck.java
// Name: Jason Harkness
// Purpose: Create deck to store card objects for dealing and shuffling

public class Deck {
	
	ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		deck = new ArrayList<Card>();
		fill();
		shuffle();
	}
	
	// Fill deck with cards
	public void fill() {
		
		for (Card.Suit s : Card.Suit.values() ) {
			for (Card.CardValue v : Card.CardValue.values()) {
				Card c = new Card(v,s);
				deck.add(c);
				c.toString();
			}
		}
	}
	
	// Algorithm to shuffle deck
	public void shuffle() {
		 ArrayList<Card> temp = new ArrayList<Card>();
	        while(!deck.isEmpty()) {
	            int loc=(int)(Math.random()*deck.size());
	            temp.add(deck.get(loc));
	            deck.remove(loc);   
	        }
	        deck=temp;
	    }     
	
	// Get card from deck
	public Card getCard(int index) {
		Card c = deck.get(index);
		deck.remove(index);
		return c;
		
	}

}
