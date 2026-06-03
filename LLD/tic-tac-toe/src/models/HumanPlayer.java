package models;

import enums.Symbol;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name, Symbol symbol) {
        super(name, symbol);
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Row:");
        int row = scanner.nextInt();
        System.out.println("Col:");
        int col = scanner.nextInt();

        return new Move(row, col);
    }
}
