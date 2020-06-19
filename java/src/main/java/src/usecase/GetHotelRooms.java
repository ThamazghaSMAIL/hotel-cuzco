package src.usecase;

import src.domain.MinimumStayException;
import src.domain.Room;

import java.time.LocalDate;
import java.util.List;

public class GetHotelRooms {

	private RoomPort hotelPort;

	public GetHotelRooms(RoomPort hotelPort) {
		this.hotelPort = hotelPort;
	}

	public List<Room> getHotelRooms(LocalDate checkIn, LocalDate checkOut) throws MinimumStayException {

		if( checkIn.isEqual(checkOut)) {
			throw new MinimumStayException();
		}

		List<Room> rooms = hotelPort.getRoomsByCheckInCheckout(checkIn, checkOut);

		return rooms;
	}

}
