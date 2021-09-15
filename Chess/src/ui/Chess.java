package ui;

import main.Game;

public class Chess {
    Game g;

    int turn; // turn in int white starts first, bing odd while the black is even

    public Chess() {
        g = new Game();
        turn = 1;



    }
}
