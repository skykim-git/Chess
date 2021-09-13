package main;

// abstract class representing a main.Piece having position
public abstract class Piece {
    protected Position position;
    protected String name; // take a look at naming convention in p3

    public Piece(String name) {
        this.name = name;
    }

    // abstract method for subclasses
    public abstract void Move();

    public void setPosition(Position position) {
        this.position = position;
        position.setPiece(this);

    }

    public void removePosition() {

    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

}
