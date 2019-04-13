import java.util.Random;

public class MontyHall {
	
	private static Random createRand() {
		return new Random();
	}
	
	
	public static boolean [] randomArray() {
		boolean [] doorArray = new boolean[3];
		int full_door_index = createRand().nextInt(3);
		for(int i=0; i<3; i++) {
			if(i == full_door_index) {
				doorArray[i] = true;
			}
			else {
				doorArray[i] = false;
			}
		}
		
		return doorArray;
	}
	
	public static boolean[] createOpenArray() {
		boolean [] openArray = new boolean[3];
		openArray[0] = false;
		openArray[1] = false;
		openArray[2] = false;
		return openArray;
	}
	
	public static int chooseDoor() {
		
		return createRand().nextInt(3);
	}
	
	public static int chooseEmptyDoor(boolean [] doorArray, int chosenDoor) {
		boolean emptyDoor = true;
		int doorIndex = 0;
		while(emptyDoor) {
			doorIndex = createRand().nextInt(3);
			if(doorArray[doorIndex] == false && doorIndex != chosenDoor) {
				emptyDoor = false;
			}
		}
		return doorIndex;
	}
	
	public static int chooseEmptyDoor(boolean [] doorArray) {
		boolean emptyDoor = true;
		int doorIndex = 0;
		while(emptyDoor) {
			doorIndex = createRand().nextInt(3);
			if(doorArray[doorIndex] == false) {
				emptyDoor = false;
			}
		}
		return doorIndex;
	}
	
	public static int chooseClosedDoor( boolean[] openArray) {
		boolean closedDoor = true;
		int doorIndex = 0;
		while(closedDoor) {
			doorIndex = createRand().nextInt(3);
			if(openArray[doorIndex] == false) {
				closedDoor = false;
			}
		}
		return doorIndex;
	}
	
	public static boolean[] openDoor(boolean[] openArray, int doorIndex) {
		if(openArray[doorIndex]) {
			openArray[doorIndex] = true;
		}
		
		return openArray;
	}
	
	public static int switchDoors(boolean[] doorArray2, int chosenDoor, int openEmptyDoor) {
		int doorIndex = 0;
		while(doorIndex == chosenDoor || doorIndex == openEmptyDoor) {
			doorIndex++;
		}
		return doorIndex;
	}
	
}
