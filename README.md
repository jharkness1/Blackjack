Blackjack Technical Assessment
The purpose of this project is to create a simplified version of the game Blackjack using
Java as the development language. The object of the game is to have two players that are
dealt cards, the "human" and the dealer and each are trying to get as close to or equal to
a total card value of 21 without going over. The entire game is text based as no GUI was 
required. 
Included Files
- All java source code
	Card.java
	CardTable.java
	Dealer.java
	Deck.java
	Hand.java
	Person.java
	Player.java

- UML diagram: Blackjack UML.png
- .jar file to run program: BlackjackAssessment.jar 
- Readme.docx 

Prerequisites 
A computer with a Java Platform to deploy Java applications, the most current of which is 
Java Platform(JDK) 9. It can be found at http://www.oracle.com/technetwork/java/javase/downloads/index.html.

Running the Program
To run the program, you can either use the command line or use a Java IDE such as Eclipse.
For this readme I will be using the command line in Windows. 

Step 1: Check that Java is installed
Type java -version into your command line. If java is installed, you will see a message stating what version of Java is currently installed.
If not, you may need to install the Java Development Kit from their website. It is free and can be found at this link: http://www.oracle.com/technetwork/java/javase/downloads/index.html.

Step 2: Navigate to the correct folder 
Use the command cd followed by the directory name to change your working directory.
For example, if you were operating in C:\Users\Bob\Project and wanted to get to C:\Users\Bob\Project\TitanProject , enter in cd TitanProject and press ↵ Enter.
You can see a list of what is in your current directory by typing dir and pressing ↵ Enter.

Step 3: Run the program
Once you are in the correct directory, you can compile the program by typing 
java -jar BlackjackAssessment.jar into the command line and pressing enter.
If you have any errors in your program, or if there is difficultly compiling, the command prompt will notify you.

Using the Program
After the program starts a welcome screen will be displayed with the rules and ask the user to input their name and then hit enter. The deck will be shuffled before each game. Once the users name is entered 2 cards will be dealt to the player and the dealer with one of the dealers cards being facedown. The player will take their turn first and be given the option to hit or stand. The player must then enter ‘hit’ or ‘stand’ and then hit enter to confirm their choice. If any other text is input or no text is input at all then the program will not progress until the player enters the correct input. Once the players turn is over the player, depending on if the player or dealer had a blackjack the dealer will take their turn. After the dealers turn is over the hands will be compared and the winner declared. Once the winner is declared an option will be given for the player to enter ‘y’ or ‘n’ to play another round. If ‘y’ is chosen the process repeats, if ‘n’ is chosen no new hand is dealt and the player is prompted to close the window. 



