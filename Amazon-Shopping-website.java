cass Customer {
    String customerId;
    ShoppingCart shoppingCart;
    Search search;

    void addItemInCart(Item item);

    void editItemInCart(Item item);

    void deleteItemInCart(Item item);

    Account createAccount();

}

class Search {
    List<Product> getProductByName(String productName);

    List<Product> getProductByType(ProductType productType);
}

class PaymentType {
    BHIM,UPI,NET_BANKING,CREDIT_CARD,DEBIT_CARD,COD
}

class User extends Customer {
    Account account;
}

class Account {
    String username;
    String password;
    String contactNo;
    String emailId;
    Status status;
}

enum Status {
    ACTIVE, BLOCKED
}

class Seller extends User {
    void addProduct(Product product);
}

class Buyer extends User {
    Order order;

    Order placeOrder(ShoppingCart shoppingCart, PaymentType paymentType);

    add review(String description);
}

class ShoppingCart {
    String shoppingCartId;
    List<Item> itemList;

    void addItem(Item item);

    void removeItem(Item item);

    void editItem(Item item);

    void checkout();

    User user;
}

class Item {
    Product product;
    Integer no;
}

class Product {
    String productId;
    ProductType productType;
    List<ProductReview> productReviewList;
    Seller seller;
    Double cost;
}

class ProductReview {
    Buyer buyer;
    String description;
}

enum ProductType {
    BABY, BOOK, FOOD, MAKEUP, DRESS
}

class Order {
    String orderId;
    List<Item> itemList;
    NotificationService notificationService;
    User user;
    Date orderDate;
    List<OrderLog> orderLogList;
    Double orderCost;

    Status getStatus(orderId);

    Status trackOrder(orderId);

}

class OrderLog {
    String orderId;
    Date date;
    OrderStatus status;
}

enum OrderStatus {
    PLACED, TRANSIT, OUT_FOR_DELIVERY, DELIVERED, DELAYED
}

class NotificationService {
    boolean sendNotification(NotificationDomain notificationDomain) {
        NotificationObject notificationObject;
        MessageAttribute messageAttribute;
        switch (notificationDomain.notificationType) {
            Case MESSAGE:notificationObject = new MessageNotification();
            messageAttribute = new MessageAttribute(notificationDomain.user.account.contactNo, "8840553897", "order-placed");
            break;
            Case EMAIL:notificationObject = new EmailNotification();
            messageAttribute = new MessageAttribute(notificationDomain.user.account.emailId, "amazon.com", "order-placed");

        }
    }
}

class NotificationDomain {
    NotificationType notificationType;
    User user;
}

enum NotificationType {
    EMAIL, PHONE, MESSAGE
}

interface NotificationObject {
    void notify(MessageAttribute messageAttribute);
}

class MessageNotification implements NotificationObject {

    void notify(MessageAttribute messageAttribute);
}

class EmailNotification implements MessageNotification {
    void notify(MessageAttribute messageAttribute);
}

class MessageAttribute {
    String from;
    String to;
    String description;
}

----------------------------------------------------------------------------------------------------------------------------------------

class Customer {
    ShoppingCart cart;
    Search search;
    String customerId;

    ShoppingCart getShoopingCart(String customerId);

    void addItemInCart(Item item);

    void editItemInCart(Item item);

    void deleteItemInCart(Item item);
}

class User extends Customer {
    Account account;
}

class GuestUser extends Customer {
    public Account createAccount();
}

class Seller extends User {
    void AddItem(Product product);
}

class Buyer extends User {
    Order object;

    void addReview();

    Status placeOrder(ShoppingCart shoppingCart);
}

class Account {
    String userName;
    String password;
    String firstName;
    String lastName;
    String email;
    Status status;
    String contactNumber;
}

enum Status {
    ACTIVE, BLOCKED
}

class ShoppingCart {
    String ShoppingCartId;
    List<Item> itemList;
    Double costValue;

    public void addItem(Item item);

    public void updateItem(Item item);

    public void deleteItem(Item item);

    public void checkoutItems();

    public List<Item> getItems();

    public double getCartValue();

}

class Search {
    List<Product> getProductByName(String productName);

    List<Product> getProductByType(ProductType productType);
}

class Order {
    String orderId;
    List<Item> itemList;
    Date orderDate;
    Double orderValue;
    Status status;
    NotificationService notificationService;

    //can we place it anywhere else maybe in buyer
    PaymentStatus makePayment(PaymentType paymentType);

    Status getStatus(orderId);

    Status trackOrder(orderId);

    List<OrderLog> orderLogList;
}

class OrderLog {
    String orderId;
    Status status;
    Date createdAt;
}

class Item {
    Product product;
    Integer Qnty;
}

class Product {
    String productId;
    ProductType productType;
    Seller seller;
    Double cost;
    String description;
    List<ProductReview> productReviews;
}

class ProductReview {
    Buyer buyer;
    String description;
}

enum ProductType {
    BABY, ADULT, FOOD, GROCERRY, SPORTS;
}

enum PaymentSStatus {
    SUCCESS, FAILURE, PENDING
}

enum PaymentType {
    CARD_PAYMENT, UPI, INTERNET_BANKKING
}

class NotificationDomain {
    String NotificationId;
    User user;
    NotificationType type;
}

enum NotificationType {
    MESSAGE, EMAIL, PHONE;
}

class NotificationService {
    bool sendNotification(NotificationDomain notificationDomain) {
        switch (notificationDomain.type) {
            NotificationObject notificationObject;
            MessageAttribute object;
            CASE MESSAGE:notificationObject = new MessageNotification();
            objec = new MessageAttribute(notificationDomain.user.account.contactNumber, "8803084844", "OrderPlaced");
            break;
            CASE EMAIL:notificationObject = new EmailNotification();
            objec = new MessageAttribute(notificationDomain.user.account.email, "amazon.com", "OrderPlaced");
            break;
        }
    }
}

class MessageAttribute {
    String to;
    String from;
    String description;
}

interface NotificationObject {
    boolean sendNotification(MessageAttribute message);
}

class MessageNotification implements NotificationObject {
    boolean sendNotification(MessageAttribute message);
}

class EmailNotification implements NotificationObject {
    boolean sendNotifation(MessageAttribute message);
}

