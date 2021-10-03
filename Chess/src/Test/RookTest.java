package Test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RookTest {

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
    void WhiteRookMoveW1() {
        testMoveHelper(new Rook("WR"), 27, 26, "WR");
    }

    @Test
    void WhiteRookMoveW2() {
        testMoveHelper(new Rook("WR"), 27, 25, "WR");
    }

    @Test
    void WhiteRookMoveW3() {
        testMoveHelper(new Rook("WR"), 27, 24, "WR");
    }

    @Test
    void WhiteRookMoveE1() {
        testMoveHelper(new Rook("WR"), 27, 28, "WR");
    }

    @Test
    void WhiteRookMoveE2() {
        testMoveHelper(new Rook("WR"), 27, 29, "WR");
    }

    @Test
    void WhiteRookMoveE3() {
        testMoveHelper(new Rook("WR"), 27, 30, "WR");
    }

    @Test
    void WhiteRookMoveE4() {
        testMoveHelper(new Rook("WR"), 27, 31, "WR");
    }

    @Test
    void WhiteRookMoveS1() {
        testMoveHelper(new Rook("WR"), 27, 19, "WR");
    }

    @Test
    void WhiteRookTeamKillS2() {
        bd.get(27).setPiece(new Rook("WR"));
        bd.get(27).getPiece().move(bd.get(11),cb);

        // check if the knight was removed from the original position
        assertEquals("WR",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WP",bd.get(11).getPiece().getName());
    }

    @Test
    void WhiteRookTeamKillBlockedS3() {
        bd.get(27).setPiece(new Rook("WR"));
        bd.get(27).getPiece().move(bd.get(3),cb);

        // check if the knight was removed from the original position
        assertEquals("WR",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WQ",bd.get(3).getPiece().getName());
    }

    @Test
    void WhiteRookMoveN1() {
        testMoveHelper(new Rook("WR"), 27, 35, "WR");
    }

    @Test
    void WhiteRookMoveN2() {
        testMoveHelper(new Rook("WR"), 27, 43, "WR");
    }

    @Test
    void WhiteRookKillN3() {
        testMoveHelper(new Rook("WR"), 27, 51, "WR");// move helper works with pre
        // - existing piece killed
    }

    @Test
    void WhiteRookKillBloackedN4() {
        bd.get(27).setPiece(new Rook("WR"));
        bd.get(27).getPiece().move(bd.get(59),cb);

        // check if the knight was removed from the original position
        assertEquals("WR",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("BQ",bd.get(59).getPiece().getName());
    }

    @Test
    void BlackRookMoveW1() {
        testMoveHelper(new Rook("BR"), 27, 26, "BR");
    }

    @Test
    void BlackRookMoveW2() {
        testMoveHelper(new Rook("BR"), 27, 25, "BR");
    }

    @Test
    void BlackRookMoveW3() {
        testMoveHelper(new Rook("BR"), 27, 24, "BR");
    }

    @Test
    void BlackRookMoveE1() {
        testMoveHelper(new Rook("BR"), 27, 28, "BR");
    }

    @Test
    void BlackRookMoveE2() {
        testMoveHelper(new Rook("BR"), 27, 29, "BR");
    }

    @Test
    void BlackRookMoveE3() {
        testMoveHelper(new Rook("BR"), 27, 30, "BR");
    }

    @Test
    void BlackRookMoveE4() {
        testMoveHelper(new Rook("BR"), 27, 31, "BR");
    }

    @Test
    void BlackRookMoveS1() {
        testMoveHelper(new Rook("BR"), 27, 19, "BR");
    }

    @Test
    void BlackRookKillS2() {
        testMoveHelper(new Rook("BR"), 27, 11, "BR");
    }

    @Test
    void BlackRookTeamKillBlockedS3() {
        bd.get(27).setPiece(new Rook("BR"));
        bd.get(27).getPiece().move(bd.get(3),cb);

        // check if the knight was removed from the original position
        assertEquals("BR",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WQ",bd.get(3).getPiece().getName());
    }

    @Test
    void BlackRookMoveN1() {
        testMoveHelper(new Rook("BR"), 27, 35, "BR");
    }

    @Test
    void BlackRookMoveN2() {
        testMoveHelper(new Rook("BR"), 27, 43, "BR");
    }

    @Test
    void BlackRookTeamKillN3() {
        bd.get(27).setPiece(new Rook("BR"));
        bd.get(27).getPiece().move(bd.get(51),cb);

        // check if the knight was removed from the original position
        assertEquals("BR",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("BP",bd.get(51).getPiece().getName());
    }

    @Test
    void BlackRookTeamKillBlockedN4() {
        bd.get(27).setPiece(new Rook("BR"));
        bd.get(27).getPiece().move(bd.get(59),cb);

        // check if the knight was removed from the original position
        assertEquals("BR",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("BQ",bd.get(59).getPiece().getName());
    }



}
