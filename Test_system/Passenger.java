package Test_system;

public class Passenger {
    private int id = 0;
    private int pid;
    private String name;
    private String berthpreference;
    private int age;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return this.pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBerthpreference() {
        return this.berthpreference;
    }

    public void setBerthpreference(String berthpreference) {
        this.berthpreference = berthpreference;
    }

    public Passenger(String name, String berthpreference, int age) {
        this.name = name;
        this.berthpreference = berthpreference;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
