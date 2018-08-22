package Games.Hangman.Recources;

import java.util.ArrayList;

public class Word {

    private String word;
    private ArrayList<Character> chars;

    public Word(String word) {
        chars = new ArrayList<>();
        this.word = word;
        for (char c : word.toCharArray()) {
            chars.add(new Character(c));
        }
    }

    public boolean isCompleted() {
        boolean completed = true;
        for (Character c : chars) {
            if (c.getActual() != c.getVisible()) {
                completed = false;
            }
        }
        return completed;
    }

    public boolean guess(char c) {
        if (word.contains(String.valueOf(c))) {
            for (Character character: chars) {
                if (character.getActual() == c) {
                    character.update();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean guessWord(String s) {
        return word.equals(s);
    }

    public String getWord() {
        StringBuilder word = new StringBuilder();
        for (Character c : chars) {
            word.append(c.getVisible());
        }
        return word.toString();
    }
}
