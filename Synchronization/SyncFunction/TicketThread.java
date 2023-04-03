package Synchronization.SyncFunction;

public class TicketThread extends Thread {
    private String username;
    private int count;
    private TicketCounter ticketCounter;

    public TicketThread(String username, int count, TicketCounter ticketCounter) {
        this.username = username;
        this.count = count;
        this.ticketCounter = ticketCounter;
    }

    public void run() {
        this.ticketCounter.bookTicket(this.username, this.count);
    }
}
