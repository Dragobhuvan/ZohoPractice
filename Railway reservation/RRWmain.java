import java.util.*;

public class RRWmain
{
    static HashMap<Integer, Compartment> compartmentList = new HashMap();
    static HashMap<Integer, Passenger> passengerMap = new HashMap<>();

    // static int totalLowerBerthSeats;
    // static int totalMiddleBerthSeats;
    // static int totalUpperBerthSeats;
    // static int totalRACSeats;
    // static int totalWL;

    static int checkSeat= 1;

    
    public static void main(String[] args)
    {
        int numberOfcompartments = 2;

        //to generate compartments
        generateCompartments(numberOfcompartments);

        // totalLowerBerthSeats = calcLowerberths();
        // totalMiddleBerthSeats = calcMiddleberths();
        // totalUpperBerthSeats = calcUpperberths();
        // totalRACSeats = calcRacberths();
        // totalWL = calcWLseats();

        //For booking tickets, total seats data is needed, so made booker class and loaded the data in a constructor
        TicketBooker booker = new TicketBooker(calcLowerberths(),calcMiddleberths(), calcUpperberths(), calcRacberths(),  calcWLseats());
        Scanner input = new Scanner(System.in);


        boolean loop = true;

        System.out.println("Welcome to railways app");
        while(loop)
        {
            System.out.println("1.Book\n2.See available seats\n3.Cancel\n4.Print booking details\n5.Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("Booking portal");
                    System.out.println("Enter Passenger name,age and berth preference (L,M or U)");
                    String name = input.next();
                    int age = input.nextInt();
                    //get berth preference (L,U,M)
                    String berthPreference = input.next();
                    //create a passenger object
                    Passenger p = new Passenger(name,age,berthPreference);
                    booker.allotTicket(p);
                    break;
                case 2:
                    System.out.println("See available tickets");
                    printAlltickets();
                    break;
                case 3:
                    System.out.println("Cancel");
                    break;
                case 4: 
                    System.out.println("See by booking id");
                    break;
                case 5: 
                    System.out.println("Exit");
                    System.out.println("Exitting............bye");
                    loop = false;
                    System.exit(0);
            }
        }
    }

     //to generate compartments
    public static void generateCompartments(int n)
    {
        for(int i = 0; i<n; i++)
        {
            Compartment c = new Compartment();

            compartmentList.put(c.cmptID, c);
        }
    }


    public static void printAlltickets()
    {
        System.out.println("----------------------");
        for(int i : compartmentList.keySet())
        {
            System.out.println("Compartment " + compartmentList.get(i).cmptID + ": ");
            System.out.println("TotalSeats : " + (compartmentList.get(i).lowerBerthSeats + compartmentList.get(i).upperBerthSeats+compartmentList.get(i).middleberthSeats+compartmentList.get(i).RACseats));
        }
    }
    //For generating total number of seats;
    public static int calcLowerberths()
    {
        int seats = 0;
        for(int i : compartmentList.keySet())
        {
            seats = seats + compartmentList.get(i).lowerBerthSeats;
        }
        return seats;
    }

    public static int calcMiddleberths()
    {
        int seats = 0;
        for(int i : compartmentList.keySet())
        {
            seats = seats + compartmentList.get(i).middleberthSeats;
        }
        return seats;
    }

    public static int calcUpperberths()
    {
        int seats = 0;
        for(int i : compartmentList.keySet())
        {
            seats = seats + compartmentList.get(i).upperBerthSeats;
        }
        return seats;
    }

    public static int calcRacberths()
    {
        int seats = 0;
        for(int i : compartmentList.keySet())
        {
            seats = seats + compartmentList.get(i).RACseats;
        }
        return seats;
    }

    public static int calcWLseats()
    {
        int seats = 0;
        for(int i : compartmentList.keySet())
        {
            seats = seats + compartmentList.get(i).waitingListSeats;
        }
        return seats;
    }



}