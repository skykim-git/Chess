package Test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BishopTest {

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
        assertEquals(moveNp+1, bd.get(moveNp).getPiece().getPosition().getNumberPosition());
    }

    void testKillHelper(Piece p, int setNp, int moveNp, String expected, Piece expectedToKill) {
        // place White knight at index 35 (for move in every possible position)
        bd.get(setNp).setPiece(p);
        //
        bd.get(moveNp).setPiece(expectedToKill);
        // move Knight to index 50 // killing
        bd.get(setNp).getPiece().move(bd.get(moveNp),cb);

        // check if the knight was removed from the original position
        assertEquals(null,bd.get(setNp).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals(expected,bd.get(moveNp).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(moveNp+1,bd.get(moveNp).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteBishopMoveNW1() { // northWest
        testMoveHelper(new Bishop("WB"), 27, 34, "WB");
    }

    @Test
    void WhiteBishopMoveNW2() {
        testMoveHelper(new Bishop("WB"), 27, 41, "WB");
    }

    @Test
    void WhiteBishopKillNW3() {
        testKillHelper(new Bishop("WB"), 27, 41, "WB", new Bishop("BB"));
    }

    @Test
    void WhiteBishopMoveNE1() { // northWest
        testMoveHelper(new Bishop("WB"), 27, 36, "WB");
    }

    @Test
    void WhiteBishopMoveNE2() { // northWest
        testMoveHelper(new Bishop("WB"), 27, 45, "WB");
    }

    @Test
    void WhiteBishopKillNE3() {
        testKillHelper(new Bishop("WB"), 27, 54, "WB", new Bishop("BB"));
    }

    @Test
    void WhiteBishopMoveSW1() { // northWest
        testMoveHelper(new Bishop("WB"), 27, 18, "WB");
    }


    @Test
    void WhiteBishopMoveSE1() { // northWest
        testMoveHelper(new Bishop("WB"), 27, 20, "WB");
    }

    @Test
    void TeamKillTest() {
        bd.get(27).setPiece(new Bishop("WB"));
        // move Knight to index 50 // killing
        bd.get(27).getPiece().move(bd.get(9),cb);

        // check if the knight was removed from the original position
        assertEquals("WB",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WP",bd.get(9).getPiece().getName());
    }

    @Test
    void blockTestNW() {
        bd.get(27).setPiece(new Bishop("WB"));
        bd.get(34).setPiece(new Bishop("WB"));
        // move Knight to index 50 // killing
        bd.get(27).getPiece().move(bd.get(41),cb);

        assertEquals("WB",bd.get(27).getPiece().getName());
        assertEquals(null,bd.get(41).getPiece());

    }


}
