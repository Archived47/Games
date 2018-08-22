import Games.Game;
import Games.Hangman.Hangman;
import Games.RoyalGameOfUr.RoyalGameOfUr;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Application {

    public static Stage stage;
    public static boolean console;

    private static Class[] games;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        games = new Class[]{Hangman.class, RoyalGameOfUr.class};

//        args = new String[0];
        if (args.length > 0 && args[0].equals("console")) {
            console = true;
            System.out.println("Console version.");
            while (true) {
                System.out.println("What game do you want to play?");
                System.out.println(0 + ": Quit the menu");
                for (int i = 0; i < games.length; i++) {
                    System.out.println((i + 1) + ": " + games[i].getSimpleName());
                }

                int gameNumber = getGame();
                if (gameNumber == 0) break;

                Class choice = games[gameNumber-1];
                try {
                    Game game = ((Game) choice.getDeclaredConstructors()[0].newInstance());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } else {
            console = false;
            System.out.println("JavaFX console");
            launch(args);
        }


    }

    private static int getGame() {
        int game;

        try {
            game = scanner.nextInt();
            if (game > 0 && game < games.length + 1) {
                return game;
            } else {
                if (game == 0) {
                    return game;
                } else {
                    System.out.println("Please enter a correct choice.");
                    return getGame();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please only enter numbers.");
            scanner = new Scanner(System.in);
            return getGame();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("Games/JavaFXMenu/FXML/MainMenu.fxml"));
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
