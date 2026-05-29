package strategy;

import model.Board;

public interface MoveStrategy {
    int applyMove(Board.Player player, int diceValue, Board board);
}
