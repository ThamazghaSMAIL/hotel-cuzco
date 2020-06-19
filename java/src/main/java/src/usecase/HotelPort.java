package src.usecase;

import src.domain.Hotel;
import src.domain.Room;

import java.time.LocalDate;
import java.util.List;

public interface HotelPort {

	Hotel getHotelByName(String hotelName);

	List<Room> getRoomsByCheckInCheckout(String hotelName, LocalDate checkIn, LocalDate checkOut);

	void save(Hotel hotel);

}
