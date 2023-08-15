/*
The Card class represents a playing card with a rank and suit. It provides methods to
access the rank and suit of the card, as well as a string representation of the card.
The ranks and suits of the cards are defined as enums within the class.
*/


public class Card {
    enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    private final Rank rank;
    private final Suit suit;
    // playing card with a rank and suit
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    // gets and returns the rank of the card
    public Rank getRank() {
        return rank;
    }
    // gets and returns the rank of the suit
    public Suit getSuit() {
        return suit;
    }
    // returns a string representation of the card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
