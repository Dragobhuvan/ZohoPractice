import java.util.HashMap;
import java.util.*;

public class CabApp
{
    static HashMap<Integer, Taxi> taxiList = new HashMap<>();
    static HashMap<Integer, Passenger> PassengerList = new HashMap<>();
    static HashMap<Integer, Booking> bookingList = new HashMap<>();


    public static void bookTaxi(Passenger p)
    {
        Taxi freeT = getFreetaxi(p.pickupLoc, p.pickupTime);

        System.out.println("Taxi available");

        freeT.booked = true;
        
        freeT.earnings = freeT.earnings + calcEarnings(p.pickupLoc, p.dropLoc);

        freeT.freeTime = freeT.freeTime -  (int)(p.pickupLoc - p.dropLoc);

        freeT.currentLocation = p.dropLoc;

        Booking b = new Booking(freeT, p);

        bookingList.put(b.bid, b);

        System.out.println("Taxi booked sucessfully");
        System.out.println("Booking id : " + b.bid);
        System.out.println("Taxi id: " + b.t.tid);
    }

    //to calc teh earnings
    public static int calcEarnings(char pickupLoc, char dropLoc)
    {
        int distance = Math.abs((int)(pickupLoc-dropLoc) * 15);
        int earnings = (distance - 5) * 10 + 100;
        return earnings;
    }

    //to get available free taxi
    public static Taxi getFreetaxi(char pickupLoc, int pickupTime)
    {
        
        for(int i : taxiList.keySet())
        {
            if(taxiList.get(i).booked == false && taxiList.get(i).currentLocation == pickupLoc && taxiList.get(i).freeTime<=pickupTime)
            {
                Taxi freeT = taxiList.get(i);
                return freeT;
            }else if(taxiList.get(i).currentLocation != pickupLoc && taxiList.get(i).booked == false )
            {
                
            }
            else{
                System.out.println("No taxi available");
                System.exit(0);
            }
        }

        return null;
    }

    public static void showCabDetails()
    {
        for(int i : taxiList.keySet())
        {

            System.out.println("Cab id: " + taxiList.get(i).tid);
            System.out.println("FreeTime: " + taxiList.get(i).freeTime);
            System.out.println("Current location: " + taxiList.get(i).currentLocation);
            System.out.println("Earnings: " + taxiList.get(i).earnings);
            System.out.println("---------------");
        }
    }

    public static void intilialiseCabs(int count)
    {
        for(int i = 0; i<count; i++)
        {
            Taxi t = new Taxi();
            taxiList.put(t.tid, t);
        }
    }
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to cab booking app");
        System.out.println("---------------");

        intilialiseCabs(3);//To create taxi's

        boolean loop = true;

        while(loop)
        {
            System.out.printf(" 1.Book \n 2.Cancel \n 3.Available cabs \n 4.booking details \n 5.Exit \n");
            System.out.println("---------------");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("Booking portal");
                    System.out.println("---------------");

                    System.out.print("Enter your name :");
                    String name = input.nextLine();
                    input.nextLine();

                    System.out.print("Enter pickup location :");
                    char pickupLoc = input.next().charAt(0);
                    input.nextLine();

                    System.out.print("Enter drop location :");
                    char dropLoc = input.next().charAt(0);
                    input.nextLine();

                    System.out.print("Enter pickup time: ");
                    int pickupTime = input.nextInt();
                    input.nextLine();

                    Passenger p = new Passenger(name, pickupLoc, dropLoc, pickupTime);
                    PassengerList.put(p.pid, p);

                    bookTaxi(p);

                    break;
                case 2:
                    System.out.println("Cancellation portal");
                    System.out.println("---------------");
                    break;
                case 3:
                    System.out.println("Available cabs");
                    System.out.println("---------------");
                    showCabDetails();
                    break;
                case 4: 
                    System.out.println("Booking details");
                    System.out.println("---------------");
                    break;
                case 5:
                    System.out.println("Exitting...bye");
                    loop = false;
                    break;
            }
        }
    }
}