package Test;

import main.ChessBoard;
import main.Game;
import main.Knight;
import main.Position;
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
    void WhiteKnightMoveTestTwoFLeft() {
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
    void WhiteKnightMoveTestTwoFRight() {
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
    void WhiteKnightMoveTestOneFLeft() {
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
}
