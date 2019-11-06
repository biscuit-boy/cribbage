
public class BestChoice extends Cribbage{
    public static void main(String[] args){
        Deck deck = new Deck();

        String[] cards = {"AS", "2H", "3S", "4D"};

        Hand hand = makeHand(deck, cards);

        System.out.println(expectedReturn(deck, hand));
    }
}