public class Booking {
    
    static int id = 0;

    int bid;

    Taxi t;

    Passenger p;

    public Booking(Taxi t, Passenger p)
    {
        id += 1;

        bid = id;

        this.t = t;

        this.p = p;
        
    }
}
