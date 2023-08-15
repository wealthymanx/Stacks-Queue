/* 
This program implements the card game War. The objective of the game is to win all the cards in the deck.
The game starts by shuffling the deck and dealing half of the cards to the user and the
other half to the computer. In each round, both players reveal the top card of their deck,
and the player with the higher-ranked card wins the round, collecting both cards. If the
cards have the same rank, a war occurs, where additional cards are played. During a war,
each player places three cards face down and one card face up. The player with the higher-ranked
card wins all the cards played in that round. The game continues until one player runs out
of cards and loses, or both players run out and the game ends in a tie.
*/

import java.util.*;

public class Game {
    private Stack<Card> player1Deck;
    private Stack<Card> player2Deck;
    private String userName;
    private static final int MAX_ROUNDS = 500;

    public Game(Stack<Card> player1Deck, Stack<Card> player2Deck, String userName) {
        this.player1Deck = player1Deck;
        this.player2Deck = player2Deck;
        this.userName = userName;
    }
    // starts the game and executes the rounds
    public void play() {
        int round = 1;
        Scanner scanner = new Scanner(System.in);
        // game loop
        while (!player1Deck.isEmpty() && !player2Deck.isEmpty() && round <= MAX_ROUNDS) {
            Card player1Card = player1Deck.pop();
            Card player2Card = player2Deck.pop();

            System.out.println("Round " + round + ":");
            System.out.println(userName + ": " + player1Card);
            System.out.println("Player 2: " + player2Card);

            int comparison = player1Card.getRank().compareTo(player2Card.getRank());
            // determine round winner
            if (comparison > 0) {
                player1Deck.add(0, player1Card);
                player1Deck.add(0, player2Card);
                System.out.println(userName + " wins the round!");
            } else if (comparison < 0) {
                player2Deck.add(0, player1Card);
                player2Deck.add(0, player2Card);
                System.out.println("Player 2 wins the round!");
            } else {
                System.out.println("War!");

                List<Card> warCards = new ArrayList<>();
                warCards.add(player1Card);
                warCards.add(player2Card);

                performWar(warCards);
            }

            System.out.println(userName + " Deck Size: " + player1Deck.size());
            System.out.println("Player 2 Deck Size: " + player2Deck.size());
            System.out.println("--------------------");

            round++;

            // Prompt user to draw another card
            if (!player1Deck.isEmpty() && !player2Deck.isEmpty() && round <= MAX_ROUNDS) {
                System.out.print("Press enter to draw another card...");
                scanner.nextLine();
            }
        }
        // game result
        if (round > MAX_ROUNDS) {
            System.out.println("Game ended in a tie!");
        } else if (player1Deck.isEmpty()) {
            System.out.println("Player 2 wins the game!");
        } else {
            System.out.println(userName + " wins the game!");
        }
    }
      // handle a war situation
      private void performWar(List<Card> warCards) {
       try {
           warCards.add(player1Deck.pop());
           warCards.add(player2Deck.pop());
   
           Card player1Card = player1Deck.pop();
           Card player2Card = player2Deck.pop();
   
           System.out.println(userName + ": " + player1Card);
           System.out.println("Player 2: " + player2Card);
   
           int comparison = player1Card.getRank().compareTo(player2Card.getRank());
   
           if (comparison > 0) {
               player1Deck.addAll(warCards);  // Add warCards to the winner's deck (player1)
               player1Deck.add(player1Card);
               player1Deck.add(player2Card);
               System.out.println(userName + " wins the war!");
           } else if (comparison < 0) {
               player2Deck.addAll(warCards);  // Add warCards to the winner's deck (player2)
               player2Deck.add(player1Card);
               player2Deck.add(player2Card);
               System.out.println("Player 2 wins the war!");
           } else {
               System.out.println("It's a tie during war!");
               player1Deck.add(player1Card);
               player2Deck.add(player2Card);
               player1Deck.addAll(warCards);  // Add warCards to the war pile (player1)
           }
       } catch (EmptyStackException e) {
           System.out.println("Insufficient cards for war!");
       }
   }
}
