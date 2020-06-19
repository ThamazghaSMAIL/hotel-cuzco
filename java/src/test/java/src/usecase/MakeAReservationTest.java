package src.usecase;

import org.junit.jupiter.api.Test;
import src.domain.MinimumStayException;
import src.domain.Reservation;
import src.infrastructure.InMemoryReservationPort;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MakeAReservationTest {

	ReservationPort reservationPort = new InMemoryReservationPort();

	MakeAReservation makeAReservation = new MakeAReservation(reservationPort);

	@Test
	public void whenARoomIsAvailable_makeAReservation() throws Exception {

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

	@Test
	public void whenARoomIsNotAvailable_throwAnException() throws Exception {

		// Given
		LocalDate checkin = LocalDate.of(2015, 12, 12);
		LocalDate checkout = LocalDate.of(2015, 12, 14);
		int roomNumber = 103;

		// When
		// Then
		assertThrows(Exception.class, () -> makeAReservation.execute(checkin, checkout, roomNumber));
	}

}
