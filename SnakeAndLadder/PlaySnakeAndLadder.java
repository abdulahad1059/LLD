import java.util.*;

public class PlaySnakeAndLadder {
    public static void main(String arg[])
    {
        Dice d=new Dice(1);
        Player p1=new Player(1,"Alberts");
        Player p2=new Player(2,"Pintose");
        List<Jumper> snakes= Arrays.asList(new Jumper(10,2),new Jumper(99,12));
        List<Jumper> ladders= Arrays.asList(new Jumper(5,25),new Jumper(40,89));
        Map<String,Integer> m=new HashMap();
        m.put("Alberts",0);
        m.put("Pintose",0);
        Queue<Player> q=new LinkedList<>();
        q.add(p1);
        q.add(p2);
        GameBoard g=new GameBoard(d,q,snakes,ladders,m,100);
        g.startGame();
    }

}
