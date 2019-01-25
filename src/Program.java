

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
	public static final int PARK_IN = 1;
	public static final int PARK_OUT = 2;
	public static final int FIND_PLACE = 3;
	public static final int RESERVE_PLACE = 4;
	public static final int EXIT = 0;

	public static void main(String[] args) throws FileNotFoundException {
		int choice = 0;
		Scanner s = new Scanner(System.in);
		ParkingLot p = new ParkingLot();

		do {
			p.printParkingLot();
			printMenu();
			choice = s.nextInt();

			switch (choice) {
			case PARK_IN: // 1
				p.parkCar(s,1);
				break;

			case PARK_OUT: // 2
				p.parkCar(s,0);
				break;

			case FIND_PLACE: // 3 - recursion!
				p.findPlace(s);
				break;

			case RESERVE_PLACE: // 4
				p.reservePlace(s);
				break;

			case EXIT:
				System.out.println("Thank you for using our service\nGoodbye");
				break;
  
			default:
				System.out.println("Wrong input");
				break;
			}
			
		} while (choice != 0);

		s.close();
	}

	private static void printMenu() {
		System.out.println("Choose 1 for park in");
		System.out.println("Choose 2 for park out");
		System.out.println("Choose 3 for find place");
		System.out.println("Choose 4 for reserve place");
		System.out.println("Choose 0 for exit");
		System.out.println("What's your choice? ");
	}

}
