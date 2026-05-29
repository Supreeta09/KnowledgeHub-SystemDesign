import dice.Dice;
import dice.StandardDice;
import engine.Game;
import model.Board;
import model.BoardEntity;
import model.Ladder;
import model.Snake;
import strategy.DefaultMoveStrategy;
import strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BoardEntity> entities = Arrays.asList(
                new Snake(99, 10),
                new Snake(76, 55),
                new Ladder(5, 25),
                new Ladder(40, 80)
        );
        Board board = new Board(100, entities);
        List<Board.Player> players = Arrays.asList(
                new Board.Player("Alice"),
                new Board.Player("Bob")
        );
        Dice dice = new StandardDice();
        MoveStrategy moveStrategy = new DefaultMoveStrategy();
        Game game = new Game(board, players, dice, moveStrategy);
        game.startGame();
    }
}
