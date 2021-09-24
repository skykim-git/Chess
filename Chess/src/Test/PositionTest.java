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
    void testPawnMoveForward() {// shouldn't it be pawn test...?
        Game g = new Game();
        ChessBoard cb = g.getChessBoard();
        List<Position> bd = g.getChessBoard().getBoard();
        Position pawnPos = bd.get(8);
        assertEquals(9,pawnPos.getPiece().getPosition().getNumberPosition());// numpos + 1 to index

        pawnPos.getPiece().move(bd.get(16), cb);


        // pawn still at the previous location
        assertEquals(null,bd.get(8).getPiece());// pawn removed from original position
        assertEquals("WP",bd.get(16).getPiece().getName());// pawn moved
        assertEquals(1,bd.get(16).getPiece().getPosition());

    }

    @Test
    void testPawnMoveForwardTwice() {// shouldn't it be pawn test...?
        Game g = new Game();
        ChessBoard cb = g.getChessBoard();
        List<Position> bd = g.getChessBoard().getBoard();
        //Position pawnPos = bd.get(8);

        //assertEquals(9,bd.get(8).getPiece().getPosition().getNumberPosition());// numpos + 1 to index

        bd.get(8).getPiece().move(bd.get(16), cb);


        // pawn still at the previous location
        assertEquals(null,bd.get(8).getPiece());// pawn removed from original position
        assertEquals("WP",bd.get(16).getPiece().getName());// pawn moved

        assertEquals(17,bd.get(16).getPiece().getPosition());
        //bd.get(16).getPiece().move(bd.get(24), cb);


        // pawn still at the previous location

        assertEquals(null,bd.get(16).getPiece());// pawn removed from original position
        assertEquals("WP",bd.get(24).getPiece().getName());// pawn moved


    }

    @Test
    void testWhitePawnKillLeft() {
        Game g = new Game();
        ChessBoard cb = g.getChessBoard();
        List<Position> bd = g.getChessBoard().getBoard(); // Beforeeach make it

        // add black
        Pawn blackPawn = new Pawn("BP");
        bd.get(16).setPiece(blackPawn); // numpos 9
        assertEquals("BP", bd.get(16).getPiece().getName());
        bd.get(9).getPiece().move(bd.get(16), cb); // numpos 2

        assertEquals("WP", bd.get(16).getPiece().getName());
        assertEquals(null, bd.get(9).getPiece());

    }

    @Test
    void testWhitePawnKillRight() {
        Game g = new Game();
        ChessBoard cb = g.getChessBoard();
        List<Position> bd = g.getChessBoard().getBoard();

        // add black
        Pawn blackPawn = new Pawn("BP");
        bd.get(18).setPiece(blackPawn); // numpos 9
        assertEquals("BP", bd.get(18).getPiece().getName());
        bd.get(9).getPiece().move(bd.get(18), cb); // numpos 2

        assertEquals("WP", bd.get(18).getPiece().getName());
        assertEquals(null, bd.get(9).getPiece());

    }
}
