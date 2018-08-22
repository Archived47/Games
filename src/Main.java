import Games.Game;
import Games.Hangman.Hangman;
import Games.RoyalGameOfUr.RoyalGameOfUr;

import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Class[] games;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        games = new Class[]{Hangman.class, RoyalGameOfUr.class};

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

}
