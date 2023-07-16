public class Manager extends Employee {
    public Manager(String name, boolean free, CallManager callManager) {
        super(name, free, callManager);
        this.rank = 3;
    }
}