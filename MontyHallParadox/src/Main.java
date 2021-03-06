
public class Main {
	
	public static void main(String[] args) {
		int switchScore = 0;
		int stayScore = 0;
		int num_of_rounds = 100000;
		for(int i = 0; i<num_of_rounds; i++) {
			boolean [] doorArray = MontyHall.createDoorArray();
			boolean [] openArray = MontyHall.createOpenArray();
			int chosenDoor = MontyHall.chooseDoor();
			int openEmptyIndex = MontyHall.chooseEmptyDoor(doorArray, chosenDoor);
			openArray = MontyHall.openDoor(openArray, openEmptyIndex);
			chosenDoor = MontyHall.switchDoors(doorArray, chosenDoor, openEmptyIndex);
			if(doorArray[chosenDoor] == true) {
				switchScore++;
			}
		}
		for(int i = 0; i<num_of_rounds; i++) {
			boolean [] doorArray = MontyHall.createDoorArray();
			boolean [] openArray = MontyHall.createOpenArray();
			int chosenDoor = MontyHall.chooseDoor();
			int openEmptyIndex = MontyHall.chooseEmptyDoor(doorArray, chosenDoor);
			openArray = MontyHall.openDoor(openArray, openEmptyIndex);
			if(doorArray[chosenDoor] == true) {
				stayScore++;
			}
		}
		System.out.println("Switch score: "+ switchScore+"/"+num_of_rounds);
		System.out.println("Stay score: "+ stayScore+"/"+num_of_rounds);
	}
}
