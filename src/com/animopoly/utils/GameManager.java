package com.animopoly.utils;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {

    Board board;
    int activeTurn;

    public GameManager(Board board)
    {
        this.board = board;
        this.activeTurn = 0;
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
            this.board.printBoard(0);
            int totalScore = 0;

            for(int player = 1; player <= this.board.players.size(); ++player) {
                Player currPlayer = this.board.players.get(player - 1);

                if(currPlayer.missTurn == true)
                {
                    currPlayer.missTurn = false;
                    continue;
                }

                System.out.println(currPlayer.name + " press enter to roll the dice");

                this.waitForEnter(); // Used since Scanner was having some weird issues

                totalScore = this.board.dice.rollDice();
                currPlayer.setPosition(totalScore);


                System.out.println("You rolled a " + totalScore + "! Press enter to move your piece.");

                this.waitForEnter();

//                if(this.animals.collides(currPlayer))
//                {
//                    // Ask if they want to purchase property etc
//                }

                if(this.board.dice.isDoubles())
                {
                    System.out.println("You got a double roll! Take a card? (Y/N)");
                    Scanner choice = new Scanner(System.in);
                }

                this.board.printBoard(player);
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
