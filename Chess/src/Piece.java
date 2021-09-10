// abstract class representing a Piece having position
public abstract class Piece {
    protected Position position;
    protected String name; // take a look at naming convention in p3

    public Piece(int np, String name) {
        this.position = new Position(np);// bi-directional
        this.name = name;
    }

    // abstract method for subclasses
    public abstract void Move();

}
