import enums.Symbol;
import models.Game;
import models.HumanPlayer;
import models.Player;

public class Main {
    public static void main(String[] args) {
        Player player1 = new HumanPlayer("Alice", Symbol.X);
        Player player2 = new HumanPlayer("Bob", Symbol.O);
        Game game = new Game(3, player1, player2);
        game.startGame();
    }
}
