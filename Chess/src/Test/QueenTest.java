package Test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenTest {

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
    void WhiteQueenMoveW1() {
        testMoveHelper(new Queen("WQ"), 27, 26, "WQ");
    }

    @Test
    void WhiteQueenMoveW2() {
        testMoveHelper(new Queen("WQ"), 27, 25, "WQ");
    }

    @Test
    void WhiteQueenMoveW3() {
        testMoveHelper(new Queen("WQ"), 27, 24, "WQ");
    }

    @Test
    void WhiteQueenMoveE1() {
        testMoveHelper(new Queen("WQ"), 27, 28, "WQ");
    }

    @Test
    void WhiteQueenMoveE2() {
        testMoveHelper(new Queen("WQ"), 27, 29, "WQ");
    }

    @Test
    void WhiteQueenMoveE3() {
        testMoveHelper(new Queen("WQ"), 27, 30, "WQ");
    }

    @Test
    void WhiteQueenMoveE4() {
        testMoveHelper(new Queen("WQ"), 27, 31, "WQ");
    }

    @Test
    void WhiteQueenMoveS1() {
        testMoveHelper(new Queen("WQ"), 27, 19, "WQ");
    }

    @Test
    void WhiteQueenTeamKillS2() {
        bd.get(27).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(11),cb);

        // check if the knight was removed from the original position
        assertEquals("WQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WP",bd.get(11).getPiece().getName());
    }

    @Test
    void WhiteQueenTeamKillBlockedS3() {
        bd.get(27).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(3),cb);

        // check if the knight was removed from the original position
        assertEquals("WQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WQ",bd.get(3).getPiece().getName());
    }

    @Test
    void WhiteQueenMoveN1() {
        testMoveHelper(new Queen("WQ"), 27, 35, "WQ");
    }

    @Test
    void WhiteQueenMoveN2() {
        testMoveHelper(new Queen("WQ"), 27, 43, "WQ");
    }

    @Test
    void WhiteQueenKillN3() {
        testMoveHelper(new Queen("WQ"), 27, 51, "WQ");// move helper works with pre
        // - existing piece killed
    }

    @Test
    void WhiteQueenKillBloackedN4() {
        bd.get(27).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(59),cb);

        // check if the knight was removed from the original position
        assertEquals("WQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("BQ",bd.get(59).getPiece().getName());
    }

    @Test
    void BlackQueenMoveW1() {
        testMoveHelper(new Queen("BQ"), 27, 26, "BQ");
    }

    @Test
    void BlackQueenMoveW2() {
        testMoveHelper(new Queen("BQ"), 27, 25, "BQ");
    }

    @Test
    void BlackQueenMoveW3() {
        testMoveHelper(new Queen("BQ"), 27, 24, "BQ");
    }

    @Test
    void BlackQueenMoveE1() {
        testMoveHelper(new Queen("BQ"), 27, 28, "BQ");
    }

    @Test
    void BlackQueenMoveE2() {
        testMoveHelper(new Queen("BQ"), 27, 29, "BQ");
    }

    @Test
    void BlackQueenMoveE3() {
        testMoveHelper(new Queen("BQ"), 27, 30, "BQ");
    }

    @Test
    void BlackQueenMoveE4() {
        testMoveHelper(new Queen("BQ"), 27, 31, "BQ");
    }

    @Test
    void BlackQueenMoveS1() {
        testMoveHelper(new Queen("BQ"), 27, 19, "BQ");
    }

    @Test
    void BlackQueenKillS2() {
        testMoveHelper(new Queen("BQ"), 27, 11, "BQ");
    }

    @Test
    void BlackQueenTeamKillBlockedS3() {
        bd.get(27).setPiece(new Queen("BQ"));
        bd.get(27).getPiece().move(bd.get(3),cb);

        // check if the knight was removed from the original position
        assertEquals("BQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WQ",bd.get(3).getPiece().getName());
    }

    @Test
    void BlackQueenMoveN1() {
        testMoveHelper(new Queen("BQ"), 27, 35, "BQ");
    }

    @Test
    void BlackQueenMoveN2() {
        testMoveHelper(new Queen("BQ"), 27, 43, "BQ");
    }

    @Test
    void BlackQueenTeamKillN3() {
        bd.get(27).setPiece(new Queen("BQ"));
        bd.get(27).getPiece().move(bd.get(51),cb);

        // check if the knight was removed from the original position
        assertEquals("BQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("BP",bd.get(51).getPiece().getName());
    }

    @Test
    void BlackQueenTeamKillBlockedN4() {
        bd.get(27).setPiece(new Queen("BQ"));
        bd.get(27).getPiece().move(bd.get(59),cb);

        // check if the knight was removed from the original position
        assertEquals("BQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("BQ",bd.get(59).getPiece().getName());
    }



}
