import java.util.*;

public class Railway
{


    public static void book(Passenger p)
    {
        Booking b = new Booking();
        if(! (b.lowerberthseats>0 || b.upperBerthseats>0 || b.middleBerthseats > 0 || b.racSeats>0 || b.waitinglistSeats > 0) )
        {
            System.out.println("-----");
            System.out.println("No seats available..Exiting");
            System.out.println("-----");
            System.exit(0);
        }
        else
        {
            //this is if the perferred berth is available
            if(p.berthPrefernce == 'L' && b.lowerberthseats>0 ||
               p.berthPrefernce == 'M' && b.middleBerthseats>0 ||
               p.berthPrefernce == 'U' && b.upperBerthseats > 0)
            {
                System.out.println("Preferred Berth available ");
                System.out.println("-----------");

                if(p.berthPrefernce == 'L')
                {
                    System.out.println("Lower berth given");
                    System.out.println("-----------");
                    b.bookTicket(p, b.lowerBerthPositionsList.get(0), "L");
                    b.lowerberthseats--;
                    b.lowerBerthPositionsList.remove(0);
                    
                }
                else if(p.berthPrefernce == 'U')
                {
                    System.out.println("Upper berth given");
                    System.out.println("-----------");
                    b.bookTicket(p, b.upperBerthPositionsList.get(0), "U");
                    b.upperBerthseats--;
                    b.upperBerthPositionsList.remove(0);
                    
                } else if (p.berthPrefernce == 'M')
                {
                    System.out.println("Middle berth given");
                    System.out.println("-----------");
                    b.bookTicket(p, b.middleBerthPositionsList.get(0), "M");
                    b.middleBerthseats--;
                    b.middleBerthPositionsList.remove(0);
                }
            }
            //if pereference is not available
            else if (b.lowerberthseats>0)
            {
                System.out.println("Lower berth given");
                System.out.println("-----------");
                b.bookTicket(p, b.lowerBerthPositionsList.get(0), "L");
                b.lowerberthseats--;
                b.lowerBerthPositionsList.remove(0);

            }
            else if (b.upperBerthseats>0)
            {
                System.out.println("Upper berth given");
                System.out.println("-----------");
                b.bookTicket(p, b.upperBerthPositionsList.get(0), "U");
                b.upperBerthseats--;
                b.upperBerthPositionsList.remove(0);
            }
            else if(b.middleBerthseats>0)
            {
                System.out.println("Middle berth given");
                System.out.println("-----------");
                b.bookTicket(p, b.middleBerthPositionsList.get(0), "M");
                b.middleBerthseats--;
                b.middleBerthPositionsList.remove(0);
            }
            else if(b.racSeats>0)
            {
                System.out.println("RAC given");
                System.out.println("-----------");
                b.bookTicket(p, b.racPositionsList.get(0), "RAC");
                b.racSeats--;
                b.racPositionsList.remove(0);
                b.racQueue.offer(p.passengerId);
            }
            else if(b.waitinglistSeats>0)
            {
                System.out.println("The ticket has been wait listed");
                System.out.println("-----------");
                b.bookTicket(p, b.wlPositionsList.get(0), "WL");
                b.waitinglistSeats--;
                b.wlPositionsList.remove(0);
                b.wlQueue.offer(p.passengerId);
            }


        }
    }

    static void cancel(int cid)
    {
        Booking b = new Booking();

        if(b.bookingList.containsKey(cid))
        {
            Passenger p = b.bookingList.get(cid);

            if(p.alloted == "L")
            {
                b.lowerberthseats++;
                b.lowerBerthPositionsList.add(p.seatNum);
                b.bookingList.remove(p.passengerId);

                if(b.racQueue.size()>0)
                {
                    Passenger p2 = b.bookingList.get(b.racQueue.poll());
                    book(p2);
                }
                else if(b.wlQueue.size() > 0)
                {   
                    Passenger p1 = b.bookingList.get(b.wlQueue.poll());
                    book(p1);
                } 
                System.out.println("Tickets cancelled");
                System.out.println("-----------");

            } else if(p.alloted == "M")
            {
                b.middleBerthseats++;
                b.middleBerthPositionsList.add(p.seatNum);
                b.bookingList.remove(p.passengerId);

                if(b.racQueue.size()>0)
                {
                    Passenger p2 = b.bookingList.get(b.racQueue.poll());
                    book(p2);
                }
                else if(b.wlQueue.size() > 0)
                {   
                    Passenger p1 = b.bookingList.get(b.wlQueue.poll());
                    book(p1);
                } 
                System.out.println("Tickets cancelled");
                System.out.println("-----------");
            }
            else if (p.alloted == "U")
            {
                b.upperBerthseats++;
                b.upperBerthPositionsList.add(p.seatNum);
                b.bookingList.remove(p.passengerId);

                if(b.racQueue.size()>0)
                {
                    Passenger p2 = b.bookingList.get(b.racQueue.poll());
                    book(p2);
                }
                else if(b.wlQueue.size() > 0)
                {   
                    Passenger p1 = b.bookingList.get(b.wlQueue.poll());
                    book(p1);
                } 

                System.out.println("Tickets cancelled");
                System.out.println("-----------");
            } 
            else if(p.alloted == "RAC")
            {
                b.racSeats++;
                b.racPositionsList.add(p.seatNum);
                b.bookingList.remove(p.passengerId);

                if(b.wlQueue.size() > 0)
                {   
                    Passenger p1 = b.bookingList.get(b.wlQueue.poll());
                    book(p1);
                } 
                System.out.println("Tickets cancelled");
                System.out.println("-----------");
            }

            else if (p.alloted == "Wl")
            {
                b.waitinglistSeats++;
                b.middleBerthPositionsList.add(p.seatNum);
                b.bookingList.remove(p.passengerId);
                
                System.out.println("Tickets cancelled");
                System.out.println("-----------");
            }
        
        else 
            {
                System.out.println("Invalid passsenger ID");
                System.out.println("-----------");
            }
        }

    }
    public static void main(String[] args) 
    {
        boolean loop = true;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to railway booking portal");
        System.out.println("-----------");
        while(loop)
        {
            System.out.println("1.Book");
            System.out.println("2.Cancel");
            System.out.println("3.Available tickets");
            System.out.println("4.Booking details");
            System.out.println("5 Exit");
            System.out.println("-----------");
            System.out.print("Enter your choice : ");
            int choice = input.nextInt();
            System.out.println("-----------");

            switch(choice)
            {
                case 1:
                    System.out.println("Booking portal");
                    System.out.println("-----------");
                    //getting user details
                    System.out.print("Enter your name : ");
                    String name = input.nextLine();

                    input.nextLine();
                    System.out.print("enter your age: ");
                    int age = input.nextInt();
                    
                    System.out.print("Enter you berth perference : ");
                    char berthpref = input.next().charAt(0);

                    System.out.println("-----------");
                    //calling booking classs
                    if(berthpref == 'L' || berthpref == 'U' || berthpref == 'M')
                    {
                        Passenger p = new Passenger(name, age, berthpref);
                        book(p);
                        
                    }else
                    {
                        System.out.println("Invalid berthpref...Only enter L,U,M");
                        break;
                    }
                    break;
                case 2: 
                    System.out.println("Cancellation portal");
                    System.out.println("-----------");
                    System.out.print("Enter your passsenger id : ");
                    int pid = input.nextInt();
                    cancel(pid);
                    break;
                case 3: 
                    System.out.println("Available tickets");
                    System.out.println("-----------");
                    Booking.printAvailable();
                    break;
                case 4: 
                    System.out.println("Booking details");
                    System.out.println("-----------");
                    System.out.print("Enter passsenger id :");
                    int cid = input.nextInt();
                    System.out.println("-----------");
                    Booking b = new Booking();
                    b.bookingDetails(cid);
                    break;
                case 5: 
                    System.out.println("Exitting...bye");
                    System.out.println("-----------");
                    loop = false;
                    break;
            }
        }
    }
}