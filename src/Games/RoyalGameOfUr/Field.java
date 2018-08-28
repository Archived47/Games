package Games.RoyalGameOfUr;

import javafx.scene.shape.Rectangle;

public class Field {

    boolean rosette;
    Player occupier;
    Rectangle physical;

    public Field(boolean rosette, Rectangle rectangle) {
        this.rosette = rosette;
        occupier = null;
        physical = rectangle;
    }

}
