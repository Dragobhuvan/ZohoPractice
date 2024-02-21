public class Passenger {

    static int id = 0;

    int passengerId;
    String name;
    int age;
    char berthPrefernce;
    String alloted;
    int seatNum;

    public Passenger(String name, int age, char berthPrefernce)
    {
        id = id+1;
        passengerId=id;
        this.name = name;
        this.age = age;
        this.berthPrefernce = berthPrefernce;
        alloted = "";
        seatNum = -1;
    }
}
