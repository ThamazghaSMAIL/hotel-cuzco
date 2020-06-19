package src.infrastructure;

import src.domain.Hotel;
import src.domain.Room;
import src.usecase.HotelPort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryHotelPort implements HotelPort {

	private List<Hotel> hotels;

	public InMemoryHotelPort(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public Hotel getHotelByName(String hotelName) {
		return hotels.stream()
				.filter(hotel -> hotel.getHotelName().equals(hotelName))
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Room> getRoomsByCheckInCheckout(String hotelName, LocalDate checkIn, LocalDate checkOut) {
		Hotel result = hotels.stream()
				.filter(hotel -> hotel.getHotelName().equals(hotelName))
				.findFirst()
				.orElse(null);

		return result.getRooms();
	}

	public void save(Hotel hotel) {
		this.hotels.add(hotel);
	}



}
