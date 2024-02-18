package Flight_booking_system;

import java.util.HashMap;
import java.util.Scanner;


public class Main
{

    public static void bookIt(Flights f, Passenger p, int tnum)
    {   
        f.seatsAvailable -= tnum;
        f.price += 200*tnum;
        System.out.println("------------");
        System.out.println("Tickets booked sucessfully");
        System.out.println("------------");
        p.printsummary();
    }

    public static void cancelTicket(Passenger p, Flights f)
    {
        f.seatsAvailable += p.ticketsBooked;
        f.price -= 200*p.ticketsBooked;
        System.out.println("---------");
        System.out.println("Cancellation sucessfull");
        System.out.println("refund amount : " + p.totalPrice);
        System.out.println("---------");
    }


    public static void main(String[] args) 
    {
        Flights f = new Flights();//creating a flight
        Flights f1 = new Flights();//creating a flight

        HashMap<Integer, Flights> flightMap = new HashMap<>();
        HashMap<Integer, Passenger> passengerMap = new HashMap<>();

        flightMap.put(f.flightid, f);
        flightMap.put(f1.flightid, f1);
        boolean loop = true;

        while(loop)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("-------");
            System.out.println("HOME PAGE");
            System.out.println("-------");
            System.out.print(" 1.Book tickets \n 2.Cancel tickets \n 3.Available flights \n 4.Booking details \n 5.Exit \n");
            System.out.println();
            System.out.print("Enter your choice: ");
            int s = input.nextInt();

            switch (s) {
                case 1:
                    System.out.println("Booking portal");
                    System.out.print("Enter the flight id: ");
                    int n = input.nextInt();

                    if(flightMap.containsKey(n))
                    {
                        System.out.println("Flight available");
                        flightMap.get(n).flightSummary();
                        System.out.print("Enter the number of tickets : ");
                        int ntickts = input.nextInt();
                        if(ntickts>flightMap.get(n).seatsAvailable)
                        {
                            System.out.println("-----");
                            System.out.println("Not enough seats");
                            System.out.println("-----");
                        }else
                        {
                            Passenger p = new Passenger(ntickts, flightMap.get(n).price, n);
                            bookIt(flightMap.get(n),p, ntickts);
                            passengerMap.put(p.pid, p);
                        }

                    }
                    else
                    {
                        System.out.println("-----");
                        System.out.println("Invalid flight id");
                        System.out.println("-----");
                    }
                    break;

                case 2:
                    System.out.println("Cancellation portal");
                    System.out.println("----------");
                    System.out.println("Enter the passenger ID: ");
                    int o = input.nextInt();
                    if(passengerMap.containsKey(o))
                    {
                        cancelTicket(passengerMap.get(o),flightMap.get(passengerMap.get(o).fid));
                        passengerMap.remove(o);
                    }
                    else
                    {
                        System.out.println("Invalid passenger ID");
                    }
                    break;
                case 3:
                    System.out.println("Available tickets");
                    for(int i = 1; i<=flightMap.size(); i++)
                    {
                            System.out.println("----------");
                            System.out.println("The Flight: " + flightMap.get(i).flightid);
                            System.out.println("Seats available : " + flightMap.get(i).seatsAvailable);
                            System.out.println("Price:  " + flightMap.get(i).price);
                            System.out.println("----------");
                    }
                    break;
                case 4:
                    System.out.println("Booking details");
                    System.out.print("Enter the passenger id: ");
                    int m = input.nextInt();
                    if(passengerMap.containsKey(m))
                    {
                        passengerMap.get(m).printsummary();
                    }else
                    {
                        System.out.println("--------------");
                        System.out.println("Invalid passenger Id");
                        System.out.println("--------------");
                    }
                    break;
                case 5:
                    System.out.println("Exit");
                    loop=false;
                    break;
            }
        }
    }
}