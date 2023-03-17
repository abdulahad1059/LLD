public class Player {
    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public Player(String playerName, int playerId, String address, char symbol) {
        this.playerName = playerName;
        this.playerId = playerId;
        this.address = address;
        this.symbol = symbol;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    private int playerId;
    private String address;
    private char symbol;
}
