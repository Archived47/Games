package Games.JavaFX.Hangman;

import Games.Hangman.Hangman;
import Games.Hangman.Resources.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HangmanController implements Initializable {

    private Stage stage;
    public static Stage mainStage;
    private int currentStage;
    private Shape[] stages;
    private Word sWord;

    @FXML
    private Line pole;
    @FXML
    private Line roof;
    @FXML
    private Line support;
    @FXML
    private Line rope;
    @FXML
    private Circle head;
    @FXML
    private Line torso;
    @FXML
    private Line rArm;
    @FXML
    private Line lArm;
    @FXML
    private Line rLeg;
    @FXML
    private Line lLeg;
    @FXML
    private Button guessButton;
    @FXML
    private TextField guessBox;
    @FXML
    private Text guessed;
    @FXML
    private Text word;


    @FXML
    void guess(ActionEvent event) {
        if (stage == null) {
            Button button = (Button) event.getSource();
            stage = (Stage) button.getScene().getWindow();
        }

        String input = guessBox.getText().toLowerCase();
        if (input.matches("[a-z]+")) {
            if (input.matches("[a-z]")) {
                if (!guessed.getText().contains(input)) {
                    // Normal guess
                    if (sWord.guess(input.charAt(0))) {
                        setWordText();
                        if (sWord.isCompleted()) {
                            end(true);
                        }
                    } else {
                        wrong(input);
                    }
                }
            } else {
                // Complete sWord
                if (sWord.guessWord(input)) {
                    end(true);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Only enter letter characters please.");
            alert.show();
        }
        guessBox.clear();
        guessBox.requestFocus();
    }

    private void setWordText() {
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < sWord.getWord().length(); i++) {
            wordBuilder.append(sWord.getWord().charAt(i)).append(" ");
        }
        word.setText(wordBuilder.toString());
    }

    private void end(boolean won) {
        Alert alert;
        if (won) {
            alert = new Alert(Alert.AlertType.CONFIRMATION, "You have won!");
        } else {
            alert = new Alert(Alert.AlertType.ERROR, "You have lost!");
        }
        mainStage.show();
        alert.show();
        stage.close();
    }

    private void wrong(String input) {
        String text = guessed.getText().isEmpty() ? guessed.getText() + input : guessed.getText() + ", " + input;
        guessed.setText(text);
        if (currentStage < stages.length - 1) {
            stages[currentStage].setVisible(true);
            currentStage++;
        } else {
            end(false);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Hangman hangman = new Hangman();
        currentStage = 0;
        stages = new Shape[]{pole, roof, support, rope, head, torso, rArm, lArm, rLeg, lLeg};
        sWord = new Word(hangman.generateWord());

        setWordText();

        guessBox.requestFocus();

        guessBox.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                guessButton.fire();
            }
        });

        guessButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                guessButton.fire();
            }
        });
    }
}
