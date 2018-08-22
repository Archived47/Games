package Games.JavaFXMenu.Controllers;

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

    @FXML
    private Button hangman;

    @FXML
    private Button RGoU;



    public void playHangman(ActionEvent actionEvent) {
        hideStage(actionEvent);
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/Hangman.fxml"));
            stage.setTitle("Main Menu");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
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
     * @param event the event that happenes
     */
    private void hideStage(ActionEvent event) {
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.hide();
    }
}

