import java.util.*;

public class BestChoice extends Cribbage{
    public static void main(String[] args){
        Deck deck = new Deck();

        String[] cards = {"2D", "3H", "5C", "5D", "6C", "8C"};

        Hand hand = makeHand(deck, cards);

        List<Possibility> options = new ArrayList<Possibility>();

        Card firstCard;
        Card secondCard;

        for (int first = 0; first < hand.getSize(); ++first){
            firstCard = hand.takeAt(first);

            for (int second = 0; second < hand.getSize(); ++second){
                secondCard = hand.takeAt(second);

                Card[] tempCards = {firstCard, secondCard};


                Possibility poss = new Possibility(tempCards, expectedReturn(deck, hand));
                options.add(poss);
                System.out.println(Arrays.toString(poss.cards) + " ->  " + poss.points);

                System.out.println(hand.toString);

                hand.addCard(firstCard);
                hand.addCard(secondCard);

            }
        }

        Collections.sort(options, Collections.reverseOrder());

        System.out.println("");

        for (int i = 0; i < 5; ++i){
            System.out.println(Arrays.toString(options.get(i).cards) + " ->  " + options.get(i).points);
        }

    }
}