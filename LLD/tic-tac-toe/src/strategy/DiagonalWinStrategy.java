package strategy;

import enums.Symbol;
import models.Board;

public class DiagonalWinStrategy implements WinStrategy {
    @Override
    public boolean checkWinner(Board board, int row, int col, Symbol symbol) {
        boolean diagonal = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCell(i, i).getSymbol() != symbol) {
                diagonal = false;
                break;
            }
        }

        if (diagonal) {
            return true;
        }

        boolean antiDiagonal = true;
        for (int i = 0; i< board.getSize(); i++) {
            if (board.getCell(i, board.getSize() - 1 - i).getSymbol() != symbol) {
                antiDiagonal = false;
                break;
            }
        }

        return antiDiagonal;
    }
}
