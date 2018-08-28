package Games.JavaFX.RoyalGameOfUr;

import Games.RoyalGameOfUr.Field;
import Games.RoyalGameOfUr.Piece;
import Games.RoyalGameOfUr.Player;
import Games.RoyalGameOfUr.RoyalGameOfUr;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayFieldController implements Initializable {

    public static Stage mainStage;

    private RoyalGameOfUr gameOfUr;
    private boolean activeTurn;
    private int currentSteps = -1;

    @FXML
    private ImageView dice;

    @FXML
    private Field player0_1;
    @FXML
    private Field player0_2;
    @FXML
    private Field player0_3;
    @FXML
    private Field player0_4;
    @FXML
    private Field player0_5;
    @FXML
    private Field player0_6;
    @FXML
    private Field player0_7;
    @FXML
    private Field player0_8;

    @FXML
    private Field player1_1;
    @FXML
    private Field player1_2;
    @FXML
    private Field player1_3;
    @FXML
    private Field player1_4;
    @FXML
    private Field player1_5;
    @FXML
    private Field player1_6;

    @FXML
    private Field player2_1;
    @FXML
    private Field player2_2;
    @FXML
    private Field player2_3;
    @FXML
    private Field player2_4;
    @FXML
    private Field player2_5;
    @FXML
    private Field player2_6;

    @FXML
    private Piece p1_1;
    @FXML
    private Piece p1_2;
    @FXML
    private Piece p1_3;
    @FXML
    private Piece p1_4;
    @FXML
    private Piece p1_5;
    @FXML
    private Piece p1_6;
    @FXML
    private Piece p1_7;

    @FXML
    private Piece p2_1;
    @FXML
    private Piece p2_2;
    @FXML
    private Piece p2_3;
    @FXML
    private Piece p2_4;
    @FXML
    private Piece p2_5;
    @FXML
    private Piece p2_6;
    @FXML
    private Piece p2_7;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameOfUr = new RoyalGameOfUr();

        gameOfUr.players[0].pieces = new Piece[]{p1_1, p1_2, p1_3, p1_4, p1_5, p1_6, p1_7};
        gameOfUr.players[1].pieces = new Piece[]{p2_1, p2_2, p2_3, p2_4, p2_5, p2_6, p2_7};

        setPaths();

        for (Piece piece:gameOfUr.players[0].pieces) {
            piece.setInitialLocation();
            movePiece(piece);
        }
        for (Piece piece:gameOfUr.players[1].pieces) {
            piece.setInitialLocation();
            movePiece(piece);
        }

        dice.setOnMouseClicked(event -> roll());
    }

    private void movePiece(Piece piece) {
        piece.setOnMouseClicked(e -> {
            Player player = gameOfUr.players[gameOfUr.playing ? 0 : 1];
            for (Piece piece1: player.pieces) {
                if (piece == piece1) {
                    //TODO Make the piece movable.
                    if (currentSteps >= 0) {
                        if (currentSteps != 0) {
                            if (piece.isMovable(currentSteps, player)) {
                                piece.move(currentSteps, player);
                                endTurn(player.path.fields[piece.getCurrentField()].rosette);
                            }
                        }
                    } else {
                        new Alert(Alert.AlertType.ERROR, "Please roll the dice first.").show();
                    }
                    break;
                }
            }
        });
    }

    private void endTurn(boolean rosette) {
        activeTurn = false;
        currentSteps = -1;
        if (!rosette) {
            gameOfUr.playing = !gameOfUr.playing;
        }
    }

    private void roll() {
        // TODO make dice change color based on whose turn it is.
        if (!activeTurn) {
            currentSteps = gameOfUr.die.roll();
            if (currentSteps == 0) {
                new Alert(Alert.AlertType.INFORMATION, "You rolled " + currentSteps + ", you skip a turn.").show();
                endTurn(false);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "You rolled " + currentSteps).show();
                activeTurn = true;
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Waiting for current turn to end.").show();
        }
    }

    private void setPaths() {
        player0_4.rosette = true;
        player1_4.rosette = true;
        player1_6.rosette = true;
        player2_4.rosette = true;
        player2_6.rosette = true;

        for (int i = 0; i < 2; i++) {
            gameOfUr.players[i].path.fields[4] = player0_1;
            gameOfUr.players[i].path.fields[5] = player0_2;
            gameOfUr.players[i].path.fields[6] = player0_3;
            gameOfUr.players[i].path.fields[7] = player0_4;
            gameOfUr.players[i].path.fields[8] = player0_5;
            gameOfUr.players[i].path.fields[9] = player0_6;
            gameOfUr.players[i].path.fields[10] = player0_7;
            gameOfUr.players[i].path.fields[11] = player0_8;
        }

        gameOfUr.players[0].path.fields[0] = player1_1;
        gameOfUr.players[0].path.fields[1] = player1_2;
        gameOfUr.players[0].path.fields[2] = player1_3;
        gameOfUr.players[0].path.fields[3] = player1_4;
        gameOfUr.players[0].path.fields[12] = player1_5;
        gameOfUr.players[0].path.fields[13] = player1_6;

        gameOfUr.players[1].path.fields[0] = player2_1;
        gameOfUr.players[1].path.fields[1] = player2_2;
        gameOfUr.players[1].path.fields[2] = player2_3;
        gameOfUr.players[1].path.fields[3] = player2_4;
        gameOfUr.players[1].path.fields[12] = player2_5;
        gameOfUr.players[1].path.fields[13] = player2_6;
    }
}
