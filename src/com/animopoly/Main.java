package com.animopoly;
import com.animopoly.utils.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int playerCount = -1;
        while(true)
        {
            System.out.println("\033cHow many Players will be playing? (MAX 4)");
            Scanner playerScanner = new Scanner(System.in);
            if(!playerScanner.hasNextInt() || (playerCount = playerScanner.nextInt()) <= 0 || playerCount > 4)
            {
                System.out.println("Invalid Input for Player Count!");
                Thread.sleep(1000);
            } else {
                break;
            }
        }

        // Loop playerCount Times

        ArrayList<Player> players = new ArrayList<Player>();

        ArrayList<Utils.Piece> pieces = new ArrayList<Utils.Piece>();
        String piecesList = "";

        // All possible pieces
        pieces.add(Utils.Piece.DOG);
        pieces.add(Utils.Piece.CAT);
        pieces.add(Utils.Piece.MOUSE);
        pieces.add(Utils.Piece.COCK);


        String playerName = "";
        Utils.Piece playerPiece = Utils.Piece.DOG;
        for(int p = 0; p < playerCount; ++p) {
            while (true) {
                System.out.println("\033cPlayer " + (p + 1) + ":");
                System.out.println("What is your name?");

                Scanner nameScanner = new Scanner(System.in);
                if (!nameScanner.hasNextLine()) {
                    System.out.println("Invalid Input for Player Name!");
                }
                playerName = nameScanner.nextLine();

                System.out.println("What Animal would you like to be? (Options: " + (piecesList = pieces.toString().toLowerCase(Locale.ROOT)).subSequence(1, piecesList.length() - 1) + ")");
                Scanner animalScanner = new Scanner(System.in);

                switch (animalScanner.nextLine().toLowerCase(Locale.ROOT)) {
                    case "dog":
                        playerPiece = Utils.Piece.DOG;
                        pieces.remove(Utils.Piece.DOG);
                        break;
                    case "cat":
                        playerPiece = Utils.Piece.CAT;
                        pieces.remove(Utils.Piece.CAT);
                        break;
                    case "mouse":
                        playerPiece = Utils.Piece.MOUSE;
                        pieces.remove(Utils.Piece.MOUSE);
                        break;
                    case "cock":
                        playerPiece = Utils.Piece.COCK;
                        pieces.remove(Utils.Piece.COCK);
                        break;
                    default:
                        System.out.println("Invalid Input for Animal Type!");
                        Thread.sleep(1000);
                        continue;
                }

                players.add(new Player(playerName, 100, playerPiece));
                break;
            }
        }
        Board board = new Board(players);

        GameManager gameManager = new GameManager(board);
        gameManager.play();
    }
}
