import java.util.List;

public class Taxi {
    
    static int id = 0;

    int tid;

    char currentLocation;

    int freeTime;

    int earnings;

    boolean booked;

    List<String> trips;

    public Taxi()
    {
        id = id+1;

        tid = id;

        currentLocation='A';

        freeTime = 6;

        booked = false;
    }
}
