package Games.RoyalGameOfUr;

import javafx.scene.shape.Circle;

public class Player {

    public Piece[] pieces;
    public Path path;

    Player() {
    }

    public void setPieces(Circle[] circles) {
        pieces = new Piece[circles.length];
        for (int i = 0; i < circles.length; i++) {
            pieces[i] = new Piece(circles[i]);
        }
        path = new Path();
    }

    boolean movePiece(Piece piece, int steps) {
        for (Piece p: pieces) {
            if (p == piece) {
                if (path.occupied(p.currentField + steps) != null && path.occupied(p.currentField + steps) != this) {
                    System.out.println("This piece can not be moved to this position.");
                }
                break;
            }
        }
        return false;
    }

}
