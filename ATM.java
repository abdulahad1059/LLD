class ATM {
    String atmId;
    Address address;
    Screen screen;
    Keypad keypad;
    CardReader cardReader;
    BankService bankService;
    Deposit deposit;
    CashDespensor cashDespensor;
    Bank bank;
    Withdaw withdaw;
    Deposite deposite;
}

class Bank {
    String bankId;
    List<ATM> atmList;
    Address address;
}

class CashDespensor {
    Map<CashType, Integer> cashTypeIntegerMap;

    List<Cash> getCash(Integer amount);
}

class Cash {
    String serialNo;
    CashType cashType;
}

enum CashType {
    TEN, TWENTY, FIFTY, HUNDRED, FIVE_HUNDRED
}

class Address {
    String streetId;
    String city;
    String state;
    String pincode;
}

class Screen {
    void display(String input);
}

class Keypad {
    String getValue();
}

class CardReader {
    CardInfo getCardInfo();
}

class CardInfo {
    String searialNo;
    String cvv;
    CardType cardType;
    Date exipityDate;
    Bank bank;
}

enum CardType {
    DEBIT_CARD, CREDIT_CARD, VISA
}


class CustomerDetail {
    String firstname;
    String lastname;
    Account account;
    String adharCardNo;
    Int age;
    Integer accountNo;
    Double balance;
}

class Transaction {
    Integer accountNo;
    Date date;
    Double amount;
    CustomerDetail customerDetail;
}

class Transfer extends Transaction {
    Integer targetAccountNo;
}

class Withdrawal extends Transaction {
    List<Cash> withdraw(CustomerDetail customerDetail, Double amount);
}

enum Status {
    SUCESS, FAILURE, PENDING
}

class Deposite extends Transaction {
    Date date;
}

class CashDeposite extends Deposit {
    void cashDeposite(CustomerDetail customerDetail, List<Cash> cashList);
}

class CheckDeposite extends Deposit {
    void checkDeposite(CustomerDetail customerDetail, Check check);
}

class TransactionDetail {
    Integer accountNo1;
    Integer accountNo2;
    Double amount;
    Status status;
    Date transactionDate;
    TransactionType transactionType;
}

enum TransactionType {
    WITHDRAWAL, CASHDEPOSITE, CHECKDEPOSITE, TRANSFER
}

class Check {
    String checkId;
    Date date;
    Double amount;
    String benificiaryName;
}


interface BankService {
    Boolean validate(CardInfo cardInfo, String pincode);

    TransactionDetail executeTransaction(Transaction transaction, CardInfo cardInfo);

    CustomerDetail getCustomerDetail(CardInfo cardInfo);
}

class A implements BankService {
    Boolean validate(CardInfo cardInfo, String pincode);

    TransactionDetail executeTransaction(Transaction transaction, CardInfo cardInfo);

    CustomerDetail getCustomerDetail(CardInfo cardInfo);
}

class B implements BankService {
    Boolean validate(CardInfo cardInfo, String pincode);

    TransactionDetail executeTransaction(Transaction transaction, CustomerDetail customerDetail);

    CustomerDetail getCustomerDetail(CardInfo cardInfo);
}


class BankServiceFactory {
    BankService getBankService(CardInfo cardInfo);
}


//----------------------------------------------------------------------------------------------------------------------------------------
class ATM {
    int atmId;
    Address address;
    BankService bankService;
    Screen screen;
    CardReader cardReader;
    Keypad keypad;
    CashDespensor cashDespensor;
    CashDeposit cashDeposit;
    CheckDeposite checkDeposite;
}

class Address {
    String pin;
    String street;
    String city;
}

class Screen {
    void display(String str);
}

class Keypad {
    string getInput();
}

class CashDespensor {
    Map<CashType, List<Cash>> map;

    List<Cash> despense(int amount);
}

class CardReader {
    CardInfo readCard();
}

class CardInfo {
    String cvv;
    Date validity;
    Bank bank;
    String CardNumber;
    CardType cardType;
}

enum CardType {
    CREDIT_CARD, DEBIT_CARD, VISA;
}

enum CashType {
    FIFTY, HUNDRED, FIVEHUNDRED
}

class Cash {
    String serialNumber;
    CashType cashType;
}

class Bank {
    String bankname;
    List<ATM> list;
    Address address;
}

interface BankService {
    Boolean validate(String pin, CardInfo);

    Customer getCustomerInformation(CardInfo cardInfo);

    TransactionDetail executeTransaction(Transaction transaction, Customer customer);
}

class BankA implements BankService {
    Boolean validate(String pin, CardInfo);

    Customer getCustomerInformation(CardInfo cardInfo);

    TransactionDetail executeTransaction(Transaction transaction, Customer customer);
}

class BankB implements BankService {
    Boolean validate(String pin, CardInfo);

    Customer getCustomerInformation(CardInfo cardInfo);

    TransactionDetail executeTransaction(Transaction transaction, Customer customer);

}

class BankServiceFactory {

    //It will return BankA / BankB object so that for transacting we can use that.
    public BankService getBankServiceObject(CardInfo cardInfo);

}

class Transaction {
    Date date;
    Integer accountNumber;
    Customer customer;
}

class Deposit extends Transaction {
    float amount;
}

class CheckDeposite extends Deposit {
    Check deposite();
}

class CashDeposite extends Deposit {
    List<Cash> cashDeposite();
}

class Withdaw extends Transaction {
    float amount;
}

class Transfer extends Transaction {
    Integer targetAccount;
    float amount;
}

class Customer {
    Account account;
}

class Account {
    String firstname;
    String lastname;
    Integer accountNumber;
    Bank bank;
    float balance;
    Status status;
}

enum Status {
    ACTIVE, BLOCKED
}

class TransactionDetail {
    Integer TransactionId;
    Integer SourceAccount;
    Integer TargetAccount;
    float amount;
    Date date;
    Customer customer;
    TransactionType type;
    Status status;
}

enum Status {
    COMPLETED, PENDING, CANCELLED
}

enum TransactionType {
    CHECK_DEPOSITE, CASH_DEPOSITE, WITHDRAW, TRANSFER;
}