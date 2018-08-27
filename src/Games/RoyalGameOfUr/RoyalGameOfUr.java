package Games.RoyalGameOfUr;

import Games.Game;

import java.util.ArrayList;
import java.util.Scanner;

public class RoyalGameOfUr implements Game {

    boolean player;
    Scanner scanner;
    Player[] players;
    public Dice die;

    public RoyalGameOfUr() {
        player = true;
        scanner = new Scanner(System.in);
        players = new Player[]{new Player(), new Player()};
        die = new Dice();
        createPaths();
    }

    private void createPaths() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                players[i].path.fields[j] = new Field(false);
            }
            players[i].path.fields[3] = new Field(true);
            players[i].path.fields[12] = new Field(false);
            players[i].path.fields[13] = new Field(true);
        }
        for (int i = 4; i < 12; i++) {
            Field field = new Field(i != 7);
            players[0].path.fields[i] = field;
            players[1].path.fields[i] = field;
        }
    }

    @Override
    public void run() {
        while(true) {
            int playing = player ? 0 : 1;
            int steps = die.roll();
            System.out.printf("Player %d rolls: %d%n", playing + 1, steps);
            if (steps != 0) {
                ArrayList<Integer> pieces = new ArrayList<>();
                int piece = -1;
                while (!pieces.contains(piece)) {
                    System.out.println("Choose a piece to move: ");
                    for (int i = 0; i < players[playing].pieces.length; i++) {
                        if (players[playing].pieces[i].isMoveable(steps)) {
                            pieces.add(i + 1);
                            System.out.printf("%d: Piece on position: %d%n", i + 1, players[playing].pieces[i].currentField + 1);
                        }
                    }
                    piece = scanner.nextInt();
                }
            } else {
                System.out.printf("Player %d was very unlucky and skips a turn.%n", playing + 1);
            }
            player = !player;
        }
    }
}
