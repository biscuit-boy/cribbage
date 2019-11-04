public class Cribbage{

    public static void deal(Deck deck, Hand hand1, Hand hand2){
        final int HAND_SIE = 6;

        for (int i = 0; i < HAND_SIE; ++i){
            hand1.addCard(deck.draw());
            hand2.addCard(deck.draw());
        }
    }

    public static void main(String[] args){
        Deck deck = new Deck();

        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        deal(deck, hand1, hand2);

        System.out.println(hand1.toString());
        System.out.println(hand2.toString());

        hand1.count();
        hand2.count();

        System.out.println(hand1.toString());
        System.out.println(hand2.toString());
    }
}