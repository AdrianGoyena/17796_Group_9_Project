/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Graham
 */
public class Hand {

    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    // reset hand between games
    public void resetHand() {
        cards.clear();
    }

    // return a list of all the cards in a hand
    public List<Card> getCards() {
        return cards;
    }

    ///
    /// HAND VALUE **USED FOR DECLARING WINNER**
    ///
    public int getHandValue() {
        int handValue = 0;  // clear any previous handvalue for new evaluation
        int acesInHand = 0; // number of aces in hand - used for 11->1 conversion

        // for each card add its respective value to the handValue
        for (Card c : cards) {
            handValue += c.getValue();

            // IF THERE IS AN ACE, ADD COUNT TO aceInHand
            if (c.getRank() == Rank.ACE) {
                acesInHand++;
            }
        }

        // if the hand value is above 21, but the hand includes an ace
        // remove 10 from the hand value (11 -> 1)  and remove 1 from acesInHand
        while (handValue > 21 && acesInHand > 0) {
            handValue -= 10;
            acesInHand--;
        }
        return handValue;
    }

    public boolean checkAceConversion() {
        // reset values
        int handValue = 0;
        int aces = 0;

        // find any aces in hand (supports multiple)
        for (Card c : cards) {
            handValue += c.getValue();
            if (c.getRank() == Rank.ACE) {
                aces++;
            }
        }

         // false = no output 
        if (handValue <= 21 || aces == 0) {
            return false;
        }
        // this condition will be used to print ACE 11 -> 1
        return true;
    }

    @Override
    public String toString() {
        if (cards.isEmpty()) {
            return "[no cards]";
        }

        String result = ""; // initialize empty string
        for (int i = 0; i < cards.size(); i++) {
            result += cards.get(i).toString(); // adds index to the string
            if (i < cards.size() - 1) { // check if theres another card
                result += ", "; // if so adds a comma+space (for formatting)
            }
        }
        return result;
    }

}
