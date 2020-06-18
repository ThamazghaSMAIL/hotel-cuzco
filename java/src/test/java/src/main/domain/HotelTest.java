package src.main.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.main.domain.bed.Bed;
import src.main.domain.bed.KingSizeBed;
import src.main.domain.bed.QueenSizeBed;

import java.util.List;

class HotelTest {

	@Test
	public void getHotelRooms_returnsHotelRooms() {
		// Given
		List<Bed> kingSizebed = List.of(new KingSizeBed());
		List<Bed> queenSizebed = List.of(new QueenSizeBed());

		Room room1 = new Room(1, 101, 2,
													kingSizebed, true, true, true, true);

		Room room2 = new Room(1, 102, 4,
													queenSizebed, true, true, true, true);

		Hotel hotel = new Hotel("Tiziouzou Hotel", List.of(room1, room2));

		// When
		List<Room> hotelRoomsReceived = hotel.getRooms();

		// Then
		Room room1Wanted = new Room(1, 101, 2,
																kingSizebed, true, true, true, true);
		Room room2Wanted = new Room(1, 102, 4,
																queenSizebed, true, true, true, true);

		List<Room> hotelRoomsWanted = List.of(room1Wanted, room2Wanted);

		Assertions.assertEquals(hotelRoomsReceived.get(0).getRoomNumber(), hotelRoomsWanted.get(0).getRoomNumber());
	}

}