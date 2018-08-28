package Games.RoyalGameOfUr;

import Games.Game;

public class RoyalGameOfUr implements Game {

    public boolean playing;
    public Player[] players;
    public Dice die;

    public RoyalGameOfUr() {
        playing = true;
        players = new Player[]{new Player(), new Player()};
        die = new Dice();
    }

    @Override
    public void run() {

    }
}
