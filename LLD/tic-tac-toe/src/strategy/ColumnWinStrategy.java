package strategy;

import enums.Symbol;
import models.Board;

public class ColumnWinStrategy implements WinStrategy {
    @Override
    public boolean checkWinner(Board board, int row, int col, Symbol symbol) {
        for (int i = 0; i< board.getSize(); i++ ) {
            if (board.getCell(i, col).getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
}
