package Games.JavaFX.RoyalGameOfUr;

import Games.RoyalGameOfUr.Field;
import Games.RoyalGameOfUr.RoyalGameOfUr;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayFieldController implements Initializable {

    public static Stage mainStage;

    @FXML
    private Rectangle player0_1;
    @FXML
    private Rectangle player0_2;
    @FXML
    private Rectangle player0_3;
    @FXML
    private Rectangle player0_4;
    @FXML
    private Rectangle player0_5;
    @FXML
    private Rectangle player0_6;
    @FXML
    private Rectangle player0_7;
    @FXML
    private Rectangle player0_8;

    @FXML
    private Rectangle player1_1;
    @FXML
    private Rectangle player1_2;
    @FXML
    private Rectangle player1_3;
    @FXML
    private Rectangle player1_4;
    @FXML
    private Rectangle player1_5;
    @FXML
    private Rectangle player1_6;

    @FXML
    private Rectangle player2_1;
    @FXML
    private Rectangle player2_2;
    @FXML
    private Rectangle player2_3;
    @FXML
    private Rectangle player2_4;
    @FXML
    private Rectangle player2_5;
    @FXML
    private Rectangle player2_6;

    @FXML
    private Circle p1_1;
    @FXML
    private Circle p1_2;
    @FXML
    private Circle p1_3;
    @FXML
    private Circle p1_4;
    @FXML
    private Circle p1_5;
    @FXML
    private Circle p1_6;
    @FXML
    private Circle p1_7;

    @FXML
    private Circle p2_1;
    @FXML
    private Circle p2_2;
    @FXML
    private Circle p2_3;
    @FXML
    private Circle p2_4;
    @FXML
    private Circle p2_5;
    @FXML
    private Circle p2_6;
    @FXML
    private Circle p2_7;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RoyalGameOfUr gameOfUr = new RoyalGameOfUr();
        Circle[] player1Pieces = new Circle[]{p1_1, p1_2, p1_3, p1_4, p1_5, p1_6, p1_7};
        Circle[] player2Pieces = new Circle[]{p2_1, p2_2, p2_3, p2_4, p2_5, p2_6, p2_7};

        gameOfUr.players[0].setPieces(player1Pieces);
        gameOfUr.players[1].setPieces(player2Pieces);

        setPaths(gameOfUr);
    }

    private void setPaths(RoyalGameOfUr gameOfUr) {
        Field fplayer0_1 = new Field(false, player0_1);
        Field fplayer0_2 = new Field(false, player0_2);
        Field fplayer0_3 = new Field(false, player0_3);
        Field fplayer0_4 = new Field(true, player0_4);
        Field fplayer0_5 = new Field(false, player0_5);
        Field fplayer0_6 = new Field(false, player0_6);
        Field fplayer0_7 = new Field(false, player0_7);
        Field fplayer0_8 = new Field(false, player0_8);

        gameOfUr.players[0].path.fields[0] = new Field(false, player1_1);
        gameOfUr.players[0].path.fields[1] = new Field(false, player1_2);
        gameOfUr.players[0].path.fields[2] = new Field(false, player1_3);
        gameOfUr.players[0].path.fields[3] = new Field(true, player1_4);
        gameOfUr.players[0].path.fields[4] = fplayer0_1;
        gameOfUr.players[0].path.fields[5] = fplayer0_2;
        gameOfUr.players[0].path.fields[6] = fplayer0_3;
        gameOfUr.players[0].path.fields[7] = fplayer0_4;
        gameOfUr.players[0].path.fields[8] = fplayer0_5;
        gameOfUr.players[0].path.fields[9] = fplayer0_6;
        gameOfUr.players[0].path.fields[10] = fplayer0_7;
        gameOfUr.players[0].path.fields[11] = fplayer0_8;
        gameOfUr.players[0].path.fields[12] = new Field(false, player1_5);
        gameOfUr.players[0].path.fields[13] = new Field(true, player1_6);

        gameOfUr.players[1].path.fields[0] = new Field(false, player2_1);
        gameOfUr.players[1].path.fields[1] = new Field(false, player2_2);
        gameOfUr.players[1].path.fields[2] = new Field(false, player2_3);
        gameOfUr.players[1].path.fields[3] = new Field(true, player2_4);
        gameOfUr.players[1].path.fields[4] = fplayer0_1;
        gameOfUr.players[1].path.fields[5] = fplayer0_2;
        gameOfUr.players[1].path.fields[6] = fplayer0_3;
        gameOfUr.players[1].path.fields[7] = fplayer0_4;
        gameOfUr.players[1].path.fields[8] = fplayer0_5;
        gameOfUr.players[1].path.fields[9] = fplayer0_6;
        gameOfUr.players[1].path.fields[10] = fplayer0_7;
        gameOfUr.players[1].path.fields[11] = fplayer0_8;
        gameOfUr.players[1].path.fields[12] = new Field(false, player2_5);
        gameOfUr.players[1].path.fields[13] = new Field(true, player2_6);
    }
}
