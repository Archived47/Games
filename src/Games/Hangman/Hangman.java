package Games.Hangman;

import Games.Game;
import Games.Hangman.Resources.Word;
import Games.Hangman.Resources.WordWriter;
import Games.Hangman.Resources.WordsReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman implements Game {

    public static CodeSource codeSource;
    public static File jarFile;

    private static String gameName = Hangman.class.getSimpleName();
    private static String filePath;

    private boolean play = true;
    private int lives;
    private Word word;
    private ArrayList<Character> guessed;
    private Scanner scanner;

    public Hangman() {
        filePath = findFile() + "/" + gameName + "/words.txt";
        lives = 5;
        guessed = new ArrayList<>();
    }

    @Override
    public void run() {
        scanner = new Scanner(System.in);
        System.out.println("You can add words in the 'words.txt' file or select 2");
        getChoice();
        word = new Word(generateWord());
        System.out.println("If you think you know the word, start the word with a '#'");
        while (play) {
            printText();
            String guess = scanner.next().toLowerCase();
            if (guess.matches("[a-zA-Z]")) {
                if (!guessed.contains(guess.charAt(0))) {
                    if (!word.guess(guess.charAt(0))) {
                        guessed.add(guess.charAt(0));
                        wrongGuess();
                    } else {
                        if (word.isCompleted()) {
                            win();
                            break;
                        }
                    }
                } else {
                    System.out.println("Already guessed this letter.");
                }
            } else {
                if (guess.charAt(0) == '#') {
                    if (word.guessWord(guess.substring(1))) {
                        win();
                        break;
                    } else {
                        wrongGuess();
                    }
                } else {
                    System.out.println("Not a valid input.");
                }
            }
        }
    }

    private void getChoice() {
        int choice;
        System.out.println("Select option.");
        System.out.println("1: Play the game.");
        System.out.println("2: Add word to the word list.");
        while (true) {
            choice = scanner.nextInt();
            if (choice == 1) {
                break;
            } else if (choice == 2) {
                try {
                    WordWriter writer = new WordWriter(filePath);
                    writer.write(scanner);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else {
                System.out.println("Not a valid choice.");
            }
        }
    }

    private void printText() {
        System.out.println();
        System.out.println("Lives: " + lives);
        System.out.println("Word length: " + word.getWord().length());
        System.out.println(word.getWord());
        System.out.print("Already guessed: ");
        for (Character c : guessed) {
            System.out.print(c + ", ");
        }
        System.out.println();
    }

    private void lose() {
        System.out.println("You have lost!");
        play = false;
    }

    private void win() {
        System.out.println("You have won!");
        play = false;
    }

    private void wrongGuess() {
        lives--;
        System.out.println("Wrong guess.");
        if (lives == 0) lose();
    }

    public static String generateWord() {
        Random random = new Random();
        String word = null;

        try {
            WordsReader reader = new WordsReader(filePath);
            ArrayList<String> words = reader.read();
            word = words.get(random.nextInt(words.size()));

        } catch (IOException e) {
            System.exit(e.hashCode());
        }

        return word;
    }

    private static String findFile() {
        if (!Paths.get(jarFile.getParentFile().getPath() + "/Hangman/words.txt").toFile().exists()) {
            try {
                File file = new File(jarFile.getParentFile().getPath() + "/Hangman");
                if (file.mkdir()) {
                    InputStream link = (Hangman.class.getResourceAsStream("Resources/words.txt"));
                    Path path = Paths.get(jarFile.getParentFile().getPath() + "/Hangman/words.txt");
                    Files.copy(link, path);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jarFile.getParentFile().getPath();
    }
}
