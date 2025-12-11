package ca.sheridancollege.project;

import java.util.Scanner;

public class UserPlayer extends Player {

    private Scanner input;

    public UserPlayer(String name, Scanner input) {
        super(name);
        this.input = input;
    }

    @Override
    public void play(Deck deck) {

        // set condition for loop
        boolean done = false;

        // loop for players turn, breaks on bust, exits on stand
        while (!done) {
            System.out.println("\n" + getName() + "'s hand: " + getHand());
            System.out.println("Value: " + getHand().getHandValue());

            // breaks if bust
            if (getHand().getHandValue() > 21) {
                System.out.println("You bust!");

                break;
            }
            // waits for hit/stand input
            System.out.print("Hit or stand? (H/S): ");
            String choice = input.nextLine().toUpperCase();

            // recieves card from dealer if hit
            if (choice.equals("H")) {
                receiveCard(deck.dealCard(), true);
                if (hand.checkAceConversion()) {
                    System.out.println("ACE CONVERTED FROM 11 TO 1");
                    hand.getHandValue();
                }

                // while loop condition exits
            } else if (choice.equals("S")) {
                done = true;
            } else {
                // catch bad input
                System.out.println("Invalid input.");
            }
        }
    }
}
