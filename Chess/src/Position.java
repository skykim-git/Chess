

public class Position {
    private int numberPosition;
    private String coordinate;
    private Piece piece;
    int initNumPos;


    public Position(int np) {
        this.numberPosition = np;
        NumPosToCoordinate();
    }

    public void NumPosToCoordinate() {
        int num = this.numberPosition / 8 + 1;
        int alphabetInt = this.numberPosition % 8;
        String alphabetString = NumToAlpha(alphabetInt);
        this.coordinate = alphabetString + String.valueOf(num);
    }

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
