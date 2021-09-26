package main;

// abstract class representing a main.Piece having position
public abstract class Piece {
    protected Position position;
    protected String name; // take a look at naming convention in p3

    public Piece(String name) {
        this.name = name;
    }

    // abstract method for subclasses
    public abstract void move(Position p, ChessBoard cb);

    public void setPosition(Position position) {
        this.position = position;
    }

    public void removePosition() {
        this.position = null;
    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    // helper 1
    public boolean isWhite(Piece p) {
        String name = p.getName();
        if (name.substring(0,1).equals("W")) {
            return true;
        } else {
            return false;
        }

    }

}
