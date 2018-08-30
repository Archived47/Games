package Games.RoyalGameOfUr.Resources;

public class Path {

    public Field[] fields;

    Path() {
        fields = new Field[14];
    }

    Player occupied(int i) {
        try {
            return fields[i].occupier;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

}
