// File: Card.java
// Name: Jason Harkness
// Purpose: Create card class to define a playing card with suits and values
public class Card {
	
	private Suit suit;
	private CardValue cardValue;	
	
	public Card(CardValue cardValue, Suit suit) {
		this.cardValue = cardValue;
		this.suit = suit;
	}
	
	
	// Utilize enum type to set suit and card values because they are constant.
	 

	public enum Suit {
		HEARTS, DIAMONDS, CLUBS, SPADES;

	}

	public enum CardValue {
		ACE(11),TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), 
		NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);

		private final int value;
		
		private CardValue(int value) {
			this.value = value;
		}
		
		public int getCardValue() {
			return value;
		}
		
	}

	public CardValue getValue() {
		return this.cardValue;
	}
	public Suit getSuit() {
		return this.suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public String toString(){
		return "\n" + cardValue + " of " + suit;
	}
}
