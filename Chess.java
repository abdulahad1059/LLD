
class Chess {
    ChessBoard chessBoard;
    List<Player> playerList;
    List<Move> moveHistory;
    Player currentPlayer;
    GameStatus status;

    void endGame();

    void changeTurn();

    bool playerMove(Position start, Position end, Piece piece);
}

class Position {
    int i;
    //must be int j
    char ch;
}

class Player {
    Color color;
    Account account;
}

enum Color {
    WHITE, BLACK
}

class Account {
    String firstname;
    String lastname;
    String username;
    String password;
    String email;
    String contact;
    AccountStatus accountStatus;
}

enum AccountStatus {
    ACTIVE, BLOCKED
}

enum GameStatus {
    ACTIVE, PAUSED, WHITE_WIN, BLACK_WIN;
}

class ChessBoard {
    List<List<Cell>> board;

    boolean resetBoard();

    boolean updateBoard(Move move);
}

class Cell {
    Position position;
    Color color;
    Piece piece;
}

class Move {
    Position startPosition;
    Piece piece;
    Piece killedPiece;
    Position endPostion;
    Player player;
}

abstract class Piece {
    Color color;

    //this function may not be required
    abstract boolean move(Position startPosition, Position endPosition);

    abstract List<Position> getAllPosition(Position start);

    abstract boolean validateMove(Position startPosition, Position endPosition);
}

//abstract class Piece {
//    Color color;
//
//    abstract boolean move(Position startPosition, Position endPosition);
//
//    abstract List<Position> getAllPosition(Position start);
//
//    abstract boolean validateMove(Position startPosition, Position endPosition);
//}

class King extends Piece {

    boolean move(Position startPosition, Position endPosition);

    List<Position> getAllPosition(Position start);

    boolean validateMove(Position startPosition, Position endPosition);
}

class Queen extends Piece {

    boolean move(Position startPosition, Position endPosition);

    List<Position> getAllPosition(Position start);

    boolean validateMove(Position startPosition, Position endPosition);
}

class Knight extends Piece {

    boolean move(Position startPosition, Position endPosition);

    List<Position> getAllPosition(Position start);

    boolean validateMove(Position startPosition, Position endPosition);
}

class Pawn extends Piece {

    boolean move(Position startPosition, Position endPosition);

    List<Position> getAllPosition(Position start);

    boolean validateMove(Position startPosition, Position endPosition);
}

class Rook extends Piece {

    boolean move(Position startPosition, Position endPosition);

    List<Position> getAllPosition(Position start);

    boolean validateMove(Position startPosition, Position endPosition);
}

class Bishop extends Piece {

    boolean move(Position startPosition, Position endPosition);

    List<Position> getAllPosition(Position start);

    boolean validateMove(Position startPosition, Position endPosition);
}