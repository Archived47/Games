package Games.RoyalGameOfUr;

public class Path {

    Field[] fields;

    Path() {
        fields = new Field[14];
    }

    boolean occupied(int i) {
        return fields[i].occupied;
    }

}
