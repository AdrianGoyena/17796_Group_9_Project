package ca.sheridancollege.project;

import java.util.Scanner;

public class Dealer extends Player {

    Scanner consoleManager = new Scanner(System.in);

    public Dealer() {
        super("Dealer");
    }

    /// FUNCTION TO ALLOW FOR A CLEAN CONSOLE
    private void pressEnter() {
        System.out.print("[Press ENTER] ");
        consoleManager.nextLine();
        System.out.println();
    }

    @Override
    public void play(Deck deck) {
        System.out.println("\n" + getName() + "'s turn...");
        pressEnter();

        System.out.println(getName() + "'s starting hand: " + getHand());
        System.out.println("Value: " + getHand().getHandValue());
        pressEnter();

        while (getHand().getHandValue() < 17) {
            System.out.println(getName() + " HITS.");
            receiveCard(deck.dealCard(), true);
            if (hand.checkAceConversion()) {
                System.out.println("ACE CONVERTED FROM 11 TO 1");
            }
            System.out.println("Value: " + getHand().getHandValue());
            pressEnter();
        }

        if (getHand().getHandValue() > 21) {
            System.out.println(getName() + " BUSTS!");
            pressEnter();
        } else {
            System.out.println(getName() + " STANDS.");
            pressEnter();
        }

    }
}
