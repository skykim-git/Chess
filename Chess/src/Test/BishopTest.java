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

    @Test
    void WhiteBishopMoveNW1() { // northWest
        testMoveHelper(new Bishop("WB"), 27, 34, "WB");
    }

    @Test
    void WhiteBishopMoveNW2() {
        testMoveHelper(new Bishop("WB"), 27, 41, "WB");
    }

    @Test
    void WhiteBishopMoveNE1() { // northWest
        testMoveHelper(new Bishop("WB"), 27, 36, "WB");
    }

    @Test
    void WhiteBishopMoveNE2() { // northWest
        testMoveHelper(new Bishop("WB"), 27, 45, "WB");
    }

//    @Test
//    void WhiteBishopKillNE3() {
//
//    }

    @Test
    void WhiteBishopMoveSW1() { // northWest
        testMoveHelper(new Bishop("WB"), 27, 18, "WB");
    }

    @Test
    void WhiteBishopMoveSE1() { // northWest
        testMoveHelper(new Bishop("WB"), 27, 20, "WB");
    }


}
