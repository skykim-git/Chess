import java.util.List;

public class ChessBoard {
    private List<Position> board;

    public ChessBoard() {}

    public void Initialize() {
        //create 64 positions, with numberPosition and coordinate and assign pieces
        board.add(new Position(1));
    }
}
