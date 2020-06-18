package starter.main.domain;

import java.util.List;

public class Room {

	public int floorNumber;
	public int roomNumber;
	public int numberGuests;
  	public List<Bed> beds;
	public boolean AC;
	public boolean wifi;
	private boolean privateBathroom;
  	private boolean wheelchairAccessible;

	public Room(int floorNumber, int roomNumber, int numberGuests, List<Bed> beds, boolean AC, boolean wifi, boolean privateBathroom, boolean wheelchairAccessible) {
		this.floorNumber = floorNumber;
		this.roomNumber = roomNumber;
		this.numberGuests = numberGuests;
		this.beds = beds;
		this.AC = AC;
		this.wifi = wifi;
		this.privateBathroom = privateBathroom;
		this.wheelchairAccessible = wheelchairAccessible;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getNumberGuests() {
		return numberGuests;
	}

	public void setNumberGuests(int numberGuests) {
		this.numberGuests = numberGuests;
	}

	public List<Bed> getBeds() {
		return beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}

	public boolean hasAC() {
		return AC;
	}

	public void setAC(boolean AC) {
		this.AC = AC;
	}

	public boolean hasWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean hasPrivateBathroom() {
		return privateBathroom;
	}

	public void setPrivateBathroom(boolean sharedBathroom) {
		this.privateBathroom = sharedBathroom;
	}

	public boolean isWheelchairAccessible() {
		return wheelchairAccessible;
	}

	public void setWheelchairAccessible(boolean wheelchairAccessible) {
		this.wheelchairAccessible = wheelchairAccessible;
	}
}
