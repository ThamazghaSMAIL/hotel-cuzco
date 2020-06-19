package src.domain;

import java.util.List;

public class Hotel {

	private String hotelName;
	private List<Room> rooms;

	public Hotel(String hotelName, List<Room> rooms) {
		this.hotelName = hotelName;
		this.rooms = rooms;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
