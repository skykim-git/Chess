package main;

// Represents main.Position on the chessboard, has numberPosition, coordinate, and a piece(can be null)
public class Position {
    private int numberPosition;
    private String coordinate;
    private Piece piece;

    // EFFECTS: constructs a main.Position of position np and a piece
    public Position(int np) {
        this.numberPosition = np;
        NumPosToCoordinate();
        this.piece = null;
    }

    public int getNumberPosition() {
        return this.numberPosition;
    }

    public String getCoordinate() {
        return this.coordinate;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) { // should be bi-directional
        if (!(this.piece == null)) {
            removePiece();
            this.piece = piece;
            piece.setPosition(this);
        } else {
//            removePiece();
//            this.setPiece(piece);
        }

    }

    public void removePiece() {
        this.piece.removePosition();
        this.piece = null;

    }

    // MODIFIES : this
    // EFFECTS  : change numberPosition to coordinate and assign it... ??? split into two... needs helper
    public void NumPosToCoordinate() {

        int num;
        int alphabetInt;

        // quotient represents the row(number) in a coordinate
        // remainder represents the col(alphabet) in a coordinate
        if (this.numberPosition % 8 == 0) {// where problem occured with 64-@ascii code
            num = this.numberPosition / 8;
            alphabetInt = 8;// 64 + 8 = ascii for h
        } else {
            num = this.numberPosition / 8 + 1;
            alphabetInt = this.numberPosition % 8;
        }

        String alphabetString = NumToAlpha(alphabetInt);
        this.coordinate = alphabetString + String.valueOf(num);
    }

    // EFFECTS: returns alphabet string in a coordinate given an colunm value of the number position
    public String NumToAlpha(int alphabetInt) {
        int radix = 10;
        int asciiAlpha = alphabetInt + 64; // converting to ascii code
        char alphabet = (char) asciiAlpha;
        String alphabetString = Character.toString(alphabet);
        alphabetString = alphabetString.toLowerCase();
        return alphabetString;
    }

    // test main function
    public static void main(String arg[]) {
        Position p = new Position(10);
        String st = p.NumToAlpha(1);
        //System.out.print(st);
        System.out.print(p.coordinate);
    }
}
