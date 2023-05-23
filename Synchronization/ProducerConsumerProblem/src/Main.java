import java.util.Date;
import java.util.HashMap;
import java.util.List;

class User{
    Search search;
    String name;
}
class Member extends User{
    Account account;
    List<Question> questions;
    List<Answer> answers;

    List<Comment>comments;

    List<Badge> badges;

    void vote(Component component,VoteType voteType){};
    void addQuestion(Question question){}
    void addAnswer(Answer answer,Question question){};
    void addComment(Component component,Comment comment){}
}
enum Badge{
    FIVE_STAR,THREE_STAR,FOUR_STAR,LEGEND,EXPERT
}
class Admin extends Member{
    void addMember(Member member){};
    void removeMember(Member member){};
    void closeQuestion(Question question){}
}
class Component{
    User user;
    Date date;
    HashMap<VoteType,Integer> map;
}
enum VoteType{
    UPVOTE,DOWN_VOTE,FLAG
}
class Comment extends Component{
    String description;
    Component component;
}
class Answer extends Component{
    Question question;
    Boolean isAccepted;

    String description;
}
class Question extends Component{
    List<Answer> answers;
    String description;
    Boolean isClosed;

    List<Tag> tagList;
    List<Edit> editHistory;
}
class Edit{
    Date editedOn;
    Question prev;
    Question current;

    User user;
}
enum Tag{
    IT,COMPUTER,ECE,FASHION,BOOK,MOVIE;
}
class Account{
    String username;
    String password;
    String email;
    int contactNo;
}
class Search{
    List<Question> getQuestionByName(String questionName){return null;}
    List<Question> getQuestionByTitle(String title){return null;}
    List<Question> getQuestionByMemberName(String memberName){return null;}
}

public class Main {
    public static void main(String[] args) {


    }
}

