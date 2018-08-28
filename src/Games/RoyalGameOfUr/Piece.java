package Games.RoyalGameOfUr;

import javafx.scene.shape.Circle;

public class Piece extends Circle {

    int currentField;

    Piece() {
        super();
        currentField = -1;
    }

    public boolean isMoveable(int steps) {
        return true;
    }
}
