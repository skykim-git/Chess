package Test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingTest {
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
    void WhiteKingMoveNW() {
        testMoveHelper(new King("WK"),27, 34, "WK");
    }
    @Test
    void WhiteKingMoveN() {
        testMoveHelper(new King("WK"),27, 35, "WK");
    }
    @Test
    void WhiteKingMoveNE() {
        testMoveHelper(new King("WK"),27, 36, "WK");
    }
    @Test
    void WhiteKingMoveW() {
        testMoveHelper(new King("WK"),27, 26, "WK");
    }
    @Test
    void WhiteKingMoveE() {
        testMoveHelper(new King("WK"),27, 28, "WK");
    }
    @Test
    void WhiteKingMoveSW() {
        testMoveHelper(new King("WK"),27, 18, "WK");
    }
    @Test
    void WhiteKingMoveS() {
        testMoveHelper(new King("WK"),27, 19, "WK");
    }
    @Test
    void WhiteKingMoveSE() {
        testMoveHelper(new King("WK"),27, 20, "WK");
    }

    @Test
    void WhiteKingKill() {
        bd.get(27).setPiece(new King("WK"));
        bd.get(35).setPiece(new Pawn("BP"));
        // move Knight to index 50 // killing
        bd.get(27).getPiece().move(bd.get(35),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(27).getPiece());
    }

    @Test
    void BlackKingKill() {
        bd.get(27).setPiece(new King("BK"));
        bd.get(35).setPiece(new Pawn("WP"));
        // move Knight to index 50 // killing
        bd.get(27).getPiece().move(bd.get(35),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(27).getPiece());
    }






    @Test
    void BlackKingMoveNW() {
        testMoveHelper(new King("BK"),35, 42, "BK");
    }
    @Test
    void BlackKingMoveN() {
        testMoveHelper(new King("BK"),35, 43, "BK");
    }
    @Test
    void BlackKingMoveNE() {
        testMoveHelper(new King("BK"),35, 44, "BK");
    }
    @Test
    void BlackKingMoveW() {
        testMoveHelper(new King("BK"),35, 34, "BK");
    }
    @Test
    void BlackKingMoveE() {
        testMoveHelper(new King("BK"),35, 36, "BK");
    }
    @Test
    void BlackKingMoveSW() {
        testMoveHelper(new King("BK"),35, 26, "BK");
    }
    @Test
    void BlackKingMoveS() {
        testMoveHelper(new King("BK"),35, 27, "BK");
    }
    @Test
    void BlackKingMoveSE() {
        testMoveHelper(new King("BK"),35, 28, "BK");
    }

    // invalid pos tests

    @Test
    void WhiteKingInValidPawn1() {
        bd.get(35).setPiece(new King("WK"));
        bd.get(35).getPiece().move(bd.get(43),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(43).getPiece());
    }

    @Test
    void WhiteKingInValidPawn2() {
        bd.get(35).setPiece(new King("WK"));
        bd.get(35).getPiece().move(bd.get(42),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(42).getPiece());
    }

    @Test
    void WhiteKingInValidPawn3() {
        bd.get(35).setPiece(new King("WK"));
        bd.get(35).getPiece().move(bd.get(45),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(45).getPiece());
    }

    @Test
    void WhiteKingInValidKnight1() { // figure 1
        bd.get(35).setPiece(new King("WK"));
        bd.get(17).setPiece(new Knight("BN"));
        bd.get(35).getPiece().move(bd.get(34),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(34).getPiece());
    }

    @Test
    void WhiteKingInValidKnight2() { // figure 1
        bd.get(35).setPiece(new King("WK"));
        bd.get(21).setPiece(new Knight("BN"));
        bd.get(35).getPiece().move(bd.get(36),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(36).getPiece());
    }

    @Test
    void WhiteKingInValidBishop1() { // figure 1
        bd.get(35).setPiece(new King("WK"));
        bd.get(18).setPiece(new Bishop("BB"));
        bd.get(35).getPiece().move(bd.get(27),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(27).getPiece());
    }

    @Test
    void WhiteKingInValidBishop2() { // figure 1
        bd.get(35).setPiece(new King("WK"));
        bd.get(20).setPiece(new Bishop("BB"));
        bd.get(35).getPiece().move(bd.get(27),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(27).getPiece());
    }

    @Test
    void WhiteKingInValidRook1() { // figure 1
        bd.get(35).setPiece(new King("WK"));
        bd.get(24).setPiece(new Rook("BR"));
        bd.get(35).getPiece().move(bd.get(27),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(27).getPiece());
    }

    @Test
    void WhiteKingInValidRook2() { // figure 1
        bd.get(35).setPiece(new King("WK"));
        bd.get(30).setPiece(new Rook("BR"));
        bd.get(35).getPiece().move(bd.get(27),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(27).getPiece());
    }

    @Test
    void WhiteKingInValidQueen1() { // figure 1
        bd.get(35).setPiece(new King("WK"));
        bd.get(18).setPiece(new Queen("BQ"));
        bd.get(35).getPiece().move(bd.get(27),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(27).getPiece());
    }

    @Test
    void WhiteKingInValidQueen2() { // figure 1
        bd.get(35).setPiece(new King("WK"));
        bd.get(20).setPiece(new Queen("BQ"));
        bd.get(35).getPiece().move(bd.get(27),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(27).getPiece());
    }

    @Test
    void WhiteKingInValidQueen3() { // figure 1
        bd.get(35).setPiece(new King("WK"));
        bd.get(24).setPiece(new Queen("BQ"));
        bd.get(35).getPiece().move(bd.get(27),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(27).getPiece());
    }

    @Test
    void WhiteKingInValidQueen4() { // figure 1
        bd.get(35).setPiece(new King("WK"));
        bd.get(30).setPiece(new Queen("BQ"));
        bd.get(35).getPiece().move(bd.get(27),cb);

        // check if the knight was removed from the original position
        assertEquals("WK",bd.get(35).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(27).getPiece());
    }

    @Test
    void BlackKingInValidPawn1() {
        bd.get(27).setPiece(new King("BK"));
        bd.get(27).getPiece().move(bd.get(18),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(18).getPiece());
    }

    @Test
    void BlackKingInValidPawn2() {
        bd.get(27).setPiece(new King("BK"));
        bd.get(27).getPiece().move(bd.get(19),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(19).getPiece());
    }

    @Test
    void BlackKingInValidPawn3() {
        bd.get(27).setPiece(new King("BK"));
        bd.get(27).getPiece().move(bd.get(20),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(20).getPiece());
    }

    @Test
    void BlackKingInValidKnight1() { // figure 1
        bd.get(27).setPiece(new King("BK"));
        bd.get(50).setPiece(new Knight("WN"));
        bd.get(27).getPiece().move(bd.get(35), cb);

        // check if the knight was removed from the original position
        assertEquals("BK", bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null, bd.get(35).getPiece());
    }

    @Test
    void BlackKingInValidKnight2() { // figure 1
        bd.get(27).setPiece(new King("BK"));
        bd.get(52).setPiece(new Knight("WN"));
        bd.get(27).getPiece().move(bd.get(35), cb);

        // check if the knight was removed from the original position
        assertEquals("BK", bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null, bd.get(35).getPiece());
    }

    @Test
    void BlackKingInValidBishop1() { // figure 1
        bd.get(27).setPiece(new King("BK"));
        bd.get(49).setPiece(new Bishop("WB"));
        bd.get(27).getPiece().move(bd.get(35),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(35).getPiece());
    }

    @Test
    void BlackKingInValidBishop2() { // figure 1
        bd.get(27).setPiece(new King("BK"));
        bd.get(53).setPiece(new Bishop("WB"));
        bd.get(27).getPiece().move(bd.get(35),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(35).getPiece());
    }

    @Test
    void BlackKingInValidRook1() { // figure 1
        bd.get(27).setPiece(new King("BK"));
        bd.get(32).setPiece(new Rook("WR"));
        bd.get(27).getPiece().move(bd.get(35),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(35).getPiece());
    }

    @Test
    void BlackKingInValidRook2() { // figure 1
        bd.get(27).setPiece(new King("BK"));
        bd.get(38).setPiece(new Rook("WR"));
        bd.get(27).getPiece().move(bd.get(35),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(35).getPiece());
    }

    @Test
    void BlackKingInValidQueen1() { // figure 1
        bd.get(27).setPiece(new King("BK"));
        bd.get(49).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(35),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(35).getPiece());
    }

    @Test
    void BlackKingInValidQueen2() { // figure 1
        bd.get(27).setPiece(new King("BK"));
        bd.get(53).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(35),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(35).getPiece());
    }

    @Test
    void BlackKingInValidQueen3() { // figure 1
        bd.get(27).setPiece(new King("BK"));
        bd.get(32).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(35),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(35).getPiece());
    }

    @Test
    void BlackKingInValidQueen4() { // figure 1
        bd.get(27).setPiece(new King("BK"));
        bd.get(38).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(35),cb);

        // check if the knight was removed from the original position
        assertEquals("BK",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals(null,bd.get(35).getPiece());
    }












}
