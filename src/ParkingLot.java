
import java.util.Scanner;

public class ParkingLot {
	public static final int ROWS = 10;
	public static final int COLS = 20;
	private ParkingPlace[][] parkingLotMap;

	public ParkingLot() { // constructor
		parkingLotMap = new ParkingPlace[ROWS][COLS];
		for (int i = 0; i < ROWS; i++)
			for (int j = 0; j < COLS; j++)
				parkingLotMap[i][j] = new ParkingPlace(i, j, "", ParkingPlace.Status.FREE);
	}

	/// prints the map of the parkingLot ///
	public void printParkingLot() {
		System.out.println("\nThis is the parking: ");
		System.out.printf("Number of reserved places: %d\n", ParkingPlace.getNumOfPlaces());
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++)
				System.out.print("" + (getPlaceCharForMap(parkingLotMap[i][j])));
			System.out.println();
		}
	}

	public char getPlaceCharForMap(ParkingPlace p) {
		if (p.getCurrentStatus().ordinal() == 2)
			return '^';
		else if (p.getCurrentStatus().ordinal() == 1)
			return p.getOwnerName().charAt(0);
		else
			return '.';
	}

	public void parkCar(Scanner s, int newStatus) { // 2
		int row, col;
		String ownerName;
		System.out.print("Enter row and col: ");
		row = s.nextInt();
		col = s.nextInt();
		if (newStatus == 0) // park out
			parkOut(row, col);
		else {
			System.out.print("Your name: ");
			ownerName = s.next();
			if (newStatus == 1) { // park in
				parkIn(row, col, ownerName);
			} else
				reservePlace(row, col, ownerName);
		}
	}

	private void reservePlace(int row, int col, String ownerName) {
		if (isAvailable(row, col)) {
			parkingLotMap[row][col].setOwnerName(ownerName);
			parkingLotMap[row][col].setCurrentStatus(ParkingPlace.Status.RESERVED);
		}
		else
			System.out.println("Unavailable parking place");
	}

	private boolean checkEmptySpace(int row, int col, String name) {
		if (isAvailable(row, col) || parkingLotMap[row][col].getCurrentStatus() == ParkingPlace.Status.RESERVED
				&& parkingLotMap[row][col].getOwnerName().equals(name))
			return true;
		else
			return false;
	}

	private void parkIn(int row, int col, String name) {
		if (checkEmptySpace(row, col, name)) {
			parkingLotMap[row][col].setOwnerName(name);
			parkingLotMap[row][col].setCurrentStatus(ParkingPlace.Status.OCCUPIED);
		} else
			System.out.println("Unavailable parking place");
	}

	private void parkOut(int row, int col) {
		parkingLotMap[row][col].setCurrentStatus(ParkingPlace.Status.FREE);
		ParkingPlace.decreaseNumOfPlaces();

	}

	public void findPlace(Scanner s) { // 5 - prints the option
		int row = 0;
		System.out.println(" Enter a row where you want to park: ");
		row = s.nextInt();
		if (!findPlace(row))
			System.out.println("There are no available places on row " + row);
	}

	public boolean findPlace(int row) {
		return findPlaceRecursion(row, 0);
	}

	public boolean findPlaceRecursion(int row, int col) { /// - recursion!
		if (col == parkingLotMap[row].length)
			return false;
		else if (checkEmptySpace(row, col, "")) {
			System.out.printf("The available place is at [%d%d]\n", row, col);
			return true;
		} else
			return findPlaceRecursion(row, col + 1);
	}

	public void reservePlace(Scanner s) {
		parkCar(s, 2);
	}

	public boolean isAvailable(int row, int col) {
		boolean avaliable = true;
		for (int i = row - 1; i <= row + 1 && avaliable; i++)
			for (int j = col - 1; j <= col + 1 && avaliable; j++)
				if (i >= 0 && j >= 0 && i < ROWS && j < COLS)
					if (parkingLotMap[i][j].getCurrentStatus() != ParkingPlace.Status.FREE)
						avaliable = false;
		return avaliable;
	}

}
