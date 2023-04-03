package Synchronization.SyncFunction;

public class TicketCounter {

    private int ticketAvailable = 2;

    synchronized void bookTicket(String user, int count) {
        if (ticketAvailable >= count) {
            System.out.println(count + "  is given to " + user);
            ticketAvailable = ticketAvailable - count;

        } else {
            System.out.println(0 + "  is given to " + user);
        }
    }
}
