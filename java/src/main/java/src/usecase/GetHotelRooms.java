package src.usecase;

import src.domain.Hotel;
import src.domain.MinimumStayException;
import src.domain.Room;

import java.time.LocalDate;
import java.util.List;

public class GetHotelRooms {

	private HotelPort hotelPort;

	public GetHotelRooms(HotelPort hotelPort) {
		this.hotelPort = hotelPort;
	}

	public List<Room> getHotelRooms(String hotelName, LocalDate checkIn, LocalDate checkOut) throws MinimumStayException {

		if( checkIn.isEqual(checkOut)) {
			throw new MinimumStayException();
		}

		List<Room> rooms = hotelPort.getRoomsByCheckInCheckout(hotelName, checkIn, checkOut);

		return rooms;
	}

}
