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

    public static void main(String[] args) {
        Deck deck = new Deck();

        String[] cards = {"AH", "JH", "6H", "KH"};

        Hand hand1 = makeHand(deck, cards);

        Card drawCard1 = deck.take("3S");
        Card drawCard2 = deck.take("3H");

        System.out.println(hand1.count(drawCard1));
        System.out.println(hand1.count(drawCard2));


    }
}
