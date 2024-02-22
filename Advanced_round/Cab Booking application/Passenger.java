public class Passenger {
    
    static int id = 0;

    int pid;

    String name;

    char pickupLoc;

    char dropLoc;

    int pickupTime;

    public Passenger(String name, char pickupLoc, char dropLoc, int pickupTime)
    {
        id +=1;

        pid = id;

        this.name = name;

        this.pickupLoc = pickupLoc;

        this.dropLoc = dropLoc;

        this.pickupTime = pickupTime;
        
    }
}
