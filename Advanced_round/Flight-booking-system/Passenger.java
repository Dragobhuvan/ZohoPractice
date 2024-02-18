package Flight_booking_system;


public class Passenger {
    
    static int id = 0;

    int pid;
    int ticketsBooked;
    int totalPrice;
    int fid;

    public Passenger(int ticketsBooked, int price, int fid)
    {
        id = id+1;
        pid = id;
        this.ticketsBooked = ticketsBooked;
        this.totalPrice = price*ticketsBooked; 
        this.fid = fid;
    }

    public void printsummary()
    {
        System.out.println("Your passenger details");
        System.out.println("------");
        System.out.println("Passenger id : " + pid);
        System.out.println("flight id : " + fid);
        System.out.println("Total Price : " + totalPrice);
        System.out.println("------");
    }

}
