import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoard {

    private Dice dice;
    private Queue<Player> players;

    public Dice getDice() {
        return dice;
    }

    public GameBoard(Dice dice, Queue<Player> players, List<Jumper> snakes, List<Jumper> ladders, Map<String, Integer> playerPosition, int boardSize) {
        this.dice = dice;
        this.players = players;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerPosition = playerPosition;
        this.boardSize = boardSize;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }

    public List<Jumper> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Jumper> snakes) {
        this.snakes = snakes;
    }

    public List<Jumper> getLadders() {
        return ladders;
    }

    public void setLadders(List<Jumper> ladders) {
        this.ladders = ladders;
    }

    public Map<String, Integer> getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Map<String, Integer> playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<String, Integer> playerPosition;
    private int boardSize;

    public void startGame() {
        while (this.players.size() > 1) {
            System.out.println(players.size() + "   ");
            Player p = players.poll();
            int d = dice.rollDice();
            int cp = playerPosition.get(p.getPlayerName());
            int np = cp + d;
            if (np > boardSize) {

                playerPosition.replace(p.getPlayerName(), cp);
                players.add(p);
                continue;
            }
            if (np == boardSize) {
                System.out.println(p.getPlayerName() + " won the match");
                continue;
            }
            boolean snake = false;
            boolean ladder = true;

            for (Jumper j : ladders) {
                if (j.getStartPosition() == np) {
                    System.out.println(p.getPlayerName() + " beaten by the snakes");
                    np = j.getEndPosition();
                    ladder = true;
                }
            }
            for (Jumper j : snakes) {
                if (j.getStartPosition() == np) {
                    System.out.println(p.getPlayerName() + " got the ladder");
                    np = j.getEndPosition();
                    snake = true;
                }
            }
            if (np == boardSize) {
                System.out.println(p.getPlayerName() + " won the match");
            } else {
                System.out.println(p.getPlayerName() + " is at position" + np);
                playerPosition.replace(p.getPlayerName(), np);
                players.add(p);
            }


        }
    }
}
