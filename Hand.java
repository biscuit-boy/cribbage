import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Hand{
    public List<Card> cards = new ArrayList<Card>();

    public Hand(){
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public String toString(){
        String words = "";
        for (Card card : cards){
            words += card + " ";
        }

        return words;
    }

    public void sort(){
        Collections.sort(cards);
    }

}