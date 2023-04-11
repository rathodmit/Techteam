//

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
public static void main(String[] args) 
{
Deck deck = new Deck();
deck.shuffle();
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(new Player("Mitali"));
    players.add(new Player("Vedant"));
    players.add(new Player("Yesha"));
    players.add(new Player("Sivgama_mam"));

    for (int i = 0; i < 13; i++) {
        for (Player player : players) {
            Card card = deck.drawCard();
            player.addCard(card);
        }
    }

    int round = 1;
    int tricksToWin = 7;
    Player startingPlayer = players.get(0);
    Scanner scanner = new Scanner(System.in);

    int[] playerTrickCounters = new int[4]; // 

    while (round <= 13) 
    {
        System.out.println("\nRound " + round);

        ArrayList<Card> cardsPlayed = new ArrayList<>();

        for (Player player : players) {
            System.out.println(player.getName() + "'s turn:");
            player.printHand();
            System.out.println("Enter the index of the card you want to play:");

            int cardIndex = scanner.nextInt();
            Card card = player.getHand().getCards().get(cardIndex);
            player.getHand().removeCard(card);

            System.out.println(player.getName() + " plays " + card.toString());
            cardsPlayed.add(card);
        }

        Card highestCard = cardsPlayed.get(0);
        Player winningPlayer = startingPlayer;

        for (int i = 1; i < cardsPlayed.size(); i++) 
        {
            Card nextCard = cardsPlayed.get(i);
            Player nextPlayer = players.get((players.indexOf(startingPlayer) + i) % players.size());
            System.out.println(nextPlayer.getName() + " plays " + nextCard.toString());

            if (nextCard.getSuit().equals(highestCard.getSuit())) 
            {
                if (nextCard.getRank().compareTo(highestCard.getRank()) > 0) 
                {
                    highestCard = nextCard;
                    winningPlayer = nextPlayer;
                }
            } 
            else if (nextCard.getSuit().equals("Spades")) 
            {
                highestCard = nextCard;
                winningPlayer = nextPlayer;
            }
        }

        startingPlayer = winningPlayer;
        System.out.println(winningPlayer.getName() + " wins the trick!");
        int winningPlayerIndex = players.indexOf(winningPlayer);
        playerTrickCounters[winningPlayerIndex]++; // increment the counter of the winning player

        if (playerTrickCounters[winningPlayerIndex] == tricksToWin) 
        {
            System.out.println("Game over! " + winningPlayer.getName() + " wins!");
            return;
        }

        round++;
    }
    
  
    int maxTricks = 0;
    int winnerIndex = -1;
    for (int i = 0; i < playerTrickCounters.length; i++)
    {
        if (playerTrickCounters[i] > maxTricks) 
        {
            maxTricks = playerTrickCounters[i];
            winnerIndex = i;
        } 
        else if (playerTrickCounters[i] == maxTricks) 
        {
            System.out.println("It's a tie between " + players.get(winnerIndex).getName() + " and " + players.get(i).getName() + "!");
            return;
        }
    }
    System.out.println(players.get(winnerIndex).getName() + " wins the game with " + maxTricks + " tricks!");

  }
}