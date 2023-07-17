public class Customer {
    private String name;
    private String email;
    private Integer phoneNo;
    public Customer(String name, String email, Integer phoneNo) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }
    public String getName() {
        return name;
    }
    //other getters and setters
}