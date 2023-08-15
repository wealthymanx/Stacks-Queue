/**
The Deck class represents a deck of cards used in the card game War. It provides
methods to create a standard deck of 52 cards, shuffle the deck, and deal the cards
to two player decks. The deck is represented as a stack of Card objects, where the
top of the stack represents the top of the deck. The class also includes a constant
TOTAL_CARDS to represent the total number of cards in the deck (52). The Deck class
is responsible for initializing and manipulating the deck of cards for the game.
*/


import java.util.*;

public class Deck {
    private static final int TOTAL_CARDS = 52;

    private Stack<Card> cards;
    // deck of cards used in the game
    public Deck() {
        cards = createDeck();
    }
    // creates a new deck of cards with all 52 cards
    // return the deck of cards as a stack
    private Stack<Card> createDeck() {
        Stack<Card> deck = new Stack<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.push(new Card(rank, suit));
            }
        }
        return deck;
    }
    // shuffles the deck of cards using Collections.shuffle method
    public void shuffle() {
        Collections.shuffle(cards);
    }
    // deals the cards from the deck to two player decks, alternating between players
    public void dealCards(Stack<Card> player1Deck, Stack<Card> player2Deck) {
        for (int i = 0; i < TOTAL_CARDS; i++) {
            Card card = cards.pop();
            if (i % 2 == 0) {
                player1Deck.push(card);
            } else {
                player2Deck.push(card);
            }
        }
    }
}
