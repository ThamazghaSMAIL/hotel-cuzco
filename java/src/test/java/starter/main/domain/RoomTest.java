package starter.main.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RoomTest {

	@Test
	public void shouldCreateRoomWithTheRightMembers() {
		int floorNumber = 1;
		int roomNumber = 234;
		int numberGuests = 1;
		boolean AC = true;
		boolean wifi = true;
		List<Bed> beds = new ArrayList<>();
		boolean sharedBathroom = false;
		boolean wheelchairAccessible = true;

		Room room = new Room(floorNumber, roomNumber, numberGuests, beds, AC, wifi, sharedBathroom, wheelchairAccessible);
		Assertions.assertEquals(room.getFloorNumber(), floorNumber);
		Assertions.assertEquals(room.getNumberGuests(), numberGuests);
		Assertions.assertEquals(room.hasAC(), AC);
		Assertions.assertEquals(room.hasWifi(), wifi);
		Assertions.assertEquals(room.getBeds(), beds);
		Assertions.assertEquals(room.hasPrivateBathroom(), sharedBathroom);
		Assertions.assertEquals(room.isWheelchairAccessible(), wheelchairAccessible);

	}

	@Test
	public void test() {
		int floorNumber = 1;
		int roomNumber = 234;
		int numberGuests = 1;
		boolean AC = true;
		boolean wifi = true;

		List<Bed> beds = new ArrayList<Bed>();
		beds.add(new SingleBed());
		beds.add(new QueenSizeBed());
		beds.add(new KingSizeBed());

		boolean sharedBathroom = false;
		boolean wheelchairAccessible = true;

		Room room = new Room(floorNumber, roomNumber, numberGuests, beds, AC, wifi, sharedBathroom, wheelchairAccessible);
		Assertions.assertEquals(room.getBeds().size(), 3);
		Assertions.assertTrue(room.getBeds().get(0) instanceof SingleBed);
		Assertions.assertTrue(room.getBeds().get(1) instanceof QueenSizeBed);
		Assertions.assertTrue(room.getBeds().get(2) instanceof KingSizeBed);
	}
}
