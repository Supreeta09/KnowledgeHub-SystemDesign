package models;

import enums.GameStatus;
import strategy.ColumnWinStrategy;
import strategy.DiagonalWinStrategy;
import strategy.RowWinStrategy;
import strategy.WinStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private Player currPlayer;
    private final List<WinStrategy> winStrategies;
    private GameStatus gameStatus;

    public Game(int size, Player player1, Player player2) {
        this.board = new Board(size);
        this.players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        this.currPlayer = players.peek();
        this.gameStatus = GameStatus.NOT_STARTED;
        this.winStrategies = new ArrayList<>();
        winStrategies.add(new RowWinStrategy());
        winStrategies.add(new ColumnWinStrategy());
        winStrategies.add(new DiagonalWinStrategy());
    }

    public Board getBoard() {
        return board;
    }

    public void startGame() {
        gameStatus = GameStatus.IN_PROGRESS;
        System.out.println("Game started!");

        while (gameStatus == GameStatus.IN_PROGRESS) {
            board.printBoard();
            makeMove();
        }
    }

    private void makeMove() {
        currPlayer = players.peek();
        System.out.println("Player " + currPlayer.getName() + " is making the move");
        Move move = currPlayer.makeMove(board);

        boolean canBePlaced = board.placeMove(move.getRow(), move.getCol(), currPlayer.getSymbol());

        if (!canBePlaced) {
            System.out.println("Invalid move. Please try again");
            return;
        }

        if (checkWinner(move)) {
            gameStatus = GameStatus.WINNER;
            System.out.println("The player " + currPlayer.getName() + " wins");
            return;
        }

        if (board.isFull()) {
            gameStatus = GameStatus.DRAW;
            System.out.println("Game draw");
            return;
        }

        players.poll();
        players.offer(currPlayer);
    }

    private boolean checkWinner(Move move) {
        for (WinStrategy winStrategy : winStrategies) {
            if (winStrategy.checkWinner(board, move.getRow(), move.getCol(), currPlayer.getSymbol())) {
                return true;
            }
        }
        return false;
    }
}
