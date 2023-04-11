import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
    private ArrayList<Card> cards;

    public Deck() 
    {
        cards = new ArrayList<Card>();
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits)
        {
            for (String rank : ranks) 
            {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    public void shuffle() 
    {
        Collections.shuffle(cards);
    }

    public Card drawCard()
    {
        return cards.remove(0);
    }
}