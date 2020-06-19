package src.usecase;

import src.domain.Reservation;

import java.time.LocalDate;

public interface ReservationPort {

	Reservation save(int roomNumber, LocalDate checkin, LocalDate checkout);

}
