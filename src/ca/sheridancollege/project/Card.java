/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */

// @modified by Graham
// added constructor including Rank/Suit, a toString method, as well as
// an abstract method to get the Value of the card. classes that 
// inherit from Card USUALLY will want a value, so i figure its a good
// implementation for most card games
public abstract class Card {
    
    Rank rank;
    Suit suit;
    
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    // to be utilized in BlackJackCard, or future games with normal card values
    public abstract int getValue();
    
    @Override
    // modified toString to show Rank and Suit 
    public String toString(){
        return rank + " OF " + suit;
    };

}
