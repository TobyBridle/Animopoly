package com.animopoly.utils;

import java.util.ArrayList;
import java.util.Arrays;;

public class Board {

    ArrayList<Player> players;
    Dice dice;

    public Board(ArrayList<Player> players)
    {
        this.players = players;
        this.dice = new Dice();
    }

    public void printBoard(int activeTurn)
    {
        String[] positions = new String[26];
        String header = "";
        Arrays.fill(positions, " ");

        for(int player = 0; player < this.players.size(); ++player) {
            header += (activeTurn == player ? "\033[32m" : "\033[m") + this.players.get(player).name + ":\t" + Utils.pieceToChar(this.players.get(player).piece) + "\n";
            for(int pos = 0; pos < positions.length; ++pos) positions[pos] += (this.players.size()-1 < player ? " " : this.players.get(player).position[pos]);
        }

        System.out.println("\033c"); // Clears Terminal Screen (DOES NOT WORK IN IDEA RUN DIALOG!) Will use dedicated terminal when showing project to ensure it works
        System.out.println(header);
        System.out.println("\033[m");
        System.out.println("_________________________________________________________");
        System.out.println("|" + positions[0] + "   |" + positions[1] + "  |" + positions[2] + "  |" + positions[3] + "  |" + positions[4] + "  |" + positions[5] + "  |" + positions[6] + "  |" + positions[7] + "  |");
        System.out.println("|Start |  1   |   2  |  3   |  4   |  5   |  6   |  7   |");
        System.out.println("|______|______|______|______|______|______|______|______|");
        System.out.println("| " + positions[25] + "  |                                         |" + positions[8] + "  |");
        System.out.println("|  25  |                                         |  8   |");
        System.out.println("|______|                                         |______|");
        System.out.println("|" + positions[24] + "  |                                         |" + positions[9] + "  |");
        System.out.println("|  24   |        _____________                    |  9   |");
        System.out.println("|______|       |             |                   |______|");
        System.out.println("|" + positions[23] + "   |       |Doubles Deck |                   |" + positions[10] + "  |");
        System.out.println("|  23  |       |_____________|                   |  10  |");
        System.out.println("|______|                                         |______|");
        System.out.println("|" + positions[22] + "  |                                         |" + positions[11] + "  |");
        System.out.println("|  22  |                                         |  11  |");
        System.out.println("|______|                                         |______|");
        System.out.println("|" + positions[21] + "  |                                         |" + positions[12] + "  |");
        System.out.println("|  21  |                                         |  12  |");
        System.out.println("|______|_________________________________________|______|");
        System.out.println("|" + positions[20] + "  |" + positions[19] + "  |" + positions[18] + "  |" + positions[17] + "  |" + positions[16] + "  |" + positions[15] + "  |" + positions[14] + "  |" + positions[13] + "  |");
        System.out.println("|  20  |  19  |  18  |  17  |  16  |  15  |  14  |missgo|");
        System.out.println("|______|______|______|______|______|______|______|______|");
    }
}
