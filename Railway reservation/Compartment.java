public class Compartment
{
  int lowerBerthSeats;
  int upperBerthSeats;
  int middleberthSeats;
  int RACseats;
  int waitingListSeats;

  //Seats are kept nonstatic such that any number of compartments can be amde, and they all have seperate seats
  
  static int id = 0; //for unique ID

  int cmptID;


  public Compartment()
  {
    this.lowerBerthSeats = 1;
    this.upperBerthSeats = 1;
    this.middleberthSeats = 1;
    this.RACseats = 1;
    this.waitingListSeats = 1;

    id++;
    cmptID = id;
  }
}
