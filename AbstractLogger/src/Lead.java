public class Lead extends Employee {
    public Lead(String name, boolean free, CallManager callManager) {
        super(name, free, callManager);
        this.rank = 2;
    }
    public void escalateCall(Call call) {
        this.setFree(true);
        call.setRank(call.getRank()+1);
        this.callManager.callHandler(call);
    }
}