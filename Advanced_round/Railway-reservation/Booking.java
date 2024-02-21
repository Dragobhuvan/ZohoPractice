import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Booking {
    

    static int lowerberthseats = 1;
    static int upperBerthseats = 1;
    static int middleBerthseats = 1;
    static int waitinglistSeats = 1;
    static int racSeats = 1;

    static ArrayList<Integer> lowerBerthPositionsList = new ArrayList<>(Arrays.asList(1));
    static ArrayList<Integer> upperBerthPositionsList = new ArrayList<>(Arrays.asList(1));
    static ArrayList<Integer> middleBerthPositionsList = new ArrayList<>(Arrays.asList(1));
    static ArrayList<Integer> racPositionsList = new ArrayList<>(Arrays.asList(1));
    static ArrayList<Integer> wlPositionsList = new ArrayList<>(Arrays.asList(1));


    static HashMap<Integer, Passenger> bookingList = new HashMap<>();

    static Queue<Integer> wlQueue = new LinkedList();
    static Queue<Integer> racQueue = new LinkedList();


    static void printAvailable()
    {
        if(lowerberthseats+upperBerthseats+middleBerthseats>0)
        {
            System.out.println("lowerberthseats - " + lowerberthseats);
            System.out.println("upperBerthseats - " + upperBerthseats);
            System.out.println("middleBerthseats - " + middleBerthseats);

            System.out.println("-----------");            
        }else if (racSeats>0)
        {
            System.out.println("RAC seats available - " + racSeats);
            System.out.println("-----------");
        }else{
            System.out.println("No seats available ");
            System.out.println("-----------");
        }
        
    }

    static void bookTicket(Passenger p, int seatNum, String alloted)
    {
        p.alloted = alloted;
        p.seatNum = seatNum;
        bookingList.put(p.passengerId, p);
        System.out.println("Booked sucessfully");
        System.out.println("-----------");
    }

    static void bookingDetails(int pid)
    {
        if(bookingList.containsKey(pid))
        {
            System.out.println("Passenger id : " + bookingList.get(pid).passengerId);
            System.out.println("Age : " + bookingList.get(pid).age);
            System.out.println("Seat alloted " + bookingList.get(pid).alloted + bookingList.get(pid).seatNum);
            System.out.println("-----------");
        }else 
        {
            System.out.println("Passenger id invalid");
        }
        
    }
}
