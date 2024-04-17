

/*
The are 6 points(A,B,C,D,E,F) 15 KM apart 60 min travel between each, n taxis all taxis at A starting
100 rs for first 5 KM and then 10 for each of the further KMs, rate from pickup to drop only
pickup time example : 9 hrs, 15 hrs

When a customer books a Taxi, a free taxi at that point is allocated
-If no free taxi is available at that point, a free taxi at the nearest point is allocated.
-If two taxi’s are free at the same point, one with lower earning is allocated
-If no taxi is free at that time, booking is rejected


Input 1:
Customer ID: 1
Pickup Point: A
Drop Point: B
Pickup Time: 9

Output 1:
Taxi can be allotted.
Taxi-1 is allotted
*/

import java.util.*;
import java.util.Collections;

public class Booking
{
    static List<Taxi> taxiList = createTaxis(4);



    public static void main(String[] args) 
    {
        System.out.println("WElcome to cab booking app");
        System.out.println("--------------------------");
        Scanner input = new Scanner(System.in);

        boolean loop = true;

        while(loop)
        {
            System.out.println(" 1. Book taxi");
            System.out.println(" 2. Taxi Details");
            System.out.println(" 3. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();           

            switch(choice)
            {
                case 1:
                    //booking
                    System.out.println("Enter pickup location : ");
                    char pickupLocation = input.next().toUpperCase().charAt(0);
                    System.out.println("Enter drop location: ");
                    char dropLocation = input.next().toUpperCase().charAt(0);
                    System.out.println("Enter pickup time: ");
                    int pickupTime = input.nextInt();

                    List<Taxi> freeTaxiList = getfreeTaxi(pickupLocation, dropLocation, pickupTime);

                    Collections.sort(freeTaxiList, (a,b)-> a.earnings - b.earnings);

                    bookTickets(pickupLocation, dropLocation, pickupTime, freeTaxiList);
                    break;
                case 2: 
                    //print
                    for(Taxi t : taxiList)
                    {
                        t.printTaxiDetails();
                    }
                    break;
                case 3:
                    //exit;
                    System.out.println("Exitting.........bye");
                    loop = false;
                    System.exit(0);
            }
        }
    }


    public static List<Taxi> createTaxis(int n)
    {
        List<Taxi> res = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            Taxi t = new Taxi();
            res.add(t);
        }

        return res;
    }

    public static List<Taxi> getfreeTaxi(char pickupLocation, char dropLocation, int pickupTime)
    {
        List<Taxi> res = new ArrayList<>();

        for( Taxi t : taxiList)
        {
            if(t.freeTime>=pickupTime && (Math.abs((t.currentLocation-'0') - (pickupLocation-'0')) <= pickupTime - t.freeTime))
            {
                res.add(t);
            }
        }
        return res;
    }

    public static void bookTickets(char pickupLocation, char dropLocation, int pickupTime, List<Taxi> freeTaxiList)
    {
        // The free taxi list is already sorted for earnings
        //now we have to find minimal distanc between points

        int minDist = Integer.MAX_VALUE;

        int distancBetweenPickupDrop = 0;

        int tripcost = 0;

        int nextFreeTime = 0;

        Taxi bookedTaxi = null;

        String tripdetail = "";
        for(Taxi t : taxiList)
        {
            int distanceBetweenCustomerAndTaxi = Math.abs((t.currentLocation - '0') - (pickupLocation - '0')) * 15;

            if(distanceBetweenCustomerAndTaxi<minDist)
            {
                bookedTaxi = t;

                distancBetweenPickupDrop = Math.abs((dropLocation-'0')-(pickupLocation-'0')) * 15;

                tripcost = 100 + ((distancBetweenPickupDrop-5) * 10);

                int droptime = pickupTime + distancBetweenPickupDrop/15;

                nextFreeTime = droptime;

                minDist = distanceBetweenCustomerAndTaxi;
            }
        }

        bookedTaxi.setDetails(true, dropLocation, nextFreeTime, tripcost, tripdetail);

        System.out.println("Booked sucessfully");
        System.out.println("Alloted taxi id: " + bookedTaxi.id);

    }
}
