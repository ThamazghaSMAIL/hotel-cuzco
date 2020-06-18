package src.usecase;

import src.main.domain.Hotel;

public interface HotelPort {

	Hotel getHotelByName(String hotelName);

}
