/* Implements the card game war. The objective is to win all the cards in the deck. User is prompted to enter their name
and can choose to play the game. During the game, the user's name is displayed and the user is prompted to draw a card before each round. 
*/
 
import java.util.Scanner;
import java.util.Stack;

public class War {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printIntroduction();

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Do you want to play War? (Y/N): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Y")) {
            playWarGame(userName);
        } else {
            System.out.println("Thank you for considering. Have a great day!");
        }
    }
    // prints the introduction and rules of the game War
    private static void printIntroduction() {
        System.out.println("Welcome to the War Card Game!");
        System.out.println("=================================");
        System.out.println("Rules of the Game:");
        System.out.println("- Each player is dealt half of the shuffled deck.");
        System.out.println("- Players reveal the top card of their deck simultaneously.");
        System.out.println("- The player with the higher-ranked card wins the round and takes both cards.");
        System.out.println("- If the cards have the same rank, a war occurs.");
        System.out.println("- During a war, each player places three cards face down and one card face up.");
        System.out.println("- The player with the higher-ranked face-up card wins all the cards played in that round.");
        System.out.println("- The game continues until one player runs out of cards.");
        System.out.println("- The player with no cards at the end of the game loses.");
        System.out.println();
    }
    // shuffles the deck, deals cards to players, and starts the game
    private static void playWarGame(String userName) {
        Deck deck = new Deck();
        deck.shuffle();

        Stack<Card> player1Deck = new Stack<>();
        Stack<Card> player2Deck = new Stack<>();
        // deals cards to player decks
        deck.dealCards(player1Deck, player2Deck);
        // creates a new instance of the Game class and starts the game
        Game game = new Game(player1Deck, player2Deck, userName);
        game.play();
    }
}
