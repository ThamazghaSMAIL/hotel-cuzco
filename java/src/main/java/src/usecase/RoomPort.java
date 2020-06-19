package src.usecase;

import src.domain.Hotel;
import src.domain.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomPort {

	List<Room> getRoomsByCheckInCheckout(LocalDate checkIn, LocalDate checkOut);

}
