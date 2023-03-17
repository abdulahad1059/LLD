-----------------------------------------------------Mera hai---------------------------------------------------------------

class BMS {
    List<Threator> threatorList;

    Map<Date, List<Movies>> getMovies(String cityName);

    List<Threator> getThreatorList(String cityName);
}

class Threator {
    String name;
    Address address;

    List<Shows> showsList(List<Date> dateList);

    List<Movies> getMovieList(List<Date> dateList);
}

class Address {
    String streetName;
    String pincode;
    String stateName;
}

class Show {
    Date startTime;
    Date endTime;
    Movie movie;
    List<Seat> seatList;
}

class Movie {
    String movieName;
    Jonre jonre;
    Double duration;
    Type type;
}

enum Jonre {
    PATRIOTIC, ROMANTIC, STORY, POLITICAL
}

enum Type {
    BOLLIWOOD, HOLLIWOOD, BHOJPURI
}

class Seat {
    Double Price;
    Status status;
    String seatNumebr;
    SEAT_TYPE seat_type;
}

enum SEAT_TYPE {
    DELUX, LUXURY, CLASSIC
}

enum Status {
    AVAILABLE, UNAVAILABLE
}

class Person {
    String name;
    int age;
}

class User extends Person {
    Account account;
    Search search;
    Booking booking;

    List<Show> getShowList(String cityName, Date date);

    List<Movie> getMOvieList(String cityName, Date date);
}

class Admin extends Person {
    Account account;
    Search search;
    Booking booking;

    void remove(Movie movie);

    void removeThreator(Threator threator);

    List<Show> getShowList(String cityName, Date date);

    List<Movie> getMOvieList(String cityName, Date date);
}

class Account {
    String username;
    String password;
    Status status;
}

enum Status {
    ACTIVE, BLOCKED;
}

class Search {
    List<Shows> getShows(String city);

    List<Threator> getThreator(String city);
}

class Booking {
    BookingInfo makeBooking(Show show, Payment payment, int noOfTickets);
}

enum Payment {
    UPI, CARD, BHIM, INTERNET_BANKING
}

class BookingInfo {
    String bookingId;
    Double totalCost;
    String userName;
    List<Seat> seatList;
    String transactionId;
}




---------------------------------------------------------From Net-------------------------------------------------------------

public class BMSService {

    List<CinemaHall> cinemas;

    public List<Movie> getMovies(Date date, String city);

    public List<CinemaHall> getCinemalHalls(String city);

}

public class CinemaHall {

    int cinemaHallId;
    String cinemaHallName;

    Address address;

    List<Audi> audiList;

    public Map<Date, Movies> getMovies(List<Date> dateList);

    public Map<Date, Show> getShows(List<Date> dateList);

}

public class Address {

    int pinCode; //ZipCode
    String street;
    String city;
    String state;
    String country;

}

public class Audi {

    int audiId;
    String audiName;
    int totalSeats;

    List<Show> shows;

}

public class Show {

    int showId;
    Movie movie;
    Date startTime;
    Date endTime;
    CinemaHall cinemaPlayedAt;
    List<Seat> seats;

}

public class Seat {

    int seatId;
    SeatType seatType;
    SeatStatus seatStatus;
    Double price;

}


public enum SeatType {

    DELUX, VIP, ECONOMY, OTHER;

}

public enum SeatStatus {

    BOOKED, AVAILABLE, RESERVED, NOT_AVAILABLE;

}

public class Movie {

    String movieName;
    int movieId;
    int durationInMins;
    String language;
    Genre genre;
    Date releaseDate;
    Map<String, List<Show>> cityShowMap;

}

public enum Genre {

    SCI_FI, DRAMA, ROM_COM, FANTASY;
}

public class User {

    int userId;
    Search searchObj;

}

public class SystemMember extends User {

    Account account;
    String name;
    String email;
    Address address;

}


public class Member extends SystemMember {

    public Booking makeBooking(Booking booking);

    public List<Booking> getBooking();

}

public class Admin extends SystemMember {

    public boolean addMovie(Movie moivie);

    public boolean addShow(Show show);

}

public class Account {

    String userName;
    String password;

}

public class Search {

    public List<Movie> searchMoviesByNames(String name);

    public List<Movie> searchMoviesByGenre(Genre genre);

    public List<Movie> searchMoviesByLanguage(String language);

    public List<Movie> searchMoviesByDate(Date releaseDate);
}

public class Booking {

    String bookingId;
    Date bookingDate;
    Member member;
    Audi audi;
    Show show;
    BookingStatus bookingStatus;
    double totalAmount;
    List<Seat> seats;
    Payment paymentObj;

    public boolean makePayment(Payment payment);

}

public class Payment {

    double amount;
    Date paymentDate;
    int transactionId;
    PaymentStatus paymentStatus;

}

public enum BookingStatus {

    REQUESTED, PENDING, CONFIRMED, CANCELLED;
}

public enum PaymentStatus {

    UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;

}
