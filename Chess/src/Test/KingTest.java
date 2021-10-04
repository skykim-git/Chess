package Test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingTest {
    private Game g;
    private ChessBoard cb;
    private List<Position> bd;

    @BeforeEach
    void setUp() {
        g = new Game();
        cb = g.getChessBoard();
        bd = cb.getBoard();
    }

    void testMoveHelper(Piece p, int setNp, int moveNp, String expected) {
        bd.get(setNp).setPiece(p);
        bd.get(setNp).getPiece().move(bd.get(moveNp), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(setNp).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals(expected, bd.get(moveNp).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(moveNp, bd.get(moveNp).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKingMoveNW() {
        testMoveHelper(new King("WK"),27, 34, "WK");
    }
    @Test
    void WhiteKingMoveN() {
        testMoveHelper(new King("WK"),27, 35, "WK");
    }
    @Test
    void WhiteKingMoveNE() {
        testMoveHelper(new King("WK"),27, 36, "WK");
    }
    @Test
    void WhiteKingMoveW() {
        testMoveHelper(new King("WK"),27, 26, "WK");
    }
    @Test
    void WhiteKingMoveE() {
        testMoveHelper(new King("WK"),27, 28, "WK");
    }
    @Test
    void WhiteKingMoveSW() {
        testMoveHelper(new King("WK"),27, 18, "WK");
    }
    @Test
    void WhiteKingMoveS() {
        testMoveHelper(new King("WK"),27, 19, "WK");
    }
    @Test
    void WhiteKingMoveSE() {
        testMoveHelper(new King("WK"),27, 20, "WK");
    }




    @Test
    void BlackKingMoveNW() {
        testMoveHelper(new King("BK"),35, 42, "BK");
    }
    @Test
    void BlackKingMoveN() {
        testMoveHelper(new King("BK"),35, 43, "BK");
    }
    @Test
    void BlackKingMoveNE() {
        testMoveHelper(new King("BK"),35, 44, "BK");
    }
    @Test
    void BlackKingMoveW() {
        testMoveHelper(new King("BK"),35, 34, "BK");
    }
    @Test
    void BlackKingMoveE() {
        testMoveHelper(new King("BK"),35, 36, "BK");
    }
    @Test
    void BlackKingMoveSW() {
        testMoveHelper(new King("BK"),35, 26, "BK");
    }
    @Test
    void BlackKingMoveS() {
        testMoveHelper(new King("BK"),35, 27, "BK");
    }
    @Test
    void BlackKingMoveSE() {
        testMoveHelper(new King("BK"),35, 28, "BK");
    }

    // invalid pos tests

    @Test
    void WhiteKingInValid() {
        bd.get(35).setPiece(new King("WK"));
        bd.get(35).getPiece().move(bd.get(43),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(43).getPiece());
    }
}
