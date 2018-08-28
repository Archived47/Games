package Games.RoyalGameOfUr;

import Games.Game;

public class RoyalGameOfUr implements Game {

    public boolean player;
    public Player[] players;
    public Dice die;

    public RoyalGameOfUr() {
        player = true;
        players = new Player[]{new Player(), new Player()};
        die = new Dice();
    }

    @Override
    public void run() {

    }
}
