import java.util.Comparator;

class Possibility implements Comparable<Possibility>{
    public Card[] cards;
    public double points;

    public Possibility(Card[] Cards, double Points){
        cards = Cards;
        points = Points;
    }

    @Override
    public int compareTo(Possibility other){
        if (this.points > other.points){
            return 1;
        }
        else if (this.points < other.points){
            return -1;
        }
        else{
            return 0;
        }
    }

}