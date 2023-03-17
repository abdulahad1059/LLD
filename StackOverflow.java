class User {
    String id;
    Search search;

    List<Question> getQuestion(String description);
}

class Member extends User {
    List<Badge> badgeList;
    List<Question> questionList;
    List<Answer> answerList;
    Account account;


    boolean addQuestion(Question question);

    boolean addAnswer(Question question, Answer answer);

    boolean flag(Entity entity);

    boolean vote(Entity entity, VoteType voteType);

    boolean addComment(Entity entity, Comment comment);

    boolean addTag(Question question, Tag tag);

}

enum VoteType {
    UPVOTE, DOWNVOTE, DELETEVOTE
}

class Badge {
    String badgeName;
    BadgeType badgeType;
}

enum BadgeType {
    FIVESTAR, FOURSTAR, FIVESTAR
}

class Account {
    String username;
    String password;
    String dob;
    String contactNo;
    Status status;
}

enum Status {
    ACTIVE, BLOCKED;
}

class Moderator extends Member {
    void closeQuestion(Question question);

    void restoreQuestion(Question question);
}

class Admin extends Member {
    void blockMember(Member member);

    void unblockMember(Member member);
}

class Entity {
    String id;
    Member member;
    Date date;
    Map<VoteType,Integer> voteTypeIntegerMap;
    List<Comment> commentList;
}

class Comment extends Entity {
    String desciption;

    void addComment(Comment comment);
}

class Answer extends Entity {
    String description;
    Question question;
    Boolean isAccepted;
}

class Question extends Entity {
    List<Tag> tagList;
    List<Edit> editList;
    String title;
    String description;
    List<Answer> answerList;
    List<Comment> commentList;
    QuestionStatus questionStatus;
}
class Edit{
    Member member;
    Question previousState;
    Question currentState;
    Date date;
}
enum QuestionStatus {
    ACTIVE, CLOSED, FLAGGED, ANSWERED
}



class User {
    int userId;
    Search search;

    List<Question> getQuestion(String description);
};

class Member extends User {
    Account account;
    List<Badge> badgesList;
    List<Question> questionsAnswered;

    boolean addQuestion(Question question);

    boolean addAnswer(Question question, Answer answer);

    boolean flag(Entity entity);

    boolean vote(Entity entity, VoteType voteType);

    boolean addComment(Entity entity, Comment comment);

    boolean addTag(Question question, Tag tag);

    List<Badges> getBadgesList();
};

class Account {
    String id;
    String username;
    String password;
    String email;
    String contactNumber;
    AccountStatus accountStatus;
    int reputation;
}

class Badge {
    String name;
    String description;
}

enum AccountStatus {
    ACTIVE, CLOSED, BLOCKED;
}

class Moderator extends Member {
    boolean closeQuestion(Question question);

    boolean restoreQuestion(Question question);
};

class Admin extends Member {
    boolean blockMember(Member member);

    boolean unblockMember(Member member);
};

class Entity {
    String id;
    List<Comment> commentList;
    Member member;
    Date date;
    Map<VoteType, Integer> map;

    boolean flagEntity(Member member);

    boolean voteEntity(VoteType voteType);

    boolean addComment(Member member, Comment comment);
}

enum VoteType {
    UPVOTE, CLOSEVOTE, DELETEVOTE, DOWNVOTE;
}

class Comment extends Entity {
    String description;

    addComment(Entity entity);
}

class Answer {
    String description;
    boolean isAccepted;

    addAnswer(Question question);
}

class Question {
    List<Tag> tagList;
    List<Answer> answerList;
    List<Edit> editHistory;
    String title;
    String description;

    boolean addAnswer(Member member, Answer answer);

    boolean addTag(Tag tag);

    boolean updateEditHostory(Edit edit);

    Status staus;
}

enum Status {
    ACTIVE, CLOSED, ANSWERED, FLAGGED;
}

class Tag {
    String tagName;
    String description;
}

class Edit {
    String id;
    Member member;
    Question prev;
    Question cur;
    Date date;
}

class Search {
    List<Question> gteQuesitonByTag(Tag tag);

    List<Question> getQuesionByDescription(String description);
}