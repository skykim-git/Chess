package Test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    private Game g;
    private ChessBoard cb;
    private List<Position> bd;
    @Test
    void testSetPieceKillPos() {
        Position p = new Position(0);
        Piece pie1 = new Queen("BQ");
        Piece pie2 = new Queen("WQ");

        p.setPiece(pie1);
        assertEquals(0,pie1.getPosition().getNumberPosition());
        p.setPiece(pie2);

        //position got WQ
        assertEquals("WQ",p.getPiece().getName());
        //piece got position 0
        assertEquals(0,pie2.getPosition().getNumberPosition());
    } // where should this test go?

    @BeforeEach
    public void setUp() {
        g = new Game();
        cb = g.getChessBoard();
        bd = g.getChessBoard().getBoard();
    }

    @Test
    void testWhitePawnMoveForward() {
        // move pawn forward from 8 to 16(index)
        bd.get(8).getPiece().move(bd.get(16), cb);

        // check if the pawn was removed from the original position
        assertEquals(null,bd.get(8).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WP",bd.get(16).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(16,bd.get(16).getPiece().getPosition().getNumberPosition());

    }

    @Test
    void testWhitePawnMoveForwardTwice() {
        // move pawn forward from 8 to 16(index)
        bd.get(8).getPiece().move(bd.get(16), cb);

        // check if the pawn is removed from the original position
        assertEquals(null,bd.get(8).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WP",bd.get(16).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(16,bd.get(16).getPiece().getPosition().getNumberPosition());

        // move the pawn from 16 to 24(index)
        bd.get(16).getPiece().move(bd.get(24), cb);

        // check if the pawn is removed from the original position
        assertEquals(null,bd.get(16).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("WP",bd.get(24).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(24,bd.get(24).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void testWhitePawnKillLeft() {
        // add black pawn
        Pawn blackPawn = new Pawn("BP");
        bd.get(16).setPiece(blackPawn);
        bd.get(9).getPiece().move(bd.get(16), cb);

        // check 9 white pawn killed 16 black pawn (left)
        assertEquals("WP", bd.get(16).getPiece().getName());
        assertEquals(null, bd.get(9).getPiece());

    }

    @Test
    void testWhitePawnKillRight() {
        // add black pawn
        Pawn blackPawn = new Pawn("BP");
        bd.get(18).setPiece(blackPawn);
        assertEquals("BP", bd.get(18).getPiece().getName());
        bd.get(9).getPiece().move(bd.get(18), cb);

        // check 9 white pawn killed 18 black pawn (right)
        assertEquals("WP", bd.get(18).getPiece().getName());
        assertEquals(null, bd.get(9).getPiece());

    }

    @Test
    void testBlackPawnMoveForward() {
        // move pawn forward from 48 to 40 (index)
        bd.get(48).getPiece().move(bd.get(40),cb);

        // check if the pawn was removed from the original position
        assertEquals(null,bd.get(48).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("BP",bd.get(40).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(40,bd.get(40).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void testBlackPawnMoveForwardTwice() {
        // move pawn forward from 48 to 40 (index)
        bd.get(48).getPiece().move(bd.get(40),cb);
        // move pawn forward from 40 to 32 (index)
        bd.get(40).getPiece().move(bd.get(32),cb);

        // check if the pawn was removed from the original position
        assertEquals(null,bd.get(40).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("BP",bd.get(32).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(32,bd.get(32).getPiece().getPosition().getNumberPosition());

    }

    @Test
    void testBlackPawnKillLeft() {// left when looking from the sight of the white
        // add white pawn
        Pawn whitePawn = new Pawn("WP");
        bd.get(40).setPiece(whitePawn);

        bd.get(49).getPiece().move(bd.get(40),cb);

        // check if the pawn was removed from the original position
        assertEquals(null,bd.get(49).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("BP",bd.get(40).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(40,bd.get(40).getPiece().getPosition().getNumberPosition());
    }

    @Test
    void testBlackPawnKillRight() {// left when looking from the sight of the white
        // add white pawn
        Pawn whitePawn = new Pawn("WP");
        bd.get(42).setPiece(whitePawn);

        bd.get(49).getPiece().move(bd.get(42),cb);

        // check if the pawn was removed from the original position
        assertEquals(null,bd.get(49).getPiece());
        // check if the pawn was moved (position has piece)
        assertEquals("BP",bd.get(42).getPiece().getName());
        // check if the pawn was moved (piece has position)
        assertEquals(42,bd.get(42).getPiece().getPosition().getNumberPosition());
    }
}
