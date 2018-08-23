import Games.Game;
import Games.Hangman.Hangman;
import Games.RoyalGameOfUr.RoyalGameOfUr;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Application {

    private static Class[] games;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Temp
        try {
            Hangman.codeSource = Hangman.class.getProtectionDomain().getCodeSource();
            Hangman.jarFile = new File(Hangman.codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        games = new Class[]{Hangman.class, RoyalGameOfUr.class};

//        args = new String[0]; // Only to run FX from the IDE
        if (args.length > 0 && args[0].equals("console")) {
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
                    game.run();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } else {
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
        Parent root = FXMLLoader.load(getClass().getResource("Games/JavaFX/MainMenu.fxml"));
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
