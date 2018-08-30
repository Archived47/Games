package Games.Hangman;

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

public class Hangman {

    public static CodeSource codeSource;
    public static File jarFile;

    private static String gameName = Hangman.class.getSimpleName();
    private static String filePath;

    public Hangman() {
        filePath = findFile() + "/" + gameName + "/words.txt";
    }

    public String generateWord() {
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

    private String findFile() {
        if (!Paths.get(jarFile.getParentFile().getPath() + "/Hangman/words.txt").toFile().exists()) {
            try {
                File file = new File(jarFile.getParentFile().getPath() + "/Hangman");
                if (file.mkdir()) {
                    InputStream link = (getClass().getResourceAsStream("Resources/words.txt"));
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
