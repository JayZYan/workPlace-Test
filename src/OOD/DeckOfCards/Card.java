package OOD.DeckOfCards;


public class Card {
    private final int value;
    private final Suit suit;

    Card(int val, Suit suit) {
        value = val;
        this.suit = suit;
    }
    public int getValue() {
        return value;
    }
    public Suit getSuit() {
        return suit;
    }
}
