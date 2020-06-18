package src.usecase;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import src.main.domain.Hotel;
import src.main.domain.Room;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

class DisplayHotelRoomsTest {

	private DisplayHotelRooms displayHotelRooms;

	@Mock
	private HotelPort hotelPort;

	@Test
	void returnAllHotelRoomsInformation_whenGivenHotelName() {

		// Given
		String hotelName = "myHotel";
		List<Room> rooms = null;
		Hotel hotel = new Hotel(hotelName, rooms);

		given(hotelPort.getHotelByName(hotelName)).willReturn(hotel);

		// When
		List<Room> roomsReturned = displayHotelRooms.getHotelRooms();

		// Then
		List<Room> roomsWanted = null;
		assertThat(roomsWanted).isEqualTo(roomsReturned);


	}

}