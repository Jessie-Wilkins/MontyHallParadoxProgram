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
		
		assertTrue(average<4);
	}
	
	@Test
	void isEmptyDoor() {
		
		oneEmptyDoor();
		
		assertEquals(1, MontyHall.chooseEmptyDoor(doorArray));
		
	}
	
	@Test
	void isClosedDoor() {

		oneClosedDoor(openArray);
		
		assertEquals(2, MontyHall.chooseClosedDoor(openArray));
	}
	@Test
	private void isSwitchedDoor() {
		allClosedDoors(doorArray);
		int chosenDoor = MontyHall.chooseDoor();
		int openEmptyDoor = MontyHall.chooseEmptyDoor(doorArray, chosenDoor);
		doorArray = MontyHall.openDoor(doorArray, openEmptyDoor);
		int newChosenDoor = MontyHall.switchDoors(doorArray, chosenDoor, openEmptyDoor);
		assertNotEquals(chosenDoor, newChosenDoor);
	}
	
	

	@Test
	private void isOpenDoor() {
		allClosedDoors(doorArray);
		int doorIndex = 0;
		doorArray = MontyHall.openDoor(doorArray, doorIndex);
		
		assertTrue(doorArray[doorIndex]);
	}
	

	private void oneClosedDoor(boolean[] openArray) {
		openArray[0] = true;
		openArray[1] = true;
		openArray[2] = false;
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
