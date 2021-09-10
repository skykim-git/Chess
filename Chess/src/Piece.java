// abstract class representing a Piece having position
public abstract class Piece {
    protected Position position;
    protected String name; // take a look at naming convention in p3

    public Piece(int np) {
        this.position = new Position(np);
    } // dummy for now

    // abstract method for subclasses
    public abstract void Move();

}
