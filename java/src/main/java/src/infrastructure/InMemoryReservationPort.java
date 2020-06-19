package src.infrastructure;

import src.domain.Reservation;
import src.usecase.ReservationPort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryReservationPort implements ReservationPort {

	private List<Reservation> reservations;

	public InMemoryReservationPort() {

		this.reservations = new ArrayList<>();

		LocalDate checkin = LocalDate.of(2015, 12, 10);
		LocalDate checkout = LocalDate.of(2015, 12, 20);
		Reservation reservation = new Reservation(103, checkin, checkout);

		this.reservations.add(reservation);
	}

	@Override
	public Reservation save(int roomNumber, LocalDate checkin, LocalDate checkout) {

		Reservation reservation = new Reservation(roomNumber, checkin, checkout);
		this.reservations.add(reservation);

		return reservation;
	}

}
