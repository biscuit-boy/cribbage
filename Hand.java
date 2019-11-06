import java.util.*;

public class Hand{
    public List<Card> cards = new ArrayList<Card>();

    public Hand(){
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void removeCard(Card card){
        cards.remove(card);
    }

    public Card takeAt(int x){
        Card temp = cards.get(x);
        removeCard(temp);
        return temp;
    }

    public Card get(int x){
        Card temp = cards.get(x);
        return temp;
    }

    public int getSize(){
        return cards.size();
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

    public int count(Card draw){
        // flushes

        int points = 0;

        char suit = cards.get(0).getSuit();
        boolean flush = true;

        for (Card card : cards){
            flush = flush && (card.getSuit() == suit);
        }

        if (flush){
            points += getSize();

            if (draw.getSuit() == suit){
                points += 1;
            }
        }

        // knobs

        for (Card card: cards){
            if (card.getVal() == 'J' && card.getSuit() == draw.getSuit()){
                points += 1;
                break;
            }
        }

        addCard(draw);

        // 15s and doubles

        int sum = 0;

        for (int i = 0; i < Math.pow(2, getSize()); ++i){
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

        // runs

        sort();

        int[] diffs = new int[getSize() - 1];

        for (int i = 0; i < getSize() - 1; ++i){
            diffs[i] = cards.get(i+1).getIndex() - cards.get(i).getIndex();
        }

        int running = 0;
        int currZero = 0;
        int zeroMult = 1;

        int d;

        for (int i=0; i < diffs.length; ++i) {
            d = diffs[i];

            if (d == 0) {
                currZero += 1;
            } else {
                if (currZero != 0) {
                    zeroMult *= (currZero + 1);
                }

                currZero = 0;
            }

            if (d == 1){
                running += 1;
            }

            if (running >= 2 && (d > 1 || i == (diffs.length - 1))){
                points += (running + 1)*zeroMult*(currZero + 1);
                zeroMult = 1;
                running = 0;
            }
        }

        removeCard(draw);

        return points;
    }

}
