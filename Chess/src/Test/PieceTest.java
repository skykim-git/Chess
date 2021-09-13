package Test;

import main.Piece;
import main.Position;
import main.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PieceTest {

    @Test
    void testBidirectional() {
        Position p =  new Position(1);
        Piece pie = new Rook("BK");
        p.setPiece(pie);

        assertEquals(pie,p.getPiece());
        assertEquals(p,pie.getPosition());

    }
}
