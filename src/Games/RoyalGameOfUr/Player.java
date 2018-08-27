package Games.RoyalGameOfUr;

public class Player {

    Piece[] pieces;
    Path path;

    Player() {
        pieces = new Piece[7];
        for (int i = 0; i < pieces.length; i++) {
            pieces[i] = new Piece();
        }
        path = new Path();
    }

    boolean movePiece(Piece piece, int steps) {
        for (Piece p: pieces) {
            if (p == piece) {
                if (path.occupied(p.currentField + steps)) {
                    System.out.println("This piece can not be moved to this position.");
                }
                break;
            }
        }
        return false;
    }

}
