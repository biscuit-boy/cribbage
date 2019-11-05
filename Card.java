import java.util.Comparator;

public class Card implements Comparable<Card>{
    private char val;
    private char suit;
    private int points;

    public Card(char Val, char Suit){
        val = Val;
        suit = Suit;

        if (val == 'A'){
          points = 1;
        }
        else if (val == 'T' || val == 'J' || val == 'Q' || val == 'K'){
          points = 10;
        }
        else{
          points = (int) val;
        }
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

    public int getPoints(){
      return points
    }

    public String toString(){
        return ("" + val + suit);
    }
}
