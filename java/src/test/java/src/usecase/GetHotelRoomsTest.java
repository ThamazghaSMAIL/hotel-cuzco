package src.usecase;

import org.junit.jupiter.api.Test;
import src.domain.MinimumStayException;
import src.domain.Room;
import src.domain.bed.Bed;
import src.domain.bed.KingSizeBed;
import src.domain.bed.QueenSizeBed;
import src.infrastructure.InMemoryRoomPort;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GetHotelRoomsTest {

	private RoomPort roomPort = new InMemoryRoomPort();
	private GetHotelRooms getHotelRooms = new GetHotelRooms(roomPort);

	@Test
	void returnAllHotelRoomsInformation_whenGivenHotelName() throws MinimumStayException {

		// Given
		LocalDate checkIn = LocalDate.of(2015, 12, 30);
		LocalDate checkOut = LocalDate.of(2015, 12, 31);

		// When
		List<Room> roomsReturned = this.getHotelRooms.getHotelRooms(checkIn, checkOut);

		// Then
		List<Bed> kingSizebed = List.of(new KingSizeBed());
		List<Bed> queenSizebed = List.of(new QueenSizeBed());

		Room room1Wanted = new Room(1, 101, 2,
																kingSizebed, true, true, true, true);
		Room room2Wanted = new Room(1, 102, 4,
																queenSizebed, true, true, true, true);

		List<Room> roomsWanted = List.of(room1Wanted, room2Wanted);

		assertThat(roomsWanted.get(0).getFloorNumber()).isEqualTo(roomsReturned.get(0).getFloorNumber());
		assertThat(roomsWanted.get(1).getFloorNumber()).isEqualTo(roomsReturned.get(1).getFloorNumber());
	}

	@Test
	void throwException_whenCheckInAndCheckoutAreEqual() {

		// When Then
		LocalDate checkIn = LocalDate.of(2015, 12, 31);
		LocalDate checkOut = LocalDate.of(2015, 12, 31);

		assertThrows(MinimumStayException.class, () -> this.getHotelRooms.getHotelRooms(checkIn, checkOut));
	}

	@Test
	void returnAvailableRooms_whenGivenHotelNameAndCheckInCheckOut() throws MinimumStayException {

		// Given
		LocalDate checkIn = LocalDate.of(2015, 12, 30);
		LocalDate checkOut = LocalDate.of(2015, 12, 31);

		// When
		List<Room> roomsReturned = this.getHotelRooms.getHotelRooms(checkIn, checkOut);

		// Then
		List<Bed> kingSizeBed = List.of(new KingSizeBed());
		List<Bed> queenSizeBed = List.of(new QueenSizeBed());

		Room room1Wanted = new Room(1, 101, 2,
																kingSizeBed, true, true, true, true);
		Room room2Wanted = new Room(1, 102, 4,
																queenSizeBed, true, true, true, true);

		List<Room> roomsWanted = List.of(room1Wanted, room2Wanted);

		assertThat(roomsWanted.get(0).getFloorNumber()).isEqualTo(roomsReturned.get(0).getFloorNumber());
		assertThat(roomsWanted.get(1).getFloorNumber()).isEqualTo(roomsReturned.get(1).getFloorNumber());
	}

}
