package Test;

import main.Piece;
import main.Position;
import main.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    void testSetPieceEmptyPos() {
        Position p = new Position(0);
        Piece pie = new Queen("BQ");
        p.setPiece(pie);
        //test if the pie has the position
        assertEquals(0,pie.getPosition().getNumberPosition());
    }
    @Test
    void testSetPieceKillPos() {
        Position p = new Position(0);
        Piece pie1 = new Queen("BQ");
        Piece pie2 = new Queen("WQ");

        p.setPiece(pie1);
        //p.removePiece(); // should put this in the setPiece or can't I just call remove when I want to place new piece
        // so that I avoid infinite loop(look for previous work you've done)
        p.setPiece(pie2);


        assertEquals("WQ",p.getPiece().getName());
       // assertEquals(0,pie2.getPosition().getNumberPosition());


    }
}
