import java.util.ArrayList;
import java.util.List;

// Represents a ChessBoard.
public class ChessBoard {
    private List<Position> board = new ArrayList<Position>();

    public List getBoard() {
        return board;
    };


    // EFFECTS : constructs a ChessBoard with 64 positions.
    public ChessBoard() {
        for (int i = 0; i < 64; i = i + 1) {
            this.board.add(new Position(i+1));
        }
    }

//    public void Initialize() {
//        //create 64 positions, with numberPosition and coordinate and assign pieces
//        board.add(new Position(1));
//    }

    public static void main(String arg[]) {
       ChessBoard cb =  new ChessBoard();
       //System.out.print(cb.board);
        for (int i = 0; i < 64; i = i + 1) {
            System.out.print(cb.board.get(i).getNumberPosition());
            System.out.println("\n");
        }
        for (int i = 0; i < 64; i = i + 1) {
            System.out.print(cb.board.get(i).getCoordinate());
            System.out.println("\n");
        }
    }
}
