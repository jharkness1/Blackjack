// File: CardTable.java
// Name: Jason Harkness
// Purpose: Driver class to hold logic for game and run main method
import java.util.Scanner;

//Driver class to initiate game, layout rules and create logic for game implementation
public class CardTable {
	public static Player p1;
	public static Hand playerHand;
	public static Hand dealerHand;
	public static int pCardTotal = 0;
	public static int pCardCount = 0;
	public static int dCardCount = 0;
	public static int dCardTotal = 0;
	public static int dNumCards = 0;
	public static int pNumCards = 0;
	public static int pAceTotal = 0;
	public static int dAceTotal = 0;
	public static int pAceCount = 0;
	public static int dAceCount = 0;
	public static boolean playerBust = false;
	public static boolean pAceToOne = false;
	public static boolean dAceToOne = false;

	public static void main(String[] args) {
		System.out.println("-----------Welcome to the game of BlackJack-----------"

				+ "\n\n Game Rules: "

				+ "\n\n -The players are each dealt 2 cards to start the hand"
				+ "\n -The player can choose to hit one or more times, or stand with any amount"
				+ "\n -The dealer must hit if his cards total less than 17 and stand otherwise"
				+ "\n -If the player�s or dealer�s cards total over 21, they bust and their turn is over"
				+ "\n -If either player has 21 with their first two cards, they win (if both have 21 they tie)"
				+ "\n -If both players bust, the dealer wins" + "\n -If both players have the same score, they tie"
				+ "\n -The player always takes their turn before the dealer"
				+ "\n -All cards count as their face value, except A which can be 1 or 11 and J, Q, K all count as 10"
				+ "\n -The deck should be shuffled before each game"

				+ "\n\nEnter Player Name: ");

		// Get input for players name
		Scanner s = new Scanner(System.in);
		String input = "";
		do {
			input = s.nextLine();
			if (input.hashCode() == 0) {
				System.out.println("Please enter a name!");
			} else {
				p1 = new Player(input);

				// Welcome statement
				System.out.println(
						"\nHello " + p1.getName() + ", I am the " + Dealer.getName() + " and I will be your Dealer!\n");
				startGame();
			}
		} while (input.hashCode() == 0);
		s.close();
	}

	public static void startGame() {

		// Create new deck of 52 cards
		Deck d = new Deck();
		// Shuffle deck
		d.shuffle();

		// Deal player 2 cards and show cards
		playerHand = new Hand();
		playerHand.getCard(0, d);
		playerHand.getCard(0, d);
		pNumCards = 2;
		pCheckForAce(0);
		pCheckForAce(1);
		pAceCount = pAceTotal;
		pAcountForAce();
		pHand();
		delay(1000);
		pCardTotal = ((playerHand.getCard(0).getValue().getCardValue())
				+ (playerHand.getCard(1).getValue().getCardValue()));

		// Deal dealer 2 cards and show cards
		dealerHand = new Hand();
		dealerHand.getCard(0, d);
		dHand();
		dealerHand.getCard(0, d);
		dNumCards = 2;
		dCheckForAce(0);
		dCheckForAce(1);
		dAceCount = dAceTotal;
		pAcountForAce();
		
		delay(1000);
		System.out.println("\nDealer also has 1 card facedown");
		delay(1000);
		System.out.println("\nDealer looks at facedown card\n");
		delay(1000);

		dCardTotal = ((dealerHand.getCard(0).getValue().getCardValue())
				+ (dealerHand.getCard(1).getValue().getCardValue()));

		// If player hand totals 21 but dealer doesn't player wins
		if (pCardTotal == 21 && dCardTotal < 21) {
			dHand();
			pBWin();

			startNewRound();
		}
		// If dealer hand totals 21 but player doesn't dealer wins
		if (dCardTotal == 21 && pCardTotal < 21) {
			dHand();
			dBWin();
			startNewRound();
		}
		// If both players have 21 they tie
		if (dCardTotal == 21 && pCardTotal == 21) {
			dHand();
			gameTie();
			startNewRound();
		}
		// playercardcount = 2
		// dealercardcount = 2

		// Player gets option to hit or stand
		pH_S();
		// If player hits, add card to hand and show card // playercardcount = 3
		Scanner s1 = new Scanner(System.in);
		String input1 = "";

		label2: do {
			label1: do {
				input1 = s1.nextLine();
				if (input1.equalsIgnoreCase("hit")) {
					delay(1000);
					input1 = null;

					playerHand.getCard(0, d);
					pNumCards++;
					playerCardTotal(pNumCards - 1);
					pHand();

					pCheckForAce(pNumCards - 1);
					pAceCount = pAceTotal;

					// If player has an ace and card total is over 21 subtract
					// 10
					// from total
					pAcountForAce();

					// If player is still over 21 player busts
					if (pCardTotal > 21) {
						System.out.println("Player busts! It's the dealers turn.\n");
						playerBust = true;
						delay(2000);
						break label2;
					}

					/* if player hand is equal to 21 players turn is over */
					if (pCardTotal == 21) {
						System.out.println("Player's hand total is 21! It is now the dealers turn");
						delay(2000);
						break label2;
					}

					/*
					 * else if player hand is less than 21 give player option to
					 * hit or stand
					 */
					else if (pCardTotal < 21) {
						
						pH_S();
						break label1;
					}
				}

				if (input1.equalsIgnoreCase("stand")) {
					System.out.println("Player has decided to stand with a card total of " + pCardTotal);
					delay(2000);
					break label2;

				}
			} while (!input1.equalsIgnoreCase("hit") || !input1.equalsIgnoreCase("stand"));

		} while (true);

		// Dealer starts their turn
		System.out.println("\nDealer's Turn:"); // dealer card total = 2
		dHand();

		// If dealer has an ace and card total is over 21 subtract 10
		// from total
		dAcountForAce();

		label4: do {
			label3: do {
				// if dealers hand is 17 or greater dealer must stand
				if (dCardTotal >= 17) {

					// if dealers hand is greater than players and player didn't
					// bust
					if (dCardTotal > pCardTotal && playerBust == false && dCardTotal <= 21) {
						dWin();
						startNewRound();
						break label4;
						
					}
					// if dealer bust and player didnt player wins
					else if (dCardTotal > 21 && playerBust == false) {
						pWin();
						startNewRound();
						break label4;
					}
					// if dealers had is less than players and player didnt bust
					else if (dCardTotal < pCardTotal && playerBust == false) {
						pWin();
						startNewRound();
						break label4;
					}
					// if player bust dealer wins
					else if (playerBust == true && dCardTotal <= 21) {
						dWin();
						startNewRound();
						break label4;
					}
					// if both bust dealer wins
					if (dCardTotal > 21 && playerBust == true) {
						dWin();
						startNewRound();
						break label4;
					}
					// if players tie
					else if (pCardTotal == dCardTotal) {
						gameTie();
						startNewRound();
						break label4;
					}

				} else if (dCardTotal < 17) {
					// Dealer draws card
					dealerHand.getCard(0, d);
					dNumCards++;
					dealerCardTotal(dNumCards - 1);
					
					System.out.println("\nDealer is dealt a card");
					
					dHand();
					dCheckForAce(dNumCards - 1);
					dAceCount = dAceTotal;

					// If dealer has an ace and card total is over 21 subtract
					// 10
					// from total
					dAcountForAce();
					delay(2000);
					break label3;

				}
				s1.close();
			} while (true);
		} while (true);
	}

	public static void gameTie() {
		System.out.println("\n********************************" + "\n**********It's a TIE!!!*********"
				+ "\n********************************");
	}

	public static void pBWin() {
		System.out.println("\n********************************" + "\n****BLACKJACK!! " + p1.getName() + " wins!!***"
				+ "\n********************************");
	}

	public static void pWin() {
		System.out.println("\n***************************************************" + "\n*Dealer's total is " + dCardTotal + ". "
				+ p1.getName() + " wins with total of " + pCardTotal + "*" + "\n***************************************************");
	}

	public static void dBWin() {
		System.out.println("\n********************************" + "\n****BLACKJACK!! Dealer Wins!!***"
				+ "\n********************************");
	}

	public static void dWin() {

		System.out.println("\n*********************************************************" + "\n*Player's total is " + pCardTotal +
				". Dealer wins with card total of "
				+ dCardTotal + "*" + "\n*********************************************************");
	}

	public static void pHand() {
		System.out.println("\nPlayer hand is: \n" + playerHand.toString().replace("[", "").replace("]", ""));
	}

	public static void dHand() {
		System.out.println("\nDealer hand is: \n" + dealerHand.toString().replace("[", "").replace("]", ""));
	}

	public static void pH_S() {
		System.out.println("\nWill " + p1.getName() + " hit or stand? Please enter 'hit' or 'stand'.\n");
	}

	public static void hit_standError() {
		System.out.println("Please enter 'hit' or 'stand'");
	}

	public static void startNewRound() {
		System.out.print("Want to play another round? Enter Y or N\n");
		Scanner s1 = new Scanner(System.in);
		String input = s1.nextLine();
		if (input.equalsIgnoreCase("y")) {
			resetVar();
			startGame();

		} else if (input.equalsIgnoreCase("n")) {
			System.out.println("Thank you for playing! Exit the window to close game.");
			System.exit(0);
		} else {
			System.out.println("Wrong input");
			startNewRound();
		}
		s1.close();
	}

	public static void playerCardTotal(int i) {
		pCardTotal += playerHand.getCard(i).getValue().getCardValue();

	}

	public static void dealerCardTotal(int i) {
		dCardTotal += dealerHand.getCard(i).getValue().getCardValue();

	}

	public static int pCheckForAce(int i) {
		int result = 0;
		if (playerHand.getCard(i).getValue() == (Card.CardValue.ACE)) {
			result = 1;
			pAceTotal++;
		}
		return result;
	}

	public static int dCheckForAce(int i) {
		int result = 0;
		if (dealerHand.getCard(i).getValue() == (Card.CardValue.ACE)) {
			result = 1;
			dAceTotal++;
		}
		return result;
	}

	public static void pAcountForAce() {
		// If player has an ace and card total is over 21 subtract 10
		// from total

	if (pAceTotal > 0 && pCardTotal > 21) {
			do {
				for (int i = 1; i < pAceTotal + 1; i++) {
					pCardTotal = pCardTotal - (10 * i);
					pAceCount--;
					pAceTotal--;
				}
			} while (pAceCount > 0 && pCardTotal > 21);

		}
	}

	public static void dAcountForAce() {
		// If dealer has an ace and card total is over 21 subtract 10
		// from total
		if (dAceTotal > 0 && dCardTotal > 21) {
			do {
			dCardTotal = dCardTotal - 10;
			dAceCount--;
			dAceTotal--;
			}while (dAceCount > 0 && dCardTotal > 21);
		} else if (dAceTotal > 0 && dCardTotal > 17 && dCardTotal <= 21 && dCardTotal < pCardTotal
				&& playerBust == false) {
			do {
				for (int i = 1; i < dAceTotal + 1; i++) {
					dCardTotal = dCardTotal - (10 * i);
					dAceCount--;
					dAceTotal--;
				}
			}while (dAceCount > 0);
		}
	}
	
	public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException exp) {
        }
    }

	public static void resetVar() {
		pCardTotal = 0;
		pCardCount = 0;
		dCardCount = 0;
		dCardTotal = 0;
		dNumCards = 0;
		pNumCards = 0;
		pAceTotal = 0;
		dAceTotal = 0;
		pAceCount = 0;
		dAceCount = 0;
		playerBust = false;
		pAceToOne = false;
		dAceToOne = false;

	}
}
