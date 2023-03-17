import java.util.Arrays;
import java.util.List;

public class PlayGame {
    public static void main(String args[])
    {
        Player p1=new Player("Ahad",1,"Alld",'X');
        Player p2=new Player("Samad",2,"Alld",'O');
        List<Player> playerList= Arrays.asList(p1,p2);
        GameBoard board=new GameBoard(3,playerList);
        board.startGame();

    }
}
