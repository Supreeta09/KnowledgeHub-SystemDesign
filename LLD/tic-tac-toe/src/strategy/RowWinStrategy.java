package strategy;

import enums.Symbol;
import models.Board;

public class RowWinStrategy implements WinStrategy{
    @Override
    public boolean checkWinner(Board board, int row, int col, Symbol symbol) {
        for (int j = 0; j<board.getSize(); j++) {
            if (board.getCell(row, j).getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
}
