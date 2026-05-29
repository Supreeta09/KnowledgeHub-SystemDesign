package strategy;

import model.Board;

public class DefaultMoveStrategy implements MoveStrategy{
    @Override
    public int applyMove(Board.Player player, int diceValue, Board board) {
        int newPos = player.getPosition() + diceValue;
        if (newPos > board.getSize()) {     // invalid move (must land exactly or stay)
            return player.getPosition();
        }
        return board.getNextPosition(newPos);
    }
}
