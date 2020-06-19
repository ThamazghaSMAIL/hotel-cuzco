package src.usecase;

import src.domain.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationPort {

	Reservation save(Reservation reservation) throws Exception;
	List<Reservation> getReservationsByRoomNumberAndDate(int roomNumber, LocalDate checkin, LocalDate checkout);

}
