package OOD.DeckOfCards;

public class BlackJackHand extends Hand{

    public BlackJackHand(int id) {
        super(id);
    }
    public int score() {
        int sum = 0;

        for (Card card : handCards) {
            int val = card.getValue();

            if (val <= 10 && val > 1) {
                sum += val;
            } else if (val > 10){
                sum += 10;
            } else {
                if (sum <= 10) {
                    sum += 11;
                } else {
                    sum += 1;
                }
            }
        }
        return sum;
    }
    public boolean isBursted() {
        return score() > 21;
    }
    public boolean is21() {
        return score() == 21;
    }
    public boolean isBJ() {
        return is21() && handCards.size() == 2;
    }
    public void print() {
        System.out.println(id);
    }
}
