package Games.RoyalGameOfUr;

import java.util.Random;

public class Dice {

    Random random;

    Dice() {
        random = new Random();
    }

    int roll() {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += random.nextInt(2);
        }
        return result;
    }

}
