import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMontyHall {

	static boolean [] doorArray = new boolean [3];
	
	static boolean [] openArray = new boolean[3];
	
	@Test
	void isBoundToThree() {
		int average = MontyHall.chooseDoor();
		for(int i = 0; i<1000; i++) {
			average = (average+MontyHall.chooseDoor())/2;
		}
		
		assertTrue(average<=3);
	}
	
	@Test
	void isEmptyDoor() {
		
		oneEmptyDoor();
		
		assertEquals(1, MontyHall.chooseEmptyDoor(doorArray,0));
		
	}
	
	@Test
	void isSwitchedDoor() {
		allClosedDoors(doorArray);
		int chosenDoor = MontyHall.chooseDoor();
		int openEmptyDoor = MontyHall.chooseEmptyDoor(doorArray, chosenDoor);
		doorArray = MontyHall.openDoor(doorArray, openEmptyDoor);
		int newChosenDoor = MontyHall.switchDoors(doorArray, chosenDoor, openEmptyDoor);
		assertNotEquals(chosenDoor, newChosenDoor);
	}
	
	

	@Test
	void isOpenDoor() {
		allClosedDoors(openArray);
		int doorIndex = 0;
		openArray = MontyHall.openDoor(openArray, doorIndex);
		
		assertTrue(openArray[doorIndex]);
	}
	

	private void allClosedDoors(boolean[] openArray) {
		openArray[0] = false;
		openArray[1] = false;
		openArray[2] = false;
	}

	private void oneEmptyDoor() {
		doorArray[0] = true;
		doorArray[1] = false;
		doorArray[2] = true;
		
	}
	
	
	
	

}
