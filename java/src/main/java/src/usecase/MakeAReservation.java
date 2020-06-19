package src.usecase;

import src.domain.Reservation;

import java.time.LocalDate;

public class MakeAReservation {

	private ReservationPort reservationPort;
	private RoomPort roomPort;

	public MakeAReservation(ReservationPort reservationPort, RoomPort roomPort) {
		this.reservationPort = reservationPort;
		this.roomPort = roomPort;
	}

	public Reservation execute(LocalDate checkinDate, LocalDate checkoutDate, int roomNumber, int guestNumber) throws Exception {

		Reservation reservation = new Reservation(roomNumber, checkinDate, checkoutDate, guestNumber);

		int roomGuestNumber = roomPort.getRoomByRoomNumber(roomNumber).getNumberGuests();
		if(reservationPort.getReservationsByRoomNumberAndDate(roomNumber, checkinDate, checkoutDate).isEmpty() || guestNumber > roomGuestNumber) {
			throw new Exception("room is not available");
		} else {
			return reservationPort.save(reservation);
		}
	}

}
