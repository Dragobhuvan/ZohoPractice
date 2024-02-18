package Flight_booking_system;

import java.util.HashMap;

public class Flights {
    
    static int id = 0; //for id creation

    int flightid;
    int price;
    int seatsAvailable ;
    
    public Flights()
    {
       seatsAvailable = 50;
       price = 5000;
       id = id+1;
       flightid = id;
    }

    public void flightSummary()
    {
        System.out.println("Your flight details");
        System.out.println("---------------");
        System.out.println("Flight id: " + flightid);
        System.out.println("Tickets: " + seatsAvailable);
        System.out.println("Price " + price);
        System.out.println("-------------------");
    }
}
