package src.usecase;

import src.domain.Reservation;

import java.time.LocalDate;

public class MakeAReservation {

	private RoomPort hotelPort;

	public MakeAReservation(RoomPort hotelPort) {
		this.hotelPort = hotelPort;
	}

	public Reservation makeReservation(LocalDate checkinDate, LocalDate checkoutDate, int roomNumber) {


		return null;
	}

}
