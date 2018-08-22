package Games.Hangman.Resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WordsReader {

    private String filePath;

    public WordsReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> read() throws IOException {
        ArrayList<String> words = new ArrayList<>();
        Path file = Paths.get(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.matches("[a-zA-Z]+")) {
                words.add(line.toLowerCase());
            }
        }

        return words;
    }

}
