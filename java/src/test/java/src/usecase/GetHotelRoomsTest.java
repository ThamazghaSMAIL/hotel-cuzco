package src.usecase;

import org.junit.jupiter.api.Test;
import src.domain.Hotel;
import src.domain.MinimumStayException;
import src.domain.Room;
import src.domain.bed.Bed;
import src.domain.bed.KingSizeBed;
import src.domain.bed.QueenSizeBed;
import src.infrastructure.InMemoryHotelPort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GetHotelRoomsTest {

	@Test
	void returnAllHotelRoomsInformation_whenGivenHotelName() throws MinimumStayException {

		// Given
		HotelPort hotelPortTest = new InMemoryHotelPort(new ArrayList<>());
		GetHotelRooms getHotelRooms = new GetHotelRooms(hotelPortTest);
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

		LocalDate checkIn = LocalDate.of(2015, 12, 30);
		LocalDate checkOut = LocalDate.of(2015, 12, 31);

		// When

		List<Room> roomsReturned = getHotelRooms.getHotelRooms("myHotel", checkIn, checkOut);

		// Then

		assertThat(rooms).isEqualTo(roomsReturned);
	}

	@Test
	void throwException_whenCheckInAndCheckoutAreEqual() {

		// Given
		HotelPort hotelPortTest = new InMemoryHotelPort(new ArrayList<>());
		GetHotelRooms getHotelRooms = new GetHotelRooms(hotelPortTest);
		String hotelName = "myHotel";
		List<Room> rooms = new ArrayList<>();

		Hotel hotel = new Hotel(hotelName, rooms);

		hotelPortTest.save(hotel);

		// When
		LocalDate checkIn = LocalDate.of(2015, 12, 31);
		LocalDate checkOut = LocalDate.of(2015, 12, 31);

		// Then
		assertThrows(MinimumStayException.class, () -> getHotelRooms.getHotelRooms(hotelName, checkIn, checkOut));

	}


	@Test
	void returnAvailableRooms_whenGivenHotelNameAndCheckInCheckOut() throws MinimumStayException {

		// Given
		HotelPort hotelPortTest = new InMemoryHotelPort(new ArrayList<>());
		GetHotelRooms getHotelRooms = new GetHotelRooms(hotelPortTest);
		String hotelName = "myHotel";
		List<Bed> kingSizeBed = List.of(new KingSizeBed());
		List<Bed> queenSizeBed = List.of(new QueenSizeBed());

		Room room1Wanted = new Room(1, 101, 2,
				kingSizeBed, true, true, true, true);
		Room room2Wanted = new Room(1, 102, 4,
				queenSizeBed, true, true, true, true);

		List<Room> rooms = List.of(room1Wanted, room2Wanted);

		Hotel hotel = new Hotel(hotelName, rooms);

		hotelPortTest.save(hotel);

		LocalDate checkIn = LocalDate.of(2015, 12, 30);
		LocalDate checkOut = LocalDate.of(2015, 12, 31);

		// When

		List<Room> roomsReturned = getHotelRooms.getHotelRooms("myHotel", checkIn, checkOut);

		// Then

		assertThat(rooms).isEqualTo(roomsReturned);
	}

}
