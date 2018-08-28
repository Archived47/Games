package Games.RoyalGameOfUr;

import javafx.scene.shape.Circle;

public class Piece extends Circle {

    private int currentField;
    private boolean won;
    private double firstX;
    private double firstY;

    public Piece() {
        super();
        currentField = -1;
    }

    public void setInitialLocation() {
        firstX = getCenterX();
        firstY = getCenterY();
    }

    public boolean isMovable(int steps, Player player) {
        if(player.path.occupied(currentField + steps) == null) {
            if (currentField + steps == 14) {
                return true;
            } else return currentField + steps <= 13;
        } else return player.path.occupied(currentField + steps) != player;
    }

    public void move(int steps, Player player) {
        if (currentField != -1) {
            player.path.fields[currentField].occupier = null;
        }

        currentField += steps;

        if (currentField > 13) {
            won = true;
        }

        if (won) {
            this.setVisible(false);
        } else {
            Field field = player.path.fields[currentField];
            if (field.occupier != player && field.occupier != null) {
                System.out.println(firstX);
                field.currentPiece.setCenterX(field.currentPiece.firstX);
                field.currentPiece.setCenterY(field.currentPiece.firstY);
                field.currentPiece.currentField = -1;
            }
            field.occupier = player;
            field.currentPiece = this;
            this.setCenterX(field.getLayoutX() + field.getWidth() / 2);
            this.setCenterY(field.getLayoutY() + field.getHeight() / 2);
        }
    }

    public int getCurrentField() {
        return currentField;
    }
}
