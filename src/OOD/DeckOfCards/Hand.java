package OOD.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    final int id;
    List<Card> handCards;

    public Hand(int id) {
        this.id = id;
        handCards = new ArrayList<>();
    }
    public void addCard(Card card) {
        handCards.add(card);
    }
    public void addCard(List<Card> cards) {
        for (Card card : cards) {
            addCard(card);
        }
    }
    public Card removeCard(int i) {
        if (handCards.size() == 0 || i >= handCards.size()) {
            return null;
        }
        return handCards.remove(i);
    }
}
