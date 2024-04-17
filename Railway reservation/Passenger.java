import java.util.HashMap;

public class Passenger 
{
    static int id = 0;
    int Pid;
    int seatNum;
    String alloted;
    String berthPreference;
    String name;
    int age;

    public Passenger(String name, int age, String berthpreference)
    {
        id++;
        Pid = id;
        this.name = name;
        this.age = age;
        this.berthPreference = berthpreference;
        alloted = "";
        seatNum = -1;
    }
}
