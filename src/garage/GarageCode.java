package garage;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GarageCode {

	private Scanner ent = new Scanner(System.in);
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public Vehicle admParking(Vehicle[] parking, Ticket[] tickets) {
		
		System.out.println("\nDo you wish to 'entry' or 'exit' the parking lot? ");
		String opc = ent.nextLine();
		
		if (opc.equalsIgnoreCase("exit")) {
			System.out.println("Enter the vehicle's plate: ");
			String plate = ent.nextLine();
			int ind = searchingVehicle(parking, plate);
			
			if (ind == -1) {
				System.err.println("Plate not registered in the system. ");
			} else {
				tickets[ind].setExit();
				tickets[ind].setSituation(true);
				System.out.println(tickets[ind]);
				System.out.print("DEPARTURE: " + formatter.format(tickets[ind].getExit())
				+ "\nValue: $" + tickets[ind].calValue(tickets[ind].getEntry(), tickets[ind].getExit()));
				System.out.println("COME BACK ANYTIME!\n");
				parking[ind] = null;
				tickets[ind] = null;
				printParking(parking);
		}
	} else if (opc.equalsIgnoreCase("entry")) {
		int vacancy = identifiesFreeVacancy(parking);
		
		if (vacancy != -1) {
			System.out.println("Enter the vehicle's plate, model and color: ");
			String plate = ent.nextLine();
			String mod = ent.nextLine();
			String col = ent.nextLine();
			
			Vehicle newVehicle = new Vehicle(plate, mod, col);
			parking[vacancy] = newVehicle;
			
			Ticket newTicket = new Ticket(plate);
			newTicket.setVacancy(vacancy);
			tickets[vacancy] = newTicket;
			
			printParking(parking);
			System.out.println(newTicket);
			
			return newVehicle;
		} else {
			System.err.println("Parking lot full! ");
		}
	} else {
			System.out.println("Invalid option! Please 'enter' or 'exit'. ");
		}
		return null;
	}

		public int searchingVehicle(Vehicle[] parking, String plateRegistered) {
			for (int ind = 0; ind < parking.length; ind++) {
				if (parking[ind] != null && parking[ind].getPlate().equals(plateRegistered)) {
					return ind;
				}
			}
			return -1;
		}
		
		public int identifiesFreeVacancy(Vehicle[] parking) {
		    for (int vacancy = 0; vacancy < parking.length; vacancy++) {
		        if (parking[vacancy] == null) {
		            return vacancy;
		        }
		    }
		    return -1;
		}
		
		public void printParking(Vehicle[] parking) {
			for (int i =0; i < parking.length; i++) {
				if (i == 10 || i == 20 || i == 30 || i == 40 || i == 50) {
					System.out.println("");
				}
				System.out.print(parking[i] == null ? " - " : " # ");
			}
			System.out.println("");
		}
		
		public static void main(String[] args) {
			GarageCode garage = new GarageCode();
			Vehicle[] parking = new Vehicle[60];
			Ticket[] tickets = new Ticket[60];
			
			String answer;
			do {
				garage.admParking(parking, tickets);
				System.out.println("Do you wish to continue? (Yes/Not)");
				answer = garage.ent.nextLine();
			}  while (answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y"));
			
			System.out.println("Service completed! ");
	
}
}
