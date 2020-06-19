package src.usecase;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import src.main.domain.Hotel;
import src.main.domain.Room;
import src.main.domain.bed.Bed;
import src.main.domain.bed.KingSizeBed;
import src.main.domain.bed.QueenSizeBed;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GetHotelRoomsTest {

	private HotelPort hotelPortTest = new HotelPortTest();

	private GetHotelRooms getHotelRooms = new GetHotelRooms(hotelPortTest);

	@Test
	void returnAllHotelRoomsInformation_whenGivenHotelName() {

		// Given
		String hotelName = "myHotel";
		List<Bed> kingSizebed = List.of(new KingSizeBed());
		List<Bed> queenSizebed = List.of(new QueenSizeBed());
		Room room1Wanted = new Room(1, 101, 2,
																kingSizebed, true, true, true, true);
		Room room2Wanted = new Room(1, 102, 4,
																queenSizebed, true, true, true, true);
		List<Room> rooms = List.of(room1Wanted, room2Wanted);

		Hotel hotel = new Hotel(hotelName, rooms);

		hotelPortTest.save(hotel);

		// When
		List<Room> roomsReturned = getHotelRooms.getHotelRooms("myHotel");

		// Then
		List<Room> roomsWanted = rooms;

		assertThat(roomsWanted).isEqualTo(roomsReturned);
	}

}