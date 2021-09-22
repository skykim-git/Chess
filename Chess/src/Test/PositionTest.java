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
        assertEquals(0,pie1.getPosition().getNumberPosition());
        p.setPiece(pie2);


        assertEquals("WQ",p.getPiece().getName());
        assertEquals(0,pie2.getPosition().getNumberPosition());


    }

    @Test
    void testPawnMove() {
        Game g = new Game();
        ChessBoard cb = g.getChessBoard();
        List<Position> bd = g.getChessBoard().getBoard();
        Position pawnPos = bd.get(8);
        pawnPos.getPiece().move(bd.get(16), cb);

        assertEquals(null,bd.get(8).getPiece().getName());// pawn removed from original position
        assertEquals("WP",bd.get(16).getPiece().getName());// pawn moved



    }
}
