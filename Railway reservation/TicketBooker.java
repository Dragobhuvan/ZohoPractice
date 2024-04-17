import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TicketBooker 
{
    static int pnrGen = 23451;

    int PNR;

    static int totalLowerBerthSeats;
    static int totalMiddleBerthSeats;
    static int totalUpperBerthSeats;
    static int totalRACSeats;
    static int totalWL;

    HashMap<Integer, Passenger> Bookingmap = new HashMap();

    static Queue<Integer> RACq = new LinkedList<>();
    static Queue<Integer> WLq = new LinkedList<>();
    

    public TicketBooker(int totalLowerBerthSeats, int totalMiddleBerthSeats, int totalUpperBerthSeats, int totalRACSeats, int totalWL)
    {
        this.totalLowerBerthSeats = totalLowerBerthSeats;
        this.totalMiddleBerthSeats = totalMiddleBerthSeats;
        this.totalRACSeats = totalRACSeats;
        this.totalWL = totalWL;
        this.totalUpperBerthSeats = totalUpperBerthSeats;
    }

    public void allotTicket(Passenger p)
    {
        
    } 
}
