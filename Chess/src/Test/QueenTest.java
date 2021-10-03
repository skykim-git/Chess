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

    @Test
    void WhiteQueenMoveNW1() { // northWest
        testMoveHelper(new Queen("WQ"), 27, 34, "WQ");
    }

    @Test
    void WhiteQueenMoveNW2() {
        testMoveHelper(new Queen("WQ"), 27, 41, "WQ");
    }

    @Test
    void WhiteQueenKillNW3() {
        testMoveHelper(new Queen("WQ"), 27, 48, "WQ");
    }

    @Test
    void WhiteQueenMoveNE1() { // northWest
        testMoveHelper(new Queen("WQ"), 27, 36, "WQ");
    }

    @Test
    void WhiteQueenMoveNE2() { // northWest
        testMoveHelper(new Queen("WQ"), 27, 45, "WQ");
    }

    @Test
    void WhiteQueenKillNE3() {
        //testKillHelper(new Queen("WQ"), 27, 54, "WQ", new Queen("BB"));
    }

    @Test
    void WhiteQueenCanNotKillNE4() {
        // place White knight at index 35 (for move in every possible position)
        bd.get(27).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(63),cb);

        // check if the knight was removed from the original position
        assertEquals("WQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("BR",bd.get(63).getPiece().getName());

    }

    @Test
    void WhiteQueenMoveSW1() { // northWest
        testMoveHelper(new Queen("WQ"), 27, 18, "WQ");
    }

    @Test
    void WhiteQueenMoveSW2() {
        bd.get(27).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(9),cb);

        // check if the knight was removed from the original position
        assertEquals("WQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WP",bd.get(9).getPiece().getName());
    }

    @Test
    void WhiteQueenMoveSW3() {
        bd.get(27).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(0),cb);

        // check if the knight was removed from the original position
        assertEquals("WQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WR",bd.get(0).getPiece().getName());
    }


    @Test
    void WhiteQueenMoveSE1() { // northWest
        testMoveHelper(new Queen("WQ"), 27, 20, "WQ");
    }

    @Test
    void WhiteQueenMoveSE2() {
        bd.get(27).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(13),cb);

        // check if the knight was removed from the original position
        assertEquals("WQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WP",bd.get(13).getPiece().getName());
    }

    @Test
    void WhiteQueenMoveSE3() {
        bd.get(27).setPiece(new Queen("WQ"));
        bd.get(27).getPiece().move(bd.get(6),cb);

        // check if the knight was removed from the original position
        assertEquals("WQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WN",bd.get(6).getPiece().getName());
    }



    @Test
    void WhiteQueenTeamKillTest() {
        bd.get(27).setPiece(new Queen("WQ"));
        // move Knight to index 50 // killing
        bd.get(27).getPiece().move(bd.get(9),cb);

        // check if the knight was removed from the original position
        assertEquals("WQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WP",bd.get(9).getPiece().getName());
    }

    @Test
    void BlackQueenTeamKillTest() {
        bd.get(27).setPiece(new Queen("BB"));
        // move Knight to index 50 // killing
        bd.get(27).getPiece().move(bd.get(48),cb);

        // check if the knight was removed from the original position
        assertEquals("BB",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("BP",bd.get(48).getPiece().getName());
    }

    @Test
    void blockQueenTestNW() {
        bd.get(27).setPiece(new Queen("WQ"));
        bd.get(34).setPiece(new Queen("WQ"));
        // move Knight to index 50 // killing
        bd.get(27).getPiece().move(bd.get(41),cb);

        assertEquals("WQ",bd.get(27).getPiece().getName());
        assertEquals(null,bd.get(41).getPiece());

    }

    @Test
    void BlackQueenMoveNW1() { // northWest
        testMoveHelper(new Queen("BQ"), 27, 34, "BQ");
    }

    @Test
    void BlackQueenMoveNW2() {
        testMoveHelper(new Queen("BQ"), 27, 41, "BQ");
    }

    @Test
    void BlackQueenMoveNE1() { // northWest
        testMoveHelper(new Queen("BQ"), 27, 36, "BQ");
    }

    @Test
    void BlackQueenMoveNE2() { // northWest
        testMoveHelper(new Queen("BQ"), 27, 45, "BQ");
    }

    @Test
    void BlackQueenTeamKillNE4() {
        bd.get(27).setPiece(new Queen("BQ"));
        bd.get(27).getPiece().move(bd.get(63),cb);

        // check if the knight was removed from the original position
        assertEquals("BQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("BR",bd.get(63).getPiece().getName());
    }


    @Test
    void BlackQueenMoveSW1() { // northWest
        testMoveHelper(new Queen("BQ"), 27, 18, "BQ");
    }

    @Test
    void BlackQueenKillSW2() { // northWest
        testMoveHelper(new Queen("BQ"), 27, 9, "BQ");
    }

    @Test
    void BlackQueenMoveSW3() { // fail
        bd.get(27).setPiece(new Queen("BQ"));
        bd.get(27).getPiece().move(bd.get(0),cb);

        // check if the knight was removed from the original position
        assertEquals("BQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WR",bd.get(0).getPiece().getName());
    }

    @Test
    void BlackQueenMoveSE1() { // northWest
        testMoveHelper(new Queen("BQ"), 27, 20, "BQ");
    }

    @Test
    void BlackQueenKillSE2() { // northWest
        testMoveHelper(new Queen("BQ"), 27, 13, "BQ");
    }

    // 6 kill fail
    @Test
    void BlackQueenMoveSE3() { // fail
        bd.get(27).setPiece(new Queen("BQ"));
        bd.get(27).getPiece().move(bd.get(6),cb);

        // check if the knight was removed from the original position
        assertEquals("BQ",bd.get(27).getPiece().getName());
        // check if the pawn was moved (position has piece)
        assertEquals("WN",bd.get(6).getPiece().getName());
    }



}
