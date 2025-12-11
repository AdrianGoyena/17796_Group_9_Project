/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Graham
 */
public class BlackjackCard extends Card {
    
    public BlackjackCard(Rank rank, Suit suit) {
        super(rank, suit);
    }
    
    @Override
    public int getValue(){
        return rank.getValue();
    }
    
}
