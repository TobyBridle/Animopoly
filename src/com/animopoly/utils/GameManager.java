package com.animopoly.utils;

import java.util.ArrayList;

public class GameManager {
    Board board;

    public GameManager(Board board)
    {
        this.board = board;
    }

    public void waitForEnter() {
        try
        {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Something went wrong whilst waiting for Enter Keypress");
            System.exit(1);
        }
    }

    public void play()
    {
        boolean shouldPlay = true;
        ArrayList<String> playersLeft = new ArrayList<String>();
        for(Player player : this.board.players) playersLeft.add(player.name);

        while(shouldPlay)
        {
            this.board.printBoard();
            int totalScore = 0;

            for(int player = 1; player <= this.board.players.size(); ++player) {
                System.out.println("\n\n");
                System.out.println("Player " + player + " press enter to roll the dice");

                this.waitForEnter(); // Used since Scanner was having some weird issues

                totalScore = this.board.dice.rollDice();
                this.board.players.get(player - 1).setPosition(totalScore);


                System.out.println("You rolled a " + totalScore + "! Press enter to move your piece.");
                this.waitForEnter();

                this.board.printBoard();

            }

            for(Player player : this.board.players)
            if(player.money <= 0 && playersLeft.contains(player.name))
            {
                playersLeft.remove(player.name);
            }

            if(playersLeft.size() == 1) shouldPlay = false;
        }
    }
}
