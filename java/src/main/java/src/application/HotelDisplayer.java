package src.application;

import src.domain.Hotel;
import src.domain.MinimumStayException;
import src.domain.Room;
import src.domain.bed.Bed;
import src.domain.bed.KingSizeBed;
import src.domain.bed.QueenSizeBed;
import src.infrastructure.InMemoryHotelPort;
import src.usecase.GetHotelRooms;
import src.usecase.HotelPort;

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

		List<Room> rooms = getHotelRooms.getHotelRooms("myHotel", checkIn, checkOut);

		for (Room room : rooms) {
			System.out.println("RoomNumber :" +room.getRoomNumber() + " FloorNumber:" + room.getFloorNumber());
		}
	}

	public static void main(String[] args) throws MinimumStayException {

		List<Bed> kingSizeBed = List.of(new KingSizeBed());
		List<Bed> queenSizeBed = List.of(new QueenSizeBed());

		Room room1Wanted = new Room(1, 101, 2,
				kingSizeBed, true, true, true, true);
		Room room2Wanted = new Room(1, 102, 4,
				queenSizeBed, true, true, true, true);
		List<Room> rooms = List.of(room1Wanted, room2Wanted);

		Hotel hotel = new Hotel("myHotel", rooms);

		HotelPort hotelPort = new InMemoryHotelPort(List.of(hotel));
		GetHotelRooms getHotelRooms = new GetHotelRooms(hotelPort);
		HotelDisplayer hotelDisplayer= new HotelDisplayer(getHotelRooms);

		hotelDisplayer.displayHotelRooms();
	}
}
