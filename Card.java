import java.util.Comparator;

public class Card implements Comparable<Card>{
    public char val;
    public char suit;

    public Card(char Val, char Suit){
        val = Val;
        suit = Suit;
    }

    @Override
    public int compareTo(Card other){
        String order = "A23456789TJQK";

        return order.indexOf(this.getVal()) - order.indexOf(other.getVal());
    }

    public char getVal(){
        return val;
    }

    public char getSuit(){
        return suit;
    }

    public String toString(){
        return ("" + val + suit);
    }
}