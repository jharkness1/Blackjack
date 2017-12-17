// File: Hand.java
// Name: Jason Harkness
// Purpose: Store information for players hand 

public class Hand {

	private ArrayList<Card> hand;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	public void getCard(int i, Deck d) {
			hand.add(d.getCard(i));

			 
	}
	
	public Card getCard(int i) {
		Card c = hand.get(i);
		return c;
	}
	
	public String toString() {
		return hand.toString();
	}
}
