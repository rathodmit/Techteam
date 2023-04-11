public class Player
{
    private String name;
    private Hand hand;

    public Player(String name)
    {
        this.name = name;
        hand = new Hand();
    }

    public String getName() 
    {
        return name;
    }

    public Hand getHand()
    {
        return hand;
    }

    public void addCard(Card card) 
    {
        hand.addCard(card);
    }

    public void removeCard(Card card) 
    {
        hand.removeCard(card);
    }

    public void printHand()
    {
        System.out.println(name + "'s hand:");
        for (Card card : hand.getCards()) 
        {
            System.out.println(card.toString());
        }
        System.out.println("Total points: " + hand.getPoints());
    }
}