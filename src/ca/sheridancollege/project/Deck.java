/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Graham
 */
public class Deck extends GroupOfCards {
    public Deck() {
        super(52); 

        // super had not initiated the ArrayList yet
        ArrayList<Card> cardList = new ArrayList<>(); 


        for (Suit suit : Suit.values()) { // for each Suit
            for (Rank rank : Rank.values()) { // for each Rank
                cardList.add(new BlackjackCard(rank, suit)); // create a card
            }
        }
            
        // Send our cardList (52 cards, 2->11 of Spades/Diamonds/Hearts/Clubs)
        // back to GroupOfCards
        super.setCards(cardList); 
        shuffle(); 
    }

    // when this method is called, remove (it gets taken) the card at index 0
    // for imaginations sake this will be the top of the deck.
    public Card dealCard() {
        return getCards().remove(0);
    }
}