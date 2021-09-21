package Test;

import main.Game;
import main.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    void testGameConstructor() {
        Game g = new Game();
        List<Position> b = g.getChessBoard().getBoard();
        Position p = b.get(0);
        assertEquals("WR",p.getPiece().getName());
        p = b.get(1);
        assertEquals("WN",p.getPiece().getName());
        p = b.get(2);
        assertEquals("WB",p.getPiece().getName());
        p = b.get(3);
        assertEquals("WQ",p.getPiece().getName());
        p = b.get(4);
        assertEquals("WK",p.getPiece().getName());
        p = b.get(5);
        assertEquals("WB",p.getPiece().getName());
        p = b.get(6);
        assertEquals("WN",p.getPiece().getName());
        p = b.get(7);
        assertEquals("WR",p.getPiece().getName());

        for (int i = 8; i < 16 ; i ++) {
            p = b.get(i);
            assertEquals("WP", p.getPiece().getName());
        }

        for (int i = 48; i < 56 ; i ++) {
            p = b.get(i);
            assertEquals("BP", p.getPiece().getName());
        }

        p = b.get(56);
        assertEquals("BR",p.getPiece().getName());
        p = b.get(57);
        assertEquals("BN",p.getPiece().getName());
        p = b.get(58);
        assertEquals("BB",p.getPiece().getName());
        p = b.get(59);
        assertEquals("BQ",p.getPiece().getName());
        p = b.get(60);
        assertEquals("BK",p.getPiece().getName());
        p = b.get(61);
        assertEquals("BB",p.getPiece().getName());
        p = b.get(62);
        assertEquals("BN",p.getPiece().getName());
        p = b.get(63);
        assertEquals("BR",p.getPiece().getName());

    }



}
