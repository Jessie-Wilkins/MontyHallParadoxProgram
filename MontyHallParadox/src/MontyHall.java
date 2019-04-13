import java.util.Random;

public class MontyHall {
	
	private static Random createRand() {
		return new Random();
	}
	
	
	public static boolean [] createDoorArray() {
		boolean [] doorArray = new boolean[3];
		int full_door_index = createRand().nextInt(3);
		iterateThroughDoorsAndSet(doorArray, full_door_index);
		
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
		int doorIndex = 0;
		doorIndex = findEmptyDoor(doorArray, chosenDoor, doorIndex);
		return doorIndex;
	}

	
	public static boolean[] openDoor(boolean[] openArray, int doorIndex) {
		if(openArray[doorIndex] == false) {
			openArray[doorIndex] = true;
		}
		return openArray;
	}
	
	public static int switchDoors(boolean[] doorArray2, int chosenDoor, int openEmptyDoor) {
		int doorIndex = 0;
		doorIndex = searchForOtherClosedDoor(chosenDoor, openEmptyDoor, doorIndex);
		return doorIndex;
	}


	private static int searchForOtherClosedDoor(int chosenDoor, int openEmptyDoor, int doorIndex) {
		while(doorIndex == chosenDoor || doorIndex == openEmptyDoor) {
			doorIndex++;
		}
		return doorIndex;
	}
	
	private static void iterateThroughDoorsAndSet(boolean[] doorArray, int full_door_index) {
		for(int i=0; i<3; i++) {
			setDoorToEmptyOrFull(doorArray, full_door_index, i);
		}
	}


	private static void setDoorToEmptyOrFull(boolean[] doorArray, int full_door_index, int i) {
		if(i == full_door_index) {
			doorArray[i] = true;
		}
		else {
			doorArray[i] = false;
		}
	}
	
	private static boolean doorIsEmptyAndDifferent(boolean[] doorArray, int chosenDoor, int doorIndex) {
		return doorArray[doorIndex] == false && doorIndex != chosenDoor;
	}
	
	private static int findEmptyDoor(boolean[] doorArray, int chosenDoor, int doorIndex) {
		boolean emptyDoor = true;
		while(emptyDoor) {
			doorIndex = createRand().nextInt(3);
			if(doorIsEmptyAndDifferent(doorArray, chosenDoor, doorIndex)) {
				emptyDoor = false;
			}
		}
		return doorIndex;
	}
	
}
