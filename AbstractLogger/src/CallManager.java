import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class CallManager {
    private static int levels = 3;
    private ArrayList<Employee>[] employeesList;
    private Queue<Call> callQueue;
    public CallManager(int numberOfFreshers, int numberOfLeads) {
        this.employeesList = new ArrayList[levels];
        this.callQueue = new LinkedList<>();
        ArrayList<Employee> freshersList = new ArrayList<>();
        for (int index = 0; index < numberOfFreshers; index++) {
            freshersList.add(new Fresher("Fresher" + index, true, this));
        }
        this.employeesList[0] = freshersList;
        ArrayList<Employee> leadsList = new ArrayList<>();
        for (int index = 0; index < numberOfLeads; index++) {
            freshersList.add(new Lead("Lead" + index, true, this));
        }
        this.employeesList[1] = leadsList;
        ArrayList<Employee> managersList = new ArrayList<>();
        managersList.add(new Manager("Manager", true, this));
        this.employeesList[2] = managersList;
    }
    public Employee getFreeEmployee(int rank) {
        for (int index = rank-1; index<levels; index++) {
            ArrayList<Employee> employees = this.employeesList[index];
            for (Employee employee: employees) {
                if (employee.isFree()) {
                    return employee;
                }
            }
        }
        return null;
    }
    public void callHandler(Call call) {
        Employee employee = this.getFreeEmployee(call.getRank());
        if (employee != null) {
            call.setRank(employee.getRank());
            employee.receiveCall(call);
        } else {
            callQueue.add(call);
        }
    }
    public void handleCallFromQueue() {
        if (callQueue.size() > 0) {
            Call call = callQueue.peek();
            int callRank = call.getRank();
            Employee employee = getFreeEmployee(callRank);
            if (employee != null) {
                callQueue.remove();
                employee.receiveCall(call);
            }
        }
    }
    public void callEnded() {
        this.handleCallFromQueue();
    }
}