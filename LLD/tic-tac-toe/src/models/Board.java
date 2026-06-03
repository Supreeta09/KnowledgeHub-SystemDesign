package models;

import enums.Symbol;

public class Board {
    private Cell[][] cells;
    private int size;
    private int moveCount;

    public Board(int size) {
        this.size = size;
        this.moveCount = 0;

        cells = new Cell[size][size];
        for (int i = 0; i<size; i++) {
            for (int j = 0; j< size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public boolean placeMove(int row, int col, Symbol symbol) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false;
        }

        if (!cells[row][col].isEmpty()) {
            return false;
        }

        cells[row][col].setSymbol(symbol);
        moveCount++;
        return true;
    }

    public boolean isFull() {
        return moveCount == size * size;
    }

    public void printBoard() {
        for (int i = 0; i<size; i++) {
            for (int j = 0; j< size; j++) {
                System.out.print(cells[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
