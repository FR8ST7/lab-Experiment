package oopslab;
import java.util.Scanner;
public class Train {
	
	 String name;
	 String source;
	 String destination;
	 int numTickets;
	 double cost;
	 public Train(String name, String source, String destination, int numTickets, double cost) {
	 this.name = name;
	 this.source = source;
	 this.destination = destination;
	 this.numTickets = numTickets;
	 this.cost = cost;
	 }
	 public void bookTicket(int tickets) {
	 if (tickets <= numTickets) {
	 numTickets -= tickets;
	 System.out.println("Booked " + tickets + " ticket(s). Total cost: " + (tickets * cost));
	 } else {
	 System.out.println("Not enough seats available.");
	 }
	 }
	}
	class TrainBookingSystem {
	 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 Train[] trains = {
	 new Train("Chennai Express", "Chennai", "Bangalore", 100, 500),
	 new Train("Coimbatore Express", "Coimbatore", "Chennai", 50, 600)
	 };
	 System.out.println("Enter source:");
	 String source = sc.nextLine();
	 System.out.println("Enter destination:");
	 String destination = sc.nextLine();
	 Train selectedTrain = null;
	 for (Train train : trains) {
	 if (train.source.equalsIgnoreCase(source) &&
	train.destination.equalsIgnoreCase(destination)) {
	 selectedTrain = train;
	break;
	 }
	 }
	 if (selectedTrain != null) {
	 System.out.println("Enter number of tickets to book:");
	 int tickets = sc.nextInt();
	 selectedTrain.bookTicket(tickets);
	 } else {
	 System.out.println("No train found for the given route.");
	 }
	 sc.close();
	 }
	}

