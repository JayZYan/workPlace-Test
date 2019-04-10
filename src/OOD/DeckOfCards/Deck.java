package OOD.DeckOfCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit: Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(i, suit));
            }
        }
    }
    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            Random random = new Random();
            int j = random.nextInt(cards.size() - i) + i; //nextInt(int k) [0,k)
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }
}
