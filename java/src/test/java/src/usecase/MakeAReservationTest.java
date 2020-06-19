package src.usecase;

import org.junit.jupiter.api.Test;
import src.domain.Reservation;
import src.infrastructure.InMemoryReservationPort;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class MakeAReservationTest {

	ReservationPort reservationPort = new InMemoryReservationPort();

	MakeAReservation makeAReservation = new MakeAReservation(reservationPort);

	@Test
	public void whenARoomIsAvailable_makeAReservation() {

		// Given
		LocalDate checkin = LocalDate.of(2015, 12, 30);
		LocalDate checkout = LocalDate.of(2015, 12, 31);
		int roomNumber = 101;

		// When
		Reservation reservationReceived = makeAReservation.execute(checkin, checkout, roomNumber);

		// Then
		assertThat(reservationReceived.getRoom()).isEqualTo(roomNumber);
		assertThat(reservationReceived.getCheckinDate()).isEqualTo(checkin);
		assertThat(reservationReceived.getCheckoutDate()).isEqualTo(checkout);

	}

}