package src.usecase;

import src.main.domain.Hotel;

import java.util.List;

public class HotelPortTest implements HotelPort {

	private List<Hotel> hotels;

	@Override
	public Hotel getHotelByName(String hotelName) {
		return hotels.stream()
				.filter(hotel -> hotel.getHotelName().equals(hotelName))
				.findFirst()
				.orElse(null);
	}

	public void save(Hotel hotel) {
		this.hotels.add(hotel);
	}

}
