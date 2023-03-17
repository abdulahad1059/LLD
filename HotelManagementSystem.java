import java.util.List;

class Hotel {
    String hotelName;
    String hotelId;
    Address address;
    List<Room> roomList;
}

class Address {
    String city;
    String street;
    String state;
    String pincode;
}

class Room {
    int roomId;
    RoomType roomType;
    Key key;
    List<HouseKeepingLog> houseKeepingLogList;
    Double cost;
    RoomStatus status;
}

enum RoomType {
    DELUX, LUXURY, FAMILY;
}

enum RoomStatus {
    AVAILAIBLE, UNAVAILABLE
}

class Key {
    String keyId;
    String barcode;
    Status status;

    void assignRoom(Room room);
}

enum Status {
    ACTIVE, UNACTIVE, BLOCKED
}

class HouseKeepingLog {
    String description;
    HouseKeeper houseKeeper;
    Date date;
}

class Person {
    String name;
    int age;
}

class HouseKeeper extends Person {
    Account account;
    List<Room> roomList;

    void addRoom(Room room);
}

class Account {
    String username;
    String password;
    String email;
    String contactNo;
}

class Guest extends Person {
    Account account;
    Search search;
    Booking booking;

    List<Room> getRoom(RoomType roomType, int count, Date startDate);

    BookingInfo book(RoomType roomType, int count, Date startDate, Payment payment);
}

class Receptionist extends Person {
    Account account;
    Search search;
    Booking booking;

    List<Room> getRoom(RoomType roomType, int count, Date startDate);

    BookingInfo book(RoomType roomType, int count, Date startDate);

    void checkout(Guest guest, BookingInfo bookingInfo);

    void checkin(Guest guest, BookingInfo bookingInfo);
}

class Admin extends Person {
    void addRoom(Room room);

    void editRoom(Room room);

    void removeRoom(int roomId);
}

class Search {
    List<Room> getRoomByRoomType(RoomType roomType, Date date);

    List<Room> getRooms(RoomType roomType, Date date, int count);
}

class Booking {
    BookingInfo book(RoomType roomType, int count, Date startDate, Payment payment);
}

enum Payment {
    UPI, BHIM, INTERNET_BANKING
}

class BookingInfo {
    String username;
    String bookingId;
    String transactionId;
    List<Room> roomList;
    Date startDate;
    int noOfDays;
    RoomCharge roomCharge;
}

abstract class RoomCharge {
    abstract double getCost();
}

class BaseRoomCharge extends RoomCharge {
    double cost;

    public double getCost();

    public void setCost(double cost) {
        this.cost = cost;
    }
}

class ServicedCharge extends RoomCharge {
    double cost;
    RoomCharge roomCharge;

    public double getCost() {
        baseRoomCharge.setCost(cost + baseRoomCharge.getCost());
        return baseRoomCharge.getCost();
    }

}


class Hotel {

    String Name;
    Integer id;
    Location hotelLocation;
    List<Room> roomList;

}

class Location {

    Double longitude;
    Double latitude;
}

class Room {

    String roomNumber;
    RoomStyle roomStyle;
    RoomStatus roomStatus;
    Double bookingPrice;
    List<RoomKey> roomKeys;
    List<HouseKeepingLog> houseKeepingLogs;

}

public enum RoomStyle {

    STANDARD, DELUX, FAMILY_SUITE;
}

public enum RoomStatus {

    AVAILABLE, RESERVED, NOT_AVAILBLE, OCCUPIED, SERVICE_IN_PROGRESS;
}

class RoomKey {

    String keyId;
    String barCode;
    Date issuedAt;
    Boolean isActive;
    Boolean isMaster;

    public void assignRoom(Room room);

}

class HouseKeepingLog {
    String description;
    Date startDate;
    int duration;
    HouseKeeper houskeeper;

    public void addRoom(Room room);
}

abstract class Person {

    String name;
    Account accountDetail;
    String phone;
}

public class Account {

    String username;
    String password;

    AccountStatus accountStatus;

}

public enum AccountStatus {

    ACTIVE, CLOSED, BLOCKED;
}

class HouseKeeper extends Person {

    public List<Room> roomList;

    public List<Room> getRoomsServiced(Date date);
}

class Guest extends Person {

    Search searchObj;
    Booking bookingObj;

    public List<RoomBooking> getAllRoomBookings();

    public RoomBooking createBooking();

    public RoomBooking cancelBooking(int bookingId);
}

class Receptionist extends Person {

    Search searchObj;
    Booking bookingObj;

    public void checkInGuest(Guest guest, RoomBooking bookingInfo);

    public void checkOutGuest(Guest guest, RoomBooking bookingInfo);

}

class admin extends Person {

    public void addRomm(Room roomDetail);

    public Room deleteRoom(String roomId);

    public void editRoom(Room roomDetail);
}

class search {

    public List<Room> searchRoom(RoomStyle roomStyle, Date startDate, int duration);

}

class RoomBooking {

    String bookingId;
    Date startDate;
    Int durationInDays;
    BookingStatus bookingStatus;
    List<Guest> guestList;
    List<Room> roomInfo;
    BaseRoomCharge totalRoomCharges;
}


/**
 * Decorator pattern is used to decorate the prices here.
 **/

interface BaseRoomCharge {

    Double getCost();

}

class RoomCharge implements BaseRoomCharge {


    double cost;

    Double getCost() {
        return cost;
    }

    void setCost(double cost) {
        this.cost = cost;
    }
}

class RoomServiceCharge implements BaseRoomCharge {

    double cost;
    BaseRoomCharge baseRoomCharge;

    Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }
}

class InRoomPurchaseCharges implements BaseRoomCharge {

    double cost;
    BaseRoomCharge baseRoomCharge;

    Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }
}

class Booking {

    public RoomBooking createBooking(Guest guestInfo);

    public RoomBooking cancelBooking(int bookingId);

}