package Games.RoyalGameOfUr;

import javafx.scene.shape.Circle;

public class Piece {

    int currentField;
    Circle physical;

    Piece(Circle circle) {
        currentField = -1;
        physical = circle;
    }

    public boolean isMoveable(int steps) {
        return true;
    }
}
