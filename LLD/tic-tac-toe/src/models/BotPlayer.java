package models;

import enums.Symbol;

public class BotPlayer extends Player {

    public BotPlayer(String name, Symbol symbol) {
        super(name, symbol);
    }

    @Override
    public Move makeMove(Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j< board.getSize(); j++) {
                if (board.getCell(i, j).isEmpty()) {
                    return new Move(i, j);
                }
            }
        }

        throw new RuntimeException("No valid move available");
    }
}
