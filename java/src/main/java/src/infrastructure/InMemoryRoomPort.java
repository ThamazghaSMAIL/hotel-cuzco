package src.infrastructure;

import src.domain.Room;
import src.domain.bed.Bed;
import src.domain.bed.KingSizeBed;
import src.domain.bed.QueenSizeBed;
import src.usecase.RoomPort;

import java.time.LocalDate;
import java.util.List;

public class InMemoryRoomPort implements RoomPort {

	private List<Room> rooms;

	public InMemoryRoomPort() {
		List<Bed> kingSizeBed = List.of(new KingSizeBed());
		List<Bed> queenSizeBed = List.of(new QueenSizeBed());

		Room room1Wanted = new Room(1, 101, 2,
																kingSizeBed, true, true, true,
																true);

		Room room2Wanted = new Room(1, 102, 4,
																queenSizeBed, true, true, true,
																true);

		this.rooms = List.of(room1Wanted, room2Wanted);
	}

	@Override
	public List<Room> getRoomsByCheckInCheckout(LocalDate checkIn, LocalDate checkOut) {
		return this.rooms;
	}

	public void save(Room room) {
		this.rooms.add(room);
	}

}
