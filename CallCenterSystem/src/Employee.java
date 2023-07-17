public class Employee {
    private String name;
    private boolean free;
    protected CallManager callManager;
    protected int rank;
    public Employee(String name, boolean free, CallManager callManager) {
        this.name = name;
        this.free = free;
        this.callManager = callManager;
    }
    public void receiveCall(Call call) {
        this.free = false;
        System.out.println("Call received by employee "+ this.name + " for customer " + call.getCustomer().getName());
    }
    public void endCall(Call call) {
        System.out.println("Call ended by employee "+ this.name + " for customer " + call.getCustomer().getName());
        this.free = true;
        this.callManager.callEnded();
    }
    public boolean isFree() {
        return free;
    }
    public void setFree(boolean free) {
        this.free = free;
    }
    public int getRank() {
        return rank;
    }
}