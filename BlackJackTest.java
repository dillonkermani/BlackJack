
    package CardGame;
    
    
    /**
     * Write a description of class BlackJackTest here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
    import java.util.ArrayList;
    import java.util.Scanner;
    public class BlackJackTest
    {
       public static void main (String[] args)
       {
            DeckOfCards myDeck = new DeckOfCards();
            Scanner scan = new Scanner(System.in);
            myDeck.shuffle(); // put Card objects in random order
        
            ArrayList <Card> dealerHand = new ArrayList <Card>();
            ArrayList <Card> playerHand = new ArrayList <Card>();
            
            int dealerVal = 0;
            int playerVal = 0;
            String hs = "";
            int playerBalance = 1000;
            int betAmt;
            boolean b = false;
            
           while(playerBalance > 0)
           {
                    dealerHand.add(myDeck.dealCard());
                    dealerHand.add(myDeck.dealCard());
                    playerHand.add(myDeck.dealCard());
                    playerHand.add(myDeck.dealCard());
                     for(Card c: playerHand)
                            {
                                if(c.getName().equals("Ace") && (21-playerVal) > 10)
                                c.changeValue(10);
                                
                            }
                     for(Card c: dealerHand)
                            {
                                if(c.getName().equals("Ace") && (21-dealerVal) > 10)
                                c.changeValue(10);
                                
                            }
                    
                    System.out.println("Current balance: $" + playerBalance);
                    System.out.println("Choose wager amount(25/50/100/200/500/1000)");
                    betAmt = scan.nextInt();
                    playerBalance -= betAmt;
                    System.out.println("[dealer]:\n{hidden}\n" + dealerHand.get(1) + "\n");
                    System.out.println("[you]:\n" + playerHand.get(0) + "\n" 
                    + playerHand.get(1));
                
                    for(Card c: dealerHand)
                    {
                        dealerVal += c.getValue();
                    }
                    for(Card c: playerHand)
                    {
                        playerVal += c.getValue();
                    }
            
                    System.out.println("VALUE: " + playerVal + "\n");
                
                    while(playerVal < 21 || b != true)
                    {
                        System.out.println("Hit or stay? (h/s)");
                        hs = scan.next();
                        if(hs.equalsIgnoreCase("s") || hs.equalsIgnoreCase("stay"))
                        {
                        b = true;
                        break;
                       }
                        if(hs.equalsIgnoreCase("h") || hs.equalsIgnoreCase("hit"))
                        {
                            playerHand.add(myDeck.dealCard());
                            for(Card c: playerHand)
                            {
                                if(c.getName().equals("Ace") && (21-playerVal) > 10)
                                c.changeValue(10);
                                
                            }
                            playerVal += playerHand.get(playerHand.size() - 1).getValue();
                            System.out.println("[you]");
                            
                            for(int i = 0; i < playerHand.size(); i++)
                            {
                                System.out.println(playerHand.get(i));
                            }
                            System.out.println("VALUE: " + playerVal + "\n");
                        }
                    }
                    while(dealerVal < 17)
                    {
                        dealerHand.add(myDeck.dealCard());
                         for(Card c: dealerHand)
                            {
                                if(c.getName().equals("Ace") && (21-dealerVal) > 10)
                                c.changeValue(10);
                                
                            }
                         dealerVal += dealerHand.get(dealerHand.size() -1).getValue();
                            }
                
                        System.out.println("[dealer]");
                        for(int i = 0; i < dealerHand.size(); i++)
                        {
                            System.out.println(dealerHand.get(i));
                        }
                        System.out.println("value: " + dealerVal + "\n");
                        
                        System.out.println("[you]");
                        for(int i = 0; i < playerHand.size(); i++)
                        {
                            System.out.println(playerHand.get(i));
                        }
                        System.out.println("VALUE: " + playerVal + "\n");
                
                    if(playerVal > dealerVal && playerVal <= 21)
                    {
                        System.out.println("\"You win!\"");
                        playerBalance += (betAmt *2);
                        playerVal = 0;
                        playerHand.clear();
                        dealerVal = 0;
                        dealerHand.clear();
                    }
                    if((dealerVal > 21 && playerVal < dealerVal) && (playerVal < 22))
                    {
                        System.out.println("\"You Win! Dealer Bust\"");
                        playerBalance += (betAmt *2);
                        playerVal = 0;
                        playerHand.clear();
                        dealerVal = 0;
                        dealerHand.clear();
                    }
                    if(playerVal < dealerVal && dealerVal <= 21)
                    {
                        System.out.println("\"Dealer wins!\"");
                        playerVal = 0;
                        playerHand.clear();
                        dealerVal = 0;
                        dealerHand.clear();
                    }
                    if(playerVal > 21)
                    {
                        System.out.println("\"Bust, Dealer wins!\"");
                        playerVal = 0;
                        playerHand.clear();
                        dealerVal = 0;
                        dealerHand.clear();
                    }
                    if((playerVal == dealerVal && playerVal != 0) || (playerVal > 21 && dealerVal > 21))
                    {
                        playerBalance += betAmt;
                        System.out.println("\"Push\"");
                        playerVal = 0;
                        playerHand.clear();
                        dealerVal = 0;
                        dealerHand.clear();
                            }
           }
            System.out.println("House wins, Game Over");
        
        
        
   }
   
}

