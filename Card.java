import java.util.Comparator;

public class Card implements Comparable<Card>{
    private char val;
    private char suit;
    private int num;
    private int index;

    public Card(char Val, char Suit){
        val = Val;
        suit = Suit;

        if (val == 'A'){
          num = 1;
        }
        else if (val == 'T' || val == 'J' || val == 'Q' || val == 'K'){
          num = 10;
        }
        else{
          num = (int) val - '0';
        }

        String order = "A23456789TJQK";
        index = order.indexOf(val);

    }

    @Override
    public int compareTo(Card other){
        return this.index - other.index;
    }

    public char getVal(){
        return val;
    }

    public char getSuit(){
        return suit;
    }

    public int getNum(){
      return num;
    }

    public int getIndex(){
        return index;
    }

    public String toString(){
        return ("" + val + suit);
    }
}
