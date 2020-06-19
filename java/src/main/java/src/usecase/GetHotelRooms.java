package src.usecase;

import src.main.domain.Hotel;
import src.main.domain.Room;

import java.util.List;

public class GetHotelRooms {

	private HotelPort hotelPort;

	public GetHotelRooms(HotelPort hotelPort) {
		this.hotelPort = hotelPort;
	}

	public List<Room> getHotelRooms(String hotelName){
		Hotel hotel = hotelPort.getHotelByName(hotelName);
		return hotel.getRooms();
	}

}
