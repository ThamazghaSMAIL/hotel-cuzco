package src.usecase;

import org.junit.jupiter.api.Test;
import src.domain.Reservation;
import src.infrastructure.InMemoryReservationPort;
import src.infrastructure.InMemoryRoomPort;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MakeAReservationTest {

	ReservationPort reservationPort = new InMemoryReservationPort();

	private RoomPort roomPort = new InMemoryRoomPort();

	MakeAReservation makeAReservation = new MakeAReservation(reservationPort, roomPort);

	@Test
	public void whenARoomIsAvailable_makeAReservation() throws Exception {

		// Given
		LocalDate checkin = LocalDate.of(2015, 12, 30);
		LocalDate checkout = LocalDate.of(2015, 12, 31);
		int roomNumber = 101;

		// When
		Reservation reservationReceived = makeAReservation.execute(checkin, checkout, roomNumber, 1);

		// Then
		assertThat(reservationReceived.getRoom()).isEqualTo(roomNumber);
		assertThat(reservationReceived.getCheckinDate()).isEqualTo(checkin);
		assertThat(reservationReceived.getCheckoutDate()).isEqualTo(checkout);

	}

	@Test
	public void whenARoomIsNotAvailable_throwAnException() {

		// Given
		LocalDate checkin = LocalDate.of(2015, 12, 12);
		LocalDate checkout = LocalDate.of(2015, 12, 14);
		int roomNumber = 103;

		// When
		// Then
		assertThrows(Exception.class, () -> makeAReservation.execute(checkin, checkout, roomNumber, 1));
	}

	@Test
	public void whenRoomNumberOfGuestIsLessThenReservationGuestsNumber_throwAnException() {

		// Given
		LocalDate checkin = LocalDate.of(2015, 12, 12);
		LocalDate checkout = LocalDate.of(2015, 12, 14);
		int roomNumber = 101;

		// When
		// Then
		assertThrows(Exception.class, () -> makeAReservation.execute(checkin, checkout, roomNumber, 2));
	}

}
