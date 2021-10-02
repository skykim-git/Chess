package Test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {

    private Game g;
    private ChessBoard cb;
    private List<Position> bd;

    @BeforeEach
    void setUp() {
        g = new Game();
        cb = g.getChessBoard();
        bd = cb.getBoard();
    }


    @Test
    void WhiteKnightMoveNotValidPos() {
        bd.get(35).setPiece(new Knight("WN"));
        bd.get(35).getPiece().move(bd.get(36),cb);
        // check if the knight was removed from the original position
        assertEquals("WN",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(36).getPiece());
    }

    @Test
    void WhiteKnightMoveTestTwoFOneL() {
        // two forward and one left

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // remove Pawn at 50
        bd.get(50).removePiece();
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(50),cb);

        // check if the knight was removed from the original position
        assertEquals(null,bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN",bd.get(50).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(51,bd.get(50).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightKillTwoFOneL() {
        // two forward and one left

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // move Knight to index 50 // killing
        bd.get(35).getPiece().move(bd.get(50),cb);

        // check if the knight was removed from the original position
        assertEquals(null,bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN",bd.get(50).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(51,bd.get(50).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightMoveTestTwoFR() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // remove Pawn at 52
        bd.get(52).removePiece();
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(52), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(52).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(53, bd.get(52).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightKillTwoFOneR() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // move Knight to index 52 // kill
        bd.get(35).getPiece().move(bd.get(52), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(52).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(53, bd.get(52).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightMoveTestOneFTwoL() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(41), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(41).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(42, bd.get(41).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightKillOneFTwoL() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // set BlackKnight at 41
        bd.get(41).setPiece(new Knight("BK"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(41), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(41).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(42, bd.get(41).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightMoveTestOneFTwoR() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(45), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(45).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(46, bd.get(45).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightKillTestOneFTwoR() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // set BlackKnight at 45
        bd.get(45).setPiece(new Knight("BK"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(45), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(45).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(46, bd.get(45).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightMoveTestTwoBOneR() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(20), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(20).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(21, bd.get(20).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightKillTestTwoBOneR() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // set BlackKnight at 20
        bd.get(20).setPiece(new Knight("BK"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(20), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(20).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(21, bd.get(20).getPiece().getPosition().getNumberPosition());
    }



    @Test
    void WhiteKnightMoveTestTwoBOneL() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(18), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(18).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(19, bd.get(18).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightKillTestTwoBOneL() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // set BlackKnight at 18
        bd.get(18).setPiece(new Knight("BK"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(18), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(18).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(19, bd.get(18).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightMoveTestOneBTwoR() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(29), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(29).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(30, bd.get(29).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightKillTestOneBTwoR() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // set BlackKnight at 18
        bd.get(29).setPiece(new Knight("BK"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(29), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(29).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(30, bd.get(29).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightMoveTestOneBTwoL() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(25), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(25).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(26, bd.get(25).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void WhiteKnightKillTestOneBTwoL() {
        // two forward and one right

        // place White knight at index 35 (for move in every possible position)
        bd.get(35).setPiece(new Knight("WN"));
        // set BlackKnight at 25
        bd.get(25).setPiece(new Knight("BK"));
        // move Knight to index 50
        bd.get(35).getPiece().move(bd.get(25), cb);

        // check if the knight was removed from the original position
        assertEquals(null, bd.get(35).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WN", bd.get(25).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(26, bd.get(25).getPiece().getPosition().getNumberPosition());
    }

    // refactor all with function

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

    void testKillHelper(Piece p, int setNp, int moveNp, String expected, String expectedToKill) {
        // place White knight at index 35 (for move in every possible position)
        bd.get(setNp).setPiece(p);
        //
        bd.get(moveNp).setPiece(new Knight(expectedToKill));
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
    void BlackKnightMove2F1L() {
        bd.get(10).removePiece();
        this.testMoveHelper(new Knight("BK"), 27, 10, "BK");
    }

    @Test
    void BlackKnightKill2F1L() {
        this.testKillHelper(new Knight("BK"), 27, 10, "BK", "WK");
    }

    @Test
    void BlackKnightMove2F1R() {
        bd.get(12).removePiece();
        this.testMoveHelper(new Knight("BK"), 27, 12, "BK");
    }

    @Test
    void BlackKnightKill2F1R() {
        this.testKillHelper(new Knight("BK"), 27, 12, "BK", "WK");
    }

    @Test
    void BlackKnightMove1F2L() {
        this.testMoveHelper(new Knight("BK"), 27, 17, "BK");
    }

    @Test
    void BlackKnightKill1F2L() {
        this.testKillHelper(new Knight("BK"), 27, 17, "BK", "WK");
    }

    @Test
    void BlackKnightMove1F2R() {
        this.testMoveHelper(new Knight("BK"), 27, 21, "BK");
    }

    @Test
    void BlackKnightKill1F2R() {
        this.testKillHelper(new Knight("BK"), 27, 21, "BK", "WK");
    }

    @Test
    void BlackKnightMove1B2L() {
        this.testMoveHelper(new Knight("BK"), 27, 33, "BK");
    }

    @Test
    void BlackKnightKill1B2L() {
        this.testKillHelper(new Knight("BK"), 27, 33, "BK", "WK");
    }

    @Test
    void BlackKnightMove1B2R() {
        this.testMoveHelper(new Knight("BK"), 27, 37, "BK");
    }
    @Test
    void BlackKnightKill1B2R() {
        this.testKillHelper(new Knight("BK"), 27, 37, "BK", "WK");
    }

    @Test
    void BlackKnightMove2B1L() {
        this.testMoveHelper(new Knight("BK"), 27, 42, "BK");
    }

    @Test
    void BlackKnightKill2B1L() {
        this.testKillHelper(new Knight("BK"), 27, 42, "BK", "WK");
    }

    @Test
    void BlackKnightMove2B1R() {
        this.testMoveHelper(new Knight("BK"), 27, 44, "BK");
    }

    @Test
    void BlackKnightKill2B1R() {
        this.testKillHelper(new Knight("BK"), 27, 44, "BK", "WK");
    }







}
