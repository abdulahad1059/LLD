import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {
    private char[][] board;
    private int boardSize;
    private Queue<Player> players;
    Scanner input;

    public GameBoard(int boardSize, List<Player> players) {
        this.boardSize = boardSize;
        this.players = new LinkedList<>();
        for (Player p : players) {
            this.players.add(p);
        }
        board = new char[boardSize][2 * boardSize - 1];
        initializeBoard();
        print();
        this.input = new Scanner(System.in);
    }

    void startGame() {
        int count = 0;
        while (players.size() > 0) {
            Player player = players.poll();
            int p = getUserInput();
            p--;
            int x = p / boardSize;
            int y = (p % boardSize) * 2;
            System.out.println(x + "," + y);
            board[x][y] = player.getSymbol();
            if (win(player)) {
                System.out.print(player.getPlayerName() + " has won the match!!!");
                break;
            }
            count++;
            if (count >= boardSize * boardSize) {
                System.out.print("Match Draw");
                break;
            }
            print();
            players.add(player);
        }
    }

    boolean win(Player p) {
        boolean win = true;
        for (int i = 0; i < board.length; i++) {
            win = true;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '|')
                    continue;
                if (board[i][j] != p.getSymbol()) {
                    win = false;
                    break;
                }

            }
            if (win)
                return true;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (i % 2 != 0)
                continue;
            win = true;
            for (int j = 0; j < board.length; j++) {

                if (board[j][i] == '|')
                    continue;
                if (board[j][i] != p.getSymbol()) {
                    win = false;
                    break;
                }

            }
            if (win)
                return true;
        }


        if (win)
            return true;
        win = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j += 2) {
                if (board[i][j] != p.getSymbol()) {
                    win = false;
                    break;
                }
            }
        }
        if (win)
            return true;
        win = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = board.length - 1; j >= 0; j -= 2) {
                if (board[i][j] != p.getSymbol()) {
                    return false;
                }
            }
        }
        return true;
    }

// /    _|_|_
//    _|_|_
//    _|_|_

    int getUserInput() {
        System.out.print("Enter your position");
        int pos = this.input.nextInt();
        while (!valid(pos)) {
            System.out.print("Incorrect Position");
            pos = this.input.nextInt();
        }
        return pos;
    }

    boolean valid(int p) {
        System.out.println(p + "   " + this.board.length);
        if (p > this.boardSize * boardSize || p <= 0) {
            return false;
        }
//        int x = 2 * ((p % board.length == 0) ? (p / board.length) - 1 : p / board.length);
//        int y = 2 * ((p % board[0].length == 0 ? board[0].length : p % board[0].length) - 1);

        p--;
        int x = p / boardSize;
        int y = (p % boardSize) * 2;

        if (board[x][y] != '_') {
            return false;
        }
        return true;
    }

    void initializeBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                if (j % 2 == 0) {
                    this.board[i][j] = '_';
                } else {
                    this.board[i][j] = '|';
                }
            }
        }
    }

    void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
}
