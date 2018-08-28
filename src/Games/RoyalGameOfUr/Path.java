package Games.RoyalGameOfUr;

public class Path {

    public Field[] fields;

    Path() {
        fields = new Field[14];
    }

    Player occupied(int i) {
        return fields[i].occupier;
    }

}
