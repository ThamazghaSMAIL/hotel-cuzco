package src.usecase;

import src.domain.Reservation;

import java.time.LocalDate;

public class MakeAReservation {

	private ReservationPort reservationPort;

	public MakeAReservation(ReservationPort reservationPort) {
		this.reservationPort = reservationPort;
	}

	public Reservation execute(LocalDate checkinDate, LocalDate checkoutDate, int roomNumber) {
		
		Reservation reservation = reservationPort.save(roomNumber, checkinDate, checkoutDate);

		return reservation;
	}

}
