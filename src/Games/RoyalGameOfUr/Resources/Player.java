package Games.RoyalGameOfUr.Resources;

public class Player {

    public Piece[] pieces;
    public Path path;

    public Player() {
        path = new Path();
    }

    boolean movePiece(Piece piece, int steps) {
        for (Piece p: pieces) {
            if (p == piece) {
                if (path.occupied(p.getCurrentField() + steps) != null && path.occupied(p.getCurrentField() + steps) != this) {
                    System.out.println("This piece can not be moved to this position.");
                }
                break;
            }
        }
        return false;
    }

}
