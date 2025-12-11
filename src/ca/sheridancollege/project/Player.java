/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * 
 * MODIFIED BY GRAHAM, DEC 2025
 */
public abstract class Player {

    private String name; //the unique name for this player
    private int score; 
    Hand hand;
    
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }
    
    /// 
    /// **CALL THIS IN MAIN METHOD WHERE THE DECK EXISTS**
    ///
    public void receiveCard(Card card, Boolean print) { // PASS IN DEAL CARD METHOD
        hand.addCard(card); // this becomes the card removed from deck
        
        if (print){
            System.out.println("\n" + name + " received: " + card);
        }
    }
    
    ///
    /// NAME GETTERS & SETTERS
    ///
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ///
    /// SCORE
    ///
    public int getScore() {
        return score;
    }

    public void addScore() {
        score++; 
    }

    ///
    /// HAND GETTER 
    ///
   public Hand getHand(){
       return this.hand;
   }
  
   // METHOD TO RESET THE HAND
   public void resetHand() {
       hand.resetHand();  
   }
   
   

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
   
   ///
   /// Modified to pass in the deck
   ///
    public abstract void play(Deck deck);

}
