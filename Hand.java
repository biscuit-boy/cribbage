import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Hand{
    public List<Card> cards = new ArrayList<Card>();
    private boolean sorted = false;

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
        sorted = true;
        return;
    }

    private int[] toBin(int x){
        int digits = cards.size();

        int[] bin = new int[digits];

        for (int i = 0; i < digits; ++i){
            if (x >= Math.pow(2, (digits - i - 1))){
                bin[i] = 1;
                x -= Math.pow(2, (digits - i - 1));
            }
            else{
                bin[i] = 0;
            }
        }

        return bin;
    }

    private List<Card> permutation(int[] code){
        List<Card> perm = new ArrayList<Card>();

        for (int i = 0; i < cards.size(); ++i){
            if (code[i] == 1){
                perm.add(cards.get(i));
            }
        }

        return perm;
    }

    public int count(){
        if (!sorted){
            sort();
        }

        int points = 0;

        int sum = 0;

        for (int i = 0; i < Math.pow(2, cards.size()); ++i){
            List<Card> perm = permutation(toBin(i));

            sum = 0;
            for (Card card : perm){
                sum += card.getNum();
            }

            if (sum == 15){
                points += 2;
            }

            if (perm.size() == 2 && perm.get(0).getVal() == perm.get(1).getVal()){
                points += 2;
            }
        }

        return points;
    }

}
