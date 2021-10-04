package ui;

import main.Game;
import main.Piece;

import java.util.Scanner;

public class Chess {
    Game g;


    public Chess() {
        g = new Game();
        runGame();
    }

    void runGame() {

        System.out.print("Welcome");
        System.out.print("\n");
        displayBoard();
        while (g.isEnd()) {
            System.out.print("First input start coordinate and the end coordinate of piece ");
            System.out.print("\n");
            String startCoor = getUserInputString();
            String endCoor = getUserInputString();
            g.movePiece(startCoor, endCoor);
            displayBoard();
        }


    }

    public String getUserInputString() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        return userInput;
    }

    public void displayBoard() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                int np = 8*i + j;
                Piece p = g.getChessBoard().getBoard().get(np).getPiece();
                if (!(p == null)) {
                    System.out.print(p.getName());
                } else {
                    System.out.print("OO");
                }
            }
            System.out.print("\n");
        }
    }




}
