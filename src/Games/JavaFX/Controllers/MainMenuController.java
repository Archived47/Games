package Games.JavaFX.Controllers;

import Games.RoyalGameOfUr.RoyalGameOfUr;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    private Stage primaryStage;

    @FXML
    private Button hangman;
    @FXML
    private Button RGoU;



    public void playHangman(ActionEvent actionEvent) {
        hideStage(actionEvent);
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/Hangman.fxml"));
            stage.setTitle("Hangman");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            HangmanController.mainStage = primaryStage;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void playRGoU(javafx.event.ActionEvent actionEvent) {
        hideStage(actionEvent);
        RoyalGameOfUr RGoR = new RoyalGameOfUr();
    }

    /**
     * A helper function to hide the stage.
     * @param event the event that happened
     */
    private void hideStage(ActionEvent event) {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        primaryStage = stage;
        stage.hide();
    }
}

