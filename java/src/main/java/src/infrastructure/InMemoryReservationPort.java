package src.infrastructure;

import src.domain.Reservation;
import src.usecase.ReservationPort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	public Reservation save(Reservation reservation) throws Exception {
		this.reservations.add(reservation);
		return reservation;
	}

	@Override
	public List<Reservation> getReservationsByRoomNumberAndDate(int roomNumber, LocalDate checkin, LocalDate checkout) {
		List<Reservation> reservationList = this.reservations.stream()
				.filter(reservation -> (checkin.isBefore(reservation.getCheckinDate()) && checkout.isBefore(reservation.getCheckoutDate())) ||
						(checkin.isAfter(reservation.getCheckinDate()) && checkout.isAfter(reservation.getCheckoutDate()))).collect(Collectors.toList());
		return reservationList;
	}

}
