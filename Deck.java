import java.util.*;

public class Deck{
    public List<Card> cards = new ArrayList<Card>();

    public Deck(){
        cards = genDeck();
    }

    private List<Card> genDeck(){
        char[] vals = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
        char[] suits = {'H', 'S', 'D', 'C'};

        List<Card> cards = new ArrayList<Card>();

        for (char value : vals){
            for (char suit : suits){
                Card temp = new Card(value, suit);
                cards.add(temp);
            }
        }

        Collections.shuffle(cards);

        return cards;
    }

    public List<Card> getCards(){
        return cards;
    }

    public int getSize(){
        return cards.size();
    }

    public Card draw(){
        Card temp = cards.get(0);
        cards.remove(0);

        return temp;
    }

    public Card take(String key){
        key = key.toUpperCase();

        for (Card card : cards){
            if (card.getVal() == key.charAt(0) && card.getSuit() == key.charAt(1)){
                cards.remove(card);

                return card;
            }
        }

        throw new IllegalArgumentException("Card " + key + " not in deck.");
    }
}