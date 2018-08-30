package Games.RoyalGameOfUr.Resources;

import java.util.Random;

public class Dice {

    private Random random;

    public Dice() {
        random = new Random();
    }

    public int roll() {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += random.nextInt(2);
        }
        return result;
    }

}
