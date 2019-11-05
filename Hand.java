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

    public int[] toBin(int x){
      int digits = cards.length;

      int[] bin = new int[digits];

      for (int i = 0; i < digits; ++i){
        if (x <= Math.pow(2, (digits - i - 1))){
          bin[i] = 1;
          x -= Math.pow(2, (digits - i -1));
        }
        else{
          bin[i] = 0;
        }
      }

      return bin;
    }

    public int count(){
      // 15s

      for (int i = 1; i < Math.pow(2, cards.length); ++i){
        continue;
      }

      // doubles and repeats

      // flush

      // runs

      return 0;
    }

}
