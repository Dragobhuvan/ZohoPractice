

import java.util.ArrayList;
import java.util.List;

public class Taxi
{
    static int tcount = 0;

    int id;
    boolean booked;
    char currentLocation;
    int freeTime;
    int earnings;
    
    List<String> bookingList;
    
    public Taxi()
    {
        tcount = tcount+1;
        id = tcount;
        booked = false;
        currentLocation = 'A';
        freeTime = 6;
        earnings = 0;
        bookingList = new ArrayList<>();
    }

    public void setDetails(boolean booked, char nextLocation, int nextFreetime, int earnings, String tripdetails)
    {
        this.booked = booked;
        this.earnings = this.earnings + earnings;
        this.currentLocation = nextLocation;
        this.freeTime = nextFreetime;
        this.bookingList.add(tripdetails);
    }

    public void printTaxiDetails_V1()
    {
        System.out.println("Taxi id: " +this.id+ "  " + "CurrentLocation:" + this.currentLocation + "TotalEarning: " + this.earnings+ "NextFreetime: "+ this.freeTime);
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("TaxiID    BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
        for(String s: bookingList)
        {
            System.out.println(id+ "    " + s);
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void printTaxiDetails()
    {
        System.out.println("Taxi id: " +this.id+ "  " + " CurrentLocation:" + this.currentLocation + " TotalEarning: " + this.earnings+ " NextFreetime: "+ this.freeTime);
        System.out.println("--------------------------------------------------");

    }
}