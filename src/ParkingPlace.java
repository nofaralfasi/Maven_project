public class ParkingPlace {
	enum Status {
		FREE, OCCUPIED, RESERVED
	}

	private Status placeStatus;
	private int row, col;
	private String OwnerName; // name of the car's owner
	private static int numOfPlacesReserved = 0; // number of the saved places

	public ParkingPlace(int r, int c, String name, Status currentStatus) {
		this.placeStatus = currentStatus;
		this.setRow(r);
		this.setCol(c);
		this.OwnerName = name;
	}
	
	public static void increaseNumOfPlaces() {
		numOfPlacesReserved++;
	}

	public static void decreaseNumOfPlaces() {
		numOfPlacesReserved--;
	}
	
	//////// getters & setters methods //////////
	public Status getCurrentStatus() {
		return placeStatus;
	}

	public void setCurrentStatus(Status currentStatus) {
		if (currentStatus == Status.RESERVED || currentStatus == Status.RESERVED && currentStatus != Status.RESERVED)
			increaseNumOfPlaces();
		this.placeStatus = currentStatus;
	}
	
	public String getOwnerName() {
		return OwnerName;
	}

	public void setOwnerName(String ownerName) {
		this.OwnerName = ownerName;
	}

	public static int getNumOfPlaces() {
		return numOfPlacesReserved;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
