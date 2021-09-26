package Test;

import main.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    void testSetPieceEmptyPos() {
        Position p = new Position(0);
        Piece pie = new Queen("BQ");
        p.setPiece(pie);
        //test if the pie has the position
        assertEquals(pie,p.getPiece());
        assertEquals(0,pie.getPosition().getNumberPosition());

    }

}
