
public class Card{
    public char val;
    public char suit;

    public Card(char Val, char Suit){
        val = Val;
        suit = Suit;
    }

    public int compareTo(Card other){
        String order = "A23456789TJQK";

        return order.indexOf(val) - order.indexOf(other.val);
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