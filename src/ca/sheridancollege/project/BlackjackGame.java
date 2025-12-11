package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * TO DO: Implement either a static method for Console management (pressEnter)
 * or, a Singleton ConsoleManager to actually handle all inputs across the board
 *
 * @author Graham Potter 2025
 */
public class BlackjackGame extends Game {

    private UserPlayer user;
    private Dealer dealer;
    private Deck deck;
    private Scanner input;

    public BlackjackGame(String name) {
        super(name);
        input = new Scanner(System.in);
        String userName = "";
        System.out.println("\n" + getName() + ": Group 9 Project");

        while (userName.isEmpty()) {
            System.out.println("\nPlease enter your name.");
            userName = input.nextLine();

  
        }

        // create player and dealer 
        user = new UserPlayer(userName, input);
        dealer = new Dealer();

        // add player/dealer to game
        getPlayers().add(user);
        getPlayers().add(dealer);

        // create deck
        deck = new Deck();
    }

    @Override
    public void play() {

        // set condition for loop
        boolean playAgain = true;

        // play until condition isnt true
        while (playAgain) {
            newRound();

            System.out.println("\nScores:");
            System.out.println(user.getName() + ": " + user.getScore());
            System.out.println(dealer.getName() + ": " + dealer.getScore());

            String selection = "";
            while (true) {
                System.out.print("\nPlay again? (Y/N): ");
                selection = input.nextLine().toUpperCase();

                if (selection.equals("Y")) {
                    playAgain = true;
                    break;
                } else if (selection.equals("N")) {
                    playAgain = false;
                    break;
                } else {
                    System.out.println("Invalid input. Please enter Y or N.");
                }
            }
        }
        declareWinner();
    }

    private void newRound() {

        // ensure fresh shuffled deck every round
        deck = new Deck();
        deck.shuffle();

        user.resetHand();
        dealer.resetHand();

        // deal 2 cards each — bool suppresses output for cleaner console.
        user.receiveCard(deck.dealCard(), false);
        user.receiveCard(deck.dealCard(), false);
        dealer.receiveCard(deck.dealCard(), false);
        dealer.receiveCard(deck.dealCard(), false);

        System.out.println("\n" + user.getName() + " and " + dealer.getName()
                + " both receive 2 cards!");
        pressEnter(); // wait for input

        // grab first card from dealer so the other can be "hidden"
        Card firstCard = dealer.getHand().getCards().get(0);

        // show string and value of just the visible card.
        System.out.println("\nDealer shows: " + firstCard
                + " and one face-down card!");
        System.out.println("Value: " + firstCard.getValue());
        pressEnter();

        // players turn (hit/stand logic in userplayer)
        user.play(deck);

        if (user.getHand().getHandValue() > 21) {
            System.out.println("\nDealer WINS (PLAYER BUST).");
            dealer.addScore();
            pressEnter();
            return;
        }
        // dealers turn (logic is in dealer)
        dealer.play(deck);

        determineRoundWinner();
    }

    private void determineRoundWinner() {

        // grab values for user/dealer
        int playerVal = user.getHand().getHandValue();
        int dealerVal = dealer.getHand().getHandValue();

        System.out.println("\nFinal Values:");
        System.out.println(user.getName() + ": " + playerVal);
        System.out.println(dealer.getName() + ": " + dealerVal + "\n");

        // check winner 
        if (playerVal > 21) {
            System.out.println(dealer.getName() + " WINS!");
            dealer.addScore();
        } else if (dealerVal > 21) {
            System.out.println(user.getName() + " WINS!");
            user.addScore();
        } else if (playerVal > dealerVal) {
            System.out.println(user.getName() + " WINS!");
            user.addScore();
        } else if (dealerVal > playerVal) {
            System.out.println(dealer.getName() + " WINS!");
            dealer.addScore();
        } else {
            System.out.println("TIE!");
        }
        // wait for user input
        pressEnter();
    }

    @Override
    public void declareWinner() {
        System.out.println("\n FINAL RESULT");

        if (user.getScore() > dealer.getScore()) {
            System.out.println("Player wins the game!");
        } else if (dealer.getScore() > user.getScore()) {
            System.out.println("Dealer wins the game!");
        } else {
            System.out.println("The game ends in a tie!");
        }
        pressEnter();
    }

    /// FUNCTION TO ALLOW FOR A CLEAN CONSOLE
    private void pressEnter() {
        System.out.print("[Press ENTER] ");
        input.nextLine();
    }

    // main method constructs BlackjackGame, invokes play method
    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame("Blackjack");
        game.play();
    }
}
