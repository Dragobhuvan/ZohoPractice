package Test_system;

public class Booker {
    public static void main(String[] args) {

        booktickets();
        printTickets();
    }

    public static void printTickets() {
        Train t = new Train();

        System.out.println("Loweerberth tickets: " + t.getLowerBerth());
    }

    public static void booktickets() {
        Train t = new Train();

        System.out.println("Ticket booked");
        t.setLowerBerth(t.getLowerBerth() - 1);
    }
}
