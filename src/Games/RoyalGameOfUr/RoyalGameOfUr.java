package Games.RoyalGameOfUr;

import Games.RoyalGameOfUr.Resources.Dice;
import Games.RoyalGameOfUr.Resources.Player;

public class RoyalGameOfUr {

    public boolean playing;
    public Player[] players;
    public Dice die;

    public RoyalGameOfUr() {
        playing = true;
        players = new Player[]{new Player(), new Player()};
        die = new Dice();
    }
}
