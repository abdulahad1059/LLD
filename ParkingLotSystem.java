long,double,both in java and c++;
        actuator
----------------------------------------------------------Mera hai------------------------------------------------------------
class ParkingLotSystem {
    String parkingLotName;
    String id;
    Address address;
    List<Floor> floorList;
    List<EntryGate> entryGateList;
    List<ExitDateList> exitDateListList;

    boolean allowed(Vehicle vehicle);
}

class Address {
    String streetName;
    String city;
    String stateName;
    String pincode;
}

class Floor {
    String floorId;
    List<Spaces> spacesList;

    boolean allowed(Vehicle vehicle, Date time);

    Dashboard dashboard;
}

class Dashboard {
    Map<SpaceType, Integer> spaceTypeIntegerMap;

    void updateMap(SpaceType spaceType, Integer, boolean flag);
}

class Spaces {
    String spaceId;
    Status status;
    Vehicle vehicle;
    Double costPerHour;
    SpaceType spaceType;
}

enum Status {
    AVAILABLE, UNAVAILABLE
}

class Vehicle {
    String vehicleNo;
    String licenceNo;
    String VehicleType;
    String modelNo;
    String chesisNumber;
}

enum SpaceType {
    TWO_WHEELER, THRE_WHEELER, CAR, TRUCK
}

class Person {
    String name;
    String age;
}

class Guard extends Person {
    //    String id;
    Account account;
}

class Account {
    String username;
    String password;
    Status accountStatus;
}

class Admin extends Guard {
    boolean addParkingSpace(SpaceType spaceType, ParkingLot parkingLot);

    boolean addFloor(Floor floor, ParkingLot parkingLot);

    boolean addDisplayBoard(Floor floor, ParkingDisplayBoard parkingDisplayBoard);
}

enum Status {
    ACTIVE, BLOCKED
}

class Gate {
    String gateId;
    Guard guard;
}

class EntryGate extends Gate {
    Boolean allowed(Vehicle vehicle);

    Ticket processVehicle(Vehicle vehicle);
}

class ExitGate extends Gate {
    PaymentService paymentService;

    TicketInfo logout(Ticket ticket, Date logoutTime, Payment type);
}

class Ticket {
    String ticketId;
    String vehicleNo;
    String licenceNo;
    String VehicleType;
    String modelNo;
    String chesisNumber;
    Date entryTime;
    Date exitTime;
    String spaceId;
    String floorId;
}

class TicketInfo {
    String id;
    Double totalCost;
    Date entryTime;
    Date exitTime;
    Payment payment;
    String spaceId;
    String floorId;
}

class Payment {
    String transactionId;
    Status status;
    PaymentType paymentType;
}

enum Status {
    PENDING, FAILED, SUCCESS
}

enum PaymentType {
    UPI, BHIM, INTERNET_BANKING
}

------------------------------------------------------From Net--------------------------------------------------------------------S
class ParkingLot {

    List<ParkingFloor> parkingFloors;
    List<Entrance> entrances;
    List<Exit> exits;

    Address address;

    String parkingLotName;

    public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle);

    public boolean updateParkingAttndant(ParkingAttendant parkingAttendant, int gateId)

}

class ParkingFloor {

    int levelId;
    List<ParkingSpace> parkingSpaces;

    ParkingDisplayBoard parkingDisplayBoard;

}

class Gate {

    int gateId;
    ParkingAttendant parkingAttendant;

}

class Entrance extends Gate {

    public ParkingTicket getParkingTicket(Vehicle vehicle);

}

class Exit extends Gate {

    public ParkingTicket payForParking(ParkingTicket parkingTicket, PaymentType paymentType);

}


class Address {

    String country;
    String state;
    String city;
    String street;
    String pinCode; //ZipCode
}

class ParkingSpace {

    int spaceId;
    boolean isFree;
    double costPerHour;
    Vehicle vehicle;
    ParkingSpaceType parkingSpaceType;

}

class ParkingDisplayBoard {

    Map<ParkingSpaceType, Integer> freeSpotsAvailableMap;

    public void updateFreeSpotsAvailable(ParkingSpaceType parkingSpaceType, int spaces);

}


class Account {

    String name;
    String email;
    String password;
    String empId;
    Address address;

}

class Admin extends Account {

    public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor floor);

    public boolean addParkingSpace(ParkingFloor floor, ParkingSpace parkingSpace);

    public boolean addParkingDisplayBoard(ParkingFloor floor, ParkingDisplayBoard parkingDisplayBoard);
	.
            .
            .

}

class ParkingAttendant extends Account {

    Payment paymentService;

    public boolean processVehicleEntry(Vehicle vehicle);

    public PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType);

}

class Vehicle {

    String licenseNumber;
    VehicleType vehicleType;
    ParkingTicket parkingTicket;
    PaymentInfo paymentInfo;

}

class ParkingTicket {

    int ticketId;
    int levelId;
    int spaceId;
    Date vehicleEntryDateTime;
    Date vehicleExitDateTime;
    ParkingSpaceType parkingSpaceType;
    double totalCost;
    ParkingTicketStatus parkingTicketStatus;

    public void updateTotalCost();

    public void updateVehicleExitTime(Date vehicleExitDateTime);

}

public enum PaymentType {

    CASH, CEDIT_CARD, DEBIT_CARD, UPI;
}

public enum ParkingSpaceType {

    BIKE_PARKING, CAR_PARKING, TRUCK_PARKING

}

class Payment {

    public PaymentInfo makePayment(ParkingTicket parkingTicket, PaymentType paymentType);
}

public class PaymentInfo {

    double amount;
    Date paymentDate;
    int transactionId;
    ParkingTicket parkingTicket;
    PaymentStatus paymentStatus;

}

public enum VehicleType {

    BIKE, CAR, TRUCK;
}

public enum ParkingTicketStatus {

    PAID, ACTIVE;
}

public enum PaymentStatus {

    UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;

}