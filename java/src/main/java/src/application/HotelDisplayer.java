package src.application;

import src.domain.MinimumStayException;
import src.domain.Room;
import src.domain.bed.Bed;
import src.domain.bed.KingSizeBed;
import src.domain.bed.QueenSizeBed;
import src.infrastructure.InMemoryRoomPort;
import src.usecase.GetHotelRooms;
import src.usecase.RoomPort;

import java.time.LocalDate;
import java.util.List;

public class HotelDisplayer {

	private GetHotelRooms getHotelRooms;

	public HotelDisplayer(GetHotelRooms getHotelRooms) {
		this.getHotelRooms = getHotelRooms;
	}

	public void displayHotelRooms() throws MinimumStayException {
		LocalDate checkIn = LocalDate.of(2015, 12, 30);
		LocalDate checkOut = LocalDate.of(2015, 12, 31);

		List<Room> rooms = getHotelRooms.getHotelRooms(checkIn, checkOut);

		for (Room room : rooms) {
			System.out.println("RoomNumber :" + room.getRoomNumber() + " FloorNumber:" + room.getFloorNumber());
		}
	}

	public static void main(String[] args) throws MinimumStayException {

		RoomPort roomPort = new InMemoryRoomPort();
		GetHotelRooms getHotelRooms = new GetHotelRooms(roomPort);
		HotelDisplayer hotelDisplayer = new HotelDisplayer(getHotelRooms);

		hotelDisplayer.displayHotelRooms();
	}

}
