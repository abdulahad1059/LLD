import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Match {
    List<Ining> ininigsList;
    Location location;
    MatchType matchType;

    Team firstTeam;
    Team secondTeam;
    Team winningTeam;
    Player manOfTheMatch;

    Time startTime;
    Time endTime;

    Date date;
}

class Ining {
    int iningNumber;
    List<PlayerInstance> playerInstances;
    int totalScore;
    List<Over> overs;
    List<Wicket> wickets;
}

enum MatchType {
    TEST_MATCH, ODI, TWENTY_TWENTY;
}

class Location {
    String country;
    String cityName;
    String stadium;
}

class Team {
    String teamName;
    List<PlayerInstance> playerList;
    String countryName;
}

class Player {
    String playerName;
    int totalScore;
    int totalFifty;
    int totalHundred;
    int strikeRate;
    PlayerType type;
}

enum PlayerType {
    BOWLER, BATSMAT, ALLROUNDER, WICKET_KEEPER
}


class PlayerInstance {
    Player player;
    int score;
    List<Over> overs;
    List<Ball> runs;
    List<Wicket> wickets;
}

class Ball {
    BallType ballType;
    PlayerInstance throwBy;
    PlayerInstance playedBy;
    int run;
    Wicket wicket;
    int ballSpeed;
}

class Wicket {
    WicketType wicketType;
    PlayerInstance playerOut;
    PlayerInstance bowler;
    PlayerInstance cath;
    PlayerInstance runOut;
}

enum WicketType {
    BOLD, CATCH, HIT_WIKIT, RUN_OUT;
}

enum BallType {
    NO_BALL, WIDE_BALL, NORMAL_DELIVERY,
}

class Over {

    int overNumber;
    List<Ball> balls;
    PlayerInstance playerInstance;
    int totalRun;
    List<Wicket> wickets;
}