import java.util.Arrays;

public class Cribbage{

    public static void deal(Deck deck, Hand hand1, Hand hand2){
        final int HAND_SIE = 5;

        for (int i = 0; i < HAND_SIE; ++i){
            hand1.addCard(deck.draw());
            hand2.addCard(deck.draw());
        }
    }

    public static Hand makeHand(Deck deck, String[] keys){
        Hand hand = new Hand();

        for (String key : keys){
            hand.addCard(deck.take(key));
        }

        return hand;
    }

    public static double expectedReturn(Deck deck, Hand hand){
        double expected = 0;

        double deckSize = deck.getSize();

        for (Card card : deck.getCards()){
            expected += hand.count(card);
        }

        return expected / deckSize;
    }

    public static void main(String[] args) {
        System.out.println("happening");
    }
}
