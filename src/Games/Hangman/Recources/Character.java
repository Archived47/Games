package Games.Hangman.Recources;

class Character {

    private char visible;
    private char actual;

    Character(char actual) {
        this.actual = actual;
        visible = '_';
    }

    void update() {
        visible = actual;
    }

    char getVisible() {
        return visible;
    }

    char getActual() {
        return actual;
    }
}
