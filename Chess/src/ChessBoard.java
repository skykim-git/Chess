import java.util.List;

public class ChessBoard {
    private List<Position> board;

    public ChessBoard() {}

    public void Initialize() {
        //create 64 positions, and assign pieces
        board.add(new Position());
    }
}
