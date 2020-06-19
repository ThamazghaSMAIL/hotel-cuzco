package src.usecase;

import org.junit.jupiter.api.Test;
import src.domain.Reservation;
import src.infrastructure.InMemoryRoomPort;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class MakeAReservationTest {

	RoomPort hotelPort = new InMemoryRoomPort();

	MakeAReservation makeAReservation = new MakeAReservation(hotelPort);

	@Test
	public void whenARoomIsAvailable_makeAReservation() {

		// Given
		LocalDate checkin = LocalDate.of(2015, 12, 30);
		LocalDate checkout = LocalDate.of(2015, 12, 31);
		int roomNumber = 101;

		// When
		Reservation reservationReceived = makeAReservation.makeReservation(checkin, checkout, roomNumber);

		// Then
		Reservation reservationWanted = new Reservation(roomNumber, checkin, checkout);
		assertThat(reservationReceived).isEqualTo(reservationWanted);

	}

}