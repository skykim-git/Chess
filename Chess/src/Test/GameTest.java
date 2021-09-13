package Test;

import main.Game;
import main.Position;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void testGame() {
        Game g = new Game();
        Position p = g.getChessBoard().getBoard().get(0);
        System.out.print(p.getPiece());
    }



}
