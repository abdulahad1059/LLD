package Synchronization.SyncFunction;

public class MainClass {

    public static void main(String args[]) {
        TicketCounter ticketCounter = new TicketCounter();
        TicketThread t1 = new TicketThread("Ahad", 2, ticketCounter);
        TicketThread t2 = new TicketThread("Samad", 2, ticketCounter);
        t1.start();
        t2.start();
    }
}
