package strategy;

import enums.Symbol;
import models.Board;

public interface WinStrategy {
    boolean checkWinner(Board board, int row, int col, Symbol symbol);
}
