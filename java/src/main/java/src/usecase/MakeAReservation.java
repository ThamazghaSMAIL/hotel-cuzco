package src.usecase;

import src.domain.Reservation;

import java.time.LocalDate;

public class MakeAReservation {

	private ReservationPort reservationPort;

	public MakeAReservation(ReservationPort reservationPort) {
		this.reservationPort = reservationPort;
	}

	public Reservation execute(LocalDate checkinDate, LocalDate checkoutDate, int roomNumber) throws Exception {

		Reservation reservation = new Reservation(roomNumber, checkinDate, checkoutDate);

		if(reservationPort.getReservationsByRoomNumberAndDate(roomNumber, checkinDate, checkoutDate).isEmpty()) {
			throw new Exception("room is not available");
		} else {
			return reservationPort.save(reservation);
		}
	}

}
