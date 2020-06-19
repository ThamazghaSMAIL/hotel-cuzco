package src.usecase;

import src.domain.MinimumStayException;
import src.domain.Room;

import java.time.LocalDate;
import java.util.List;

public class GetHotelRooms {

	private RoomPort roomPort;

	public GetHotelRooms(RoomPort roomPort) {
		this.roomPort = roomPort;
	}

	public List<Room> getHotelRooms(LocalDate checkIn, LocalDate checkOut) throws MinimumStayException {

		if( checkIn.isEqual(checkOut)) {
			throw new MinimumStayException();
		}

		List<Room> rooms = roomPort.getRoomsByCheckInCheckout(checkIn, checkOut);

		return rooms;
	}

}
