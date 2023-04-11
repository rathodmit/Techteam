import java.util.ArrayList;

public class Hand 
{
    private ArrayList<Card> cardsPlayed;

    public Hand() 
    {
        cardsPlayed = new ArrayList<>();
    }

    public void addCard(Card card)
    {
        cardsPlayed.add(card);
    }

    public void removeCard(Card card)
    {
        cardsPlayed.remove(card);
    }

    public ArrayList<Card> getCards() 
    {
        return cardsPlayed;
    }

    public int getPoints()
    {
        int points = 0;
        for (Card card : cardsPlayed) 
        {
            if (card.getRank().equals("Ace"))
            {
                points += 4;
            }
            else if (card.getRank().equals("King"))
            {
                points += 3;
            }
            else if (card.getRank().equals("Queen"))
            {
                points += 2;
            } 
            else if (card.getRank().equals("Jack"))
            {
                points += 1;
            }
        }
        return points;
    }
}