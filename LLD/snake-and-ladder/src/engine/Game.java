package engine;

import dice.Dice;
import model.Board;
import model.GameStatus;
import strategy.MoveStrategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private final Board board;
    private final Queue<Board.Player> players;
    private final Dice dice;
    private final MoveStrategy moveStrategy;
    private GameStatus status;

    public Game(Board board, List<Board.Player> players, Dice dice, MoveStrategy moveStrategy) {
        this.board = board;
        this.players = new LinkedList<>(players);
        this.dice = dice;
        this.moveStrategy = moveStrategy;
        this.status = GameStatus.NOT_STARTED;
    }

    public void startGame() {
        status = GameStatus.IN_PROGRESS;
        System.out.println("engine.Game started!");

        while (status == GameStatus.IN_PROGRESS) {
            playTurn();
        }
    }

    private void playTurn() {
        Board.Player player = players.poll();
        int diceValue = dice.roll();
        System.out.println(player.getName() + " rolled: " + diceValue);

        int newPos = moveStrategy.applyMove(player, diceValue, board);
        System.out.println(player.getName() + " moved from " + player.getPosition() + " to " + newPos);

        player.setPosition(newPos);

        if (player.getPosition() == board.getSize()) {
            System.out.println("Winner: " + player.getName());
            status = GameStatus.FINISHED;
            return;
        }

        players.offer(player);
    }
}
